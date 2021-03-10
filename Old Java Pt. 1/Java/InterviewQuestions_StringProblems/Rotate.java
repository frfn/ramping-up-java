package InterviewQuestions_StringProblems;

public class Rotate {

    public static void main(String[] args) {
        System.out.println(rotate("Flexer", 0));
    }

    public static String rotate(String str, int index){
        if(str.length() == 1) {return str;}
        if(str.length() < 0) {return "Invalid index...";}

        StringBuilder build = new StringBuilder();

        String s1 = str.substring(index, str.length());
        String s2 = str.substring(0, index);

        build.append(s1); build.append(s2);

        return build.toString();
    }

}
