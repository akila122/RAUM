
package raum2.Algorithms;

public class ShellSort extends SortAlgo {

    @Override
    protected void startSort() {
        
        int n = arr.length; 
  
 
        for (int gap = n/2; gap > 0; gap /= 2){ 
            for (int i = gap; i < n; i += 1) { 
                
                double temp = arr[i]; 
                int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap]; 
                    cmpCnt++;
                    swapCnt++;
                    callMatLab();
                }
   
                arr[j] = temp;
                swapCnt++;
                callMatLab();
            } 
        } 
    }
    
}
