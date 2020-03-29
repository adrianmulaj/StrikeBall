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

    public static Socket connessione;
    public static Gioco gioc;
    public static Giocatore vincitore;

    public static void main(String[] args) throws ClassNotFoundException {
        ServerSocket sSocket;
        int porta = 3500;
        int millisecondi = 1000000;
        boolean open = true;
        String messaggio = "";
        gioc = new Gioco();
        while (open) {
            try {
                sSocket = new ServerSocket(porta);
                sSocket.setSoTimeout(millisecondi);
                System.out.println("in attesa di connessioni...");
                Timer thread = new Timer(millisecondi);
                thread.start();
                connessione = sSocket.accept();
                System.out.println("Connessione stabilita");
                thread.setConnesso(true);
                Server.gestione();
                Server.confronto();
                ServerMSGS s = new ServerMSGS();
                s.start();
                esitoinvio();
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

    public static void gestione() throws IOException, ClassNotFoundException {
        ObjectOutputStream os = new ObjectOutputStream(connessione.getOutputStream());
        os.writeObject(gioc);
    }

    public static void confronto() throws IOException, ClassNotFoundException {
        InputStream is = connessione.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        Giocatore giocatore = (Giocatore) ois.readObject();
        System.out.println((String) ois.readObject());
        is.close();
        vincitore = new Giocatore("Nessno");
        if (giocatore.getPunti() > vincitore.getPunti()) {
            vincitore.equals(giocatore);
        }
    }

    public static void esitoinvio() throws IOException {
        DataOutputStream alclient = new DataOutputStream(connessione.getOutputStream());
        alclient.writeBytes(vincitore.toString());
    }

}
