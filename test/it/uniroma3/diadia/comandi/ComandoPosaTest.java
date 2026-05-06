package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
	private Stanza s1;
	private Attrezzo a1;
	private Partita p;
	private ComandoPosa c;
	private Attrezzo a2;
	
	@BeforeEach
	void setUp() {
		s1 = new Stanza("s1");
		a1 = new Attrezzo("a1",2);
		p = new Partita();
		c = new ComandoPosa();
		c.setIo(new IOConsole());
		p.getGiocatore().getBorsa().addAttrezzo(a1);
		p.getLabirinto().setStanzaCorrente(s1);
		a2 = new Attrezzo("a2",200);
	}
	
	@Test
	void testComandoPosa1() {
		c.setParametro("a1");
		c.esegui(p);
		assertTrue(s1.hasAttrezzo("a1"));
	}
	@Test
	void testComandoPosa2() {
		c.setParametro("a2");
		c.esegui(p);
		assertFalse(s1.hasAttrezzo("a2"));
	}
	
	@Test
	void testComandoPosa3() {
		String[] s = {"posa a1","Oggetto posato nella stanza"};
		IOSimulator io = new IOSimulator(s);
		p.getGiocatore().getBorsa().addAttrezzo(a1);
		c.setIo(io);
		p.getLabirinto().setStanzaCorrente(s1);
		c.setParametro("a1");
		c.esegui(p);
		assertEquals("Oggetto posato nella stanza",io.getUltimoMessaggio());
	}
	
	@Test
	void testComandoPosa4() {
		String[] s = {"posa a2","a2 non e' presente nella borsa"};
		IOSimulator io = new IOSimulator(s);
		p.getGiocatore().getBorsa().addAttrezzo(a2);
		c.setIo(io);
		p.getLabirinto().setStanzaCorrente(s1);
		c.setParametro("a2");
		c.esegui(p);
		assertEquals("a2 non e' presente nella borsa",io.getUltimoMessaggio());
	}
}