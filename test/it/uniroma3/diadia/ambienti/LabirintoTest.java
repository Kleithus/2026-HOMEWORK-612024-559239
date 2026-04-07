package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	private Labirinto lab;
	private Stanza mensa;
	
	@BeforeEach
	void setUp(){
		lab = new Labirinto();
		mensa = new Stanza("mensa");
		lab.init();
	}

	@Test
	void testGetStanzaVincente() {
		lab.setStanzaVincente(mensa);
		assertEquals(mensa, lab.getStanzaVincente());
	}
	
	@Test
	void testSetStanzaCorrenteCambioEseguito() {
		assertNotEquals(mensa, lab.getStanzaCorrente());
		lab.setStanzaCorrente(mensa);
		assertEquals(mensa, lab.getStanzaCorrente());
	}
	
	@Test
	void testGetAtrio() {
		assertEquals(lab.getStanzaCorrente(), lab.getAtrio());
	}
	
	@Test
	void testInitAtrioCollegamenti() {
		assertEquals(lab.getBiblioteca(), lab.getAtrio().getStanzaAdiacente("nord"));
	    assertEquals(lab.getAulaN11(), lab.getAtrio().getStanzaAdiacente("est"));
	    assertEquals(lab.getAulaN10(), lab.getAtrio().getStanzaAdiacente("sud"));
	    assertEquals(lab.getLaboratorio(), lab.getAtrio().getStanzaAdiacente("ovest"));
	}
	
	@Test
	void testInitAtrioCollegamentiNelSensoOpposto() {
	    assertEquals(lab.getAtrio(), lab.getBiblioteca().getStanzaAdiacente("sud"));
	    assertEquals(lab.getAtrio(), lab.getAulaN11().getStanzaAdiacente("ovest"));
	    assertEquals(lab.getAtrio(), lab.getAulaN10().getStanzaAdiacente("nord"));
	    assertEquals(lab.getAtrio(), lab.getLaboratorio().getStanzaAdiacente("est"));
	}
	
	@Test
	void testInitOssoInAtrio() {
		assertTrue(lab.getAtrio().hasAttrezzo("osso"));
	}
	
	@Test
	void testInitLanternaInAulaN10() {
		assertTrue(lab.getAulaN10().hasAttrezzo("lanterna"));
	}
	
	@Test
	void testInitStanzaVincente() {
		assertEquals(lab.getBiblioteca(), lab.getStanzaVincente());
	}
	
	@Test
	void testInitStanzaCorrente() {
		assertEquals(lab.getAtrio(), lab.getStanzaCorrente());
	}
}
