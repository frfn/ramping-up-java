package Kangaroo;

public class Kangaroo {
	
	public static void main(String[] args) {
		String boo = kangaroo(0, 3, 4, 2);
		System.out.println(boo);
	}
	
	static String kangaroo(int x1, int v1, int x2, int v2) {
        // x1 = index, v1 = how many steps
        StringBuilder build = new StringBuilder();

        if(x2 > x1 && v2 > v1){
            build.append("No"); 
            return build.toString();
        }
        
        if((x2 - x1) % (v1 - v2) == 0) {
        	build.append("Yes"); 
            return build.toString();
        }
        
        build.append("No"); 
        return build.toString();
       
//        else {
//
//	        int count = 1;
//	
//	        while(count <= 10000){
//	        	if(x1 < x2) {
//		            if((x1 + (v1 * count)) == (x2 + (v2 * count))){
//		                build.append("Yes");
//		                return build.toString();
//		            }
//	        	}
//	        	else {
//	        		build.append("No");
//	     	        return build.toString();
//	        	}
//	        	
//	        	count++;
//	        }
//	
//	        build.append("No");
//	        return build.toString();
//        
//        }
    }

}
