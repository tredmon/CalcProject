package model;

public class MathParser extends ParseTreeDouble{
	private String mstr;
	public MathParser(){
		this(null);
	}
	public MathParser(String mem){
		super();
		setMem(mem);
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
		add(new ParseFunc<Double>("^",250,"POW"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = Math.pow(parent.getNodeVal1(0.0), parent.getNodeVal2(0.0));
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("rt",250,"ROOT"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					if(parent.getNode1()==null){
						ret = Math.sqrt(parent.getNodeVal2(0.0));
					}
					else{
						//TODO: implement a root() function
//						ret = root(parent.getNodeVal2(0.0), parent.getNodeVal1(2.0));
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("!",200,"NOT"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				parent.setNode1(parent.getInstance());
				parent.getNode1().setData(1.0);
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.not() function
//					ret = MyMath.not(parent.getNodeVal2(0.0));
					ret = Double.longBitsToDouble(~Double.doubleToRawLongBits(parent.getNodeVal2(0.0)));
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
		add(new ParseFunc<Double>("M",1010,"MEM"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				if(!str.equals(ret)){
					parent.parse(mstr);
				}
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getInstance(parent.getFunctionList(), mstr).eval();
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("e",1010,"EULER"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.E field
//					ret = MyMath.E;
					ret = 2.71;
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("π",1010,"PI"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.PI field
//					ret = MyMath.PI;
					ret = 3.14;
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("sin",90,"SIN"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				parent.setNode1(parent.getInstance());
				parent.getNode1().setData(1.0);
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.sin() function
					ret = Math.sin(parent.getNodeVal2(0.0));
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("cos",90,"COS"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				parent.setNode1(parent.getInstance());
				parent.getNode1().setData(1.0);
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.cos() function
					ret = Math.cos(parent.getNodeVal2(0.0));
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("tan",90,"TAN"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				parent.setNode1(parent.getInstance());
				parent.getNode1().setData(1.0);
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.tan() function
					ret = Math.tan(parent.getNodeVal2(0.0));
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("asin",91,"ASIN"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				parent.setNode1(parent.getInstance());
				parent.getNode1().setData(1.0);
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.asin() function
					ret = Math.asin(parent.getNodeVal2(0.0));
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("acos",91,"ACOS"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				parent.setNode1(parent.getInstance());
				parent.getNode1().setData(1.0);
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.acos() function
					ret = Math.acos(parent.getNodeVal2(0.0));
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("atan",91,"ATAN"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				parent.setNode1(parent.getInstance());
				parent.getNode1().setData(1.0);
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use MyMath.atan() function
					ret = Math.atan(parent.getNodeVal2(0.0));
				}
				return ret;
			}
		});
		
		add(new ParseGroupFunc<Double>("(",")",Integer.MAX_VALUE,"PARENTH"));
		add(new ParseFunc<Double>("0",Integer.MIN_VALUE,"DATA"){
			@Override
			public String parse(ParseTree<Double> parent, String parse){
				String ret = parse;
				if(parent != null){
					parent.setData(parent.parseData(parse));
					ret = "";
				}
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getData();
				}
				return ret;
			}
		});
		sortr();
	}
	@Override
	public MathParser parse(String parse){
		return (MathParser) super.parse(parse);
	}
	public void setMem(String mem){
		if(mem == null){
			mstr = "";
		}
		else{
			mstr = mem;
		}
	}
}
