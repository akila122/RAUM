package raum2.gui;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import raum2.Generator;
import raum2.Generator.FUN_TYPE;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class RadioPanel extends JPanel {
	
	public RadioPanel() {
		setUp();
		this.setBackground(new Color(31,40,51));
		this.setForeground(new Color(102,252,241));
	}

	private void setUp() {
		
		
		this.setLayout(new GridLayout(7,1));
		JLabel l1=new JLabel("Izbor funkcije generatora:");
		l1.setBackground(new Color(31,40,51));
		l1.setForeground(new Color(102,252,241));
		add(l1);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton cb = new JRadioButton("f(x) = x", true);
		group.add(cb);
		add(cb);
		cb.setBackground(new Color(31,40,51));
		cb.setForeground(new Color(102,252,241));
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) Generator.setFunType(FUN_TYPE.LIN);
				
				
			}
			
		});
		
		cb = new JRadioButton("f(x) = x^2", false);
		group.add(cb);
		add(cb);
		cb.setBackground(new Color(31,40,51));
		cb.setForeground(new Color(102,252,241));
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) Generator.setFunType(FUN_TYPE.SQR);
				
				}
			
		});
		
		cb = new JRadioButton("f(x) = x^3", false);
		group.add(cb);
		add(cb);
		cb.setBackground(new Color(31,40,51));
		cb.setForeground(new Color(102,252,241));
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) Generator.setFunType(FUN_TYPE.CUB);
				
				
			}
			
		});
		
		cb = new JRadioButton("f(x) = sqrt(x)", false);
		group.add(cb);
		add(cb);
		cb.setBackground(new Color(31,40,51));
		cb.setForeground(new Color(102,252,241));
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) Generator.setFunType(FUN_TYPE.SQRT);
				
				
			}
			
		});
		
		cb = new JRadioButton("f(x) = cos(x)", false);
		group.add(cb);
		add(cb);
		cb.setBackground(new Color(31,40,51));
		cb.setForeground(new Color(102,252,241));
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) Generator.setFunType(FUN_TYPE.COS);
				
				
			}
			
		});
		
		cb = new JRadioButton("f(x) =log(x+1)", false);
		group.add(cb);
		add(cb);
		cb.setBackground(new Color(31,40,51));
		cb.setForeground(new Color(102,252,241));
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) Generator.setFunType(FUN_TYPE.LN);
				
				
			}
			
		});
	}

	}
