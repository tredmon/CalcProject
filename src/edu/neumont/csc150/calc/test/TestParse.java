package edu.neumont.csc150.calc.test;
import java.util.ArrayList;

import model.ParseFunc;
import model.ParseGroupFunc;
import model.ParseTree;
import model.ParseTreeDouble;


public class TestParse {
	public static void main(String[] args) {
		String str = "3+4%6-2";
		ParseTree<Double> doubtree = new ParseTreeDouble();
		doubtree.add(new ParseFunc<Double>("+",400,"PLUS"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) + parent.getNodeVal2(0.0);
				}
				return ret;
			}
		});
		doubtree.add(new ParseFunc<Double>("-",400,"MINUS"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) - parent.getNodeVal2(0.0);
				}
				return ret;
			}
		});
		doubtree.add(new ParseFunc<Double>("*",300,"MULT"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) * parent.getNodeVal2(0.0);
				}
				return ret;
			}
		});
		doubtree.add(new ParseFunc<Double>("/",300,"DIV"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) / parent.getNodeVal2(0.0);
				}
				return ret;
			}
		});
		doubtree.add(new ParseFunc<Double>("%",300,"MOD"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) % parent.getNodeVal2(0.0);
				}
				return ret;
			}
		});
		doubtree.add(new ParseGroupFunc<Double>("(",")",100,"PARENTH"));
		for(ParseFunc p : doubtree.getFunctionList()){
			System.out.print(p.getName()+" ");
		}
		System.out.println();
		doubtree.sort();
		for(ParseFunc p : doubtree.getFunctionList()){
			System.out.print(p.getName()+" ");
		}
		System.out.println();
		
		ParseTree<Double> tree = doubtree.parse(str);
//		System.out.println(str+" = "+tree+" = "+eval(tree));
		System.out.println(str+" = "+doubtree+" = "+doubtree.eval());
	}
//	public static ParseTree<Double> parse(String str){
//		ParseTree.Function[] tokens = ParseTree.Function.values();
//		ParseTree.Function firsttoken = null;
//		int firsttokenpos = str.length();
//		for(int i=0; i<tokens.length; i++){
//			int tmpstart = str.indexOf(ParseTree.parsefuncs[i]);
//			if(tmpstart >= 0 && tmpstart < firsttokenpos){
//				firsttokenpos = tmpstart;
//				firsttoken = tokens[i];
//			}
//		}
//		ParseTree<Double> ret = new ParseTree<Double>();
//		if(firsttoken == null){
//			ret.setData(Double.parseDouble(str));
//		}
//		else{
//			ret.setNode1(new ParseTree<Double>(Double.parseDouble(str.substring(0, firsttokenpos))));
//			ret.setNode2(parse(str.substring(firsttokenpos+ParseTree.parsefuncs[firsttoken.ordinal()].length())));
//		}
//		ret.setFunction(firsttoken);
//		return ret;
//	}
//	public static double eval(ParseTree<Double> p){
//		Double ret = 0.0;
//		if(p != null){
//			double left = eval(p.getNode1());
//			double right = eval(p.getNode2());
//			if(p.getFunction() == null){
//				ret = p.getData();
//			}
//			else{
//				switch(p.getFunction()){
//					case DIVIDE:
//						ret = left / right;
//						break;
//					case MINUS:
//						ret = left - right;
//						break;
//					case MODULO:
//						ret = left % right;
//						break;
//					case MULTIPLY:
//						ret = left * right;
//						break;
//					case PLUS:
//						ret = left + right;
//						break;
//					default:
//						ret = p.getData();
//						break;
//				}
//			}
//			System.out.println(p.getData()+" D "+left+" "+p.getFunction()+" "+right+" = "+ret);
//		}
//		if(ret == null){
//			ret = 0.0;
//		}
//		return ret;
//	}
}
