/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.io.Serializable;
import java.util.Scanner;


/**
 *
 * @author andim
 */
public class Giocatore implements Serializable{

    public  String name;
    public int numero[];
    public  int strike;
    public  int ball;
    public int tentativi;
    public int punti; 

    public Giocatore(String name) {
        numero = new int[4];

        this.name = name;
    }

    @Override
    public String toString() {
        return "Giocatore{" + "name=" + name + ", strike=" + strike + ", ball=" + ball + ", tentativi=" + tentativi + ", punti=" + punti + '}';
    }

    
    public void tenta(){
        System.out.println("TENTA: ");
        String s = inserimento(); 
        String[] result = s.split("");
        for(int i=0; i<result.length; i++){
          numero[i] = Integer.parseInt(String.valueOf(result[i]));  
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

    public void setTentativi(int tentativi) {
        this.tentativi =  this.tentativi + tentativi;
    }

    public int getTentativi() {
        return tentativi;
    }

    public int[] getNumero() {
        return numero;
    }

    public void setNumero(int[] numero) {
        this.numero = numero;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public int getPunti() {
        return punti;
    }
 
}

