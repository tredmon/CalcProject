package testcase;

import main.CalcProjectDriver;

public class TestCaseG {
	
	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("10");
		System.out.println("Press M+ and then M and the result should be 10");
		driv.visify();
	}
}
