package model;

import java.util.ArrayList;

public class MathParser extends ParseTreeDouble{
	private String mstr;
	private int bas;
	private double xval;
	
	private static MathParser emptytree = new MathParser(){
		public Double eval(){
			return null;
		}
		public String evalString(){
			return "";
		}
	};
	public MathParser(){
		this(null, 10);
	}
	public MathParser(String mem, int base){
		super();
		setMem(mem);
		setBase(base);
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
				}
				return ret;
			}
			@Override
			public String evalString(ParseTree<Double> parent){
				return mstr;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				ParseTree<Double> tmp = parent.getInstance(parent.getFunctionList(), mstr);
				return tmp.evalOutString();
			}
		});
		add(new ParseFunc<Double>("e",1010,"EULER"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = TheMath.E;
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				return ""+eval(parent);
			}
		});
		add(new ParseFunc<Double>("pi",1010,"PI"){
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = 0.0;
				if(parent != null){
					ret = TheMath.PI;
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				return ""+eval(parent);
			}
		});
		add(new ParseFunc<Double>("sin",90,"SIN"){
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
					//TODO: use TheMath.sin() function
					ret = Math.sin(parent.getNodeVal2(0.0));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret)){
						ret = ""+eval(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("cos",90,"COS"){
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
					//TODO: use TheMath.cos() function
					ret = Math.cos(parent.getNodeVal2(0.0));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret)){
						ret = ""+eval(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("tan",90,"TAN"){
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
					//TODO: use TheMath.tan() function
					ret = Math.tan(parent.getNodeVal2(0.0));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret)){
						ret = ""+eval(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("asin",91,"ASIN"){
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
					//TODO: use TheMath.asin() function
					ret = Math.asin(parent.getNodeVal2(0.0));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret)){
						ret = ""+eval(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("acos",91,"ACOS"){
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
					//TODO: use TheMath.acos() function
					ret = Math.acos(parent.getNodeVal2(0.0));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret)){
						ret = ""+eval(parent);
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("atan",91,"ATAN"){
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
					//TODO: use TheMath.atan() function
					ret = Math.atan(parent.getNodeVal2(0.0));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					ret = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret)){
						ret = ""+eval(parent);
					}
				}
				return ret;
			}
		});
		
		add(new ParseGroupFunc<Double>("(",")",Integer.MAX_VALUE,"PARENTH"){
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = getParse();
				if(parent != null && parent.getNode1() != null){
					String tmp = parent.getNode1().evalOutString();
					if(((MathParser)parent).isOnlyNumber(tmp)){
						ret = tmp;
					}
					else{
						ret += parent.getNode1().evalOutString() + getParseEnd();
					}
				}
				else{
					ret += "null" + getParseEnd();
				}
				return ret;
			}
			@Override
			public String evalString(ParseTree<Double> parent){
				String ret = getParse();
				if(parent != null && parent.getNode1() != null){
					ret += parent.getNode1().evalString();
				}
				else{
					ret += "null";
				}
				ret += getParseEnd();
				return ret;
			}
		});
		add(new ParseFunc<Double>("",Integer.MIN_VALUE,"DATA"){
			@Override
			public String parse(ParseTree<Double> parent, String parse){
				String ret = parse;
				if(parent != null){
					parent.setFunction(this);
					parent.setData(((ParseTreeDouble)parent).parseData(parse, getBase()));
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
					ret = ""+parent.getData();
					switch(getBase()){
						case 2:
							//TODO: use TheMath.deciToBinary()
//							ret = TheMath.deciToBinary(ret);
							break;
						case 8:
							//TODO: use TheMath.deciToOctal()
//							ret = TheMath.deciToOctal(ret);
							break;
						case 10:
							break;
						case 16:
							//TODO: use TheMath.deciToHex()
//							ret = TheMath.deciToHex(ret);
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
			public String parse(ParseTree<Double> parent, String parse){
				String ret = super.parse(parent, parse);
				if(parent != null){
					parent.setNode1(MathParser.emptytree);
					parent.setNode2(MathParser.emptytree);
				}
				return ret;
			}
			@Override
			public Double eval(ParseTree<Double> parent){
				Double ret = null;
				if(parent != null){
					ret = ((MathParser)parent).getX();
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
	public boolean isOnlyNumber(String num){
		boolean ret = true;
		ArrayList<Character> valid = new ArrayList<Character>();
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
				valid.add('.');
				break;
			default:
				System.out.println("ERR: bad base in isOnlyNumber:"+getBase());
		}
		for(int i=0; i<num.length() && ret; i++){
			boolean found = false;
			for(int j=0; j<valid.size() && !found; j++){
				if(num.charAt(i)==valid.get(j)){
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
