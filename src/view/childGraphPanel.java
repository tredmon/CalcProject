package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;



import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class childGraphPanel extends JPanel{

	double[][] coordinates;
	private double xMin;
	private double xMax;
	private double yMin;
	private double yMax;
			
	public childGraphPanel()
	{
		super();
//		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(250,200));
		this.setSize(new Dimension(250,200));
		this.setBackground(Color.WHITE);
	}
	@Override
	public void paint(Graphics g)
	{		
		super.paint(g);
		g.setColor(Color.BLACK);
		drawGraph(g);
			
	}
	public void Graph(double [][] array)
	{
		coordinates = array;
		
	}
	public void drawGraph(Graphics g)
	{
		double ratioW = getWidth() / (xMax - xMin);
		double ratioH = getHeight() / (yMax - yMin);
		double originx = -1.0 * xMin * ratioW;
		double originy = yMin * ratioH;
		g.drawLine(getWidth(), (int)originy, 0, (int)originy);
		g.drawLine((int)originx, 0, (int)originx, getHeight());
		System.out.println("origin at ("+(int)originx+", "+(int)originy+")");
		if(coordinates != null){
			for(int x = 0; x < coordinates.length-1; x++)
			{
//				g.drawLine((int)(originx+coordinates[x][0]*ratioW), (int)(originy-coordinates[x][1]*ratioH), (int)(originx+coordinates[x][0]*ratioW), (int)(originy-coordinates[x][1]*ratioH));
				g.drawLine((int)(originx+coordinates[x][0]*ratioW), (int)(originy-coordinates[x][1]*ratioH), (int)(originx+coordinates[x+1][0]*ratioW), (int)(originy-coordinates[x+1][1]*ratioH));
				System.out.println("line:"+x+" from:("+(int)(originx+coordinates[x][0]*ratioW)+", "+(int)(originy-coordinates[x][1]*ratioH)+") to:("+(int)(originx+coordinates[x+1][0]*ratioW)+", "+(int)(originy-coordinates[x+1][1]*ratioH)+") originally from:("+coordinates[x][0]+", "+coordinates[x][1]+") to:("+coordinates[x+1][0]+", "+coordinates[x+1][1]+")");
			}
		}
	}
	public void DRAWGraph(Double MinX, Double MaxX, Double MinY, Double MaxY, double[][] xy)
	{
		xMin = MinX;
		xMax = MaxX;
		yMin = MinY;
		yMax = MaxY;
		Graph(xy);
		repaint();
	}
}
