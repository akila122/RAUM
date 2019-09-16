package raum2;

public class Generator {

    public Generator(int N) {
        if (N<=0) N = 100;
        this.N = N;
    }
    
    public Generator(){
        this(100);
    }

  
    public void setN(int N) {
        this.N = N;
    }

    
    public double[] getArr(){
    
        double[] ret = new double[N];
        for(int i = 0; i<N; i++) {
        	ret[i] = f(i);
        };
        shuffle(ret);
        return ret;
        
       }

   
    public static String marshallize(double arr[]) {
    	
    	StringBuffer sb = new StringBuffer("[");
    	for(int i=0;i<arr.length;i++) {
    		
    		sb.append(arr[i]);
    		if(i != arr.length-1) sb.append(",");
    		else sb.append("]");
    		
    	}
    	return sb.toString();
    }
 
    public enum ShuffleMode { LOW, MED, HIGH };
    
    private void shuffle(double[] ret) {
        
        for(int k=0; k<(myMode.ordinal()+1)*50;k++){
            
            for(int i=0; i<N; i++){
                
                int rand = (int) (Math.random()*N);
                
                while(rand==i) rand = (int) (Math.random()*N);
                
                double temp = ret[i];
                ret[i] = ret[rand];
                ret[rand]=temp;
                
            }
            
        }
        
    }
    
    private static ShuffleMode myMode = ShuffleMode.MED;

    private int N;
    
    public enum FUN_TYPE{SQR,CUB,SQRT,LIN,LN,COS}
    
    private static FUN_TYPE fType = FUN_TYPE.LIN;
    
    public static void setFunType(FUN_TYPE t) {
    	
    	fType = t;
    	
    }

    public static void setGenType(ShuffleMode mode) {
    	
    	myMode = mode;
    	
    }
    
    private static double f(int x) {
    	
    	switch(fType) {
    		
    	case SQR:   return x*x;
    	case CUB:   return x*x*x;
    	case SQRT:  return Math.sqrt(x);
    	case LIN:	return x;	
    	case LN:	return Math.log(x+1);
    	case COS:	return Math.cos(x);
    	default:    return x;
    	
    	}
    	
    }
    
}
