package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza corrente;
	private Stanza adiacente;
	Attrezzo spada;
	
	@BeforeEach
	void setUp() {
		corrente = new Stanza("corrente");
		adiacente = new Stanza("adiacente");
		corrente.impostaStanzaAdiacente("nord", adiacente);
		spada = new Attrezzo("spada", 8);
		corrente.addAttrezzo(spada);
		for(int i=0; i<10; i++) {
			adiacente.addAttrezzo(new Attrezzo("attrezzo"+i, i));
		}
	}

	@Test
	void testImpostaStanzaAdiacente() {
		assertEquals(adiacente, corrente.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaAdiacenteSovrascritta() {
		Stanza nuova = new Stanza("nuova");
		corrente.impostaStanzaAdiacente("nord", nuova);
		assertEquals(nuova, corrente.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testGetStanzaAdiacenteDirezioneNull() {
		assertNull(corrente.getStanzaAdiacente("sud"));
	}
	
	@Test
	void testGetNome() {
		assertEquals("corrente", corrente.getNome());
	}

	@Test
	void testAddAttrezziInserito() {
		Attrezzo scudo = new Attrezzo("scudo", 20);
		assertTrue(corrente.addAttrezzo(scudo));
	}
	
	@Test
	void testAddAttrezziUnoDiTroppo() {
		assertFalse(adiacente.addAttrezzo(new Attrezzo("overflow", 100)));
	}
	
	@Test
	void testGetAttrezzoPresente() {
		assertEquals(spada, corrente.getAttrezzo("spada"));
	}
	
	@Test
	void testGetAttrezzoNonPresente() {
		assertNull(corrente.getAttrezzo("lancia"));
	}
	
	@Test
	void testHasAttrezzoTrue() {
		assertTrue(corrente.hasAttrezzo("spada"));
	}
	
	@Test
	void testHasAttrezzoFalse() {
		assertFalse(corrente.hasAttrezzo("mazza"));
	}
	
	@Test
	void testRemoveAttrezzoRimosso() {
		assertTrue(corrente.removeAttrezzo("spada"));
		assertFalse(corrente.hasAttrezzo("spada"));
	}
	
	@Test
	void testRemoveAttrezzoNonPresente() {
		assertFalse(corrente.removeAttrezzo("scudo"));
	}
	
	@Test
	void testRemoveAttrezzoInMezzo() {
		assertTrue(adiacente.removeAttrezzo("attrezzo2"));
		assertFalse(adiacente.hasAttrezzo("attrezzo2"));
		assertTrue(adiacente.hasAttrezzo("attrezzo3"));
	}
	
	@Test
	void testRemoveAttrezzoAllaFine() {
		assertTrue(adiacente.removeAttrezzo("attrezzo9"));
		assertNull(adiacente.getAttrezzo("attrezzo9"));
	}
	
	@Test
	void testDirezioni() {
		String[] dir = new String[1];
		dir[0] = "nord";
		assertArrayEquals(dir, corrente.getDirezioni());
	}
	
	@Test
	void testDirezioniMultiple() {
		adiacente.impostaStanzaAdiacente("sud", corrente);
		
		assertEquals(adiacente, corrente.getStanzaAdiacente("nord"));
		assertEquals(corrente, adiacente.getStanzaAdiacente("sud"));
	}
	
}