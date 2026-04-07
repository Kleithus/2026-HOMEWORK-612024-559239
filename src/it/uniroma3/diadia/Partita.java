package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;		// importo tutto il package
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto lab;
	private boolean finita;
	private Giocatore pg;
	

	public Partita(){
		this.lab = new Labirinto();
		this.lab.init();
		this.finita = false;
		this.pg = new Giocatore();
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.lab.getStanzaCorrente()== this.lab.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return this.finita || this.vinta() || (this.pg.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Labirinto getLabirinto() {
		return this.lab;
	}
	
	public Giocatore getPg() {
		return this.pg;
	}
}
