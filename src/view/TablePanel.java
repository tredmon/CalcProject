package view;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class TablePanel extends JPanel{

	/**
	 * @param args
	 */
	public TablePanel(){
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(250,20));
		this.setSize(new Dimension(250,20));
		JLabel label = new JLabel("Table View");
		label.setVerticalAlignment(JLabel.CENTER);		
		add(label);
		
		
		
		
		String[] columnNames = new String[2];
		columnNames[1] = "Y";
		columnNames[0] = "X";
		
		
		int NumofItems = 5;
		Double[][] x = new Double[NumofItems][2]; 
		for(int R = 0; R < NumofItems; R++)
		{
			
			for(int C = 0; C < columnNames.length; C++)
			{
				x[R][C] = 2.0;
				
				
			}
		}
		JTable table = new JTable(x,columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
	
		
		add(scrollPane);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
