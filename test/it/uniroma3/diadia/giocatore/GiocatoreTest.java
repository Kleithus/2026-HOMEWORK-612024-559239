package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class GiocatoreTest {

	Giocatore pg;
	int cfu;
	
	@BeforeEach
	void setUp() {
		cfu = 5;
		pg = new Giocatore(cfu);
	}

	@Test
	void testGetCfuIniziali() {
		assertEquals(cfu, pg.getCfu());
	}
	
	@Test
	void testSetCfuAggiornati() {
		pg.setCfu(10);
		assertEquals(10, pg.getCfu());
	}
	
	@Test
	void testGetBorsaIniziale() {
		assertTrue(pg.getBorsa().isEmpty());
	}
	
	@Test
	void testGetBorsaConUnElemento() {
		Attrezzo spada = new Attrezzo("spada", 8);
		pg.getBorsa().addAttrezzo(spada);
		assertTrue(pg.getBorsa().hasAttrezzo("spada"));
	}
}
