package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.GraphPanel;
import view.MyPanel;

public class CalcProjectDriver {
	private static GraphPanel gp;
	public static void main (String[] args) throws Exception {
		gp = new GraphPanel();
		JFrame frame = new JFrame("Calculator"){
			@Override public void setVisible(boolean set){
				CalcProjectDriver.gp.setVisible(set);
				super.setVisible(set);
			}
		};
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainpanel = new MyPanel(gp);
		frame.getContentPane().add(mainpanel);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
