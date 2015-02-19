package edu.neumont.csc150.calc.test;



public class TheMath {
	
	private TheMath(){}
	
	
	
	
	private  String o0 = "000"; 
	private  String o1 = "001";
	private  String o2 = "010";
	private  String o3 = "011";
	private  String o4 = "100";
	private  String o5 = "101";
	private  String o6 = "110";
	private  String o7 = "111";
	
	private  String h0 = "0000"; 
	private  String h1 = "0001";
	private  String h2 = "0010";
	private  String h3 = "0011";
	private  String h4 = "0100";
	private  String h5 = "0101";
	private  String h6 = "0110";
	private  String h7 = "0111";
	private  String h8 = "1000";
	private  String h9 = "1001";
	private  String ha = "1010";
	private  String hb = "1011";
	private  String hc = "1100";
	private  String hd = "1101";
	private  String he = "1110";
	private  String hf = "1111";
	
//	private  ArrayList <Integer> list = new ArrayList <Integer>();
	
	public static String deciToBinary(String input){
		String x = "";
		int newinput = Integer.parseInt(input);
		
		while(newinput >= 1){
			
			if(newinput % 2 == 0){
				newinput = newinput/2;
				x += "0";
			}
			else if(newinput % 2 == 1){
				newinput = newinput/2;
				x += "1";
			}
		}
		String z = "";
		for(int i = x.length() - 1; i >= 0; i--){
				 z += x.charAt(i);
		}
		return z;
	}
	
	public static String octToBinary(String input){
		String value = "";
		for(int x = 0; x < input.length(); x++){
			switch(input.charAt(x)){
				case '0':
					value += (o0);
					break;
				case '1':
					value += (o1);
					break;
				case '2':
					value += (o2);
					break;
				case '3':
					value += (o3);
					break;
				case '4':
					value += (o4);
					break;
				case '5':
					value += (o5);
					break;
				case '6':
					value += (o6);
					break;
				case '7':
					value += (o7);
					break;
			}
		}
		return value;
	}
	
	public static String hexToBinary(String input){
		String value = "";
		for(int x = 0; x < input.length(); x++){
			switch(input.charAt(x)){
			case '0':
				value += (h0);
				break;
			case '1':
				value += (h1);
				break;
			case '2':
				value += (h2);
				break;
			case '3':
				value += (h3);
				break;
			case '4':
				value += (h4);
				break;
			case '5':
				value += (h5);
				break;
			case '6':
				value += (h6);
				break;
			case '7':
				value += (h7);
				break;
			case '8':
				value += (h8);
				break;
			case '9':
				value += (h9);
				break;
			case 'a':
				value += (ha);
				break;
			case 'b':
				value += (hb);
				break;
			case 'c':
				value += (hc);
				break;
			case 'd':
				value += (hd);
				break;
			case 'e':
				value += (he);
				break;
			case 'f':
				value += (hf);
				break;
			}
		}
		return value;
	}
	
	public static int binToDecimal(String input){
		return Integer.parseInt(input, 2);
	}
	
	public static int octToDecimal(String input){
		return Integer.parseInt(input, 8);
	}
	
	public static int hexToDecimal(String input){
		return Integer.parseInt(input, 16);
	}
	
	public static String deciToHex(String input){
		String x = "";
		int newinput = Integer.parseInt(input);
		
		while(newinput >= 1){
			newinput = newinput/16;
			x += newinput % 16;
		}
		String z = "";
		for(int i = x.length() - 1; i >= 0; i--){
				 z += x.charAt(i);
		}
		return z;
	}
	
	public static int octToHex(String input){
		return binToHex(octToBinary(input));
	}
	
	public static int binToHex(String input){
		int num = Integer.parseInt(input, 2);
		String result = Integer.toHexString(num);
		return Integer.parseInt(result, 16);
	}
	
	public static String deciToOctal(String input){
		String x = "";
		int newinput = Integer.parseInt(input);
		
		while(newinput >= 1){
			
			if(newinput % 2 == 0){
				newinput = newinput/8;
				x += "0";
			}
			else if(newinput % 2 == 1){
				newinput = newinput/8;
				x += "1";
			}
		}
		String z = "";
		for(int i = x.length() - 1; i >= 0; i--){
				 z += x.charAt(i);
		}
		return z;
	}
	
	public static int hexToOctal(String input){
		return binToOctal(hexToBinary(input));
	}
	
	public static int binToOctal(String input){
		int num = Integer.parseInt(input, 2);
		String result = Integer.toOctalString(num);
		return Integer.parseInt(result, 8);
	}
}