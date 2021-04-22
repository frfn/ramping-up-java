package a_classTraits.personExample;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        House house = new House();

        Person Flex = new Person(510, 170, "Flexer");
        Person Cyro = new Person(509, 210, "Cyro");
        Person Isla = new Person(2, 30, "Isla");

        house.addPersonToHouse(Flex, Relations.BROTHER);
        house.addPersonToHouse(Cyro, Relations.BROTHER);
        house.addPersonToHouse(Isla, Relations.SISTER);

        house.printPeople();

        Scanner scan = new Scanner(System.in);

        System.out.println("Input '1' to change a name! '2' to print!");
        String userInput = scan.next();

        while(!userInput.equals("-1")) {

            switch(userInput) {
                case "1":
                    System.out.println("Changing name UI... who would you like to change?");
                    String person = scan.next();
                    Scanner name = new Scanner(System.in);

                    Person temp;

                    boolean flag = false;

                    for(Person people: house.getHouse().keySet()) {
                        if(people.getName().equals(person)) {
                            flag = true;
                            temp = people;
                            System.out.println("The person you are changing is: " + temp.getName());
                            System.out.print("Changing name to: ");
                            String newName = name.nextLine();
                            changeName(house, temp, newName);
                            System.out.println("All set!");
                            break;
                        }
                    }

                    String exit = flag ? "Thank you for using name changer! Bye!" : "Go to main menu and select '1'";
                    System.out.println(exit);

                    break;
                case "2":
                    System.out.println("Printing out people...");
                    house.printPeople();
                    break;
            }

            System.out.print("Please enter '1' to change name, or '2' to print. '-1' to quit: ");
            userInput = scan.next();

        }
        System.out.println("Thank you, bye!");
    }

    public static void changeName(House house, Person person, String newName) {
        if(house.getHouse().containsKey(person)) {
            person.setName(newName);
        }
        else {
            System.out.println("Person does not exist.");
        }

    }

}
