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
		if(parent != null && str != null){
			int instr = ret.indexOf(getParse());
			if(instr == 0){
				int i, count = instr + 1;
				for(i=count; i<ret.length() && count>0 && instr>=0; i++){
					int tmpin = ret.indexOf(getParse(), instr);
					int tmpend = ret.indexOf(getParseEnd(), instr);
					if(tmpin < tmpend && tmpin>=0){
						instr = tmpin;
						count++;
					}
					else if(tmpend >= 0){
						instr = tmpend;
						count--;
					}
				}
				if(count <= 0){
					parent.setFunction(this);
					parent.setNode1(parent.getInstance(parent.getFunctionList(), ret.substring(getParse().length(), instr)));
					ret = ret.substring(instr+getParseEnd().length());
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
