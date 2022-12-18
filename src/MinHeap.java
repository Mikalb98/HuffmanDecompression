
public class MinHeap {

//attributi
	
	private NodoBinaryTree[] heap; // minheap di nodi
	public int size = 0; //dimensione albero
	private int capacity; //dimensione array

//costruttore
	
	public MinHeap(int capacity){
		this.capacity = capacity;
		this.heap = new NodoBinaryTree[this.capacity]; 
		
	}

//metodi
		    
	//restituisce l'indice del figliosx
	
	public int left(int i){ 				
		return (2*i)+1;
	}
		
	//restituisce l'indice del figliodx
	
	public int right(int i){
		return (2*i)+2;
	}
		
	//restituisce l'indice del padre
	
	public int parent(int i) {
		return (int) Math.floor(i/2);
	}
		  
	//permette di verificare l'heap-order
	
	public void minHeapify(int i) {
	
		NodoBinaryTree[] A = this.heap;
		
		int l = this.left(i); //indice figliosx
		int r = this.right(i); //indice figliodx
		int min = i;
		
		if (l<this.size && A[l].getChiave()<A[i].getChiave())
			min = l;
		
		if (r<this.size && A[r].getChiave()<A[min].getChiave())
			min = r;
		
		if(min!=i) {
			NodoBinaryTree temp = A[i];
		    A[i] = A[min];
		    A[min] = temp;
		    minHeapify(min);
		}
	}
	
	//riorganizzo correttamente il minHeap
	
	public void buildMinHeap() {
		NodoBinaryTree[] A = this.heap;
		for(int i = (int) Math.floor(A.length/2); i>=0; i--) {
			this.minHeapify(i);
		}
	}
	
	//inserisco n nel minHeap
	
	public void insert(NodoBinaryTree n) {
		NodoBinaryTree[] A = this.heap;
		this.size++;
		A[size-1]= n;
	    int i = size-1; //indice della foglia in cui ho inserito n
	    int p = this.parent(i); //indice del padre della foglia 
	    while (i>=0 && A[p].getChiave()>A[i].getChiave()) {
	    	NodoBinaryTree temp = A[i];
		    A[i] = A[p];
		    A[p] = temp;
		    i = p;
		    p=this.parent(i);
	    }
	}
		  
	//restituisce l'elemento con chiave minima (radice) senza rimuoverlo
	
	public NodoBinaryTree minimum () {
		
		if (this.size==0) //caso in cui l'heap e' vuoto
			return null;
		
		return this.heap[0];
	}
		  
	//restituisce e rimuove l'elemento con chiave minima (radice)
	
	public NodoBinaryTree extractMin() {
		NodoBinaryTree[] A = this.heap;
		
		if(this.size==0) //caso in cui l'heap e' vuoto
			return null;
		
		NodoBinaryTree min = A[0];
		
	    A[0] = A[this.size-1]; //copio l'ultima foglia in prima posizione e poi gli invoco la minHeapify
	    A[this.size-1] = null; //dealloco l'ultimo elemento
	    this.size--; //decremento la dimensione dell'heap
	    this.minHeapify(0);
	    return min; 
	}
	
}

