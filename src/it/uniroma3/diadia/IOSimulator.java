package it.uniroma3.diadia;

public class IOSimulator implements IO {
	
	private String[] input;
	private String[] output;
	private int indiceInput;
	private int indiceOutput;
	
	public IOSimulator(String[] input) {
		this.input = input;
		this.output = new String[10000];
		this.indiceInput = 0;
		this.indiceOutput = 0;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		// TODO Auto-generated method stub
		if(indiceOutput < output.length) {
			output[indiceOutput] = messaggio;
			indiceOutput++;
		}
		
	}

	@Override
	public String leggiRiga() {
		// TODO Auto-generated method stub
		if(indiceInput < input.length) {
			String s = input[indiceInput];
			indiceInput++;
			return s;
		}
		return null;
	}
	
	public String[] getOutput() {
		return output;
	}
	
    public String getUltimoMessaggio() {
        if (indiceOutput == 0) return null;
        return output[indiceOutput - 1];
    }

}