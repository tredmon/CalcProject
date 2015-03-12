package testcase;

import main.CalcProjectDriver;

public class TestCaseM {
	
	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("100/20");
		driv.eval();
		System.out.println("\""+driv.input()+"\" should be \"5\"");
		System.exit(0);
		
	}

}
