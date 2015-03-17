package model;

import java.lang.reflect.InvocationTargetException;
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
						tmpstr = parent.getNode2().evalOutString();
					}
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
					ret = TheMath.mod(parent.getNodeVal1(0.0), parent.getNodeVal2(0.0));
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
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
					}
					else{
						ret = evalString(parent);
					}
				}
				return ret;
			}
		});
		try {
			@SuppressWarnings("unchecked")
			ParseFunc<Double> tmp = (ParseFunc<Double>)this.getFunctionList().get(this.getFunctionList().size()-1).getClass().getDeclaredConstructor(MathParser.class, String.class, Integer.class, String.class).newInstance(this, "mod",this.getFunctionList().get(this.getFunctionList().size()-1).getOrder(),"MODWORD");
			add(tmp);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			System.out.println("ERR: unable to create the mod function for the parser");
		}
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
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
					ret = TheMath.root(parent.getNodeVal2(0.0), parent.getNodeVal1(2.0));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode2()!=null){
					if(parent.getNode1()!=null){
						ret = parent.getNode1().evalOutString();
					}
					String tmpstr = parent.getNode2().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && ((MathParser)parent).isOnlyNumber(tmpstr)){
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
					ret = TheMath.Not(parent.getNodeVal2(0.0));
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
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
					ret = TheMath.lShift(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null){
					ret = parent.getNode1().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && (parent.getNode2()==null || parent.getNode2()==emptytree || ((MathParser)parent).isOnlyNumber(parent.getNode2().evalOutString()))){
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
					ret = TheMath.rShift(parent.getNodeVal1(0.0), parent.getNodeVal2(1.0));
				}
				return ret;
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1()!=null){
					ret = parent.getNode1().evalOutString();
					if(((MathParser)parent).isOnlyNumber(ret) && (parent.getNode2()==null || parent.getNode2()==emptytree || ((MathParser)parent).isOnlyNumber(parent.getNode2().evalOutString()))){
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
					ret = TheMath.And(parent.getNodeVal1(0.0), parent.getNodeVal2(0.0));
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
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
					ret = TheMath.Xor(parent.getNodeVal1(0.0), parent.getNodeVal2(0.0));
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
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
					ret = TheMath.Or(parent.getNodeVal1(0.0), parent.getNodeVal2(0.0));
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
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
					if(ret == null){ret = 0.0;}
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
				return ret;
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
				String ret = "";
				if(parent != null){
					ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
				}
				return ret;
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
					ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
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
							ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
						}
						else{
							ret = tmp+"*"+((MathParser)parent).dataToString(TheMath.sin(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle()), ((MathParser)parent).getBase());
						}
					}
					else{
						ret = tmp +getParse()+ ret;
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
							ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
						}
						else{
							ret = tmp+"*"+((MathParser)parent).dataToString(TheMath.cosine(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle()), ((MathParser)parent).getBase());
						}
					}
					else{
						ret = tmp +getParse()+ ret;
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
							ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
						}
						else{
							ret = tmp+"*"+((MathParser)parent).dataToString(TheMath.tangent(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle()), ((MathParser)parent).getBase());
						}
					}
					else{
						ret = tmp +getParse()+ ret;
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
							ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
						}
						else{
							ret = tmp+"*"+((MathParser)parent).dataToString(TheMath.arcsine(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle()), ((MathParser)parent).getBase());
						}
					}
					else{
						ret = tmp +getParse()+ ret;
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
							ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
						}
						else{
							ret = tmp+"*"+((MathParser)parent).dataToString(TheMath.arccosine(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle()), ((MathParser)parent).getBase());
						}
					}
					else{
						ret = tmp +getParse()+ ret;
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
							ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
						}
						else{
							ret = tmp+"*"+((MathParser)parent).dataToString(TheMath.arctangent(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle()), ((MathParser)parent).getBase());
						}
					}
					else{
						ret = tmp +getParse()+ ret;
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("ln",90,"NATLOG"){
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
					ret = TheMath.ln(parent.getNodeVal2(0.0));
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
							ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
						}
						else{
							ret = ((MathParser)parent).dataToString(TheMath.sin(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle()), ((MathParser)parent).getBase());
						}
					}
					else if(parent.getNode1()!=emptytree && ((MathParser)parent).isOnlyNumber(tmp)){
						ret = parent.getNode1().evalOutString() +"*"+ ret;
					}
					else{
						ret = parent.getNode1().evalOutString()+getParse()+ret;
					}
				}
				return ret;
			}
		});
		add(new ParseFunc<Double>("log",90,"LOG"){
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
					ret = TheMath.log(parent.getNodeVal2(0.0));
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
							ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
						}
						else{
							ret = ((MathParser)parent).dataToString(TheMath.sin(parent.getNodeVal2(0.0), ((MathParser)parent).getAngle()), ((MathParser)parent).getBase());
						}
					}
					else if(parent.getNode1()!=emptytree && ((MathParser)parent).isOnlyNumber(tmp)){
						ret = parent.getNode1().evalOutString() +"*"+ ret;
					}
					else{
						ret = parent.getNode1().evalOutString()+getParse()+ret;
					}
				}
				return ret;
			}
		});
		//TODO: ensure that groupings work
		add(new ParseGroupFunc<Double>("(",")",Integer.MAX_VALUE,"PARENTH"){
			@Override
			public void push(ParseTree<Double> parent, ParseTree<Double> newtree){
				super.pushr(parent, newtree);
			}
			@Override
			public void pushr(ParseTree<Double> parent, ParseTree<Double> newtree){
				super.push(parent, newtree);
			}
			@Override
			public String evalOutString(ParseTree<Double> parent){
				String ret = "";
				if(parent != null && parent.getNode1() != null){
					String tmp = parent.getNode1().evalOutString();
					if(((MathParser)parent).isOnlyNumber(tmp)){
						ret = ((MathParser)parent).dataToString(eval(parent), ((MathParser)parent).getBase());
					}
					else{
						ret += tmp;
					}
					if(!ret.startsWith(getParse()) && !ret.endsWith(getParseEnd())){
						int count = 1;
						boolean needparenth = false;
						for(int i=getParse().length(); i<ret.length() && !needparenth; i++){
							int start = ret.indexOf(getParse(), i);
							int end = ret.indexOf(getParseEnd(), i);
							if(start>=0 && end>=0){
								if(start<end){
									count++;
									i = start + getParse().length();
								}
							}
							else if(start>=0){
								count++;
								i = start + getParse().length();
							}
							else{
								count--;
								i = end + getParseEnd().length();
							}
							if(count <= 0 && i<ret.length()){
								needparenth = true;
							}
						}
						if(needparenth){
							ret = getParse() + ret + getParseEnd();
						}
					}
				}
				else{
					ret += "null";
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
					int instr = parse.indexOf("-");
					if(instr >= 0){
						char[] valid;
						switch(MathParser.this.getBase()){
							case 16:
								valid = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
								break;
							case 10:
								valid = new char[]{'0','1','2','3','4','5','6','7','8','9'};
								break;
							case 8:
								valid = new char[]{'0','1','2','3','4','5','6','7'};
								break;
							case 2:
								valid = new char[]{'0','1'};
								break;
							default:
								valid = new char[]{};
						}
						boolean founddot = false;
						boolean found = true;
						int i = instr + 1;
						for(; i<ret.length() && found; i++){
							boolean tmpfound = false;
							for(int j=0; j<ret.length() && !tmpfound; j++){
								if(ret.charAt(i)==valid[j]){
									tmpfound = true;
								}
							}
							if(!tmpfound){
								if(ret.charAt(i)=='.'){
									if(founddot){
										found = false;
										i--;
									}
									else{
										founddot = true;
									}
								}
								else{
									found = false;
									i--;
								}
							}
						}
						if(!found){
							String datstr = ret.substring(instr,i);
							if(datstr.length() > 1){
								String prestr = ret.substring(0,instr);
								String posstr = ret.substring(i);
								ParseTree<Double> p = parent.clone();
								p.setFunction(this);
								p.setData(((ParseTreeDouble)p).parseData(datstr, MathParser.this.getBase()));
								p.setNode1(emptytree);
								p.setNode2(emptytree);
								if(instr > 0){
									parent.parse(prestr);
									parent.push(p);
								}
								else{
									parent.clone(p);
								}
								ret = posstr;
							}
						}
					}
					else if(getParse().equals("")){
						parent.setFunction(this);
						parent.setData(((ParseTreeDouble)parent).parseData(parse, MathParser.this.getBase()));
						parent.setNode1(emptytree);
						parent.setNode2(emptytree);
						ret = "";
					}
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
					ret = ((ParseTreeDouble)parent).dataToString(((ParseTreeDouble)parent).getData(), ((MathParser)parent).getBase());
				}
				return ret;
			}
		});
		try {
			@SuppressWarnings("unchecked")
			ParseFunc<Double> tmp = (ParseFunc<Double>)this.getFunctionList().get(this.getFunctionList().size()-1).getClass().getDeclaredConstructor(MathParser.class, String.class, Integer.class, String.class).newInstance(this, "-",Integer.MAX_VALUE-1,"DATANEG");
			add(tmp);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			System.out.println("ERR: unable to create the negative number function for the parser");
		}
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
