package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class childGraphPanel extends JPanel{

	private static final long serialVersionUID = 1L;
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
		double originy = yMax * ratioH;
		g.drawLine(getWidth(), (int)originy, 0, (int)originy);
		g.drawLine((int)originx, 0, (int)originx, getHeight());
		g.setColor(Color.BLUE);
		if(coordinates != null){
			for(int x = 0; x < coordinates.length-1; x++)
			{
				g.drawLine((int)(originx+coordinates[x][0]*ratioW), (int)(originy-coordinates[x][1]*ratioH), (int)(originx+coordinates[x+1][0]*ratioW), (int)(originy-coordinates[x+1][1]*ratioH));
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
