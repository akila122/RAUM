
package raum2.Algorithms;
import com.mathworks.engine.MatlabEngine;
import raum2.Generator;
import raum2.gui.ButtonPanel;
import raum2.gui.FieldsPanel;


public abstract class SortAlgo extends Thread{
    
	

    @Override
    public void run(){
        
        
        try{
                startSort();                      

        }
        catch(Exception err){};
        
        ButtonPanel.enableBtns();
        
    }

	public static MatlabEngine startMatlab() {
		try {
		if(eng == null) eng = MatlabEngine.startMatlab();
		}
		catch(Exception err) {System.out.println("ERROR IN startMatLab()");};
		return eng;
	}


	public void eval(String cmnd) {
		try {
		if(eng == null) return;
		eng.eval(cmnd);
		}
		catch(Exception err) {System.out.println("ERROR IN eval()");};
		
		
	}
    
	public static void changeRate(double x) {
		
		RFRSH_RATE = x;
		
	}
	
	protected SortAlgo() {
		start();
	}
	
	protected void callMatLab() {
        
    	String mrshl = Generator.marshallize(arr);
    	
    	String cmnd = "x="+mrshl+";";
    	eval(cmnd);
    	eval("bar(x);");
    	
    	FieldsPanel.updateReport(cmpCnt, swapCnt);
    	
    	if(RFRSH_RATE != 0) {
    		try {
				Thread.sleep((long) (RFRSH_RATE*2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
 
    protected abstract void startSort();
	
    protected Generator myGen = new Generator(FieldsPanel.getN());
    
    protected double[] arr = myGen.getArr();
    
    protected int swapCnt, cmpCnt;
    
    private static MatlabEngine eng;
    
    private static double RFRSH_RATE = 0;
    
}
