package model;

public class MathParser extends ParseTreeDouble{
	public MathParser(){
		super();
		add(new ParseFunc<Double>("+",400,"PLUS"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) + parent.getNodeVal2(0.0);
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("-",400,"MINUS"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) - parent.getNodeVal2(0.0);
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("*",300,"MULT"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) * parent.getNodeVal2(0.0);
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("/",300,"DIV"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) / parent.getNodeVal2(0.0);
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("%",300,"MOD"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) % parent.getNodeVal2(0.0);
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("!",200,"NOT"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.not() function
//					ret = MyMath.not(parent.getNodeVal1(0.0));
					ret = Double.longBitsToDouble(~Double.doubleToRawLongBits(parent.getNodeVal1(0.0)));
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("<<",500,"SHIFTL"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.shiftleft() function
//					ret = MyMath.shiftleft(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
					long amnt = (long)(double)parent.getNodeVal2(1.0);
					ret = Double.longBitsToDouble(Double.doubleToRawLongBits(parent.getNodeVal1(0.0)) << amnt);
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>(">>",500,"SHIFTR"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.shiftright() function
//					ret = MyMath.shiftright(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
					long amnt = (long)(double)parent.getNodeVal2(1.0);
					ret = Double.longBitsToDouble(Double.doubleToRawLongBits(parent.getNodeVal1(0.0)) >> amnt);
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("&",800,"AND"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.and() function
//					ret = MyMath.and(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
					ret = Double.longBitsToDouble(Double.doubleToRawLongBits(parent.getNodeVal1(0.0)) & Double.doubleToRawLongBits(parent.getNodeVal2(0.0)));
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("~",900,"XOR"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.xor() function
//					ret = MyMath.xor(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
					ret = Double.longBitsToDouble(Double.doubleToRawLongBits(parent.getNodeVal1(0.0)) ^ Double.doubleToRawLongBits(parent.getNodeVal2(0.0)));
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("|",1000,"OR"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.or() function
//					ret = MyMath.or(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
					ret = Double.longBitsToDouble(Double.doubleToRawLongBits(parent.getNodeVal1(0.0)) | Double.doubleToRawLongBits(parent.getNodeVal2(0.0)));
				}
				return ret;
			}
		});
		
		add(new ParseGroupFunc<Double>("(",")",100,"PARENTH"));

	}
}
