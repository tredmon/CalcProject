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

	JButton Or, Xor, Not, And, Lsh, Rsh;

	JTextField textfield;	

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
		rbuttonBinary.addActionListener(this);

		textfield = new JTextField("0");
		c.gridwidth = 8;
		c.gridx = numOffX -4;
		c.gridy = numOffY -3;
		this.add(textfield, c);
		c.gridwidth = 2;
		textfield.setEditable(false);
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		textfield.addActionListener(this);


		rbuttonOctal = new JRadioButton("Octal");
		c.gridx = numOffX  -6;
		c.gridy = numOffY -2;
		this.add(rbuttonOctal, c);
		rbuttonOctal.addActionListener(this);

		rbuttonDecimal = new JRadioButton("Decimal");
		c.gridx = numOffX  -6;
		c.gridy = numOffY -1;
		this.add(rbuttonDecimal, c);
		rbuttonDecimal.addActionListener(this);

		rbuttonHexadecimal = new JRadioButton("Hexadecimal");
		c.gridx = numOffX  -6;
		c.gridy = numOffY;
		this.add(rbuttonHexadecimal, c);
		rbuttonHexadecimal.addActionListener(this);

		numtype.add(rbuttonBinary);
		numtype.add(rbuttonDecimal);
		numtype.add(rbuttonOctal);
		numtype.add(rbuttonOctal);

		c.gridwidth = 1;

		rbuttonRadians = new JRadioButton("Radians");
		c.gridx = numOffX -3;
		c.gridy = numOffY -2;
		this.add(rbuttonRadians, c);
		rbuttonRadians.addActionListener(this);

		rbuttonDegrees = new JRadioButton("Degrees");
		c.gridx = numOffX -4;
		c.gridy = numOffY -2;
		this.add(rbuttonDegrees, c);
		rbuttonDegrees.addActionListener(this);

		angletype.add(rbuttonDegrees);
		angletype.add(rbuttonRadians);;

		Or = new JButton("Or");
		c.gridx = numOffX -6;
		c.gridy = numOffY + 1;
		this.add(Or, c);
		Or.addActionListener(this);

		Xor = new JButton("Xor");
		c.gridx = numOffX -5;
		c.gridy = numOffY + 1;
		this.add(Xor, c);
		Xor.addActionListener(this);

		Not = new JButton("Not");
		c.gridx = numOffX -6;
		c.gridy = numOffY + 2;
		this.add(Not, c);
		Not.addActionListener(this);


		And = new JButton("And");
		c.gridx = numOffX -5;
		c.gridy = numOffY + 2;
		this.add(And, c);
		And.addActionListener(this);

		Lsh = new JButton("Lsh");
		c.gridx = numOffX -6;
		c.gridy = numOffY + 3;
		this.add(Lsh, c);
		Lsh.addActionListener(this);

		Rsh = new JButton("Rsh");
		c.gridx = numOffX -5;
		c.gridy = numOffY + 3;
		this.add(Rsh, c);
		Rsh.addActionListener(this);

		c.insets = new Insets(0,10,0,0);
		sin = new JButton("sin");
		c.gridx = numOffX -4;
		c.gridy = numOffY -1;
		this.add(sin, c);
		c.insets = new Insets(0,0,0,0);
		sin.addActionListener(this);

		cos = new JButton("cos");
		c.gridx = numOffX -3;
		c.gridy = numOffY -1;
		this.add(cos, c);
		cos.addActionListener(this);

		tan = new JButton("tan");
		c.gridx = numOffX -2;
		c.gridy = numOffY -1;
		this.add(tan, c);
		tan.addActionListener(this);

		c.insets = new Insets(0,10,0,0);
		arcsin = new JButton("asin");
		c.gridx = numOffX -4;
		c.gridy = numOffY;
		this.add(arcsin, c);
		c.insets = new Insets(0,0,0,0);
		arcsin.addActionListener(this);

		arccos = new JButton("acos");
		c.gridx = numOffX -3;
		c.gridy = numOffY;
		this.add(arccos, c);
		arccos.addActionListener(this);

		arctan = new JButton("atan");
		c.gridx = numOffX -2;
		c.gridy = numOffY;
		this.add(arctan, c);
		arctan.addActionListener(this);

		c.insets = new Insets(0,10,0,0);
		Mplus = new JButton("M+");
		c.gridx = numOffX -4;
		c.gridy = numOffY + 1;
		this.add(Mplus, c);
		c.insets = new Insets(0,0,0,0);
		Mplus.addActionListener(this);

		M = new JButton("M");
		c.gridx = numOffX -3;
		c.gridy = numOffY + 1;
		this.add(M, c);
		M.addActionListener(this);

		rt = new JButton("rt");
		c.gridx = numOffX -2;
		c.gridy = numOffY + 1;
		this.add(rt, c);
		rt.addActionListener(this);

		c.insets = new Insets(0,10,0,0);
		Mod = new JButton("Mod");
		c.gridx = numOffX -4;
		c.gridy = numOffY + 2;
		this.add(Mod, c);
		c.insets = new Insets(0,0,0,0);
		Mod.addActionListener(this);

		Ln = new JButton("Ln");
		c.gridx = numOffX -3;
		c.gridy = numOffY + 2;
		this.add(Ln, c);
		Ln.addActionListener(this);

		Log = new JButton("Log");
		c.gridx = numOffX -2;
		c.gridy = numOffY + 2;
		this.add(Log, c);
		Log.addActionListener(this);

		c.insets = new Insets(0,10,0,0);
		e = new JButton("e");
		c.gridx = numOffX -4;
		c.gridy = numOffY + 3;
		this.add(e, c);
		c.insets = new Insets(0,0,0,0);
		e.addActionListener(this);

		pi = new JButton("pi");
		c.gridx = numOffX -2;
		c.gridy = numOffY + 3;
		this.add(pi, c);
		pi.addActionListener(this);

		Log = new JButton("Log");
		c.gridx = numOffX -2;
		c.gridy = numOffY + 2;
		this.add(Log, c);
		Log.addActionListener(this);

		c.insets = new Insets(0,10,0,10);
		buttonHexA = new JButton("A"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY  -2;
		this.add(buttonHexA, c);
		buttonHexA.addActionListener(this);	


		buttonHexB = new JButton("B"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY  -1;
		this.add(buttonHexB, c);
		buttonHexB.addActionListener(this);

		buttonHexC = new JButton("C"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY + 0;
		this.add(buttonHexC, c);
		buttonHexC.addActionListener(this);

		buttonHexD = new JButton("D"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY + 1;
		this.add(buttonHexD, c);
		buttonHexD.addActionListener(this);

		buttonHexE = new JButton("E"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY + 2;
		this.add(buttonHexE, c);
		buttonHexE.addActionListener(this);

		buttonHexF = new JButton("F"); 
		c.gridx = numOffX  -1;
		c.gridy = numOffY + 3;
		this.add(buttonHexF, c);
		c.insets = new Insets(0,0,0,0);
		buttonHexF.addActionListener(this);

		button1 = new JButton("1");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + 2;
		this.add(button1, c);
		button1.addActionListener(this);

		button2 = new JButton("2");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + 2;
		this.add(button2, c);
		button2.addActionListener(this);


		button3 = new JButton("3");
		c.gridx = numOffX + 2;
		c.gridy = numOffY + 2;
		this.add(button3, c);
		button3.addActionListener(this);

		button4 = new JButton("4");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + 1;
		this.add(button4, c);
		button4.addActionListener(this);

		button5 = new JButton("5");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + 1;
		this.add(button5, c);
		button5.addActionListener(this);

		button6 = new JButton("6");
		c.gridx = numOffX + 2;
		c.gridy = numOffY + 1;
		this.add(button6, c);
		button6.addActionListener(this);

		button7 = new JButton("7");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + 0;
		this.add(button7, c);
		button7.addActionListener(this);

		button8 = new JButton("8");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + 0;
		this.add(button8, c);
		button8.addActionListener(this);

		button9 = new JButton("9");
		c.gridx = numOffX + 2;
		c.gridy = numOffY + 0;
		this.add(button9, c);
		button9.addActionListener(this);

		button0 = new JButton("0");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + 3;
		this.add(button0, c);
		button0.addActionListener(this);

		buttonLeftParen = new JButton("(");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + -1;
		this.add(buttonLeftParen, c);
		buttonLeftParen.addActionListener(this);

		buttonRightParen = new JButton(")");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + -1;
		this.add(buttonRightParen, c);
		buttonRightParen.addActionListener(this);

		buttonExponent = new JButton("^");
		c.gridx = numOffX + 2;
		c.gridy = numOffY + -1;
		this.add(buttonExponent, c);
		buttonExponent.addActionListener(this);

		buttonX = new JButton("X");
		c.gridx = numOffX + 3;
		c.gridy = numOffY + -1;
		this.add(buttonX, c);
		buttonX.addActionListener(this);

		buttonDivide = new JButton("/");
		c.gridx = numOffX + 3;
		c.gridy = numOffY + 0;
		this.add(buttonDivide, c);
buttonDivide.addActionListener(this);
		
		buttonMultiply = new JButton("*");
		c.gridx = numOffX + 3;
		c.gridy = numOffY + 1;
		this.add(buttonMultiply, c);
buttonMultiply.addActionListener(this);
		
		buttonSubtract = new JButton("-");
		c.gridx = numOffX + 3;
		c.gridy = numOffY + 2;
		this.add(buttonSubtract, c);
		buttonSubtract.addActionListener(this);

		buttonAdd = new JButton("+");
		c.gridx = numOffX + 3;
		c.gridy = numOffY + 3;
		this.add(buttonAdd, c);
		buttonAdd.addActionListener(this);

		buttonDecimal = new JButton(".");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + 3;
		this.add(buttonDecimal, c);
		buttonDecimal.addActionListener(this);

		buttonEquals = new JButton("=");
		c.gridx = numOffX + 2;
		c.gridy = numOffY + 3;
		this.add(buttonEquals, c);
		buttonEquals.addActionListener(this);

		buttonClear = new JButton("Clr");
		c.gridx = numOffX + 0;
		c.gridy = numOffY + -2;
		this.add(buttonClear, c);
		buttonClear.addActionListener(this);

		buttonBackspace = new JButton("Backspace");
		c.gridx = numOffX + 1;
		c.gridy = numOffY + -2;
		c.gridwidth = 3;
		this.add(buttonBackspace, c);
		c.gridwidth = 0;
		buttonBackspace.addActionListener(this);



	}

	public void actionPerformed(ActionEvent e) {
		JButton tempbutton = (JButton)e.getSource();
		switch(tempbutton.getText()) {
		case "Clr":
			textfield.setText("");
			break;
		case "Backspace":
			String tempstring = "";
			for (int i=0; i < textfield.getText().length() - 1; i++) {
				tempstring += textfield.getText().charAt(i);
			}
			textfield.setText(tempstring);
			break;
		case "=":
//			textfield.setText(parsething(textfield.getText()));
			break;
		default:
			textfield.setText(textfield.getText() + "" + tempbutton.getText());
			break;
		}
		
	}
}
