package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;



import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class childGraphPanel extends JPanel{

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
	
}
