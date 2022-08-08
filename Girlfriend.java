public class Girlfriend {
    private int happiness;
    private int age;
    private String name;

    public Girlfriend(String name, int age) {
        this.name = name;
        this.age = age;
        this.happiness = 0;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
    public int getHappiness() {
        return this.happiness;
    }
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return name;
    }
}