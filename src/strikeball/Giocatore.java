/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

import java.util.Scanner;
import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author andim
 */
public class Giocatore extends JFrame implements ActionListener {

    public  String name;
    public int numero[];
    public  int strike;
    public  int ball;
    public int tentativi;
    public int cont;

    //Variabili di grafica 
    JPanel primo = new JPanel();
    JPanel selezioni = new JPanel();
    JPanel azioni = new JPanel();
    JButton aggiungi = new JButton("Vai");
    JTextField[] scrit = new JTextField[2];
    JComboBox selmen = new JComboBox();
    JComboBox selmens = new JComboBox();
    JComboBox selmenb = new JComboBox();
    JTextArea scontrino = new JTextArea();

    public Giocatore() {
        super("|STRIKE BALL®| Dove il gioco è a colori");
        aggiungi.addActionListener(this);

        scrit[0] = new JTextField("");
        scrit[1] = new JTextField("Seleziona Numero 1"
                + "Inserisci il Numero sopra e premi vai.");
        add(primo);

        primo.setLayout(new GridLayout(0, 3));
        primo.add(selezioni);
        primo.add(azioni);
        azioni.setLayout(new GridLayout(4, 0));

        primo.add(scontrino);
        scontrino.setVisible(true);
        azioni.add(scrit[0]);
        azioni.add(scrit[1]);
        scrit[0].setVisible(false);
        scrit[1].setVisible(false);
        azioni.add(aggiungi);

        selmen.setEditable(true);
        selmen.addItem("");
        selmen.addItem("Facile");
        selmen.addItem("Medio");
        selmen.addItem("Difficile");
        selmens.addItem("");
        selmens.addItem("Numero 1");
        selmens.addItem("Numero 2");
        selmens.addItem("Numero 3");
        selmens.addItem("Numero 4");
        selezioni.add(selmen);
        selezioni.add(selmens);
        selmens.setVisible(false);
        numero = new int[4];
        cont = 0;
        Container c = this.getContentPane();
        this.setSize(630, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        // System.out.println("Inserisci il tuo nome");
        this.name = "Andi";

    }

    @Override
    public String toString() {
        return "Giocatore{" + "name=" + name + ", strike=" + strike + ", ball=" + ball + '}';
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
    public void actionPerformed(ActionEvent e) {
        String ms = null;
        String sl = (String) selmen.getSelectedItem();
        scrit[0].setVisible(true);
        scrit[1].setVisible(true);

        if (e.getActionCommand().equals("Vai")) {
            if (sl.equals("Facile")) {
                this.tentativi = 1;
                selmens.setVisible(true);
                ms = (String) selmens.getSelectedItem();

                if (ms.equals("Numero 1")) {
                    numero[0] = Integer.parseInt(scrit[0].getText());
                    scrit[1].setText("Seleziona Numero 2 e digita");
                    scontrino.append("\n" + ms + ": " + numero[0]);
                }
                if (ms.equals("Numero 2")) {
                    numero[1] = Integer.parseInt(scrit[0].getText());
                    scrit[1].setText("Seleziona Numero 3 e digita");
                    scontrino.append("\n" + ms + ": " + numero[1]);
                }

                if (ms.equals("Numero 3")) {
                    numero[2] = Integer.parseInt(scrit[0].getText());
                    scrit[1].setText("Seleziona Numero 4 e digita");
                    scontrino.append("\n" + ms + ": " + numero[2]);
                }

                if (ms.equals("Numero 4")) {
                    numero[3] = Integer.parseInt(scrit[0].getText());
                    scrit[1].setText("Premi tenta per tentare");
                    scontrino.append("\n" + ms + ": " + numero[3]);
                    //System.exit(0);
                }

            } else {
                selmens.setVisible(false);
            }
            
        }
    }

}
