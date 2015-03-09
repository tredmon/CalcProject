package view;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class TablePanel extends JPanel{

	JTable BoundsTable;
	/**
	 * @param args
	 */
	public TablePanel()
	
	
	
	{
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(550,260));
		this.setSize(new Dimension(550,260));
		MinVal(0.0, 10.0, 2.0, 10.0, 5.0);
		
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
		table.getColumnModel().getColumn(0).setCellEditor(new noEditor());
		table.getColumnModel().getColumn(1).setCellEditor(new noEditor());
	}
		public void  MinVal(Double MinX, Double MaxX, Double MinY, Double MaxY, Double DeltaX)
		
		{
			
			
			
			JLabel label = new JLabel("Bounds");
			label.setHorizontalAlignment(JLabel.CENTER);
			add(label);
			
			String[] columnNames = new String[2];
			columnNames[0] = "";
			columnNames[1] = "";
			
			Object[][] row = new Object[5][2];
			row[0][0] = "MinX";
			row[1][0] = "MaxX";
			row[2][0] = "MinY";
			row[3][0] = "MaxY";
			row[4][0] = "DeltaX";
			
			row[0][1] = MinX.toString();
			row[1][1] = MaxX.toString();
			row[2][1] = MinY.toString();
			row[3][1] = MaxY.toString();
			row[4][1] = DeltaX.toString();
			
			BoundsTable = new JTable(row, columnNames);
			add(BoundsTable);
			
			
			BoundsTable.getColumnModel().getColumn(0).setCellEditor(new noEditor());
			
		}
		public static class noEditor extends DefaultCellEditor
		{
			public noEditor()
			{
				super(new JTextField());
				
				
			}
			public Object getCellEditorValue()
			{
				return null;
			}
			@Override
			public Component getTableCellEditorComponent(JTable table, Object object, boolean Boolean, int INT1, int INT2)
			{
				return null;
				
			}
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
		public JTable getMinTable()
		{
			return BoundsTable;
			
			
		}

}
