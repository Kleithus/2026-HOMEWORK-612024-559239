package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	public String nomeAttrezzo;
	public IO io;

	public ComandoPrendi(IO io2) {
		this.io = io2;
	}

	@Override
	public void esegui(Partita partita) {
		// TODO risolvere messaggio "null non è presente nella stanza"
		if(partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo)) {
			Attrezzo attrezzoPreso;
			attrezzoPreso = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
			if(partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo) && 
			   partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso))
				this.io.mostraMessaggio("Oggetto aggiunto alla borsa");
			else {
				partita.getStanzaCorrente().addAttrezzo(attrezzoPreso);
				this.io.mostraMessaggio("Raggiunto massimo peso o numero oggetti");
			}
		}
		else
			this.io.mostraMessaggio(nomeAttrezzo + " non e' presente nella stanza");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
