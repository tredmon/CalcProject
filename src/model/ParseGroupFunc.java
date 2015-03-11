package model;

public class ParseGroupFunc<T> extends ParseFunc<T>{
	private String parsE;
	
	public ParseGroupFunc(){
		this(null,null);
	}
	public ParseGroupFunc(String parseBegin, String parseEnd){
		this(parseBegin,parseEnd, null);
	}
	public ParseGroupFunc(String parseBegin,String parseEnd, Integer order){
		this(parseBegin,parseEnd, order, null);
	}
	public ParseGroupFunc(String parseBegin,String parseEnd, Integer order, String name){
		setParse(parseBegin);
		setParseEnd(parseEnd);
		setOrder(order);
		setName(name);
	}
	public String getParseEnd(){
		return parsE;
	}
	public void setParseEnd(String parseEnd){
		if(parseEnd == null){
			parsE = getParse();
		}
		else{
			parsE = parseEnd;
		}
	}
	@Override
	public int find(String str){
		int ret = -1;
		if(str != null){
			ret = str.indexOf(getParse());
		}
		return ret;
	}
	public int findEnd(String str){
		int ret = -1;
		if(str != null){
			ret = str.indexOf(getParseEnd());
		}
		return ret;
	}
	@Override
	public String parse(ParseTree<T> parent, String str){
		String ret = str;
		if(parent != null && ret != null){
			int start = ret.indexOf(getParse());//find(ret);
			if(start >= 0){
				int count = 1;
				int instr = start;
				int tmplen = getParse().length();
				while(instr<ret.length() && count>0){
					int tmpin = ret.indexOf(getParse(), instr+tmplen);
					int tmpend = ret.indexOf(getParseEnd(), instr+tmplen);
					if(tmpend >= 0 && tmpin >= 0){
						if(tmpin<tmpend){
							instr = tmpin;
							tmplen = getParse().length();
							count++;
						}
						else{
							instr = tmpend;
							tmplen = getParseEnd().length();
							count--;
						}
					}
					else{
						if(tmpin >= 0){
							instr = tmpin;
							tmplen = getParse().length();
							count++;
						}
						else if(tmpend >= 0){
							instr = tmpend;
							tmplen = getParseEnd().length();
							count--;
						}
						else{
							break;
						}
					}
				}
				if(count <= 0){
					parent.setFunction(this);
					parent.setNode1(parent.getInstance(parent.getFunctionList(), ret.substring(start+getParse().length(), instr)));
					if(start > 0){
						parent.push(parent.getInstance(parent.getFunctionList(), ret.substring(0, start)));
					}
					ret = ret.substring(instr+getParseEnd().length());
				}
				else{
					System.out.println("\""+getParseEnd()+"\" that matches \""+getParse()+"\" not found:"+count+" in \""+ret+"\" = "+str);
				}
			}
		}
		return ret;
	}
	@Override
	public T eval(ParseTree<T> parent){
		T ret = null;
		if(parent != null && parent.getNode1() != null){
			ret = parent.getNode1().eval();
		}
		return ret;
	}
	public String evalString(ParseTree<T> parent){
		String ret = "";
		if(parent != null){
			ret = getParse();
			boolean found1 = false;
			if(parent.getNode1() != null){
				ret += parent.getNode1().evalString();
				found1 = true;
			}
			if(parent.getNode2() != null){
				if(found1){ret += ", ";}
				ret += parent.getNode2().evalString();
			}
			ret += getParseEnd();
		}
		return ret;
	}
}
