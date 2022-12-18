public class NodoBinaryTree {

//attributi
	
	private double chiave;
	private char carattere;
	private NodoBinaryTree figliosx;
	private NodoBinaryTree figliodx;
	private String codiceNodo;
				
//costruttore
				
	public NodoBinaryTree(double chiave, char carattere, NodoBinaryTree figliosx, NodoBinaryTree figliodx, String codiceNodo) {
					
		this.chiave = chiave;
		this.carattere = carattere;
		this.figliosx = figliosx;
		this.figliodx = figliodx;
		this.codiceNodo = codiceNodo;
	}
				
//metodi
				
	public double getChiave() {
		return this.chiave;
	}
	
	public char getCarattere() {
		return this.carattere;
	}
				
	public NodoBinaryTree getLeft() {
		return this.figliosx;
	}
				
	public NodoBinaryTree getRight() {
		return this.figliodx;
	}
	
	public void setCodice(String c) {
		this.codiceNodo = c;
	}
	
	public String getCodice() {
		return this.codiceNodo;
	}
}
