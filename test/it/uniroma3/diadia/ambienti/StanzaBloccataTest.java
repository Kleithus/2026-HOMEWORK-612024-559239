package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;


class StanzaBlocattaTest {
	
	
	private Stanza stanza;
	private StanzaBloccata sb1;
	private StanzaBloccata sb2;
	private StanzaBloccata sb3;
	private StanzaBloccata sb4;
	private Attrezzo piedediporco;
	private Attrezzo spada;
	
	@BeforeEach
	void setUp() {
		stanza = new Stanza("stanza");
		sb1 = new StanzaBloccata("sb1","nord","piedediporco");
		sb2 = new StanzaBloccata("sb2","sud","piedediporco");
		sb3 = new StanzaBloccata("sb3","est","piedediporco");
		sb4 = new StanzaBloccata("sb4","ovest","piedediporco");
		sb1.impostaStanzaAdiacente("nord", stanza);
		piedediporco = new Attrezzo("piedediporco",3);
		spada = new Attrezzo("spada",2);
	}
	
	@Test
	void testGetStanzaAdiacente() {
		assertEquals(sb1,sb1.getStanzaAdiacente("nord"));
		assertEquals(sb2,sb2.getStanzaAdiacente("sud"));
		assertEquals(sb3,sb3.getStanzaAdiacente("est"));
		assertEquals(sb4,sb4.getStanzaAdiacente("ovest"));
	}
	
	@Test
	void testGetStanzaAdiacente1() {
		sb1.addAttrezzo(piedediporco);
		assertEquals(stanza,sb1.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testGetStanzaAdiacente2() {
		sb1.addAttrezzo(spada);
		assertEquals(sb1,sb1.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testGetDescrione() {
		sb1.addAttrezzo(piedediporco);
		assertEquals(sb1.toString(),sb1.getDescrizione());
	}
	
	@Test
	void testGetDescrione2() {
		sb1.addAttrezzo(spada);
		assertNotEquals(sb1.toString(),sb1.getDescrizione());
	}
}