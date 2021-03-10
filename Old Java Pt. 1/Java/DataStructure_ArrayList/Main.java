package DataStructure_ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("Flex");
        list.add("Cole");
        list.add("Isla");

        System.out.println(list.toString());

        list.removeAtIndex(0);

        System.out.println(list.toString());

    }

}
