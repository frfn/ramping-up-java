package Conclusion;

public class ReverseWords {
	
	public static void main(String[] args) {
		
		String string = reverseWords("   Hi I am Flexer    Fadrigalan.    ");
		
		System.out.println(string);
		
	}

	public static String reverseWords(String s) {
		
		String[] strArr = s.trim().split(" ");
		
		for(int i = 0; i < strArr.length / 2; i++) {
			
			int other = strArr.length - i - 1;
			
			String temp = strArr[i];
			strArr[i] = strArr[other];
			strArr[other] = temp;
			
			
		}
		
		StringBuilder build = new StringBuilder();
		
		for(int i = 0; i < strArr.length; i++) {
			if(!strArr[i].equals("" )) {
				build.append(strArr[i] + " ");
			}
		}
		
		return build.toString().trim();
		
	}
		
}
