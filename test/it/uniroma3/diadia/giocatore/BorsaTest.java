package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	
	Borsa bag;
	Attrezzo mazza;

	@BeforeEach
	void setUp() {
		bag = new Borsa();
		mazza = new Attrezzo("mazza", 5);
		bag.addAttrezzo(mazza);
	}

	@Test
	void testAddAttrezzoNumeroMassimoAttrezzi() {
		for (int i=0; i<9; i++)
			assertTrue(bag.addAttrezzo(new Attrezzo("attrezzo"+i, 0)));
		assertFalse(bag.addAttrezzo(new Attrezzo("overflow", 0)));
	}

	@Test
	void testAddAttrezzoRaggiuntoPesoMassimo() {
		assertFalse(bag.addAttrezzo(new Attrezzo("oggetto pesante", bag.getPesoMax()+1)));
	}
	
	@Test
	void testAddAttrezzoCorrettamente() {
		assertTrue(bag.hasAttrezzo("mazza"));
	}
	
	@Test
	void testAddAttrezzoAggiornaNumeroAttrezziCorretto() {
		bag.addAttrezzo(new Attrezzo("spada", 4));
		assertEquals(2, bag.getNumeroAttrezzi());
	}
	
	@Test
	void testGetAttrezzoNonInserito() {
		assertNull(bag.getAttrezzo("osso"));
	}
	
	@Test
	void testGetAttrezzoTrovato() {
		assertEquals(mazza, bag.getAttrezzo("mazza"));
	}
	
	@Test
	void testGetPesoAggiuntiAttrezzi() {
		bag.addAttrezzo(new Attrezzo("lancia", 2));
		bag.addAttrezzo(new Attrezzo("piuma", 0));
		assertEquals(7, bag.getPeso());
	}
	
	@Test
	void testGetPesoBorsaVuota() {
		bag.removeAttrezzo("mazza");
		assertEquals(0, bag.getPeso());
	}
	
	@Test
	void testRemoveAttrezzoInesistente() {
		assertNull(bag.removeAttrezzo("osso"));
	}
	
	@Test
	void testRemoveAttrezzoAggiornaBeneNumeroAttrezzi() {
		bag.removeAttrezzo("mazza");
		assertEquals(0, bag.getNumeroAttrezzi());
	}
	
	@Test
	void testRemoveAttrezzoSoloPrimoAttrezzoUguale() {
		bag.addAttrezzo(new Attrezzo("mazza", 2));
		bag.addAttrezzo(new Attrezzo("mazza", 3));
		bag.removeAttrezzo("mazza");
		assertEquals(5, bag.getPeso());
	}
	
	@Test
	void testRemoveAttrezzoScalaListaBene() {
		for (int i=0; i<9; i++)
			assertTrue(bag.addAttrezzo(new Attrezzo("attrezzo"+i, 0)));
		bag.removeAttrezzo("mazza");
		for (int i = 0; i < 9; i++) {
	        assertNotNull(bag.getAttrezzo("attrezzo" + i));
	    }
		assertNull(bag.getAttrezzo("mazza"));
	}
		
}
