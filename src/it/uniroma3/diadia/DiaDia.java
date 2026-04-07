package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private IOConsole io;
	private Partita partita;

	public DiaDia(IOConsole io) {
		this.io = io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do {
			this.io.mostraMessaggio("CFU: " + this.partita.getPg().getCfu());	// aggiunto per test
			istruzione = this.io.leggiRiga();
		}
		while (!processaIstruzione(istruzione) && !this.partita.isFinita());
		if(this.partita.getPg().getCfu() == 0 && !this.partita.vinta())
			this.io.mostraMessaggio("CFU: finiti");
		this.fine();
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine"))
			return true;
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			this.io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getPg().setCfu(this.partita.getPg().getCfu() - 1);
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		}
		this.io.mostraMessaggio(this.partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	/*
	 * Comando "Prendi" che toglie un oggetto dalla stanza
	 * corrente e lo inserisce nella borsa del giocatore
	 */
	private void prendi(String nomeAttrezzo) {
		if(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoPreso;
			attrezzoPreso = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo) && 
			   this.partita.getPg().getBorsa().addAttrezzo(attrezzoPreso))
				this.io.mostraMessaggio("Oggetto aggiunto alla borsa");
			else {
				this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoPreso);
				this.io.mostraMessaggio("raggiunto massimo peso o numero oggetti");
			}
		}
		else
			this.io.mostraMessaggio(nomeAttrezzo + " non e' presente nella stanza");
	}
	/*
	 * Comando "Posa" che toglie un oggetto dalla borsa del
	 * giocatore e lo lascia nella stanza corrente
	 */
	private void posa(String nomeAttrezzo) {
		if(this.partita.getPg().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoPosato;
			attrezzoPosato = this.partita.getPg().getBorsa().removeAttrezzo(nomeAttrezzo);
			if(this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoPosato))
				this.io.mostraMessaggio("Oggetto posato nella stanza");
			else
				this.io.mostraMessaggio("raggiunto massimo numero oggetti di oggetti in stanza");
		}
		else
			this.io.mostraMessaggio(nomeAttrezzo + " non e' presente nella borsa");
	}
	
	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}