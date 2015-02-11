package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyPanel extends JPanel implements ActionListener{
	private JLabel fromText, toText;
	private JTextField numberField;
	private JButton submitButton;
	private ButtonGroup numberFrom, numberTo;
	private JRadioButton binary, octal, decimal, hexadecimal, binary2, octal2, decimal2, hexadecimal2;
	
	public MyPanel() {
		this.fromText = new JLabel("Convert from:");
		this.toText = new JLabel("Convert to:");
		this.numberField = new JTextField(15);
		this.submitButton = new JButton("Submit");
		this.binary = new JRadioButton("Binary");
		this.octal = new JRadioButton("Octal");
		this.decimal = new JRadioButton("Decimal");
		this.hexadecimal = new JRadioButton("Hexadecimal");
		this.binary2 = new JRadioButton("Binary");
		this.octal2 = new JRadioButton("Octal");
		this.decimal2 = new JRadioButton("Decimal");
		this.hexadecimal2 = new JRadioButton("Hexadecimal");
		this.numberFrom = new ButtonGroup();
		this.numberFrom.add(binary);
		this.numberFrom.add(octal);
		this.numberFrom.add(decimal);
		this.numberFrom.add(hexadecimal);
		this.numberTo = new ButtonGroup();
		this.numberTo.add(binary2);
		this.numberTo.add(octal2);
		this.numberTo.add(decimal2);
		this.numberTo.add(hexadecimal2);
		
		this.submitButton.addActionListener(this);
		
		this.setLayout(new GridLayout(12, 3));
		
		this.add(numberField);
		this.add(fromText);
		this.add(binary);
		this.add(octal);
		this.add(decimal);
		this.add(hexadecimal);
		this.add(toText);
		this.add(binary2);
		this.add(octal2);
		this.add(decimal2);
		this.add(hexadecimal2);
		this.add(submitButton);
		
		
		
 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
