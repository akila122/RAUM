
package raum2.Algorithms;

public class QuickSort extends SortAlgo {
    
	@Override
    protected void startSort() {
        quickSort(0,arr.length-1);
    }

    private int partition(int low, int high) {
        
        double pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++){
        	
            cmpCnt++;
            if (arr[j] <= pivot){
                
                i++;  
                double temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp;
                swapCnt++;
                callMatLab();
            } 
        } 
        double temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        swapCnt++;
        callMatLab();
  
        return i+1; 
    } 
  
    private void quickSort(int low, int high){ 
        
        if (low < high){   
            
            int pi = partition(low, high); 
            quickSort(low, pi-1); 
            quickSort(pi+1, high); 
        } 
    }
 
}
