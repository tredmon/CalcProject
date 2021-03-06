package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.MathParser;

public class GraphPanel extends JFrame{
	private static final long serialVersionUID = 1L;
	TablePanel Panel;
	  childGraphPanel GraphPanel;
	  MathParser eq;
	 
	public GraphPanel()
	{
		super("Graph");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Panel = new TablePanel(this);
		this.setLayout(new BorderLayout());

		GraphPanel = new childGraphPanel();


		this.add(Panel, BorderLayout.WEST);
		this.add(GraphPanel, BorderLayout.CENTER);
		this.pack();
		EvalEquation(null);
	}
	public void EvalEquation(MathParser eq){
		this.eq = eq;
		EvalEquation();
	}
	public void EvalEquation(){
		double dx = Double.parseDouble(""+Panel.getMinTable().getModel().getValueAt(4, 1));
		double minx = Double.parseDouble(""+Panel.getMinTable().getModel().getValueAt(0, 1));
		double maxx = Double.parseDouble(""+Panel.getMinTable().getModel().getValueAt(1, 1));
		Double[][] xy = new Double[(int)((maxx-minx)/dx)+1][2];
		double x = minx;
		for(int i=0; i<xy.length; i++, x+=dx){
			xy[i][0] = x;
			if(eq == null){
				xy[i][1] = 0.0;
			}
			else{
				xy[i][1] = eq.eval(x);
			}
		}
		Panel.setTable(xy);
		DrawGraph();
	}
	public void DrawGraph()
	{
		JTable StrMinTable = Panel.getMinTable();
		
		
		Double MinX = Double.parseDouble(""+StrMinTable.getModel().getValueAt(0, 1));
		Double MaxX = Double.parseDouble(""+StrMinTable.getModel().getValueAt(1, 1));
		Double MinY = Double.parseDouble(""+StrMinTable.getModel().getValueAt(2, 1));
		Double MaxY = Double.parseDouble(""+StrMinTable.getModel().getValueAt(3, 1));
				
		TableModel Model = Panel.getXYTable().getModel();
		double[][] xy = new double[Model.getRowCount()][Model.getColumnCount()];
		for(int i=0; i<xy.length; i++){
			for(int j=0; j<xy[i].length; j++){
				xy[i][j] = (double) Model.getValueAt(i, j);
			}
		}
		GraphPanel.DRAWGraph(MinX, MaxX, MinY, MaxY, xy);
	}
	public void setGraphBounds(double minx, double maxx, double miny, double maxy, double deltax){
		Panel.MinVal(minx,maxx, miny,maxy, deltax);
	}
	
	
}
