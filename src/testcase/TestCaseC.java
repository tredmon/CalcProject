package testcase;

import main.CalcProjectDriver;

public class TestCaseC {
	public static void main(String[] args)
	{

	CalcProjectDriver driv = new CalcProjectDriver();
	driv.base(10);
	driv.mode('d');
	driv.input("3+4*2+7");
	driv.eval();
	System.out.println(("\""+ driv.input() + "\" should be \"18\""));
	System.exit(0);

}
}
