package testcase;

import main.CalcProjectDriver;

public class TestCaseH {
	
	public static void main(String[] args) {
		
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("rt625");
		driv.eval();
		System.out.println("\""+ driv.input() +"\" should be \"25\"");
		System.exit(0);
		
	}

}
