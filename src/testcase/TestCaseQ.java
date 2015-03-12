package testcase;

import main.CalcProjectDriver;

public class TestCaseQ {
	
	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("log(1000)");

		driv.eval();
		System.out.println("\""+driv.input()+"\" should be \"3\"");
		System.exit(0);
	}
}
