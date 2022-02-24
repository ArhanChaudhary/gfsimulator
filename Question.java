import java.util.*;
public class Question {
    private String question;
    private String firstOption;
    private int firstOptionPoints;
    private String secondOption;
    private int secondOptionPoints;
    private String thirdOption;
    private int thirdOptionPoints;
    private String fourthOption;
    private int fourthOptionPoints;

    public Question(String question, String firstOption, int firstOptionPoints, String secondOption, int secondOptionPoints, String thirdOption, int thirdOptionPoints, String fourthOption, int fourthOptionPoints) {
        this.question = question;
        this.firstOption = firstOption;
        this.firstOptionPoints = firstOptionPoints;
        this.secondOption = secondOption;
        this.secondOptionPoints = secondOptionPoints;
        this.thirdOption = thirdOption;
        this.thirdOptionPoints = thirdOptionPoints;
        this.fourthOption = fourthOption;
        this.fourthOptionPoints = fourthOptionPoints;
    }
    public int askQuestion() {
        Scanner input = new Scanner(System.in);
        System.out.println(question);
        System.out.println("1) " + firstOption);
        System.out.println("2) " + secondOption);
        System.out.println("3) " + thirdOption);
        System.out.println("4) " + fourthOption);
        int answer = input.nextInt();
        input.nextLine();
        if (answer == 1) {
            return firstOptionPoints;
        } else if (answer == 2) {
            return secondOptionPoints;
        } else if (answer == 3) {
            return thirdOptionPoints;
        } else if (answer == 4) {
            return fourthOptionPoints;
        } else {
            System.out.println("Invalid answer, please try again");
            return askQuestion();
        }
    }


}
