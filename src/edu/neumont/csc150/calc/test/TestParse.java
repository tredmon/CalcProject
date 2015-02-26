package edu.neumont.csc150.calc.test;
import java.util.ArrayList;

import model.MathParser;
import model.ParseFunc;
import model.ParseTree;


public class TestParse {
	public static void main(String[] args) {
		String str = "3+4%6-2";
		MathParser doubtree = new MathParser();
		for(ParseFunc p : doubtree.getFunctionList()){
			System.out.print(p.getName()+" ");
		}
		System.out.println();
		
		doubtree.parse(str);
		System.out.println(str+" = "+doubtree+" = "+doubtree.eval());
	}
}
