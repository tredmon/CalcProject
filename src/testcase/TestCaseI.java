package testcase;

import main.CalcProjectDriver;

public class TestCaseI {
	
	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("5%2");
		driv.eval();
		System.out.println("\""+driv.input()+"\" should be \"1\"");
		System.exit(0);
}
}