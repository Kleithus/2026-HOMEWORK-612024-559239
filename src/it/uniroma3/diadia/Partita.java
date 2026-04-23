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
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se il giocatore finisce i suoi CFU
	 * @return vero se CFU finiti
	 */
	public boolean giocatoreIsVivo() {
		return this.pg.getCfu() != 0;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return this.finita || this.vinta() || !this.giocatoreIsVivo();
	}

	/**
	 * Imposta la partita come finita
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	/**
	 * Metodi getter e setter
	 */
	
	public Stanza getStanzaCorrente() {
		return this.lab.getStanzaCorrente();
	}
	
	public Stanza getStanzaVincente() {
		return this.lab.getStanzaVincente();
	}
	
	public Labirinto getLabirinto() {
		return this.lab;
	}
	
	public Giocatore getGiocatore() {
		return this.pg;
	}

}
