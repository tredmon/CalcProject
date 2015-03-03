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
	public String parse(ParseTree<T> parent, String str){
		String ret = str;
		if(parent != null && ret != null){
			int start = ret.indexOf(getParse());
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
						if(tmpend >= 0){
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
					System.out.print("this:\""+parent+"\"");
					if(start > 0){
						System.out.println("\tpre:\""+ret.substring(0, start)+"\"");
						parent.push(parent.getInstance(parent.getFunctionList(), ret.substring(0, start)));
					}
					ret = ret.substring(instr+getParseEnd().length());
					if(ret.length() > 0){
						System.out.println("\tpost:\""+ret+"\"");
						parent.push(parent.getInstance(parent.getFunctionList(), ret));
						ret = "";
					}
					System.out.println("\tfinal:\""+parent+"\"");
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
}
