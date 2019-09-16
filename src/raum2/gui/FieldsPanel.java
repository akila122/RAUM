package raum2.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import raum2.Generator;
import raum2.Algorithms.SortAlgo;
import raum2.Generator.ShuffleMode;

public class FieldsPanel extends JPanel {
	
	public static int getN() {
		int n=0;
		try {
			n = Integer.parseInt(nField.getText());
			if (n <= 0) throw new Exception();
		}catch(Exception err) {
			nField.setText("Nekorektno! Za N uzeto 100!");
			
			n=100;
		}
		return n;
	}
	

	public FieldsPanel() {
		setUp();
	}
	
	public static void updateReport(int cmp, int swp) {
		
		report.setText(" CmpCnt : "+cmp+"   SwpCnt : "+swp);
		
	}
	
	public static void regulateFonts() {
		
		area.setFont(area.getFont().deriveFont(Font.PLAIN,14));
	}
	
	private void setUp() {
		
		this.setLayout(new GridLayout(7,1));
		
		JSlider jSlider = new JSlider(JSlider.HORIZONTAL, V_MIN, V_MAX, V_INIT);
		jSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				JSlider source = (JSlider)e.getSource();
			    if (!source.getValueIsAdjusting()) {
			        double fps = source.getValue();
			        fps=10-fps;
			        fps/=10;
			        SortAlgo.changeRate(fps);
			}
			}});

		jSlider.setMajorTickSpacing(2);
		jSlider.setMinorTickSpacing(1);
		jSlider.setPaintTicks(true);
		jSlider.setPaintLabels(true);
		jSlider.setBackground(new Color(31,40,51));
		jSlider.setForeground(new Color(102,252,241));
	
		
		
		JLabel l2  = new JLabel(" N - elemenata niza");
		l2.setForeground(new Color(102,252,241));
		add(l2);
		nField.setBackground(new Color(31,40,51));
		nField.setForeground(new Color(102,252,241));
		nField.setSize(401, 55);
		add(nField);

		
		JPanel sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridLayout(2,1));
		JLabel l1 = new JLabel(" Regulacija brzine");
		l1.setForeground(new Color(102,252,241));
		sliderPanel.add(l1);
		sliderPanel.add(jSlider);
		add(sliderPanel);
		
		sliderPanel.setBackground(new Color(31,40,51));
		sliderPanel.setForeground(new Color(102,252,241));
		
	
		JLabel l = new JLabel(" Kontrola neuredjenosti niza");
		l.setBackground(new Color(31,40,51));
		l.setForeground(new Color(102,252,241));
		add(l);
		
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3,1));
		
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton cb = new JRadioButton(" Niska", false);
		group.add(cb);
		p2.add(cb);
		cb.setBackground(new Color(31,40,51));
		cb.setForeground(new Color(102,252,241));
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) Generator.setGenType(ShuffleMode.LOW);
				
				
			}
			
		});
		
		cb = new JRadioButton(" Srednja", true);
		group.add(cb);
		p2.add(cb);
		cb.setBackground(new Color(31,40,51));
		cb.setForeground(new Color(102,252,241));
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) Generator.setGenType(ShuffleMode.MED);
				
				
			}
			
		});
		
		cb = new JRadioButton(" Visoka", false);
		group.add(cb);
		p2.add(cb);
		cb.setBackground(new Color(31,40,51));
		cb.setForeground(new Color(102,252,241));
		cb.addItemListener(new ItemListener() {

			@Override
		public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) Generator.setGenType(ShuffleMode.HIGH);
				
				
			}
			
		});
		add(p2);
		
		
		add(report);
		
		setBackground(new Color(31,40,51));
		setForeground(new Color(102,252,241));
		
		
		p2.setBackground(new Color(31,40,51));
		p2.setForeground(new Color(102,252,241));
		
		report.setForeground(new Color(102,252,241));
		
		area.setEditable(false);
		area.setBackground(new Color(31,40,51));
		area.setForeground(new Color(102,252,241));
		String msg = " Filip Borvicanovic 241|16\n Aleksa Rajkovic 248|16\n Marko Arsenovic 424|16\n"
					+ " Prof:"
					+ " Malesevic Branko, Jovovic Ivana, Koledin Tamara\n"
					+ " Implementirano za potrebe kursa RAUM\n"
					+ " Elektrotehnicki fakultet Univerziteta u Beogradu\n Novembar 2018.";	
		area.setText(msg);
		
		add(area);
	}
	private static JLabel report = new JLabel();
	private static JTextField nField = new JTextField();
	private static JTextArea area = new JTextArea();
	static final int V_MIN = 0;
	static final int V_MAX = 10;
	static final int V_INIT = 10;
	
}
