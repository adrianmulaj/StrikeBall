/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andim
 */
public class Timer extends Thread{
	private int tempo;
	private boolean connesso;
        
	public Timer (int tempo) {
		this.tempo=tempo;
		this.connesso=false;
	}
	
	public void run(){
		while(tempo>0 && connesso==false)
		{
			try {
				System.out.println(tempo/1000);
				this.sleep(1000);
				tempo=tempo-1000;
			} catch (InterruptedException ex) {
				System.out.println("ERRORE Interruzione del conto alla rovescia");
			}
		}
	}

	
	public void setConnesso(boolean connesso){
		this.connesso=connesso;
	}
        
}

