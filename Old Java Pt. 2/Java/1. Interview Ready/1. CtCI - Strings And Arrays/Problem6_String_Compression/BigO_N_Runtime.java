package Problem6_String_Compression;

public class BigO_N_Runtime {
	
	public static void main(String[] args) {
		
		String compress = compression("NNNicccooollleee Fad");
		
		System.out.println(compress);
	}

	
	public static String compression(String str) {
		if(str.length() == 1) {
			return str;
		}
		if(str.length() == 0) {
			return "";
		}
		
		StringBuilder build = new StringBuilder();
		int count = 1;
		
		for(int i = 0; i < str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)) {
				count++;
			}
			
			if(str.charAt(i) != str.charAt(i + 1)) {
				if(count > 1) {
					build.append(str.charAt(i) + Integer.toString(count));
				}
				else {
					build.append(str.charAt(i));
				}
				count = 1;
			}
			
		}
		
	
		if(count > 1) {
			build.append(str.charAt(str.length()-1) + Integer.toString(count));
		}
		else {
			build.append(str.charAt(str.length()-1));
		}		
		
		return build.toString();
	}
}
