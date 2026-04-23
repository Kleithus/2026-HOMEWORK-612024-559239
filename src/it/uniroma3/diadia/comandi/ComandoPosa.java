package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	public String nomeAttrezzo;
	public IO io;
	
	public ComandoPosa(IO io2) {
		this.io = io2;
	}

	@Override
	public void esegui(Partita partita) {
		// TODO risolvere messaggio "null non è presente nella borsa"
		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoPosato;
			attrezzoPosato = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			if(partita.getStanzaCorrente().addAttrezzo(attrezzoPosato))
				io.mostraMessaggio("Oggetto posato nella stanza");
			else
				io.mostraMessaggio("raggiunto massimo numero oggetti di oggetti in stanza");
		}
		else
			io.mostraMessaggio(nomeAttrezzo + " non e' presente nella borsa");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
