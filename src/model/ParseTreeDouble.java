package model;
import java.util.ArrayList;


public class ParseTreeDouble extends ParseTree<Double>{
	public ParseTreeDouble(){
		super();
	}
	@Override
	public ParseTreeDouble getInstance(Double data, ParseFunc<Double> f, ParseTree<Double> node1, ParseTree<Double> node2, ArrayList<ParseFunc<Double>> arr) {
		ParseTreeDouble ret = new ParseTreeDouble();
		ret.init(data, f, node1, node2, arr);
		return ret;
	}
	@Override
	public Double parseData(String parse) {
		return parseData(parse, 10);
	}
	public Double parseData(String parse, int base) {
		Double ret = null;
		if(parse != null && parse.length() > 0){
			//TODO: parse using MyMath.parse(), utilizing base
			String numstr = parse;
			switch(base){
				case 2:
					numstr = TheMath.binToDecimal(parse);
					break;
				case 8:
					numstr = TheMath.octToDecimal(parse);
					break;
				case 10:
					break;
				case 16:
					numstr = TheMath.hexToDecimal(parse);
					break;
				default:
					System.out.println("ERR: cannot parseData as a base:"+base);
			}
			try{
				ret = Double.parseDouble(numstr);
			}
			catch(NumberFormatException e){
				ret = new Double(0);
			}
		}
		return ret;
	}
}
