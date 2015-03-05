package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class GraphPanel extends JFrame{
	
	public GraphPanel()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setLocationRelativeTo(null);
		
		  TablePanel Panel= new TablePanel();
		  this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		  childGraphPanel GraphPanel = new childGraphPanel();
			 

		  this.add(Panel);
		  this.add(GraphPanel);
			this.pack();
	}
	
}
