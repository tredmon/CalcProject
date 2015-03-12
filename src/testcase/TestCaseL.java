package testcase;

import main.CalcProjectDriver;

public class TestCaseL {
	

	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("5*20");
		driv.eval();
		System.out.println("\""+driv.input()+"\" should be \"100\"");
		System.exit(0);
	}
}
