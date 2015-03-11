package model;

import java.util.ArrayList;

public class MathParser extends ParseTreeDouble{
	private String mstr;
	private int bas;
	private double xval;
	private char angle;
	
	private static MathParser emptytree = new MathParser(){
		public Double eval(){
			return null;
		}
		public String evalString(){
			return "";
		}
	};
	public MathParser(){
		this(null, 10, 'd');
	}
	public MathParser(String mem, int base, char angtype){
		super();
		setMem(mem);
		setBase(base);
		setAngle(angtype);
		add(new ParseFunc<Double>("+",400,"PLUS"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = parent.getNodeVal1(0.0) + parent.getNodeVal2(0.0);
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					if(parent.getNode1()!=null){
						ret = parent.getNode1().evalOutString();
					}
					String tmpstr = "";
					if(parent.getNode2()!=null){
						parent.getNode2().evalOutString();
					}
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
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
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null){
					if(parent.getNode1() != null){
						ret = parent.getNode1().evalOutString();
					}
					else{
						ret = ""+0.0;
					}
					String tmpstr = "";
					if(parent.getNode2() != null){
						tmpstr = parent.getNode2().evalOutString();
					}
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
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
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
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
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("%",300,"MOD"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use TheMath.mod()
					ret = parent.getNodeVal1(0.0) % parent.getNodeVal2(0.0);
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("^",250,"POW"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use TheMath.pow()
					ret = Math.pow(parent.getNodeVal1(0.0), parent.getNodeVal2(0.0));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
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
						//TODO: use TheMath.root() function
//						ret = TheMath.root(parent.getNodeVal2(0.0), 2);
						ret = Math.sqrt(parent.getNodeVal2(0.0));
					}
					else{
						//TODO: use TheMath.root() function
//						ret = root(parent.getNodeVal2(0.0), parent.getNodeVal1(2.0));
					}
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("!",200,"NOT"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				if(!ret.equals(str)){
					parent.setNode1(emptytree);
				}
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use TheMath.not() function
//					ret = TheMath.not(parent.getNodeVal2(0.0));
					ret = Double.longBitsToDouble(~Double.doubleToRawLongBits(parent.getNodeVal2(0.0)));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("<<",500,"SHIFTL"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use TheMath.shiftleft() function
//					ret = TheMath.shiftleft(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
					long amnt = (long)(double)parent.getNodeVal2(1.0);
					ret = Double.longBitsToDouble(Double.doubleToRawLongBits(parent.getNodeVal1(0.0)) << amnt);
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>(">>",500,"SHIFTR"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use TheMath.shiftright() function
//					ret = TheMath.shiftright(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
					long amnt = (long)(double)parent.getNodeVal2(1.0);
					ret = Double.longBitsToDouble(Double.doubleToRawLongBits(parent.getNodeVal1(0.0)) >> amnt);
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("&",800,"AND"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use TheMath.and() function
//					ret = TheMath.and(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
					ret = Double.longBitsToDouble(Double.doubleToRawLongBits(parent.getNodeVal1(0.0)) & Double.doubleToRawLongBits(parent.getNodeVal2(0.0)));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("~",900,"XOR"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use TheMath.xor() function
//					ret = TheMath.xor(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
					ret = Double.longBitsToDouble(Double.doubleToRawLongBits(parent.getNodeVal1(0.0)) ^ Double.doubleToRawLongBits(parent.getNodeVal2(0.0)));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("|",1000,"OR"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					//TODO: use TheMath.or() function
//					ret = TheMath.or(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
					ret = Double.longBitsToDouble(Double.doubleToRawLongBits(parent.getNodeVal1(0.0)) | Double.doubleToRawLongBits(parent.getNodeVal2(0.0)));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null && parent.getNode2()!=null){
					ret = parent.getNode1().evalOutString();
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ""+eval(parent);
					}
					else{
						ret = evalString(parent);
					}
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
					if(parent.getNode1() != null){
						ret *= parent.getNodeVal1(1.0);
					}
					if(parent.getNode2() != null){
						ret *= parent.getNodeVal2(1.0);
					}
				}
				return ret;
			}
			@Override
			public String evalString(ParseTree<Double> parent){
				String ret = "";
				if(parent!=null && parent.getNode1()!=null){
					ret += parent.getNode1().evalString()+"*";
				}
				ret += mstr;
				if(parent!=null && parent.getNode2()!=null){
					ret += "*"+parent.getNode2().evalString();
				}
				return mstr;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null){
					ret = parent.getInstance(parent.getFunctionList(), evalString(parent)).evalOutString();
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("e",Integer.MIN_VALUE+1,"EULER"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = TheMath.E;
					if(parent.getNode1() != null){
						ret *= parent.getNodeVal1(1.0);
					}
					if(parent.getNode2() != null){
						ret *= parent.getNodeVal2(1.0);
					}
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				return ""+eval(parent);
			}
		});
		add(new ParseFunc<Double>("pi",Integer.MIN_VALUE+1,"PI"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = TheMath.PI;
					if(parent.getNode1() != null){
						ret *= parent.getNodeVal1(1.0);
					}
					if(parent.getNode2() != null){
						ret *= parent.getNodeVal2(1.0);
					}
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null){
					ret = ""+eval(parent);
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("sin",90,"SIN"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				if(!ret.equals(str) && parent!=null && parent.getNode1()==null){
					parent.setNode1(emptytree);
				}
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = TheMath.sin(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
					if(parent.getNode1()!=emptytree){
						ret *= parent.getNode1().eval();
					}
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					String tmp = "";
					if(parent.getNode1()!=emptytree){
						tmp = parent.getNode1().evalOutString();
					}
					if(((MathParser)parent).isOnlyNumber(ret)){
						if(((MathParser)parent).isOnlyNumber(tmp)){
							ret = ""+eval(parent);
						}
						else{
							ret = ""+TheMath.sin(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
						}
					}
					else if(parent.getNode1()!=emptytree && ((MathParser)parent).isOnlyNumber(tmp)){
						ret = parent.getNode1().evalOutString() +"*"+ ret;
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("cos",90,"COS"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				if(!ret.equals(str) && parent!=null && parent.getNode1()==null){
					parent.setNode1(emptytree);
				}
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = TheMath.cosine(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
					if(parent.getNode1()!=emptytree){
						ret *= parent.getNode1().eval();
					}
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					String tmp = "";
					if(parent.getNode1()!=emptytree){
						tmp = parent.getNode1().evalOutString();
					}
					if(((MathParser)parent).isOnlyNumber(ret)){
						if(((MathParser)parent).isOnlyNumber(tmp)){
							ret = ""+eval(parent);
						}
						else{
							ret = ""+TheMath.cosine(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
						}
					}
					else if(parent.getNode1()!=emptytree && ((MathParser)parent).isOnlyNumber(tmp)){
						ret = parent.getNode1().evalOutString() +"*"+ ret;
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("tan",90,"TAN"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				if(!ret.equals(str) && parent!=null && parent.getNode1()==null){
					parent.setNode1(emptytree);
				}
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = TheMath.tangent(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
					if(parent.getNode1()!=emptytree){
						ret *= parent.getNode1().eval();
					}
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					String tmp = "";
					if(parent.getNode1()!=emptytree){
						tmp = parent.getNode1().evalOutString();
					}
					if(((MathParser)parent).isOnlyNumber(ret)){
						if(((MathParser)parent).isOnlyNumber(tmp)){
							ret = ""+eval(parent);
						}
						else{
							ret = ""+TheMath.tangent(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
						}
					}
					else if(parent.getNode1()!=emptytree && ((MathParser)parent).isOnlyNumber(tmp)){
						ret = parent.getNode1().evalOutString() +"*"+ ret;
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("asin",91,"ASIN"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				if(!ret.equals(str) && parent!=null && parent.getNode1()==null){
					parent.setNode1(emptytree);
				}
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = TheMath.arcsine(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
					if(parent.getNode1()!=emptytree){
						ret *= parent.getNode1().eval();
					}
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					String tmp = "";
					if(parent.getNode1()!=emptytree){
						tmp = parent.getNode1().evalOutString();
					}
					if(((MathParser)parent).isOnlyNumber(ret)){
						if(((MathParser)parent).isOnlyNumber(tmp)){
							ret = ""+eval(parent);
						}
						else{
							ret = ""+TheMath.arcsine(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
						}
					}
					else if(parent.getNode1()!=emptytree && ((MathParser)parent).isOnlyNumber(tmp)){
						ret = parent.getNode1().evalOutString() +"*"+ ret;
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("acos",91,"ACOS"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				if(!ret.equals(str) && parent!=null && parent.getNode1()==null){
					parent.setNode1(emptytree);
				}
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = TheMath.arccosine(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
					if(parent.getNode1()!=emptytree){
						ret *= parent.getNode1().eval();
					}
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					String tmp = "";
					if(parent.getNode1()!=emptytree){
						tmp = parent.getNode1().evalOutString();
					}
					if(((MathParser)parent).isOnlyNumber(ret)){
						if(((MathParser)parent).isOnlyNumber(tmp)){
							ret = ""+eval(parent);
						}
						else{
							ret = ""+TheMath.arccosine(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
						}
					}
					else if(parent.getNode1()!=emptytree && ((MathParser)parent).isOnlyNumber(tmp)){
						ret = parent.getNode1().evalOutString() +"*"+ ret;
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("atan",91,"ATAN"){
			@Override
			public String parse(ParseTree<Double> parent, String str){
				String ret = super.parse(parent, str);
				if(!ret.equals(str) && parent!=null && parent.getNode1()==null){
					parent.setNode1(emptytree);
				}
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = TheMath.arctangent(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
					if(parent.getNode1()!=emptytree){
						ret *= parent.getNode1().eval();
					}
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					String tmp = "";
					if(parent.getNode1()!=emptytree){
						tmp = parent.getNode1().evalOutString();
					}
					if(((MathParser)parent).isOnlyNumber(ret)){
						if(((MathParser)parent).isOnlyNumber(tmp)){
							ret = ""+eval(parent);
						}
						else{
							ret = ""+TheMath.arctangent(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle());
						}
					}
					else if(parent.getNode1()!=emptytree && ((MathParser)parent).isOnlyNumber(tmp)){
						ret = parent.getNode1().evalOutString() +"*"+ ret;
					}
				}
				return ret;
			}
		});
		
		add(new ParseGroupFunc<Double>("(",")",Integer.MAX_VALUE,"PARENTH"){
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1() != null){
					String tmp = parent.getNode1().evalOutString();
					if(((MathParser)parent).isOnlyNumber(tmp)){
						ret = tmp;
					}
					else{
						ret = parent.getNode1().evalOutString() + getParseEnd();
					}
					int tmpin = ret.indexOf(getParse());
					if(tmpin != 0){
						ret = getParse()+ret+getParseEnd();
					}
				}
				else{
					ret += "null";
				}
				return ret;
			}
			@Override
			public String evalString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1() != null){
					ret = parent.getNode1().evalString();
					int tmpin = ret.indexOf(getParse());
					if(tmpin != 0){
						ret = getParse()+ret+getParseEnd();
					}
				}
				else{
					ret += "null";
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("",Integer.MIN_VALUE,"DATA"){
			@Override
			public int find(String str){
				if(str != null){
					return 0;
				}
				return -1;
			}
			@Override
			public String parse(ParseTree<Double> parent, String parse){
				String ret = parse;
				if(parent != null){
					parent.setFunction(this);
					parent.setData(((ParseTreeDouble)parent).parseData(parse, MathParser.this.getBase()));
					parent.setNode1(emptytree);
					parent.setNode2(emptytree);
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
			@Override
			public String evalString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null){
					ret = ""+eval(parent);
					switch(getBase()){
						case 2:
							ret = TheMath.deciToBinary(ret);
							break;
						case 8:
							ret = TheMath.deciToOctal(ret);
							break;
						case 10://already in this base
							break;
						case 16:
							ret = TheMath.deciToHex(ret);
							break;
						default:
							System.out.println("ERR: cannot evalString as a base:"+((MathParser)parent).getBase());
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("X",Integer.MIN_VALUE+1,"VARX"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = null;
				if(parent != null){
					ret = ((MathParser)parent).getX();
					if(parent.getNode1() != null){
						ret *= parent.getNodeVal1(1.0);
					}
					if(parent.getNode2() != null){
						ret *= parent.getNodeVal2(1.0);
					}
				}
				return ret;
			}
			@Override
			public String evalString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1() != null){
					ret += parent.getNode1().evalString();
				}
				ret += getParse();
				if(parent != null && parent.getNode2() != null){
					ret += parent.getNode2().evalString();
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
	public MathParser parse(String parse, int base){
		setBase(base);
		return parse(parse);
	}
	public MathParser parse(String parse, String mem, int base){
		setMem(mem);
		return parse(parse, base);
	}
	public MathParser getInstance(Double data,	ParseFunc<Double> f, ParseTree<Double> node1, ParseTree<Double> node2, ArrayList<ParseFunc<Double>> arr) {
		MathParser ret = new MathParser();
		ret.init(data, f, node1, node2, arr);
		ret.setBase(getBase());
		ret.setMem(getMem());
		ret.setX(getX());
		return ret;
	}
	public Double eval(double xval){
		this.setX(xval);
		return eval();
	}
	public void setMem(String mem){
		if(mem == null){
			mstr = "";
		}
		else{
			mstr = mem;
		}
		if(getNode1()!=null){
			((MathParser)getNode1()).setMem(mstr);
		}
		if(getNode2()!=null){
			((MathParser)getNode2()).setMem(mstr);
		}
	}
	public String getMem(){
		return mstr;
	}
	public void setBase(int base){
		bas = base;
		if(getNode1()!=null){
			((MathParser)getNode1()).setBase(bas);
		}
		if(getNode2()!=null){
			((MathParser)getNode2()).setBase(bas);
		}
	}
	public int getBase(){
		return bas;
	}
	public void setX(double x){
		xval = x;
		if(getNode1()!=null){
			((MathParser)getNode1()).setX(x);
		}
		if(getNode2()!=null){
			((MathParser)getNode2()).setX(x);
		}
	}
	public double getX(){
		return xval;
	}
	public void setAngle(char angtype){
		angle = angtype;
	}
	public char getAngle(){
		return angle;
	}
	public boolean isOnlyNumber(String num){
		boolean ret = true;
		ArrayList<Character> valid = new ArrayList<Character>();
		valid.add('.');
		switch(getBase()){
			case 16:
				valid.add('F');
				valid.add('E');
				valid.add('D');
				valid.add('C');
				valid.add('B');
				valid.add('A');
			case 10:
				valid.add('9');
				valid.add('8');
			case 8:
				valid.add('7');
				valid.add('6');
				valid.add('5');
				valid.add('4');
				valid.add('3');
				valid.add('2');
			case 2:
				valid.add('1');
				valid.add('0');
				break;
			default:
				System.out.println("ERR: bad base in isOnlyNumber:"+getBase());
		}
		boolean foundfirst = false;
		boolean parenth = false;
		for(int i=0; i<num.length() && ret; i++){
			boolean found = false;
			for(int j=0; j<valid.size() && !found; j++){
				if(num.charAt(i)==valid.get(j)){
					found = true;
					if(num.charAt(i)==valid.get(0)){
						if(foundfirst){
							found = false;
						}
						else{
							foundfirst = true;
						}
					}
				}
				else if(i==0 && num.charAt(i)=='('){
					found = true;
					parenth = true;
				}
				else if(i==num.length()-1 && num.charAt(i)==')'){
					found = true;
				}
				else if(num.charAt(i)=='-' && ((!parenth&&i==0) || (parenth&&i==1))){
					found = true;
				}
			}
			if(!found){
				ret = false;
			}
		}
		return ret;
	}
}
