package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;		

import model.MathParser;

public class MyPanel extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;

	private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, 
	buttonClear, buttonBackspace, buttonLeftParen, buttonRightParen, buttonExponent, buttonX, buttonDivide,
	buttonMultiply, buttonSubtract, buttonAdd, buttonEquals, buttonDecimal;

	private JButton buttonHexA, buttonHexB, buttonHexC, buttonHexD, buttonHexE, buttonHexF;

	private JButton sin, cos, tan, arcsin, arccos, arctan;

	private JButton Mplus, M, rt, Mod, Ln, Log, e, pi;

	private JButton Or, Xor, Not, And, Lsh, Rsh;

	private JTextField textfield;	

	private JRadioButton rbuttonDegrees, rbuttonRadians, rbuttonBinary, rbuttonOctal, rbuttonDecimal, rbuttonHexadecimal;
	private final int numOffX = 6;
	private final int numOffY = 3;

	private MathParser parser;
	private GraphPanel gp;
	private String memory = "";
	private int numtype = 10;
	private char angletype = 'd';
	private boolean shifttyped = false;
	private int cursor = 0;
	//TODO: draw the cursor

	public MyPanel(GraphPanel gp) {
		super();
		this.addKeyListener(this);
		this.setFocusable(true);

		this.gp = gp;
		gp.addKeyListener(this);

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
		numtype.add(rbuttonHexadecimal);

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
		Mod = new JButton("mod");
		c.gridx = numOffX -4;
		c.gridy = numOffY + 2;
		this.add(Mod, c);
		c.insets = new Insets(0,0,0,0);
		Mod.addActionListener(this);

		Ln = new JButton("ln");
		c.gridx = numOffX -3;
		c.gridy = numOffY + 2;
		this.add(Ln, c);
		Ln.addActionListener(this);

		Log = new JButton("log");
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

		Log = new JButton("log");
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

		for (int i = 0; i < this.getComponents().length; i++) {
			this.getComponents()[i].addKeyListener(this);
		}


		rbuttonDegrees.doClick();
		rbuttonDecimal.doClick();
	}



	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		if(this.buttonClear == source) {
			textfield.setText("");
			cursor = 0;
		}
		else if (this.buttonBackspace == source) {
			cursor -= 1;
			if(cursor < 0){cursor = 0;}
			if(textfield.getText().length()>0){
				textfield.setText(textfield.getText().substring(0,cursor) + textfield.getText().substring(cursor+1));
			}
		}
		else if (this.buttonEquals == source) {
			if (this.rbuttonBinary.isSelected() == true) {
				numtype = 2;
			}
			else if (this.rbuttonOctal.isSelected() == true) {
				numtype = 8;
			}
			else if (this.rbuttonDecimal.isSelected() == true) {
				numtype = 10;
			}
			else if (this.rbuttonHexadecimal.isSelected() == true) {
				numtype = 16;
			}
			else {
				numtype = 10;
			}

			parser = new MathParser(memory, numtype, angletype);
			parser.parse(textfield.getText());
			textfield.setText(parser.evalOutString());
			cursor = textfield.getText().length();
			gp.EvalEquation(parser);
		}
		else if (this.M == source) {
			addAtCursor(memory);
		}
		else if (this.Mplus == source) {
			memory = textfield.getText();
		}
		else if (this.Or == source) {
			addAtCursor("|");
		}
		else if (this.Xor == source) {
			addAtCursor("~");
		}
		else if (this.Not == source) {
			addAtCursor("!");
		}
		else if (this.And == source) {
			addAtCursor("&");
		}
		else if (this.Lsh == source) {
			addAtCursor("<<");
		}
		else if (this.Rsh == source) {
			addAtCursor(">>");
		}
		else if (this.rbuttonBinary == source) {
			parser = new MathParser(memory, numtype, angletype);
			parser.parse(textfield.getText());
			numtype = 2;
			parser.setBase(numtype);
			textfield.setText(parser.evalString());
			cursor = textfield.getText().length();
			button0.setEnabled(true);
			button1.setEnabled(true);
			button2.setEnabled(false);
			button3.setEnabled(false);
			button4.setEnabled(false);
			button5.setEnabled(false);
			button6.setEnabled(false);
			button7.setEnabled(false);
			button8.setEnabled(false);
			button9.setEnabled(false);
			buttonHexA.setEnabled(false);
			buttonHexB.setEnabled(false);
			buttonHexC.setEnabled(false);
			buttonHexD.setEnabled(false);
			buttonHexE.setEnabled(false);
			buttonHexF.setEnabled(false);
		}
		else if (this.rbuttonDecimal == source) {
			parser = new MathParser(memory, numtype, angletype);
			parser.parse(textfield.getText());
			numtype = 10;
			parser.setBase(numtype);
			textfield.setText(parser.evalString());
			cursor = textfield.getText().length();
			button0.setEnabled(true);
			button1.setEnabled(true);
			button2.setEnabled(true);
			button3.setEnabled(true);
			button4.setEnabled(true);
			button5.setEnabled(true);
			button6.setEnabled(true);
			button7.setEnabled(true);
			button8.setEnabled(true);
			button9.setEnabled(true);
			buttonHexA.setEnabled(false);
			buttonHexB.setEnabled(false);
			buttonHexC.setEnabled(false);
			buttonHexD.setEnabled(false);
			buttonHexE.setEnabled(false);
			buttonHexF.setEnabled(false);
		}
		else if (this.rbuttonOctal == source) {
			parser = new MathParser(memory, numtype, angletype);
			parser.parse(textfield.getText());
			numtype = 8;
			parser.setBase(numtype);
			textfield.setText(parser.evalString());
			cursor = textfield.getText().length();
			button0.setEnabled(true);
			button1.setEnabled(true);
			button2.setEnabled(true);
			button3.setEnabled(true);
			button4.setEnabled(true);
			button5.setEnabled(true);
			button6.setEnabled(true);
			button7.setEnabled(true);
			button8.setEnabled(false);
			button9.setEnabled(false);
			buttonHexA.setEnabled(false);
			buttonHexB.setEnabled(false);
			buttonHexC.setEnabled(false);
			buttonHexD.setEnabled(false);
			buttonHexE.setEnabled(false);
			buttonHexF.setEnabled(false);
		}
		else if (this.rbuttonHexadecimal == source) {
			parser = new MathParser(memory, numtype, angletype);
			parser.parse(textfield.getText());
			numtype = 16;
			parser.setBase(numtype);
			textfield.setText(parser.evalString());
			cursor = textfield.getText().length();
			button0.setEnabled(true);
			button1.setEnabled(true);
			button2.setEnabled(true);
			button3.setEnabled(true);
			button4.setEnabled(true);
			button5.setEnabled(true);
			button6.setEnabled(true);
			button7.setEnabled(true);
			button8.setEnabled(true);
			button9.setEnabled(true);
			buttonHexA.setEnabled(true);
			buttonHexB.setEnabled(true);
			buttonHexC.setEnabled(true);
			buttonHexD.setEnabled(true);
			buttonHexE.setEnabled(true);
			buttonHexF.setEnabled(true);
		}
		else if (this.rbuttonDegrees == source) {
			angletype = 'd';
		}
		else if (this.rbuttonRadians == source) {
			angletype = 'r';
		}
		else {
			addAtCursor(((JButton) source).getText());
		}


	}

	public void addAtCursor(String add){
		String precursor = textfield.getText().substring(0,cursor);
		String postcursor = textfield.getText().substring(cursor);
		textfield.setText(precursor + add + postcursor);
		cursor += add.length();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (KeyEvent.getKeyText(e.getKeyCode()).equals("Shift")) {
			this.shifttyped = true;
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Left")){
			this.cursor -= 1;
			if(this.cursor < 0){
				this.cursor = 0;
			}
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Right")){
			this.cursor += 1;
			if(this.cursor > textfield.getText().length()){
				this.cursor = textfield.getText().length();
			}
		}

	}



	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("moo:"+KeyEvent.getKeyText(e.getKeyCode()));
		if (KeyEvent.getKeyText(e.getKeyCode()).equals("Shift")) {
			this.shifttyped = false;
		}
		else if (e.getKeyChar() == '=' || e.getKeyChar() == KeyEvent.VK_ENTER) {
			buttonEquals.doClick();
		}
		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("9") && this.shifttyped) {
			buttonLeftParen.doClick();
		}
		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("0") && this.shifttyped) {
			buttonRightParen.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Comma") && this.shifttyped){
			Lsh.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Period") && this.shifttyped){
			Rsh.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("E") && (this.shifttyped || numtype<14)){
			this.e.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("P")){
			pi.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("M") && this.shifttyped){
			Mplus.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("M") && !this.shifttyped){
			M.doClick();
		}
		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("6") && this.shifttyped) {
			buttonExponent.doClick();
		}
		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Back Quote") && this.shifttyped) {
			Xor.doClick();
		}
		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("1") && this.shifttyped) {	
			Not.doClick();
		}

		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("7") && this.shifttyped) {
			And.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Back Slash") && this.shifttyped){
			Or.doClick();
		}
		
		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("5") && this.shifttyped) {
			Mod.doClick();
		}

		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("X")) {
			buttonX.doClick();
		}

		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("NumPad +") || (KeyEvent.getKeyText(e.getKeyCode()).equals("Equals") && this.shifttyped)) {
			buttonAdd.doClick();
		}
		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("NumPad *") || (KeyEvent.getKeyText(e.getKeyCode()).equals("8") && this.shifttyped)) {
			buttonMultiply.doClick();
		}
		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Minus") || KeyEvent.getKeyText(e.getKeyCode()).equals("NumPad -")) {
			buttonSubtract.doClick();
		}
		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("NumPad /") || KeyEvent.getKeyText(e.getKeyCode()).equals("Slash")) {
			buttonDivide.doClick();
		}

		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("NumPad .") || KeyEvent.getKeyText(e.getKeyCode()).equals("Period")) {
			buttonDecimal.doClick();
		}
		
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("S") && this.shifttyped){
			arcsin.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("S") && !this.shifttyped){
			sin.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("C") && this.shifttyped){
			arccos.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("C") && !this.shifttyped && numtype<12){
			cos.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("T") && this.shifttyped){
			arctan.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("T") && !this.shifttyped){
			tan.doClick();
		}
		
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("L") && this.shifttyped){
			Log.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("L") && !this.shifttyped){
			Ln.doClick();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("R")){
			rt.doClick();
		}

		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Backspace")) {
			this.buttonBackspace.doClick();
		}
		else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Escape")) {
			this.buttonClear.doClick();
		}

		else {
			switch (numtype) {
			case 16: {
				if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")) {
					this.buttonHexA.doClick();
				}
				else if (KeyEvent.getKeyText(e.getKeyCode()).equals("B")) {
					this.buttonHexB.doClick();
				}

				else if (KeyEvent.getKeyText(e.getKeyCode()).equals("C")) {
					this.buttonHexC.doClick();
				}

				else if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")) {
					this.buttonHexD.doClick();
				}

				else if (KeyEvent.getKeyText(e.getKeyCode()).equals("E")) {
					this.buttonHexE.doClick();
				}
				
				else if (KeyEvent.getKeyText(e.getKeyCode()).equals("F")) {
					this.buttonHexF.doClick();
				}

				else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Backspace")) {
					this.buttonHexF.doClick();
				}
			}
			case 10: {
				if (e.getKeyChar() ==   KeyEvent.VK_9) {
					this.button9.doClick();

				}

				else if (e.getKeyChar() ==   KeyEvent.VK_8) {
					this.button8.doClick();
				}
			}
			case 8: {
				if (e.getKeyChar() ==  KeyEvent.VK_7) {
					this.button7.doClick();
				}

				else if (e.getKeyChar() ==  KeyEvent.VK_6) {
					this.button6.doClick();
				}
				else if (e.getKeyChar() ==  KeyEvent.VK_5) {
					this.button5.doClick();
				}

				else if (e.getKeyChar() ==  KeyEvent.VK_4) {
					this.button4.doClick();
				}

				else if (e.getKeyChar() ==  KeyEvent.VK_3) {
					this.button3.doClick();
				}

				else if (e.getKeyChar() ==  KeyEvent.VK_2) {
					this.button2.doClick();
				}
			}
			case 2: {
				if (e.getKeyChar() ==  KeyEvent.VK_1) {
					this.button1.doClick();
				}

				else if (e.getKeyChar() ==  KeyEvent.VK_0) {
					this.button0.doClick();
				}
			}



			}
		}
	}

}