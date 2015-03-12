package testcase;

import main.CalcProjectDriver;

public class TestCaseJ {
	
	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("5*pi");
		driv.eval();
		System.out.println("\""+driv.input()+"\" should be \"15.707963267948966192313216916398\"");
		System.exit(0);
		
		
		
		
		
	}
}
