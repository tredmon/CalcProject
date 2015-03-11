package testcase;

import main.CalcProjectDriver;

public class TestCaseA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("9.5");
		driv.base(2);
		driv.base(16);
		driv.base(8);
		driv.eval();
		System.out.println("\""+driv.input()+"\" should be \"11.4\"");
//		driv.visify();
	}

}
