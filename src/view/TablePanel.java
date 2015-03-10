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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class TablePanel extends JPanel{

	JTable BoundsTable;
	JTable XYTable; 
	JScrollPane xyscroller;
	GraphPanel par;

	public TablePanel(GraphPanel parent)
	{
		super();
		par = parent;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(550,260));
		this.setSize(new Dimension(550,260));
		MinVal(-10.0, 10.0, -10.0, 10.0, 1.0);

		JLabel label = new JLabel("Table View");
		label.setVerticalAlignment(JLabel.CENTER);		
		add(label);

		setTable(new Double[][]{new Double[]{0.0, 0.0}});
	}
	public void setTable(Double[][] tablevals){
		String[] columnNames = new String[2];
		columnNames[1] = "Y";
		columnNames[0] = "X";

		XYTable = new JTable(tablevals,columnNames);
		
		if(xyscroller != null){
			remove(xyscroller);
		}
		xyscroller = new JScrollPane(XYTable);
		XYTable.setFillsViewportHeight(true);
		add(xyscroller);
		XYTable.getColumnModel().getColumn(0).setCellEditor(new noEditor());
		XYTable.getColumnModel().getColumn(1).setCellEditor(new noEditor());
		invalidate();
		revalidate();
		repaint();
	}
	public class TabelModel implements TableModelListener
	{
		@Override
		public void tableChanged(TableModelEvent arg0) 
		{
			par.DrawGraph();
			
		}
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

		if(BoundsTable != null)
		{
			remove(BoundsTable);
		
		}
		BoundsTable = new JTable(row, columnNames);
		add(BoundsTable);


		BoundsTable.getColumnModel().getColumn(0).setCellEditor(new noEditor());
		
		BoundsTable.getModel().addTableModelListener(new TabelModel());
		BoundsTable.getColumnModel().getColumn(1).setCellEditor(new numEditor());
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
	public class numEditor extends DefaultCellEditor{
		public numEditor(){
			super(new JTextField());
		}
		@Override public boolean stopCellEditing(){
			JTextField input = (JTextField) this.getComponent();
		    String text = input.getText();
		    try {
		       double value = Double.parseDouble(text);
		        return true && super.stopCellEditing();
		    } catch (NumberFormatException dsa) {
//		    	((JTextField)input).setText("0");
		        return false;
		    }
		}
	}
	public JTable getMinTable()
	{
		return BoundsTable;
	}
	public JTable getXYTable()
	{
		return XYTable;
	}

}
