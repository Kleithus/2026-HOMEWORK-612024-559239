package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;

class StanzaBuiaTest {

	private Attrezzo lantern;
	private StanzaBuia sb;
	private Attrezzo spada;
	
	
	@BeforeEach
	void setUp() {
		this.lantern = new Attrezzo("lantern",1);
		this.sb = new StanzaBuia("sb","lantern");
		this.spada = new Attrezzo("spada",2);
	}
	
	@Test
	void TestGetDescrizione1() {
		sb.addAttrezzo(lantern);
		assertEquals(sb.toString(),sb.getDescrizione());
	}
	@Test 
	void TestGetDescrizione2() {
		sb.addAttrezzo(spada);
		String s = "qui c'è buio pesto";
		assertEquals(s,sb.getDescrizione());
	}
	
}