package Problem3_URLify;

public class URLify {
	
	public static void main(String[] args) {
		
		String url = urlify("Mrs Nicole Fadrigalan");
		
		System.out.println(url);
		
	}
	
	public static String urlify(String str) {
		
		StringBuilder build = new StringBuilder();
		
		if(str.length() == 0) {
			return "Empty string...";
		}
		
		for(int i = 0; i<str.length(); i++) {
			
			if(str.charAt(i) == ' ') {
				build.append("%20");
				continue;
			}
			
			build.append(str.charAt(i));
			
		}
		
		return build.toString();
		
	}

}
