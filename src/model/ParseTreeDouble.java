package model;
import java.util.ArrayList;


public class ParseTreeDouble extends ParseTree<Double>{
	public ParseTreeDouble(){
		super();
	}
	@Override
	public ParseTree<Double> getInstance(Double data,
			ParseFunc<Double> f, ParseTree<Double> node1,
			ParseTree<Double> node2, ArrayList<ParseFunc<Double>> arr) {
		ParseTree<Double> ret = new ParseTreeDouble();
		ret.init(data, f, node1, node2, arr);
		return ret;
	}
	@Override
	public Double parseData(String parse) {
		Double ret = null;
		if(parse != null && parse.length() > 0){
			try{
				ret = Double.parseDouble(parse);
			}
			catch(NumberFormatException e){
				ret = new Double(0);
			}
		}
		return ret;
	}
}
