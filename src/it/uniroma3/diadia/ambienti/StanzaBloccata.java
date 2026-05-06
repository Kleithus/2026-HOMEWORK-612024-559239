package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String attrezzoSbloccante;
	private String direzioneBloccata;
	
	public StanzaBloccata(String nome) {
		this(nome, null, null);
	}

	public StanzaBloccata(String nome, String attrezzo, String direzione) {
		super(nome);
		this.attrezzoSbloccante = attrezzo;
		this.direzioneBloccata = direzione;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione){
		if(direzioneBloccata.equals(direzione) && !super.hasAttrezzo(attrezzoSbloccante))
			return this;
		else return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		// TODO fare descrizione adatta
		return "La direzione " + this.direzioneBloccata + "è bloccata\n" 
				+ super.getDescrizione();
	}
}
