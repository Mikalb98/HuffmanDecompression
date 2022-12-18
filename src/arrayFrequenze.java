
public class arrayFrequenze {

//attributi
	
	public int frequenze [] = new int[128]; //128 caratteri ASCII
	public double frequenzePercentualizzate [] = new double[128];
	private String testo;
	
//costruttore
	
	public arrayFrequenze(String t) { 
		
		this.testo = t;
		for(int i=0 ; i<127 ; i++ ) 
			frequenze [i] = 0; //inizializzo tutte le frequenze a 0
	}
	
//metodi
	
	//restituisce l'array delle frequenze sul totale dei caratteri
	
	public int[] getFrequenzePure () {
		
		for(int i=0 ; i<this.testo.length() ; i++)
			this.frequenze[(int) this.testo.charAt(i)]++ ; //incremento di 1 la casella di indice corrispondente al codice ASCII del carattere
		
		return this.frequenze;
		
	}
	
	//restituisce l'array delle frequenze in percentuale
	
	public double[] getFrequenzePercentualizzate() {
		
		double sommaCaratteri = 0;
		
		for(int i=0 ; i<128 ; i++)
			sommaCaratteri = sommaCaratteri + this.frequenze[i];
		
		for(int i=0 ; i<128 ; i++) 
			this.frequenzePercentualizzate[i] = 100*this.frequenze[i]/sommaCaratteri; 
		
		return this.frequenzePercentualizzate;
	}	
	
	public double verificaPercentuali() {
		double sommaFrequenzePercentualizzate = 0;
		for(int i=0 ; i<128 ; i++)
			sommaFrequenzePercentualizzate = sommaFrequenzePercentualizzate + this.frequenzePercentualizzate[i];
		return sommaFrequenzePercentualizzate;
	}

}
