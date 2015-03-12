package testcase;

import main.CalcProjectDriver;

public class TestCaseN {
	
	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("5-20");
		driv.eval();
		System.out.println("\""+driv.input()+"\" should be \"-15\"");
		System.exit(0);
		
		
		
		
	}

}
