package raum2;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import raum2.Algorithms.*;
import raum2.gui.*;


public class Main extends JFrame {
	
	public static Font myFont;
	
	public Main() {
		
		super("SIMULACIJA ALGORITAMA SORTIRANJA");
		
		setLayout(new GridLayout(1,2));
		JPanel btns=new ButtonPanel();
		setExtendedState(Frame.MAXIMIZED_BOTH); 
		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(1,2));
		fields.add(new FieldsPanel());
		fields.add(new RadioPanel());
		add(fields);
		add(btns);
		
		Font myFont = null;
		try {
			myFont = Font.createFont(Font.TRUETYPE_FONT,new FileInputStream(new File("Gugi-Regular.ttf"))).deriveFont(Font.PLAIN,25);
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {	
			dispose();
		}
		});
	
		changeFont(this,myFont);
		
		FieldsPanel.regulateFonts();
		
		try {
			(new MusicPlayer()).play();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
		
		setVisible(true);
		
	}
	
	public static void changeFont ( Component component, Font font )
	{
	    component.setFont ( font );
	    if ( component instanceof Container )
	    {
	        for ( Component child : ( ( Container ) component ).getComponents () )
	        {
	            changeFont ( child, font );
	        }
	    }
	}
	public static void main(String[] args)
	   {
		   SortAlgo.startMatlab();
		   new Main();
	   }
}