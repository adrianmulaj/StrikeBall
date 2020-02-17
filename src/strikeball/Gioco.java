/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.util.Random;

/**
 *
 * @author andim
 */
public class Gioco{

    public static int numero[];
    public Giocatore gioc;
    public static int strike;
    public static int ball;
    
    
    public Gioco() {
        super();
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
            gioc.insNum();
            this.verifica();
            this.printResults();
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

    public void printResults() {
        System.out.print(this.gioc);
    }
}
