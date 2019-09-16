
package raum2.Algorithms;

public class InsertionSort extends SortAlgo {

    @Override
    protected void startSort() {
       
        int i,j;
        double key;
        
        for(i=1;i<arr.length;i++){
            
            key=arr[i];
            j=i-1;
            
            while( j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
                swapCnt++;
                cmpCnt++;
                callMatLab();
            }
            arr[j+1] = key;
            swapCnt++;
            callMatLab();
        }
        
    }
  
       
}
