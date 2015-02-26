package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MyPanel extends JPanel implements ActionListener{
	JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, 
	buttonClear, buttonBackspace, buttonLeftParen, buttonRightParen, buttonExponent, buttonX, buttonDivide,
	buttonMultiply, buttonSubtract, buttonAdd, buttonEquals, buttonDecimal;
	private final int numOffY = 3;
	private final int numOffX = 3;
	
	public MyPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c =  new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;

		// Calculator setup		
		button1 = new JButton("1");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + 2;
		this.add(button1, c);
		
		button2 = new JButton("2");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + 2;
		this.add(button2, c);
		
		button3 = new JButton("3");
		c.gridx = numOffX + 2;
		c.gridy = numOffY + 2;
		this.add(button3, c);
		
		button4 = new JButton("4");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + 1;
		this.add(button4, c);
		
		button5 = new JButton("5");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + 1;
		this.add(button5, c);
		
		button6 = new JButton("6");
		c.gridx = numOffX + 2;
		c.gridy = numOffY + 1;
		this.add(button6, c);
		
		button7 = new JButton("7");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + 0;
		this.add(button7, c);
		
		button8 = new JButton("8");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + 0;
		this.add(button8, c);
		
		button9 = new JButton("9");
		c.gridx = numOffX + 2;
		c.gridy = numOffY + 0;
		this.add(button9, c);
		
		button0 = new JButton("0");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + 3;
		this.add(button0, c);
		
		buttonLeftParen = new JButton("(");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + -1;
		this.add(buttonLeftParen, c);
		
		buttonRightParen = new JButton(")");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + -1;
		this.add(buttonRightParen, c);
		
		buttonExponent = new JButton("^");
		c.gridx = numOffX + 2;
		c.gridy = numOffY + -1;
		this.add(buttonExponent, c);
		
		buttonX = new JButton("X");
		c.gridx = numOffX + 3;
		c.gridy = numOffY + -1;
		this.add(buttonX, c);
		
		buttonDivide = new JButton("/");
		c.gridx = numOffX + 3;
		c.gridy = numOffY + 0;
		this.add(buttonDivide, c);
		
		buttonMultiply = new JButton("*");
		c.gridx = numOffX + 3;
		c.gridy = numOffY + 1;
		this.add(buttonMultiply, c);
		
		buttonSubtract = new JButton("-");
		c.gridx = numOffX + 3;
		c.gridy = numOffY + 2;
		this.add(buttonSubtract, c);
		
		buttonAdd = new JButton("+");
		c.gridx = numOffX + 3;
		c.gridy = numOffY + 3;
		this.add(buttonAdd, c);
		
		buttonDecimal = new JButton(".");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + 3;
		this.add(buttonDecimal, c);
		
		buttonEquals = new JButton("=");
		c.gridx = numOffX + 2;
		c.gridy = numOffY + 3;
		this.add(buttonEquals, c);
		
		
		buttonClear = new JButton("Clr");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + -2;
		this.add(buttonClear, c);
		
		buttonBackspace = new JButton("Backspace");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + -2;
		c.gridwidth = 3;
		this.add(buttonBackspace, c);
		c.gridwidth = 0;
		
		/*
		this.fromText = new JLabel("Convert from:");
		this.toText = new JLabel("Convert to:");
		this.numberField = new JTextField(15);
		this.submitButton = new JButton("Submit");
		this.binary = new JRadioButton("Binary");
		this.octal = new JRadioButton("Octal");
		this.decimal = new JRadioButton("Decimal");
		this.hexadecimal = new JRadioButton("Hexadecimal");

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
		*/
		
		
 
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
