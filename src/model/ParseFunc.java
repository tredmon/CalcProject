package model;

public class ParseFunc<T> implements Comparable<ParseFunc<T>>{
	private String nam;
	private String pars;
	private Integer ord;
	
	public ParseFunc(){
		this(null);
	}
	public ParseFunc(String parse){
		this(parse, null);
	}
	public ParseFunc(String parse, Integer order){
		this(parse, order, null);
	}
	public ParseFunc(String parse, Integer order, String name){
		setParse(parse);
		setOrder(order);
		setName(name);
	}

	public String getName() {
		return nam;
	}
	public void setName(String name) {
		if(name == null){
			this.nam = "";
		}
		else{
			this.nam = name;
		}
	}
	public Integer getOrder(){
		return ord;
	}
	public void setOrder(Integer order){
		if(order == null){
			this.ord = Integer.MAX_VALUE;
		}
		else{
			this.ord = order;
		}
	}
	public String getParse() {
		return pars;
	}
	public void setParse(String parse) {
		if(parse == null){
			this.pars = "";
		}
		else{
			this.pars = parse;
		}
	}
	
	/**
	 * Evaluates the result of performing this function on the parent's children.
	 * @param parent
	 * @return The result of this function.
	 */
	public T eval(ParseTree<T> parent){
		T ret = null;
		if(parent != null){
			ret = parent.getData();
		}
		return ret;
	}
	/**
	 * Outputs the evaluation as a string
	 * @param parent
	 * @return the string evaluation
	 */
	public String evalOutString(ParseTree<T> parent){
		return evalString(parent);
	}
	/**
	 * Outputs the equation as a string which is reparseable
	 * @param parent
	 * @return the string equation
	 */
	public String evalString(ParseTree<T> parent){
		String ret = "";
		if(parent != null){
			ret = "(";
			if(parent.getNode1() != null){
				ret += parent.getNode1().evalString();
			}
			ret += getParse();
			if(parent.getNode2() != null){
				ret += parent.getNode2().evalString();
			}
			ret += ")";
		}
		return ret;
	}
	public int find(String str){
		int ret = -1;
		if(str != null){
			ret = str.lastIndexOf(getParse());
		}
		return ret;
	}
	/**
	 * Parses the given string and returns the unused portion.
	 * @param parent The parent tree will be modified by the parse.
	 * @param str The string to parse.
	 * @return The unused portion of str.
	 */
	public String parse(ParseTree<T> parent, String str){
		String ret = str;
		if(parent != null && ret != null){
			int instr = this.find(ret);
//			int instr = ret.indexOf(getParse());
			if(instr >= 0){
				parent.setFunction(this);
				String ns1 = ret.substring(0, instr);
				String ns2 = ret.substring(instr+getParse().length());
				if(ns1.length() > 0){
					parent.setNode1(parent.getInstance(parent.getFunctionList(), ns1));
				}
				if(ns2.length() > 0){
					parent.setNode2(parent.getInstance(parent.getFunctionList(), ns2));
				}
				ret = "";
			}
		}
		return ret;
	}
	public void push(ParseTree<T> parent, ParseTree<T> newtree){
		if(parent != null){
			parent.push(newtree);
		}
	}
	public void pushr(ParseTree<T> parent, ParseTree<T> newtree){
		if(parent != null){
			parent.pushr(newtree);
		}
	}
	/**
	 * Compares this ParseFunc with the given ParseFunc.
	 * @param o The ParseFunc with which we are comparing.
	 * @return -1 if this<o, 1 if this>o, else 0
	 */
	public int compareTo(ParseFunc<T> o) {
		return getOrder().compareTo(o.getOrder());
	}
}
