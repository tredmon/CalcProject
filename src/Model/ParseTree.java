package model;
import java.util.ArrayList;
import java.util.Collections;


public abstract class ParseTree<T> {
	private ArrayList<ParseFunc<T>> parsefuncs;
	private T data;
	private ParseFunc<T> func;
	private ParseTree<T> node1, node2;
	
	public ParseTree(ArrayList<ParseFunc<T>> arr, String parse){
		setFunctionList(arr);
		parse(parse);
	}
	public ParseTree(){
		this(null);
	}
	public ParseTree(T data){
		this(data, null);
	}
	public ParseTree(T data, ParseFunc<T> f){
		this(data, f, null,null);
	}
	public ParseTree(T data, ParseFunc<T> f, ParseTree<T> node1, ParseTree<T> node2){
		this(data, f, node1,node2, null);
	}
	public ParseTree(T data, ParseFunc<T> f, ParseTree<T> node1, ParseTree<T> node2, ArrayList<ParseFunc<T>> arr){
		init(data, f, node1,node2, arr);
	}
	public void init(T data, ParseFunc<T> f, ParseTree<T> node1, ParseTree<T> node2, ArrayList<ParseFunc<T>> arr){
		setData(data);
		setFunction(f);
		setNode1(node1);
		setNode2(node2);
		setFunctionList(arr);
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ParseTree<T> getNode1() {
		return node1;
	}
	public void setNode1(ParseTree<T> node1) {
		this.node1 = node1;
	}
	public ParseTree<T> getNode2() {
		return node2;
	}
	public void setNode2(ParseTree<T> node2) {
		this.node2 = node2;
	}
	public ParseFunc<T> getFunction() {
		return func;
	}
	public void setFunction(ParseFunc<T> func) {
		this.func = func;
	}
	public ArrayList<ParseFunc<T>> getFunctionList(){
		return parsefuncs;
	}
	public void setFunctionList(ArrayList<ParseFunc<T>> arr){
		if(arr == null){
			parsefuncs = new ArrayList<ParseFunc<T>>();
		}
		else{
			parsefuncs = arr;
		}
	}
	public ParseTree<T> clone(ParseTree<T> c){
		init(c.getData(), c.getFunction(), c.getNode1(), c.getNode2(), c.getFunctionList());
		return this;
	}
	public ParseTree<T> clone(){
		return getInstance(getData(), getFunction(), getNode1(),getNode2(), getFunctionList());
	}
	public void add(ParseFunc<T> f){
		parsefuncs.add(f);
	}
	public void remove(ParseFunc<T> f){
		parsefuncs.remove(f);
	}
	public void sort(){
		Collections.sort(parsefuncs);
	}
	public void sortr(){
		sort();
		Collections.reverse(parsefuncs);
	}
	public T getNodeVal1(T def){
		T ret = def;
		if(getNode1() != null){
			ret = getNode1().eval();
			if(ret == null){
				ret = getNode1().getData();
			}
			if(ret == null){
				ret = def;
			}
		}
		return ret;
	}
	public T getNodeVal2(T def){
		T ret = def;
		if(getNode2() != null){
			ret = getNode2().eval();
			if(ret == null){
				ret = getNode2().getData();
			}
			if(ret == null){
				ret = def;
			}
		}
		return ret;
	}
	
	public ParseTree<T> parse(String parse){
		if(parse != null && parse.length() > 0){
			this.clone(getInstance(null,null,null,null,getFunctionList()));
			String parsestr = parse, parsestrlast = "";
			ParseTree<T> thetree = null;
			while(parsestr.length() > 0 && !parsestr.equals(parsestrlast)){
				ParseTree<T> tmptree = getInstance(null,null,null,null,getFunctionList());
				parsestrlast = parsestr;
				ParseFunc<T> foundfunc = null;
				int foundat = parsestr.length();
				String tmpstr = "";
				for(int i=0; i<parsefuncs.size() && (foundfunc==null || foundfunc.compareTo(parsefuncs.get(i))==0); i++){
					tmpstr = parsefuncs.get(i).parse(tmptree, parsestrlast);
					if(!tmpstr.equals(parsestrlast)){
						//TODO: ensure that the leftmost of a single order of functions is used first
						ParseFunc<T> tmpfunc = parsefuncs.get(i);
						int tmpat = tmpfunc.find(parsestrlast);
						if(tmpat < foundat && (foundfunc==null || foundfunc.compareTo(tmpfunc)==0)){
							thetree = tmptree;
							foundat = tmpat;
							foundfunc = tmpfunc;
							parsestr = tmpstr;
						}
					}
				}
				push(thetree);
				if(thetree == null){
					System.out.println("bad tree in parsing:\""+parsestrlast+"\"");
				}
			}
			if(parsestr.length() > 0){
//				setData(parseData(parsestr));
				System.out.println("ERR: not able to parse the entire string. \""+parsestr+"\" remaining.");
			}
		}
		return this;
	}
	public void push(ParseTree<T> p){
		ParseTree<T> tmp = this.clone();
		if(p != null){
			if(p.getNode1() == null && !tmp.toString().equals("null")){
				p.setNode1(tmp);
			}
			else if(p.getNode2() == null && !tmp.toString().equals("null")){
				p.setNode2(tmp);
			}
			else if((p.getNode1()==null || p.getNode2()==null) && !tmp.toString().equals("null")){
				System.out.println("error pushing:\""+tmp+"\" into:\""+p+"\"");
			}
			this.clone(p);
		}
	}
	public ParseTree<T> getInstance(){return getInstance(null);};
	public ParseTree<T> getInstance(T data){return getInstance(data,null);};
	public ParseTree<T> getInstance(T data, ParseFunc<T> f){return getInstance(data, f, null,null);};
	public ParseTree<T> getInstance(T data, ParseFunc<T> f, ParseTree<T> node1, ParseTree<T> node2){return getInstance(data, f, node1,node2, null);};
	public abstract ParseTree<T> getInstance(T data, ParseFunc<T> f, ParseTree<T> node1, ParseTree<T> node2, ArrayList<ParseFunc<T>> arr);
	public ParseTree<T> getInstance(ArrayList<ParseFunc<T>> arr, String parse){
		ParseTree<T> ret = getInstance();
		ret.setFunctionList(arr);
		ret.parse(parse);
		return ret;
	}
	public abstract T parseData(String parse);
	public T eval(){
		T ret = getData();
		if(func != null){
			ret = func.eval(this);
		}
		return ret;
	}
	
	public String evalOutString(){
		String ret = "";
		if(getFunction() == null){
			ret = evalString();
		}
		else{
			ret = getFunction().evalOutString(this);
		}
		return ret;
	}
	public String evalString(){
		String ret = "";
		if(getFunction() == null){
			if(getData() != null){
				ret = getData().toString();
			}
		}
		else{
			ret = getFunction().evalString(this);
		}
		return ret;
	}
	public String toString(){
		String ret = evalString();
		if(ret.length()==0){
			return "null";
		}
		return ret;
	}
}
