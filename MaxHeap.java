import java.util.Scanner;


public  class MaxHeap{
	private int size;
	private int maxsize;
	private int[] Heap;
    
    public MaxHeap(int maxsize){
    	this.maxsize = maxsize;
    	this.size = 0;
    	Heap = new int[this.maxsize];
    }
    private int parent(int pos){
    	return (pos-1)/2;
    }

    private int leftChild(int pos){
    	return  (2*pos)+1;
    }

    private int rightChild(int pos){
    	return (2*pos)+2;
    }

    private boolean isLeaf(int pos){
    	if(pos >= size/2  && pos<= size)
    		return true;
    	else
    		return false;
    }

    private void swap(int x, int y){
    	int temp = Heap[x];
    	Heap[x] = Heap[y];
    	Heap[y] =  temp;
    }

//1. BottomUp Heapify
    private void BottomUpHeapify(int i){
         
        while(parent(i)>=0 &&  Heap[parent(i)] < Heap [i]){
    		swap(i, parent(i));
    		i = parent(i);
    	}

    }
// 2.Top Down Heapify
    private void topDownHeapify(int i){
        int  l = leftChild(i);
        int  r = rightChild(i);
         int j;
         while(r<size){    
             if(Heap[l]< Heap[r])
             	j = r;
             else  j=l;

             if(Heap[j]>Heap[i]){
             	swap(i,j);
             	i = j;
             	l = leftChild(i);
             	r = rightChild(i);
             }
            
         }

         if ((l == size-1) && (Heap[i]<Heap[l])) {
             	swap(i,l);
             }
        
    }

//3. Insert Key
    private void insert(int ele){
    	if(size == maxsize){
    		System.out.println("Overflow");
    		return;
    	}
    	int i= size;

    	Heap[size++] = ele;
        
        BottomUpHeapify(i);       
    }
//4. MaxHeapify
   private void maxheapify(int i){
    	int l = leftChild(i);
    	int r = rightChild(i);
    	int largest;

    	if((l<size) && Heap[i]<Heap[l])
    		largest = l;
    	else
    		largest =i;
    	if((r<size) && Heap[largest]<Heap[r])
    		largest = r;

    	if(largest != i){
    		swap(largest,i);
    		maxheapify(largest);
    	}

    }
//5. Build heap
    private void BuildHeap(){
    	// taking the input
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int x;
    	for(int i = 0; i<n; i++){
    	     x  = sc.nextInt();
    	     Heap[i] =x;
    	 }
    	size = n;
        
    	int startIndex = (size/2) -1;
    	for(int i = startIndex ; i>=0 ; i-- )
              maxheapify(i);

    }
     
 //6. decrease key;
    private void decreaseKey(int i, int x){
    	Heap[i] = x;
    	topDownHeapify(i);
    }
 //7. extract max
    
    private int  deletemax(){
    	swap(0,size-1);
        int max = Heap[size-1];
        size--;
        topDownHeapify(0);
        return max;
    }

 //8.print heap
    public void print() 
    { 
        for (int i = 0; i <size; i++) { 
            System.out.print(Heap[i] + " "); 
        } 
        System.out.println(); 
    } 
//9. FInd max
    private int findmax(){
    	return Heap[0];
    }
    

	public static void main(String[] args) {
	     System.out.println(" Bulid Heap");
	     MaxHeap maxheap = new MaxHeap(12);

	    maxheap.BuildHeap();
	    maxheap.print();
	    maxheap.insert(9);
	    maxheap.print();
	    int max  = maxheap.deletemax();
        System.out.println(" Max element which has been deleted : "+max);
         max  = maxheap.deletemax();
        System.out.println(" Max element which has been deleted : "+max);
         max  = maxheap.deletemax();
        System.out.println(" Max element which has been deleted : "+max);
         max  = maxheap.deletemax();
        System.out.println(" Max element which has been deleted : "+max);

        maxheap.print();
        maxheap.decreaseKey(0,-1);

        maxheap.print();


	}
}