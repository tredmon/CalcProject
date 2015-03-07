package edu.neumont.csc150.calc.test;

import model.MathParser;
import model.ParseFunc;


public class TestParse {
	public static void main(String[] args) {
		MathParser tree = new MathParser();
		for(ParseFunc p : tree.getFunctionList()){
			System.out.print(p.getName()+" ");
		}
		System.out.println();
		
		String str = "3+4%6-2";
		tree.parse(str);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval());
		
		str = "3+(2)+1";
		tree.parse(str);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval());
		
		str = "sin(32+58)+7";
		tree.parse(str);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval());
		
		str = "4+(3)+(1)+2";
		tree.parse(str);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval());
		
		str = "(((2+2)))";
		tree.parse(str);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval());
		
		str = "(((2)))";
		tree.parse(str);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval());
		
		str = "(2)+1";
		tree.parse(str);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval());
		
		str = "1+(2)";
		tree.parse(str);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval());
		
		str = "2+X+3";
		tree.parse(str);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval(3));
		
		str = "12+13";
		tree.parse(str, 8);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval(3));
		
		str = "12";
		tree.parse(str, 8);
		System.out.println("\""+str+"\" = "+tree+" = "+tree.evalOutString()+" = "+tree.eval(3));
		
	}
}
