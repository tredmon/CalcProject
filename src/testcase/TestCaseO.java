package testcase;

import main.CalcProjectDriver;

public class TestCaseO {
	
	
	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("4000 + 3000");
		driv.eval();
		System.out.println("\""+driv.input()+"\" should be \"7000\"");
		System.exit(0);
	}
}
