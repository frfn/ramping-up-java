package a_classTraits.personExample;

import java.util.HashMap;

public class House {

    private HashMap<Person, String> house = new HashMap<>();

    public House() {}

    public HashMap<Person, String> getHouse() { return house; }

    public void addPersonToHouse(Person person, Relations relation) {
        String r = null;
        switch(relation) {
           case FATHER: r = "Father"; break;
           case MOTHER: r = "Mother"; break;
           case BROTHER: r = "Brother"; break;
           case SISTER: r = "Sister"; break;
           case GRANDPARENTS: r = "Grand Parents"; break;
        }
        house.put(person, r);
    }

    public void printPeople() {
    for(HashMap.Entry<Person, String> people : house.entrySet()) {
        System.out.println(people.getKey().getName() + " : " + people.getValue());
    }
    }


}
