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

public class InviaMSG implements Runnable {
    public final static int PORT = 3500;
    private DatagramSocket sock;
    private String hostname;
    private static String idg;

    
    InviaMSG (DatagramSocket s, String h, String nome) {
        sock = s;
        hostname = h;
        this.idg = nome; 
    }
    
    private void sendMessage(String s) throws Exception {
        byte buf[] = s.getBytes();
        InetAddress address = InetAddress.getByName(hostname);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, PORT);
        sock.send(packet);
    }
    
    @Override
    public void run() {
        boolean connected = false;
        do {
            try {
                sendMessage(this.idg + ": è nella lobby");
                connected = true;
            } catch (Exception e) {
                
            }
        } while (!connected);
        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                while (!in.ready()) {
                    Thread.sleep(100);
                }
                sendMessage(in.readLine());
            } catch(Exception e) {
                System.err.println(e);
            }
        }
    }
}
