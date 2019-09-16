
package raum2.Algorithms;

public class HeapSort extends SortAlgo {
	  
	
	@Override
	protected void startSort() {
	     
		sort();
	}

    private void sort(){ 
        int n = arr.length; 
   
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(n, i); 
  
        for (int i=n-1; i>=0; i--){
         
            double temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            swapCnt++;
            callMatLab();
         
            heapify(i, 0); 
        } 
    } 
    
    private void heapify(int n, int i) {
        
        int largest = i; 
        int l = 2*i + 1;
        int r = 2*i + 2;
        
        if (l < n && arr[l] > arr[largest]) {
            largest = l; 
        }
 
        if (r < n && arr[r] > arr[largest]) {
            largest = r; 
        }
  
        cmpCnt+=2;
        
        if (largest != i) {
            
            double swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
            swapCnt++;
            callMatLab();
            heapify(n, largest); 
        }
        
    }

}
