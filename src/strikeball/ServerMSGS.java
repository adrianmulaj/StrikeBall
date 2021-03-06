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
public class ServerMSGS extends Thread {

    public final static int PORT = 3500;
    private final static int BUFFER = 1024;

    private DatagramSocket socket;
    private ArrayList<InetAddress> clientAddresses;
    private ArrayList<Integer> clientPorts;
    private HashSet<String> existingClients;

    public ServerMSGS() throws IOException {
        socket = new DatagramSocket(PORT);
        clientAddresses = new ArrayList();
        clientPorts = new ArrayList();
        existingClients = new HashSet();
    }

    @Override
    public void run() {
        byte[] buf = new byte[BUFFER];
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                String content = new String(buf, buf.length);

                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();

                String id = clientAddress.toString() + "," + clientPort;
                if (!existingClients.contains(id)) {
                    existingClients.add(id);
                    clientPorts.add(clientPort);
                    clientAddresses.add(clientAddress);
                }

                System.out.println(id + " : " + content);
                byte[] data = (id + " : " + content).getBytes();
                for (int i = 0; i < clientAddresses.size(); i++) {
                    InetAddress cl = clientAddresses.get(i);
                    int cp = clientPorts.get(i);
                    packet = new DatagramPacket(data, data.length, cl, cp);
                    socket.send(packet);
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
