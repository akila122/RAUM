
package raum2.Algorithms;

public class SelectionSort extends SortAlgo {
   
    @Override
    protected void startSort() {
        
        int n = arr.length; 
  
    
        for (int i = 0; i < n-1; i++){ 

            int min_idx = i; 
            for (int j = i+1; j < n; j++) { 
                cmpCnt++;
            	if (arr[j] < arr[min_idx]) {
                    min_idx = j; 
            }
          }
           
            double temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp;
            swapCnt++;
            callMatLab();
        
        }
    }
    
}
