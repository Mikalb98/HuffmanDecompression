public class Huffman {

//attributi
	
	private double frequenze [] = new double [128];
	private String codici [] = new String [128];
	private NodoBinaryTree figliosx;
	private NodoBinaryTree figliodx;
	private double freqpadre;
	private MinHeap minHeap = new MinHeap(255); //creo un minHeap di 255 nodi (128 nodi foglia + 127 nodi interni);

//costruttore 
	
	public Huffman(double frequenze[]) {
		this.frequenze = frequenze;
		for(int i=0; i<128 ; i++)
			this.codici[i]= "";
	}
	
//metodi 
	
	//costruisco l'albero di Huffman
	
	public NodoBinaryTree BuildHuffmanTree() {
	
	//aggiungo i 128 nodi foglia nel minHeap
		
		for(int i=0 ; i<127 ; i++ ) {
			NodoBinaryTree n = new NodoBinaryTree(this.frequenze[i], (char)i, null, null, null);
			this.minHeap.insert(n); 
		}	
		
	
		while(minHeap.size > 1) {
			
			this.figliosx = minHeap.extractMin();
			this.figliodx = minHeap.extractMin();
			
			freqpadre = this.figliosx.getChiave() + this.figliodx.getChiave(); 
			minHeap.insert(new NodoBinaryTree(freqpadre, '\u0000', this.figliosx, this.figliodx, null));
		}
		
		return minHeap.extractMin();
	}

	//creo la tabella dei codici
	
	public String[] tabellaCodici(NodoBinaryTree root){
	    fill(root, "");                            
	    return this.codici;
	}
	
	//visito ricorsivamente tutto l'albero per creare la tabella dei codici
	
	public void fill(NodoBinaryTree n, String codiceRelativo) {
		
		n.setCodice(codiceRelativo);											//memorizzo il codice relativo al nodo n
		
		if (n.getLeft()==null && n.getRight()==null ) {          				//se sono su una foglia    	
			this.codici[(int)n.getCarattere()] = n.getCodice();                          
	    } 
	    
	    else {
	    	
	    	if(n.getLeft()!= null)
	    		fill( n.getLeft(),  n.getCodice() +"0");          		//se vado a sx aggiungo uno 0
	    	
	    	if(n.getLeft()!= null)
	    		fill( n.getRight(), n.getCodice() +"1");               //se vado a dx aggiungo un  1
	   
	    }
	  }
	
	//codifico il testo secondo la tabellaCodici
	
	public String CodificaTesto (String testo) {
		
		String testoCodificato = "";
		for(int i=0 ; i<testo.length() ; i++) {
			testoCodificato = testoCodificato + this.codici[(int)testo.charAt(i)];
		}
		return testoCodificato;
	}
		
	//decodifico il testo codificato mediante l'algoritmo di Huffman
	
	public String DecodificaTesto (String testoCodificato) {
	
		String testoDecodificato = "";
		String a = "";
		
		
		for(int i=0 ; i<testoCodificato.length(); i++){
			
			a = a + testoCodificato.charAt(i);
			
			for(int j=0 ; j<128 ; j++){
				
				if (a.equals(this.codici[j])){
					char b = (char)j;
					testoDecodificato = testoDecodificato + b;
					a = "";
					break;
				}
					
			}	
		}
		return testoDecodificato;
	}
	
	

}
