
package raum2.Algorithms;

public class MergeSort extends SortAlgo {
	
	   @Override
	    protected void startSort() {
	        
	        mergeSort(0,arr.length-1);
	        
	    }
    
	   private void merge(int l,int m,int r){
        
        int n1 = m - l + 1;
        int n2 = r - m;
        
        double L[] = new double[n1];
        double R[] = new double[n2];
        
        for(int i = 0; i < n1; i++ ) L[i] = arr[l+i];
        for(int i = 0; i < n2; i++ ) R[i] = arr[m+1+i];
        
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            
            if(L[i] <= R[j]){
                arr[k] = L[i];
                
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
            cmpCnt++;
            swapCnt++;
            callMatLab();
            
        }
        
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
            swapCnt++;
            callMatLab();
        }
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
            swapCnt++;
            callMatLab();
        }
        
    }
    
	   private void mergeSort(int l,int r){
        
        if(l<r){
            
            int m = (l+r)/2;
            
            mergeSort(l,m);
            mergeSort(m+1,r);
            
            merge(l,m,r);
            
        }
        
    }

 
    
    
}
