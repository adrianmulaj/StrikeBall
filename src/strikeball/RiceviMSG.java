/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author andim
 */
public class RiceviMSG implements Runnable{
    
    DatagramSocket sock;
    byte buf[];
    String received; 

    RiceviMSG(DatagramSocket s) {
        sock = s;
        buf = new byte[1024];
    }
    @Override
    public void run() {
        
        boolean f =true;
        while (f) {
            try {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                sock.receive(packet);
                received = new String(packet.getData(), 0, packet.getLength());
                System.out.println(received);
                if(received == "esci"){
                    f=false;
                }
            } catch(IOException e) {
                System.err.println(e);
            }
        }
    }  

    public String getReceived() {
        return received;
    }
    
}




