package testcase;

import main.CalcProjectDriver;

public class TestCaseE {
	
	public static void main(String[] args)
	{
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.mode('d');
		driv.input("X^2+4X+8");
		driv.graphBounds(-1, 1, 0, 15, 1);
		driv.eval();
		driv.visify();
	
	}
		

}
