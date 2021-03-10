package Problem9_String_Rotation;

public class String_Rotation {
	
	public static void main(String[] args) {
		String rotate = rotation("waterbottle", 1);
		
		System.out.println(rotate);
	}
	
	public static String rotation(String str, int index) {
		StringBuilder build = new StringBuilder();
		
		if(index < 0 || index > str.length()) {
			return "Invalid index...";
		}
		
		String s1 = str.substring(index, str.length());
		System.out.println("S1: "+s1);
		
		String s2 = str.substring(0, index);
		System.out.println("S2: "+s2);
	
		
		build.append(s1 + s2);
		
		return build.toString();
	}

}
