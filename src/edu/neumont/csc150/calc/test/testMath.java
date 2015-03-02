package edu.neumont.csc150.calc.test;

import java.io.IOException;

import edu.neumont.csc150.payroll.view.IUserInterface;
import edu.neumont.csc150.payroll.view.UserInterfaceFactory;

public class testMath {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		IUserInterface ui = UserInterfaceFactory.getInstance();
		System.out.println(":D");
		System.out.println(TheMath.hexToBinary(ui.promptStringInput()));

	}

}
