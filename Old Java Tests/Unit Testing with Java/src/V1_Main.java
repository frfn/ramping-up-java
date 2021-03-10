public class V1_Main {

    private String name;
    private int age;
    private boolean happy;

    public V1_Main(){
        name = null;
        age = 0;
        happy = false;
    }

    public void setNameAndAge(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setMood(boolean value){
        happy = value;
    }

    public boolean isHappy(){
        happy = true;
        return true;
    }
}
