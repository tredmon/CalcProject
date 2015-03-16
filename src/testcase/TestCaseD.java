package testcase;

import main.CalcProjectDriver;

public class TestCaseD {
	
	public static void main(String[] args)
	{
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(8);
//		driv.mode('d');
		driv.mode('r');
//		driv.input("sin(asin(0.7))");
		driv.input("asin(0.7)");
		driv.input("sin(0.7)");
		driv.eval();
		System.out.println(("\""+ driv.input() + "\" should be \"7\""));
		System.exit(0);
	}
		
	

}
