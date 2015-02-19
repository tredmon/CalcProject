package edu.neumont.csc150.calc.test;

public class testMath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IUserInterface ui = UserInterfaceFactories.getInstance();
		String input = ui.promptStringInput();
		System.out.println(TheMath.deciToBinary(input));

	}

}
