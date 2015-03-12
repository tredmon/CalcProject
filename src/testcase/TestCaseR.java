package testcase;

import main.CalcProjectDriver;

public class TestCaseR {
	
	public static void main(String[] args) {
		CalcProjectDriver driv = new CalcProjectDriver();
		driv.base(10);
		driv.input("5^4");
		driv.eval();
		System.out.println("\""+driv.input()+"\" should be \"625\"");
		System.exit(0);
		
	}

}
