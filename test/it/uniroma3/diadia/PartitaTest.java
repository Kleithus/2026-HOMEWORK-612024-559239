package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.Labirinto;

class PartitaTest {
	private Partita game;
	private Labirinto lab;
	
	@BeforeEach
	void setUp() {
		game = new Partita();
		lab = game.getLabirinto();
	}
	
	@Test
	void testVintaTrue() {
		lab.setStanzaCorrente(lab.getStanzaVincente());
		assertTrue(game.vinta());
	}
	
	@Test
	void testVintaFalse() {
		assertFalse(game.vinta());
	}
	
	@Test
	void testSetFinita() {
		assertFalse(game.isFinita());
		game.setFinita();
		assertTrue(game.isFinita());
	}
	
	@Test
	void testIsFinitaFalse() {
		assertFalse(game.isFinita());
	}
	
	@Test
	void testIsFinitaTrueFinita() {
		game.setFinita();
		assertTrue(game.isFinita());
	}
	
	@Test
	void testIsFinitaTrueVinta() {
		lab.setStanzaCorrente(lab.getStanzaVincente());
		assertTrue(game.isFinita());
	}
	
	@Test
	void testIsFinitaTrueCfuEqualZero() {
		game.getPg().setCfu(0);
		assertTrue(game.isFinita());
	}
}
