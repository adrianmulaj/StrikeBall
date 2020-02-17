/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.util.Scanner;

/**
 *
 * @author andim
 */
public class Giocatore {

    public static String name;
    public int numero[];
    public static int strike;
    public static int ball;
    public int tentativi;

    public Giocatore() {
        System.out.println("3) Easy | 2) Medium | 1) Hard");
        this.tentativi =Integer.valueOf(inserimento());;
        System.out.println("Inserisci il tuo nome");
        this.name = inserimento();
        numero = new int[4];
    }

    public void insNum() {
        System.out.println("Inserisci i tupoi numeri cifra per cifra");
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + " Numero: ");
            numero[i] = Integer.valueOf(inserimento());
        }
    }

    public String inserimento() {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        return s;
    }

    public int getNumero(int i) {
        return numero[i];
    }

    public void setStrike(int strike) {
        this.strike = this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = this.ball = ball;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Giocatore{" + "Nome=" + name + ", strike=" + strike + ", ball=" + ball + '}';
    }

}
