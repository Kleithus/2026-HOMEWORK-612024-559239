package it.uniroma3.diadia.comandi;


import static org.junit.jupiter.api.Assertions.*;

import java.security.PKCS12Attribute;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

	private Stanza s1;
	private Stanza s2;
	private Partita p;
	private ComandoVai c;

	
	@BeforeEach
	void setUp() {
		s1 = new Stanza("s1");
		s2 = new Stanza("s2");
		p = new Partita();
		c = new ComandoVai();
		c.setIo(new IOConsole());
		
	}
	@Test
	void testComandoVai1() {
		s1.impostaStanzaAdiacente("sud", s2);
		p.getLabirinto().setStanzaCorrente(s1);
		c.setParametro("sud");
		c.esegui(p);
		assertEquals(s2,p.getStanzaCorrente());
	}
	@Test
	void testComandoVai2() {
		s1.impostaStanzaAdiacente("sud", s2);
		p.getLabirinto().setStanzaCorrente(s1);
		c.setParametro("nord");
		c.esegui(p);
		assertNotEquals(s2,p.getStanzaCorrente());
	}
	
	@Test
	void testComandoVaiParametroNull() {

	    IOSimulator io = new IOSimulator(new String[]{});
	    p.getLabirinto().setStanzaCorrente(s1);
	    c.setParametro(null);
	    c.setIo(io);
	    c.esegui(p);
	    assertEquals("Dove vuoi andare ?", io.getUltimoMessaggio());
	}
	
	@Test
	void testComandoVai3() {
		String[] s = {"Direzione inesistente","est"};
	    IOSimulator io = new IOSimulator(s);
	    p.getLabirinto().setStanzaCorrente(s1);
	    Stanza s3 = null;
	    s1.impostaStanzaAdiacente("nord", s3);
	    c.setParametro("nord");
	    c.setIo(io);
	    c.esegui(p);
	    assertEquals("Direzione inesistente", io.getUltimoMessaggio());
	}
}