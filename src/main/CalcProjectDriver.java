package main;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import view.GraphPanel;
import view.MyPanel;

public class CalcProjectDriver {
	private GraphPanel gp;
	private JFrame jfram;
	private MyPanel jpan;
	
	public static void main (String[] args) throws Exception {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.visify();
	}
	public CalcProjectDriver(){
		gp = new GraphPanel();
		jfram = new JFrame("Calculator"){
			@Override public void setVisible(boolean set){
				CalcProjectDriver.this.gp.setVisible(set);
				super.setVisible(set);
			}
		};
		jfram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jpan = new MyPanel(gp);
		jfram.getContentPane().add(jpan);
		
		jfram.pack();
		jfram.setLocationRelativeTo(null);
	}
	public void visify(){
		jfram.setVisible(true);
	}
	
	
	public void graphBounds(double xmin,double xmax, double ymin,double ymax, double deltax){
		gp.setGraphBounds(xmin,xmax,ymin,ymax,deltax);
	}
	public void base(int b) {
		Component[] c = jpan.getComponents();
		for(int i=0; i<c.length; i++){
			if(JRadioButton.class.isAssignableFrom(c[i].getClass())){
				if(((JRadioButton)c[i]).getText().equals("Binary") && b==2){
					((JRadioButton)c[i]).doClick();
				}
				if(((JRadioButton)c[i]).getText().equals("Octal") && b==8){
					((JRadioButton)c[i]).doClick();
				}
				if(((JRadioButton)c[i]).getText().equals("Decimal") && b==10){
					((JRadioButton)c[i]).doClick();
				}
				if(((JRadioButton)c[i]).getText().equals("Hexadecimal") && b==16){
					((JRadioButton)c[i]).doClick();
				}
			}
		}
	}
	public int base(){
		int ret = 10;
		Component[] c = jpan.getComponents();
		for(int i=0; i<c.length; i++){
			if(JRadioButton.class.isAssignableFrom(c[i].getClass()) && ((JRadioButton)c[i]).isSelected()){
				if(((JRadioButton)c[i]).getText().equals("Binary")){
					ret = 2;
				}
				else if(((JRadioButton)c[i]).getText().equals("Octal")){
					ret = 8;
				}
				else if(((JRadioButton)c[i]).getText().equals("Decimal")){
					ret = 10;
				}
				else if(((JRadioButton)c[i]).getText().equals("Hexadecimal")){
					ret = 16;
				}
			}
		}
		return ret;
	}
	public void mode(int a) {
		Component[] c = jpan.getComponents();
		for(int i=0; i<c.length; i++){
			if(JRadioButton.class.isAssignableFrom(c[i].getClass())){
				if(((JRadioButton)c[i]).getText().equals("Degrees") && a=='d'){
					((JRadioButton)c[i]).doClick();
				}
				if(((JRadioButton)c[i]).getText().equals("Radians") && a=='r'){
					((JRadioButton)c[i]).doClick();
				}
			}
		}
	}
	public char mode(){
		char ret = 'd';
		Component[] c = jpan.getComponents();
		for(int i=0; i<c.length; i++){
			if(JRadioButton.class.isAssignableFrom(c[i].getClass()) && ((JRadioButton)c[i]).isSelected()){
				if(((JRadioButton)c[i]).getText().equals("Degrees")){
					ret = 'd';
				}
				else if(((JRadioButton)c[i]).getText().equals("Radians")){
					ret = 'r';
				}
			}
		}
		return ret;
	}
	public void input(String string) {
		Component[] c = jpan.getComponents();
		for(int i=0; i<c.length; i++){
			if(JTextField.class.isAssignableFrom(c[i].getClass())){
				((JTextField)c[i]).setText(string);
			}
		}
	}
	public String input() {
		String ret = "";
		Component[] c = jpan.getComponents();
		for(int i=0; i<c.length; i++){
			if(JTextField.class.isAssignableFrom(c[i].getClass())){
				ret = ((JTextField)c[i]).getText();
			}
		}
		return ret;
	}
	public void eval() {
		Component[] c = jpan.getComponents();
		for(int i=0; i<c.length; i++){
			if(JButton.class.isAssignableFrom(c[i].getClass()) && ((JButton)c[i]).getText().equals("=")){
				((JButton)c[i]).doClick();
			}
		}
	}
}
