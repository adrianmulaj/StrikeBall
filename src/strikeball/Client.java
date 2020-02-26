/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author andim
 */
public class Client {

    public static String name;

    public static void main(String[] args) {
        int porta = 3500;
        String messaggio = "";
        String host = "localhost";
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader riga = new BufferedReader(reader);
        try {
            Socket connessione;
            String server = "localhost";
            connessione = new Socket(server, porta);
            System.out.println("connessione aperta");
            Gioco gioker = new Gioco();
            DatagramSocket socket = new DatagramSocket();
            RiceviMSG r = new RiceviMSG(socket);
            InviaMSG s = new InviaMSG(socket, host, Client.name);
            Thread rt = new Thread(r);
            Thread st = new Thread(s);
            rt.start();
            st.start();
            connessione.close();
        } catch (IOException ex) {
            System.err.println("Server non trovato sulla porta: " + porta);
        }
    }

    public static String inserimento() {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        return s;
    }
}
