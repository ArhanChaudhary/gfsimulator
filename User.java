public class User {
    private String name;
    private int age;
    private int personalityScore;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.personalityScore = 0;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getPersonalityScore() {
        return personalityScore;
    }
    public void setPersonalityScore(int personalityScore) {
        this.personalityScore = personalityScore;
    }
}
