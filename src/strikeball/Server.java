/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.net.*;
import java.io.*;

/**
 *
 * @author andim
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket sSocket;
        int porta = 3500;
        int millisecondi = 1000000;
        boolean open = true;
        String messaggio = "";
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader riga = new BufferedReader(reader);
        while (open) {
            try {
                sSocket = new ServerSocket(porta);
                sSocket.setSoTimeout(millisecondi);
                Socket connessione;
                System.out.println("in attesa di connessioni...");
                Timer thread = new Timer(millisecondi);
                thread.start();
                connessione = sSocket.accept();
                System.out.println("Connessione stabilita");
                thread.setConnesso(true);
                ServerMSGS s = new ServerMSGS();
                s.start();
                sSocket.close();
                System.out.println("connessione chiusa");
            } catch (SocketTimeoutException ex) {
                System.out.println("Tempo scaduto sulla porta " + porta);
                open = false;
            } catch (IOException ex) {
                System.out.println("Client non trovati sulla porta: " + porta);
            }
        }
    }

}
