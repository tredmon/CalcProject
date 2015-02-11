import java.util.ArrayList;


public class TheMath {
	
	private TheMath(){}
	
	
	
	
	public static String o0 = "000"; 
	public static String o1 = "001";
	public static String o2 = "010";
	public static String o3 = "011";
	public static String o4 = "100";
	public static String o5 = "101";
	public static String o6 = "110";
	public static String o7 = "111";
	
	public static String h0 = "0000"; 
	public static String h1 = "0001";
	public static String h2 = "0010";
	public static String h3 = "0011";
	public static String h4 = "0100";
	public static String h5 = "0101";
	public static String h6 = "0110";
	public static String h7 = "0111";
	public static String h8 = "1000";
	public static String h9 = "1001";
	public static String ha = "1010";
	public static String hb = "1011";
	public static String hc = "1100";
	public static String hd = "1101";
	public static String he = "1110";
	public static String hf = "1111";
	
//	private static ArrayList <Integer> list = new ArrayList <Integer>();
	
	public static String deciToBinary(int input){
		String x = "";
		
		while(input >= 1){
			
			if(input % 2 == 0){
				input = input/2;
				x += "0";
			}
			else if(input % 2 == 1){
				input = input/2;
				x += "1";
			}
		}
		String z = "";
		for(int y = x.length() - 1; y >= 0; y--)
		{
			 for(int i = 0; i < z.length(); i++)
				 z += x.charAt(y);
		}
		return z;
	}
	
	public static String octToBinary(String input){
		String value = "";
		for(int x = 0; x < input.length(); x++){
			switch(input.charAt(x)){
				case '0':
					value += (o0);
				case '1':
					value += (o1);
				case '2':
					value += (o2);
				case '3':
					value += (o3);
				case '4':
					value += (o4);
				case '5':
					value += (o5);
				case '6':
					value += (o6);
				case '7':
					value += (o7);
			}
		}
		return value + "\n";
	}
	
	public static String hexToBinary(String input){
		String value = "";
		for(int x = 0; x < input.length(); x++){
			switch(input.charAt(x)){
			case '0':
				value += (h0);
			case '1':
				value += (h1);
			case '2':
				value += (h2);
			case '3':
				value += (h3);
			case '4':
				value += (h4);
			case '5':
				value += (h5);
			case '6':
				value += (h6);
			case '7':
				value += (h7);
			case '8':
				value += (h8);
			case '9':
				value += (h9);
			case 'a':
				value += (ha);
			case 'b':
				value += (hb);
			case 'c':
				value += (hc);
			case 'd':
				value += (hd);
			case 'e':
				value += (he);
			case 'f':
				value += (hf);
			}
		}
		return value + "\n";
	}
}
