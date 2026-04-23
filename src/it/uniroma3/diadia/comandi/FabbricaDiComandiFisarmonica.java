package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {

	private IO io;

	public FabbricaDiComandiFisarmonica(IO io2) {
		this.io = io2;
	}

	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();	// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();		// seconda parola: eventuale parametro
		
		if (nomeComando == null)
			comando = new ComandoNonValido(this.io);
		else if ("vai".equals(nomeComando))		// mettiamo prima la stringa e poi nomeComando per evitare NullPointerException
			comando = new ComandoVai(this.io);
		else if ("prendi".equals(nomeComando))
			comando = new ComandoPrendi(this.io);
		else if ("posa".equals(nomeComando))
			comando = new ComandoPosa(this.io);
		else if ("aiuto".equals(nomeComando))
			comando = new ComandoAiuto(this.io);
		else if ("fine".equals(nomeComando))
			comando = new ComandoFine();
		else if ("guarda".equals(nomeComando))
			comando = new ComandoGuarda(this.io);
		else comando = new ComandoNonValido(this.io);
		comando.setParametro(parametro);
		return comando;
	}

}
