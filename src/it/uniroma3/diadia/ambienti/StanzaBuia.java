package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String attrezzoPerVedere;
	
	public StanzaBuia(String nome) {
		this(nome, null);
	}
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoPerVedere = attrezzo;
	}

	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(attrezzoPerVedere))
			return super.getDescrizione();
		else
			return "qui c'è buio pesto";
	}
}
