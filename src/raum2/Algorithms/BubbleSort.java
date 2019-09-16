
package raum2.Algorithms;

public class BubbleSort extends SortAlgo{
    
    @Override
    protected void startSort(){
        
        for(int i=0; i<arr.length; i++){
            
            for(int j=0; j<arr.length-i-1; j++){
            	
            	cmpCnt++;
                if(arr[j]>arr[j+1]){
                    double temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapCnt++;
                    callMatLab();
                }
            }
            
        }
        
        
    }
    
}
