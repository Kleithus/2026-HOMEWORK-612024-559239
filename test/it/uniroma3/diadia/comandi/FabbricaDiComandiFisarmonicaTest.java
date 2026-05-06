package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica factory;
	
	@BeforeEach
	void setUp() {
		factory = new FabbricaDiComandiFisarmonica(new IOConsole());
	}
	
	@Test
	void testCostruisciComando1() {
		Comando c = factory.costruisciComando("fine");
		assertEquals("fine",c.getNome());
	}
	
	@Test
	void testCostruisciComando2() {
		Comando c = factory.costruisciComando("prendi spada");
		assertEquals("prendi",c.getNome());
		assertEquals("spada",c.getParametro());
	}
	
	@Test
	void testCostruisciComando3() {
		Comando c = factory.costruisciComando("vai sud");
		assertEquals("vai",c.getNome());
		assertEquals("sud",c.getParametro());
	}
	

	
}