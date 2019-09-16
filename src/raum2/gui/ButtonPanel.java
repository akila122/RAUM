package raum2.gui;


import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import raum2.Algorithms.*;

public class ButtonPanel extends JPanel  {
	

	public static void enableBtns() {
		for(JButton b : btns) b.setEnabled(true);
	}
	
	public ButtonPanel() {
		setUp();
	}
	
	private static JButton[]  btns = new JButton[7];
	
	private static void blockBtns() {
		
		for(JButton b : btns) b.setEnabled(false);
		
	}
	
	private void setUp() {
		
		setLayout(new GridLayout(7,1));
		
		setSize(600,7*180);
		
		String[] names = {"BblSort.png","HpSort.png","MrgSort.png","QckSort.png","InsSort.png","ShellSort.png","SelectionSort.png"};
		
		for(int i=0; i<names.length;i++) {
			
			btns[i] = new JButton();
			btns[i].setIcon(new ImageIcon(names[i]));
			btns[i].setSize(600, 180);
			add(btns[i]);
			
		}
		
		btns[0].addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {				
								new BubbleSort();
								blockBtns();
								}
						});
		btns[1].addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {				
								new HeapSort();
								blockBtns();
								}
						});
		 btns[2].addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {				
								new MergeSort();
								blockBtns();
								}
						});
		btns[3].addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {				
								new QuickSort();
								blockBtns();
								}
						});
		btns[4].addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {				
								new InsertionSort();
								blockBtns();
								}
						});
		btns[5].addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {				
								new ShellSort();
								blockBtns();
								}
						});
		btns[6].addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {				
								new SelectionSort();
								blockBtns();
								}
						});
			
	
	}

}
