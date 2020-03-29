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
    public static final String ANSI_CYAN = "\u001B[36m";
    public static Socket connessione;
    public static Giocatore gioc;

    public static void main(String[] args) throws ClassNotFoundException {

        int porta = 3500;
        String messaggio = "";
        try {
            String server = "localhost";
            connessione = new Socket(server, porta);
            System.out.println("connessione aperta");
            System.out.println(ANSI_CYAN + "Inserisci il tuo nome");
            Client.name = inserimento();
            Client.gioca();
            Client.chat();
        } catch (IOException ex) {
            System.err.println("Server non trovato sulla porta: " + porta);
        }
    }

    public static void gioca() throws IOException, ClassNotFoundException {
        boolean v = true;
        String v1;
        gioc = new Giocatore(Client.name);
        ObjectInputStream is = new ObjectInputStream(connessione.getInputStream());
        Gioco gioker = (Gioco) is.readObject();

        Gioco gserver = new Gioco(gioc);
        gserver.setNumero(gioker.getNumero());

        do {
            gioc.tenta();
            gioc.setTentativi(1);
            gserver.verifica();
            System.out.println(gioc.toString());
            if (gserver.isRisolto()) {
                v1 = "0";
                System.out.println("Hai risolto la combinazione");
                Client.sendPlayer();
            } else {
                System.out.println("1| Ritenta  0|Esci dai tentativi");
                v1 = inserimento();
            }
        } while (v1.equals("1"));
        System.out.println("Attendi i risulatati");
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
         System.out.println(inFromServer.readLine());
    }

    public static void chat() throws SocketException, IOException {
        String host = "localhost";
        DatagramSocket socket = new DatagramSocket();
        RiceviMSG r = new RiceviMSG(socket);
        InviaMSG s = new InviaMSG(socket, host, Client.name);
        Thread rt = new Thread(r);
        Thread st = new Thread(s);
        rt.start();
        st.start();
    }

    public static String inserimento() {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        return s;
    }

    public static void sendPlayer() throws  IOException{
        OutputStream os = connessione.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(gioc);
        oos.close();
        os.close();
    }
}
