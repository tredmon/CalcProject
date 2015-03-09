package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class GraphPanel extends JFrame{
	  TablePanel Panel;
	  childGraphPanel GraphPanel;
	 
	public GraphPanel()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setLocationRelativeTo(null);
		
		Panel = new TablePanel();
		  this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		  GraphPanel = new childGraphPanel();
			 

		  this.add(Panel);
		  this.add(GraphPanel);
		this.pack();
	}
	public void DrawGraph()
	{
		JTable StrMinTable = Panel.getMinTable();
		
		
		Double MinX = (Double) StrMinTable.getModel().getValueAt(0, 1);
		Double MaxX = (Double) StrMinTable.getModel().getValueAt(1, 1);
		Double MinY = (Double) StrMinTable.getModel().getValueAt(2, 1);
		Double MaxY = (Double) StrMinTable.getModel().getValueAt(3, 1);
				
		TableModel Model = Panel.getXYTable().getModel();
		double[][] xy = new double[Model.getRowCount()][Model.getColumnCount()];
		for(int i=0; i<xy.length; i++){
			for(int j=0; j<xy[i].length; j++){
				xy[i][j] = (double) Model.getValueAt(i, j);
			}
		}
		GraphPanel.DRAWGraph(MinX, MaxX, MinY, MaxY, xy);
		
	}
	
	
}
