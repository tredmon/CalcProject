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
	
//	private static char[] hexnums = 
//	{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	
	public static String deciToBinary(String input){
		return doubleToBase(baseToDouble(input, 10), 2);
//		String x = "", z = "";
//		double newinput = Double.parseDouble(input);
//			while(newinput >= 1){
//				if(newinput % 2 == 0){
//					newinput = Math.floor(newinput/2);
//					x += "0";
//				}
//				else if(newinput % 2 == 1){
//					newinput = Math.floor(newinput/2);
//					x += "1";
//				}
//				else
//				{
//					newinput = Math.floor(newinput/2);
//					x +="."+newinput%2;
//				}
//			}
//			for(int i = x.length() - 1; i >= 0; i--){
//				 z += x.charAt(i);
//		}
//		return z;
	}
	
	public static String octToBinary(String input){
		return doubleToBase(baseToDouble(input, 8), 2);
//		boolean again = true;
//		String value = "";
//		while(again){
//			if(input.contains("0")||input.contains("1")||input.contains("2")||input.contains("3")||input.contains("4")||input.contains("5")||input.contains("6")||input.contains("7")){	
//			for(int x = 0; x < input.length(); x++){
//					switch(input.charAt(x)){
//						case '0':
//							value += (o0);
//							break;
//						case '1':
//							value += (o1);
//							break;
//						case '2':
//							value += (o2);
//							break;
//						case '3':
//							value += (o3);
//							break;
//						case '4':
//							value += (o4);
//							break;
//						case '5':
//							value += (o5);
//							break;
//						case '6':
//							value += (o6);
//							break;
//						case '7':
//							value += (o7);
//							break;
//						}
//					}	
//					again = false;
//				}
//			else
//				again = true;
//		}
//	
//		return value;
	}
	
	
	public static String hexToBinary(String input){
		return doubleToBase(baseToDouble(input, 16), 2);
//		boolean again = true;
//		String value = "";
//		while(again){
//		for(int i = 0; i < input.length(); i++){
//			if(Character.getNumericValue(input.charAt(i)) >= 0 && Character.getNumericValue(input.charAt(i)) <= 9 || input.charAt(i) >= 'a' && input.charAt(i) <= 'f'){
//				for(int x = 0; x < input.length(); x++){
//					switch(input.charAt(x)){
//					case '0':
//						value += (h0);
//						break;
//					case '1':
//						value += (h1);
//						break;
//					case '2':
//						value += (h2);
//						break;
//					case '3':
//						value += (h3);
//						break;
//					case '4':
//						value += (h4);
//						break;
//					case '5':
//						value += (h5);
//						break;
//					case '6':
//						value += (h6);
//						break;
//					case '7':
//						value += (h7);
//						break;
//					case '8':
//						value += (h8);
//						break;
//					case '9':
//						value += (h9);
//						break;
//					case 'a':
//						value += (ha);
//						break;
//					case 'b':
//						value += (hb);
//						break;
//					case 'c':
//						value += (hc);
//						break;
//					case 'd':
//						value += (hd);
//						break;
//					case 'e':
//						value += (he);
//						break;
//					case 'f':
//						value += (hf);
//						break;
//					}
//				}
//			}
//		}
//		}
//		
//		return value;
	}
	
	public static String binToDecimal(String input){
		return doubleToBase(baseToDouble(input, 2), 10);
//		int x = Integer.parseInt(input, 2);
//		return Integer.toString(x, 10);
	}
	
	
	public static String octToDecimal(String input){
		return doubleToBase(baseToDouble(input, 8), 10);
//		int x = Integer.parseInt(input, 8);
//		return Integer.toString(x, 10);
	}
	
	public static String hexToDecimal(String input){
		return doubleToBase(baseToDouble(input, 16), 10);
//		return Integer.toString(Integer.parseInt(input, 16), 10);
	}
	
	public static String deciToHex(String input){
		return doubleToBase(baseToDouble(input, 10), 16);
//		return Integer.toHexString((int)Double.parseDouble(input)).toUpperCase();
	}
	
	public static String octToHex(String input){
		return doubleToBase(baseToDouble(input, 8), 16);
//		String x = Integer.toOctalString((int)Double.parseDouble(input)).toUpperCase();
//		return Integer.toHexString((int)Double.parseDouble(x)).toUpperCase();
	}
	
	public static String binToHex(String input){
		return doubleToBase(baseToDouble(input, 2), 16);
//		int num = Integer.parseInt(input, 2);
//		String result = Double.toHexString(num);
//		return result.toUpperCase();
	}
	
	public static String deciToOctal(String input){
		return doubleToBase(baseToDouble(input, 10), 8);
//		return Integer.toOctalString((int)Double.parseDouble(input));
	}
	
	public static String hexToOctal(String input){
		return doubleToBase(baseToDouble(input, 16), 8);
//		double x = Double.parseDouble(hexToBinary(input));
//		return binToOctal(Double.toHexString(x));
	}
	
	public static String binToOctal(String input){
		return doubleToBase(baseToDouble(input, 2), 8);
//		int num = Integer.parseInt(input, 2);
//		String result = Integer.toOctalString(num);
//		return Integer.toString(Integer.parseInt(result, 8),8);
	}
	

	public static double sin(double input, char unit){
		if(unit == 'r')
			return Math.sin(input);
		else
			return Math.sin(degToRadians(input));
	}
	
	public static double cosine(double input, char unit){
		if(unit == 'r')
			return Math.cos(input);
		else
			return Math.cos(degToRadians(input));
	}
	
	public static double tangent(double input, char unit){
		if(unit == 'r')
			return Math.tan(input);
		else
			return Math.tan(degToRadians(input));
	}
	
	public static double secant(double input, char unit){
		if(unit == 'r')
			return 1/Math.cos(input);
		else
			return 1/Math.cos(degToRadians(input));
	}
	
	public static double cosecant(double input, char unit){
		if(unit == 'r')
			return 1/Math.sin(input);
		else
			return 1/Math.sin(degToRadians(input));
	}
	
	public static double cotangent(double input, char unit){
		if(unit == 'r')
			return 1/Math.tan(input);
		else
			return 1/Math.tan(degToRadians(input));
	}
	
	public static double arcsine(double input, char unit){
		if(unit == 'r')
			return Math.asin(input);
		else
			return degToRadians(Math.asin(input));
	}
	
	public static double arccosine(double input, char unit){
		if(unit == 'r')
			return Math.acos(input);
		else
			return degToRadians(Math.acos(input));
	}
	
	public static double arctangent(double input, char unit){
		if(unit == 'r')
			return Math.atan(input);
		else
			return degToRadians(Math.atan(input));
	}
	
	public static double radToDegrees(double input){
		return Math.toDegrees(input);
	}
	
	public static double degToRadians(double input){
		return Math.toRadians(input);
	}
	
	public static double log(double input){
		return Math.log10(input);
	}
	
	public static double ln(double input){
		return Math.log(input);
	}
	
	public static double mod(double input, double input2){
		return input%input2;
	}
	
	public static double root(double base, double root){
		return Math.pow(base, (1/root));
	}
	
	public static double Xor(double input, double input2){
		String str1 = doubleToBase(input, 2);
		String str2 = doubleToBase(input2, 2);
		int dot1 = str1.indexOf('.'); if(dot1<0){dot1=str1.length();}
		int dot2 = str2.indexOf('.'); if(dot2<0){dot2=str2.length();}
		int longer = Math.max(dot1, dot2);
		int i = longer - dot1;
		int j = longer - dot2;
		String retstr = "";
		for(; i<dot1 && j<dot2; i++, j++){
			if(i>=0 && str1.charAt(i)=='1'){
				if(j>=0 && str2.charAt(j)=='1'){
					retstr += '0';
				}
				else{
					retstr += '1';
				}
			}
			else if(j>=0 && str1.charAt(i)=='1'){
				retstr += '1';
			}
			else{
				retstr += '0';
			}
		}
		retstr += '.';
		for(i=dot1+1, j=dot2+1; i<str1.length() && j<str2.length(); i++, j++){
			if(i>=0 && str1.charAt(i)=='1'){
				if(j>=0 && str2.charAt(j)=='1'){
					retstr += '0';
				}
				else{
					retstr += '1';
				}
			}
			else if(j>=0 && str1.charAt(i)=='1'){
				retstr += '1';
			}
			else{
				retstr += '0';
			}
		}
		return baseToDouble(retstr, 2);
//		return Double.longBitsToDouble(Double.doubleToRawLongBits(input) ^ Double.doubleToRawLongBits(input2));
//		return Integer.parseInt(input) ^ Integer.parseInt(input2);
	}
	
	public static double Or(double input, double input2){
		String str1 = doubleToBase(input, 2);
		String str2 = doubleToBase(input2, 2);
		int dot1 = str1.indexOf('.'); if(dot1<0){dot1=str1.length();}
		int dot2 = str2.indexOf('.'); if(dot2<0){dot2=str2.length();}
		int longer = Math.max(dot1, dot2);
		int i = longer - dot1;
		int j = longer - dot2;
		String retstr = "";
		for(; i<dot1 && j<dot2; i++, j++){
			if(i>=0 && str1.charAt(i)=='1'){
				retstr += '1';
			}
			else if(j>=0 && str2.charAt(j)=='1'){
				retstr += '1';
			}
			else{
				retstr += '0';
			}
		}
		retstr += '.';
		for(i=dot1+1, j=dot2+1; i<str1.length() && j<str2.length(); i++, j++){
			if(i>=0 && str1.charAt(i)=='1'){
				retstr += '1';
			}
			else if(j>=0 && str2.charAt(j)=='1'){
				retstr += '1';
			}
			else{
				retstr += '0';
			}
		}
		return baseToDouble(retstr, 2);
//		return Double.longBitsToDouble(Double.doubleToRawLongBits(input) | Double.doubleToRawLongBits(input2));
//		return Integer.parseInt(input) | Integer.parseInt(input2);
	}
	
	public static double And(double input, double input2){
		String str1 = doubleToBase(input, 2);
		String str2 = doubleToBase(input2, 2);
		int dot1 = str1.indexOf('.'); if(dot1<0){dot1=str1.length();}
		int dot2 = str2.indexOf('.'); if(dot2<0){dot2=str2.length();}
		int longer = Math.max(dot1, dot2);
		int i = longer - dot1;
		int j = longer - dot2;
		String retstr = "";
		for(; i<dot1 && j<dot2; i++, j++){
			if(i>=0){
				if(j>=0){
					if(str1.charAt(i)==str2.charAt(j) && str1.charAt(i)=='1'){
						retstr += '1';
					}
					else{
						retstr += '0';
					}
				}
				else{
					retstr += '0';
				}
			}
			else if(j>=0){
				retstr += '0';
			}
		}
		retstr += '.';
		for(i=dot1+1, j=dot2+1; i<str1.length() && j<str2.length(); i++, j++){
			if(i>=0){
				if(j>=0){
					if(str1.charAt(i)==str2.charAt(j) && str1.charAt(i)=='1'){
						retstr += '1';
					}
					else{
						retstr += '0';
					}
				}
				else{
					retstr += '0';
				}
			}
			else if(j>=0){
				retstr += '0';
			}
		}
		return baseToDouble(retstr, 2);
//		return Double.longBitsToDouble(Double.doubleToRawLongBits(input) & Double.doubleToRawLongBits(input2));
//		return Integer.parseInt(input) & Integer.parseInt(input2);
	}
	
	public static double Not(double input){
		String str = doubleToBase(input, 2);
		int dot = str.indexOf('.'); if(dot<0){dot=str.length();}
		String retstr = "";
		for(int i=0; i<dot; i++){
			if(str.charAt(i)=='1'){
				retstr += '0';
			}
			else{
				retstr += '1';
			}
		}
		retstr += '.';
		if(dot >= str.length()){
			for(int i=dot+1; i<str.length(); i++){
				if(str.charAt(i)=='1'){
					retstr += '0';
				}
				else{
					retstr += '1';
				}
			}
		}
		else{
			retstr += '0';
		}
		return baseToDouble(retstr, 2);
//		return Double.longBitsToDouble(~Double.doubleToRawLongBits(input));
//		return ~Integer.parseInt(input);
	}
	
	public static double lShift(double input, double input2){
		String numstr = doubleToBase(input, 2);
		int olddot = numstr.indexOf('.');
		int newdot = (int) (olddot - input2);
		String nodot = numstr.substring(0,olddot)+numstr.substring(olddot+1);
		String retstr = "";
		if(newdot >= nodot.length()){
			retstr = nodot;
			for(int i=nodot.length()-1; i<newdot; i++){
				retstr += '0';
			}
			retstr += ".0";
		}
		else if(newdot < 0){
			retstr += "0.";
			for(int i=newdot; i<0; i++){
				retstr += '0';
			}
			retstr += nodot;
		}
		else{
			retstr = nodot.substring(0,newdot)+'.'+nodot.substring(newdot);
		}
		return baseToDouble(retstr, 2);
//		return Double.longBitsToDouble(Double.doubleToRawLongBits(input) << (long)input2);
//		return Integer.parseInt(input) << Integer.parseInt(input2);
	}
	
	public static double rShift(double input, double input2){
		return lShift(input, -1*input2);
//		return Double.longBitsToDouble(Double.doubleToRawLongBits(input) >> (long)input2);
//		return Integer.parseInt(input) >> Integer.parseInt(input2);
	}
	
	public static double baseToDouble(String num, int base){
		double ret = 0.0;
		int dot = num.indexOf('.');
		int neg = num.indexOf('-');
		int start = 0;
		if(neg >= 0){
			start = neg+1;
		}
		int end = num.length();
		if(dot >= 0){
			end = dot;
		}
		for(int i=start; i<end; i++){
			ret *= base;
			ret += charToBaseInt(num.charAt(i), base);
		}
		start = end+1;
		end = num.length();
		double frac = 0.0;
		for(int i=end-1, j=1; i>=start; i--, j++){
			frac += ((double)charToBaseInt(num.charAt(i), base));
			frac /= base;
		}
		ret += frac;
		if(neg == 0){
			ret *= -1;
		}
		return ret;
	}
	public static String doubleToBase(double num, int base){
		String ret = "";
		long intnum = (long)num;
		double frac = num - intnum;
		if(num < 0){
			intnum *= -1;
			frac *= -1;
		}
		while(intnum > 0){
			ret = intToBaseChar((int)intnum%base, base) + ret;
			intnum /= base;
		}
		if(frac > 0){
			ret += ".";
			while(frac > 0){
				frac = frac*base;
				intnum = (long)frac;
				frac -= intnum;
				ret += intToBaseChar((int)intnum, base);
			}
		}
		if(num < 0){
			ret = "-"+ret;
		}
		return ret;
	}
	public static char intToBaseChar(int num, int base){
		if(base>=16 && num==15){
			return 'F';
		}
		else if(base>=15 && num==14){
			return 'E';
		}
		else if(base>=14 && num==13){
			return 'D';
		}
		else if(base>=13 && num==12){
			return 'C';
		}
		else if(base>=12 && num==11){
			return 'B';
		}
		else if(base>=11 && num==10){
			return 'A';
		}
		else if(base>=10 && num==9){
			return '9';
		}
		else if(base>=9 && num==8){
			return '8';
		}
		else if(base>=8 && num==7){
			return '7';
		}
		else if(base>=7 && num==6){
			return '6';
		}
		else if(base>=6 && num==5){
			return '5';
		}
		else if(base>=5 && num==4){
			return '4';
		}
		else if(base>=4 && num==3){
			return '3';
		}
		else if(base>=3 && num==2){
			return '2';
		}
		else if(base>=2 && num==1){
			return '1';
		}
		return '0';
	}
	static public int charToBaseInt(char num, int base){
		if(base>=16 && (num=='F' || num=='f')){
			return 15;
		}
		else if(base>=15 && (num=='E' || num=='e')){
			return 14;
		}
		else if(base>=14 && (num=='D' || num=='d')){
			return 13;
		}
		else if(base>=13 && (num=='C' || num=='c')){
			return 12;
		}
		else if(base>=12 && (num=='B' || num=='b')){
			return 11;
		}
		else if(base>=11 && (num=='A' || num=='a')){
			return 10;
		}
		else if(base>=10 && num=='9'){
			return 9;
		}
		else if(base>=9 && num=='8'){
			return 8;
		}
		else if(base>=8 && num=='7'){
			return 7;
		}
		else if(base>=7 && num=='6'){
			return 6;
		}
		else if(base>=6 && num=='5'){
			return 5;
		}
		else if(base>=5 && num=='4'){
			return 4;
		}
		else if(base>=4 && num=='3'){
			return 3;
		}
		else if(base>=3 && num=='2'){
			return 2;
		}
		else if(base>=2 && num=='1'){
			return 1;
		}
		return 0;
	}
}