package a_classTraits.personExample;

public class Person implements Interaction {

    private double height;
    private double weight;
    private String name;
    private Integer age;


    public Person(double h, double w, String n) {
        height = h;
        weight = w;
        name = n;
        age = null;
    }

    public void setHeight(double newHeight) { height = newHeight; }
    public void setWeight(double newWeight) { weight = newWeight; }
    public void setName(String newName) { name = newName; }
    public void setAge(Integer newName) { age = newName; }

    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public String getName() { return name; }
    public Integer getAge() { return age; }

    @Override
    public void sayHello() { System.out.println("Hello!"); }

    @Override
    public boolean isTallerShorter(Interaction otherPerson) { return height > ((Person) otherPerson).getHeight(); }

    @Override
    public boolean isHeavierLighter(Interaction otherPerson) {
        return weight > ((Person) otherPerson).getWeight();
    }
}
