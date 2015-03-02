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
	
	JButton buttonHexA, buttonHexB, buttonHexC, buttonHexD, buttonHexE, buttonHexF;
	
	JButton sin, cos, tan, arcsin, arccos, arctan;
	
	JButton Mplus, M, rt, Mod, Ln, Log, e, pi;
	
	JRadioButton rbuttonDegrees, rbuttonRadians, rbuttonBinary, rbuttonOctal, rbuttonDecimal, rbuttonHexadecimal;
	private final int numOffX = 6;
	private final int numOffY = 3;
	
	public MyPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c =  new GridBagConstraints();
		ButtonGroup numtype = new ButtonGroup();
		ButtonGroup angletype = new ButtonGroup();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;

		c.gridwidth = 2;

		rbuttonBinary = new JRadioButton("Binary");
		c.gridx = numOffX  -6;
		c.gridy = numOffY -3;
		this.add(rbuttonBinary, c);
		
		rbuttonOctal = new JRadioButton("Octal");
		c.gridx = numOffX  -6;
		c.gridy = numOffY -2;
		this.add(rbuttonOctal, c);
		
		rbuttonDecimal = new JRadioButton("Decimal");
		c.gridx = numOffX  -6;
		c.gridy = numOffY -1;
		this.add(rbuttonDecimal, c);
		
		rbuttonHexadecimal = new JRadioButton("Hexadecimal");
		c.gridx = numOffX  -6;
		c.gridy = numOffY;
		this.add(rbuttonHexadecimal, c);
		
		numtype.add(rbuttonBinary);
		numtype.add(rbuttonDecimal);
		numtype.add(rbuttonOctal);
		numtype.add(rbuttonOctal);
		
		c.gridwidth = 1;

		rbuttonRadians = new JRadioButton("Radians");
		c.gridx = numOffX -3;
		c.gridy = numOffY -2;
		this.add(rbuttonRadians, c);
		
		rbuttonDegrees = new JRadioButton("Degrees");
		c.gridx = numOffX -4;
		c.gridy = numOffY -2;
		this.add(rbuttonDegrees, c);
		
		angletype.add(rbuttonDegrees);
		angletype.add(rbuttonRadians);;
		
		sin = new JButton("sin");
		c.gridx = numOffX -4;
		c.gridy = numOffY -1;
		this.add(sin, c);
		
		cos = new JButton("cos");
		c.gridx = numOffX -3;
		c.gridy = numOffY -1;
		this.add(cos, c);
		
		tan = new JButton("tan");
		c.gridx = numOffX -2;
		c.gridy = numOffY -1;
		this.add(tan, c);
		
		arcsin = new JButton("Sin-");
		c.gridx = numOffX -4;
		c.gridy = numOffY;
		this.add(arcsin, c);
		
		arccos = new JButton("Cos-");
		c.gridx = numOffX -3;
		c.gridy = numOffY;
		this.add(arccos, c);
		
		arctan = new JButton("Tan-");
		c.gridx = numOffX -2;
		c.gridy = numOffY;
		this.add(arctan, c);
		
		Mplus = new JButton("M+");
		c.gridx = numOffX -4;
		c.gridy = numOffY + 1;
		this.add(Mplus, c);
		
		M = new JButton("M");
		c.gridx = numOffX -3;
		c.gridy = numOffY + 1;
		this.add(M, c);
		
		rt = new JButton("rt");
		c.gridx = numOffX -2;
		c.gridy = numOffY + 1;
		this.add(rt, c);
		
		Mod = new JButton("Mod");
		c.gridx = numOffX -4;
		c.gridy = numOffY + 2;
		this.add(Mod, c);
		
		Ln = new JButton("Ln");
		c.gridx = numOffX -3;
		c.gridy = numOffY + 2;
		this.add(Ln, c);
		
		Log = new JButton("Log");
		c.gridx = numOffX -2;
		c.gridy = numOffY + 2;
		this.add(Log, c);
		
		e = new JButton("e");
		c.gridx = numOffX -4;
		c.gridy = numOffY + 3;
		this.add(e, c);
		
		pi = new JButton("pi");
		c.gridx = numOffX -2;
		c.gridy = numOffY + 3;
		this.add(pi, c);
		
		Log = new JButton("Log");
		c.gridx = numOffX -2;
		c.gridy = numOffY + 2;
		this.add(Log, c);
		
		buttonHexA = new JButton("A"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY  -2;
		this.add(buttonHexA, c);
		
		buttonHexB = new JButton("B"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY  -1;
		this.add(buttonHexB, c);
		
		buttonHexC = new JButton("C"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY + 0;
		this.add(buttonHexC, c);
		
		buttonHexD = new JButton("D"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY + 1;
		this.add(buttonHexD, c);
		
		buttonHexE = new JButton("E"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY + 2;
		this.add(buttonHexE, c);
		
		buttonHexF = new JButton("F"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY + 3;
		this.add(buttonHexF, c);
		
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
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
