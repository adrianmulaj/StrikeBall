/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.util.Random;
import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author andim
 */
public class Gioco extends JFrame {

    public static int numero[];
    public Giocatore gioc;
    public static int strike;
    public static int ball;
    public JTextArea scontrino = new JTextArea();

    public Gioco() {
        super();
        Container c = this.getContentPane();
        this.setSize(630, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(scontrino);
        scontrino.setVisible(true);

        this.strike = 0;
        this.ball = 0;
        int n;
        numero = new int[4];
        Random random = new Random();
        gioc = new Giocatore();
        for (int i = 0; i < 4; i++) {
            numero[i] = random.nextInt(9);
            System.out.println(numero[i]);
        }

        for (int i = 0; i < gioc.tentativi; i++) {
            System.out.println("vvvv");
            this.verifica();
            this.serchRes();
        }
    }

    public void verifica() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j && this.numero[i] == gioc.getNumero(j)) {
                    strike++;
                } else {
                    if (this.numero[i] == gioc.getNumero(j)) {
                        ball++;
                    }
                }
            }
        }

        this.gioc.setStrike(this.strike);
        this.gioc.setBall(this.ball);
    }

    public void serchRes() {
        System.out.println("");
        scontrino.append(this.gioc.toString());
    }
}
