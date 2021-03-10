package InterviewQuestions_HashMapProblems;

import java.util.HashMap;
import java.util.Scanner;

public class QuickLookUp {

    public static void main(String[] args) {
        HashMap<String, Person> kv = new HashMap<>();
        Person flex = new Person("Flexer", "23");
        Person cole = new Person("Cole", "22");
        Person isla = new Person("Isla", "4 months");

        kv.put("Flex", flex);
        kv.put("Cole", cole);
        kv.put("Isla", isla);

        for(HashMap.Entry entry: kv.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter person name or -1 to quit: ");
        String name = scan.next();
        while(!name.equals("-1")){
            if(kv.containsKey(name)){
                System.out.println("Would you like to change name or age?: ");
                String choose = scan.next();

                if(choose.equalsIgnoreCase("age")){
                    System.out.println("Change age for " + kv.get(name).getName() + " to: ");
                    String newAge = scan.next();
                    kv.get(name).setAge(newAge);
                    System.out.println("Success! Age changed...");
                }

                else if(choose.equalsIgnoreCase("name")){
                    System.out.println("Change name for " + kv.get(name).getName() + " to: ");
                    String newName = scan.next();
                    kv.get(name).setName(newName);
                    System.out.println("Success! Name changed...");
                }

                else{
                    System.out.println("Failed, try again...");
                }

                for(HashMap.Entry entry: kv.entrySet()){
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }

            }
            else{
                System.out.println("Person does not exist...");
            }

            System.out.println("Enter person name or -1 to quit: ");
            name = scan.next();

        }

        System.out.println("Later!");

    }

    private static class Person {

        private String name, age;

        public Person(String n, String a){
            name = n; age = a;
        }

        public String getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(name + ", " + age);
            return sb.toString();
        }

    }

}
