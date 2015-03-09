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
		//g.setColor(Color.WHITE);
		//g.fillRect(0, 0, getWidth(), getHeight());
//		g.fillRect(0, 0, 200, 200);
//		g.fillRect(getX(), getY(), 200, 200);
		g.setColor(Color.BLACK);
		g.drawLine(getWidth(), getHeight()/2, 0, getHeight()/2);
		g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
		
			
	}
	public void Graph(double [][] array)
	{
		coordinates = array;
		
		
		
		
	}
	public void drawGraph(Graphics g)
	{
		
		for(int x = 0; x < coordinates.length; x++)
		{
			
			//g.drawLine(coordinates[x][0],coordinates[x][1], coordinates[x][0],coordinates[x][1]);
		}
	}
	public void DRAWGraph(Double MinX, Double MaxX, Double MinY, Double MaxY, double[][] xy)
	{
		xMin = MinX;
		xMax = MaxX;
		yMin = MinY;
		yMax = MaxY;
		coordinates = xy;
		repaint();
	}
}
