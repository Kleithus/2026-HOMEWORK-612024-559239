package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Attrezzo lanterna;
	private Attrezzo osso;

	private Stanza atrio;
	private Stanza aulaN11;
	private Stanza aulaN10;
	private Stanza laboratorio;
	private Stanza biblioteca;
	
	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	
	public Labirinto() {
		// Oggetti
		this.lanterna = new Attrezzo("lanterna",3);
		this.osso = new Attrezzo("osso",1);
    	// Stanze
		this.atrio = new Stanza("Atrio");
		this.aulaN11 = new Stanza("Aula N11");
		this.aulaN10 = new Stanza("Aula N10");
		this.laboratorio = new Stanza("Laboratorio Campus");
		this.biblioteca = new Stanza("Biblioteca");
	}
	
	/*
	 * Crea tutte le stanze, le porte di collegamento
	 * stanza iniziale e stanza finale
	 */
	public void init() {

		/* collega le stanze */
		this.atrio.impostaStanzaAdiacente("nord", biblioteca);
		this.atrio.impostaStanzaAdiacente("est", aulaN11);
		this.atrio.impostaStanzaAdiacente("sud", aulaN10);
		this.atrio.impostaStanzaAdiacente("ovest", laboratorio);
		
		this.aulaN11.impostaStanzaAdiacente("est", laboratorio);
		this.aulaN11.impostaStanzaAdiacente("ovest", atrio);
		
		this.aulaN10.impostaStanzaAdiacente("nord", atrio);
		this.aulaN10.impostaStanzaAdiacente("est", aulaN11);
		this.aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		
		this.laboratorio.impostaStanzaAdiacente("est", atrio);
		this.laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		
		this.biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		this.aulaN10.addAttrezzo(lanterna);
		this.atrio.addAttrezzo(osso);
		
		/* setup stanza iniziale e finale */
		this.stanzaCorrente = atrio;
		this.stanzaVincente = biblioteca;

	}
	
	/*
	 * Setter e getter stanza vincente e stanza corrente
	 */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanza) {
		this.stanzaVincente = stanza;
	}

	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaCorrente = stanza;
	}
	
	/*
	 * Getter stanze labirinto per test
	 */
	public Stanza getAtrio() {
		return atrio;
	}
	
	public Stanza getAulaN10() {
		return aulaN10;
	}
	
	public Stanza getAulaN11() {
		return aulaN11;
	}
	
	public Stanza getLaboratorio() {
		return laboratorio;
	}
	
	public Stanza getBiblioteca() {
		return biblioteca;
	}
}
