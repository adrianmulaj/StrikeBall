/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author andim
 */
public class Gioco implements Serializable{

    public  int numero[];
    public Giocatore gioc;
    public  int strike;
    public  int ball;
    public  int punti;
    public boolean risolto; 

    public Gioco() {
        risolto = false; 
        this.strike = 0;
        this.ball = 0;
        numero = new int[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            numero[i] = random.nextInt(9);
            System.out.println(numero[i]);
        }
    }

    public Gioco(Giocatore gioc) {
        this.gioc = gioc;
    }

    
    public void verifica() {
  int k =0; 
        for (int i = 0; i < 4; i++) {
            System.out.println(this.numero[i]);
            for (int j = 0; j < 4; j++) {
                if (i == j && this.numero[i] == gioc.getNumero(j)) {
                    strike++;
                    punti = punti + 1000;
                    k++; 
                } else {
                    if (this.numero[i] == gioc.getNumero(j)) {
                        ball++;
                        punti = punti + 500;
                        k--; 
                    }
                }
            }
        }
        this.gioc.setStrike(this.strike);
        this.gioc.setBall(this.ball);
        punti = punti / gioc.getTentativi();
        this.gioc.setPunti(this.punti); 
        if(k==4){
            setRisolto(true); 
        }
    }

    public Giocatore getgioker() {
        return this.gioc;
    }

    public  void setNumero(int[] numero) {
       this.numero = numero;
    }

    
    public  int [] getNumero() {
        return this.numero;
    }

    public void setRisolto(boolean risolto) {
        this.risolto = risolto;
    }

    public boolean isRisolto() {
        return risolto;
    }
    

    
}
