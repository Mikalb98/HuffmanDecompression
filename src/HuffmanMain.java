import java.util.Scanner;

public class HuffmanMain {

	public static void main(String[] args) {

//variabili per misurare il tempo di esecuzione delle varie fasi
		
		double inizio; 
		double fine; 
		
//input
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Inserisci il testo a cui applicare la codifica di Huffman");
		String testo = s.nextLine();
		s.close();

//creo l'array delle frequenze
		
		inizio = System.nanoTime(); 
		
		arrayFrequenze af = new arrayFrequenze(testo); 
	    
	    fine = System.nanoTime();
	    double tempoTabellaFrequenze = (fine-inizio)/1000000000;
	    
	    int frequenze[] = af.getFrequenzePure();
	    double frequenzePercentualizzate [] = af.getFrequenzePercentualizzate();
	    System.out.println(af.verificaPercentuali());
	    
//creo l'albero di Huffman e la tabella dei codici
	    
	    inizio = System.nanoTime();
	    
	    Huffman huff = new Huffman(frequenzePercentualizzate);
	    NodoBinaryTree root = huff.BuildHuffmanTree();
	    String cod [] = huff.tabellaCodici(root);
	    
	    fine = System.nanoTime();
	    double tempoCostruzioneCodici = (fine-inizio)/1000000000;
	    

//stampo i risultati della codifica
	    
	    for(int i=0; i<128; i++) 
	    	System.out.println("\ncarattere: " + (char)i + "\nfrequenza nel testo: " + frequenze[i] + "\nfrequenza in percentuale: " + 
	    						frequenzePercentualizzate[i] + "\ncodifica di Huffman: " + cod[i] );
	    
//codifico il testo e lo stampo
	    
	    inizio = System.nanoTime();
	    
	    String testoCodificato = huff.CodificaTesto(testo);
	    
	    fine = System.nanoTime();
	    double tempoCodifica = (fine-inizio)/1000000000;
	    
	    System.out.println("\nIl testo viene codificato nel seguente modo:\n" + testoCodificato);
	    
//decodifico il testo e lo stampo per verificarne la correttezza
	    
	    inizio = System.nanoTime();
	    
	    String testoDecodificato = huff.DecodificaTesto(testoCodificato);
	    
	    fine = System.nanoTime();
	    double tempoDecodifica = (fine-inizio)/1000000000;
	    
	    System.out.println("\nil testo decodificato e' il seguente:\n" + testoDecodificato);

//fattore di compressione
	    
	    double numeroBitTotali = 7*testo.length();
	    double numeroBitCodificati = testoCodificato.length();
	    
	    double fattoreCompressione = numeroBitCodificati/numeroBitTotali;
	    
	    System.out.println("\n\nnumero di bit senza applicare la codifica:  " + numeroBitTotali + "\nnumero di bit codificati:  " + numeroBitCodificati + 
	    					"\n\nnumero di bit risparmiati:  " + (numeroBitTotali-numeroBitCodificati) + "\n\nfattore di compressione:  " + fattoreCompressione);
	    
//tempistiche
	    
	    System.out.println("\n\n\nTEMPO DI ESECUZIONE DELLE VARIE FASI\n\nCreazione della tabella delle frequenze: " + tempoTabellaFrequenze + " sec" + 
	    					"\nCreazione dell'albero e della tabella dei codici: " + tempoCostruzioneCodici + " sec" + "\nCodifica del testo inserito: " 
	    					+ tempoCodifica + " sec" + "\nDecodifica del testo codificato: " + tempoDecodifica + " sec");
	    
	}

}
