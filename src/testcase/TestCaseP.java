package testcase;

import main.CalcProjectDriver;

public class TestCaseP {

	
	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("ln(50)");
		driv.eval();
		System.out.println("\""+driv.input()+"\" should be \"3.9120230054281460586187507879106\"");
		System.exit(0);
}
}
