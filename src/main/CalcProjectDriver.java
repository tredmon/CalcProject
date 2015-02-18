package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.MyPanel;
//import model.Converters;

public class CalcProjectDriver {
	public static void main (String[] args) throws Exception {
		JFrame frame = new JFrame("Converting between number systems");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainpanel = new MyPanel();
		frame.getContentPane().add(mainpanel);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
