package model;

public class TheMath {
private TheMath(){}
	
	public static final double PI = Math.PI;
	public static final double E = Math.E;
	
	private static String o0 = "000"; 
	private static String o1 = "001";
	private static String o2 = "010";
	private static String o3 = "011";
	private static String o4 = "100";
	private static String o5 = "101";
	private static String o6 = "110";
	private static String o7 = "111";
	
	private static String h0 = "0000"; 
	private static String h1 = "0001";
	private static String h2 = "0010";
	private static String h3 = "0011";
	private static String h4 = "0100";
	private static String h5 = "0101";
	private static String h6 = "0110";
	private static String h7 = "0111";
	private static String h8 = "1000";
	private static String h9 = "1001";
	private static String ha = "1010";
	private static String hb = "1011";
	private static String hc = "1100";
	private static String hd = "1101";
	private static String he = "1110";
	private static String hf = "1111";
	

	public static String deciToBinary(String input){
		boolean again = true;
		String x = "", z = "";
		double newinput = Double.parseDouble(input);
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
			for(int i = x.length() - 1; i >= 0; i--){
				 z += x.charAt(i);
		}
		return z;
	}
	
	public static String octToBinary(String input){
		boolean again = true;
		String value = "";
		while(again){
			if(input.contains("0")||input.contains("1")||input.contains("2")||input.contains("3")||input.contains("4")||input.contains("5")||input.contains("6")||input.contains("7")){	
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
					again = false;
				}
			else
				again = true;
		}
	
		return value;
	}
	
	
	public static String hexToBinary(String input){
		boolean again = true;
		String value = "";
		while(again){
		for(int i = 0; i < input.length(); i++){
			if(Character.getNumericValue(input.charAt(i)) >= 0 && Character.getNumericValue(input.charAt(i)) <= 9 || input.charAt(i) >= 'a' && input.charAt(i) <= 'f'){
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
			}
			else
				again = true;
		}
		}
		
		return value;
	}
	
	public static String binToDecimal(String input){
		int x = Integer.parseInt(input, 2);
		return Integer.toString(x, 10);
	}
	
	
	public static String octToDecimal(String input){
		int x = Integer.parseInt(input, 8);
		return Integer.toString(x, 10);
	}
	
	public static String hexToDecimal(String input){
		return Integer.toString(Integer.parseInt(input, 16), 10);
	}
	
	public static String deciToHex(String input){
		String x = "";
		double newinput = Double.parseDouble(input);
		
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
	
	public static String octToHex(String input){
		return binToHex(octToBinary(input));
	}
	
	public static String binToHex(String input){
		int num = Integer.parseInt(input, 2);
		String result = Integer.toHexString(num);
		return result;
	}
	
	public static String deciToOctal(String input){
		String x = "";
		double newinput = Double.parseDouble(input);
		
		while(newinput >= 1){
			newinput = newinput/8;
			x+= newinput % 8;
		}
		String z = "";
		for(int i = x.length() - 1; i >= 0; i--){
				 z += x.charAt(i);
		}
		return z;
	}
	
	public static String hexToOctal(String input){
		return binToOctal(hexToBinary(input));
	}
	
	public static String binToOctal(String input){
		int num = Integer.parseInt(input, 2);
		String result = Integer.toOctalString(num);
		return Integer.toString(Integer.parseInt(result, 8),8);
	}
	

	public static double sin(String input){
		double result = Math.sin(Double.parseDouble(input));
//		if(Double.isNaN(Double.parseDouble(input)))
//			return Double.parseDouble(input);
//		else
		return result;
	}
	
	public static double cosine(String input){
		double result = Math.cos(Double.parseDouble(input));
		return result;
	}
	
	public static double tangent(String input){
		double result = Math.tan(Double.parseDouble(input));
		return result;
	}
	
	public static double secant(String input){
		return 1/cosine(input);
	}
	
	public static double cosecant(String input){
		return 1/sin(input);
	}
	
	public static double cotangent(String input){
		return 1/tangent(input);
	}
	
	public static double arcsine(String input){
		return Math.asin(Double.parseDouble(input));
	}
	
	public static double arccosine(String input){
		return Math.acos(Double.parseDouble(input));
	}
	
	public static double arctangent(String input){
		return Math.atan(Double.parseDouble(input));
	}
	
	public static double radToDegrees(String input){
		return Math.toDegrees(Double.parseDouble(input));
	}
	
	public static double degToRadians(String input){
		return Math.toRadians(Double.parseDouble(input));
	}
	
	public static double log(String input){
		return Math.log10(Double.parseDouble(input));
	}
	
	public static double ln(String input){
		return Math.log(Double.parseDouble(input));
	}
	
	public static double mod(String input, String input2){
		return Double.parseDouble(input)%Double.parseDouble(input2);
	}
	
	public static double root(String base, String root){
		return Math.pow(Double.parseDouble(base), (1/Double.parseDouble(root)));
	}
	
	public static double Xor(String input, String input2){
		return Integer.parseInt(input) ^ Integer.parseInt(input2);
	}
	
	public static double Or(String input, String input2){
		return Integer.parseInt(input) | Integer.parseInt(input2);
	}
	
	public static double And(String input, String input2){
		return Integer.parseInt(input) & Integer.parseInt(input2);
	}
	
	public static double Not(String input){
		return ~Integer.parseInt(input);
	}
	
	public static double lShift(String input, String input2){
		return Integer.parseInt(input) << Integer.parseInt(input2);
	}
	
	public static double rShift(String input, String input2){
		return Integer.parseInt(input) >> Integer.parseInt(input2);
	}
}