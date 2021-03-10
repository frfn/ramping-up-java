package Conclusion;

public class ReverseWords2 {
	
	public static void main(String[] s) {
		
		String str = "Let's take LeetCode contest";
		String newStr = reverseWords(str);
		
		System.out.println(newStr);
		
	}

	public static String reverseWords(String s) {
        
        String[] strArr = s.trim().split(" ");
        
        StringBuilder build = new StringBuilder();
        
        for(String word: strArr){
            char[] charArr = word.toCharArray();
            for(int i = 0; i < charArr.length / 2; i++) {
            	int other = charArr.length - i - 1;
            	
            	char temp = charArr[i];
            	charArr[i] = charArr[other];
            	charArr[other] = temp;
            	
            	
            }
            
            String reversed = String.valueOf(charArr);
        	build.append(reversed + " ");
            
        }
        
        String word = build.toString().trim();
        return word;
        
    }
	
}
