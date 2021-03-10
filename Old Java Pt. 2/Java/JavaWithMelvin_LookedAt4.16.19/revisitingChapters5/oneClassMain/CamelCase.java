package oneClassMain;

public class CamelCase {
	
	private static String str = "Hello_all-friends";
	private static String revisedStr = "";
	
	public static void main(String[] args){
		
		System.out.println(str);
		
		if(Character.isUpperCase(str.charAt(0))) {
			char lowercaseLetter = Character.toLowerCase(str.charAt(0));
			revisedStr += lowercaseLetter;
			
		}
		
		for(int i = 1; i <= str.length() - 1; i++) {
			
			if(str.charAt(i) == '-') {
				i++;
				char fixToLetter = Character.toUpperCase(str.charAt(i));
				
				revisedStr += fixToLetter;
				
				
			}
			else if(str.charAt(i) == '_') {
				i++;
				char fixToLetter = Character.toUpperCase(str.charAt(i));
				
				revisedStr += fixToLetter;
				
				
			}
			else {
				revisedStr += str.charAt(i);
			}
			
			//System.out.println(revisedStr);
			
		}
		
		System.out.println(revisedStr);
	}
}
