package testcase;

import main.CalcProjectDriver;

public class TestCaseB {
	public static void main(String[] args)
	{
	
	CalcProjectDriver driv = new CalcProjectDriver();
	driv.base(10);
	driv.mode('d');
	driv.input("sin(32+58)+7");
	driv.eval();
	System.out.println("\""+ driv.input() + "\" should be \"8\"");
	System.exit(0);

}
}