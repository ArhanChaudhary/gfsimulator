import java.util.*;
public class Question {
    private String question;
    private String firstOption;
    private int firstOptionPoints;
    private String firstOptionExplanation;
    private String secondOption;
    private int secondOptionPoints;
    private String secondOptionExplanation;
    private String thirdOption;
    private int thirdOptionPoints;
    private String thirdOptionExplanation;
    private String fourthOption;
    private int fourthOptionPoints;
    private String fourthOptionExplanation;

    public Question(String question, String firstOption, int firstOptionPoints, String firstOptionExplanation, String secondOption, int secondOptionPoints, String secondOptionExplanation, String thirdOption, int thirdOptionPoints, String thirdOptionExplanation, String fourthOption, int fourthOptionPoints, String fourthOptionExplanation) {
        this.question = question;
        this.firstOption = firstOption;
        this.firstOptionPoints = firstOptionPoints;
        this.firstOptionExplanation = firstOptionExplanation;
        this.secondOption = secondOption;
        this.secondOptionPoints = secondOptionPoints;
        this.secondOptionExplanation = secondOptionExplanation;
        this.thirdOption = thirdOption;
        this.thirdOptionPoints = thirdOptionPoints;
        this.thirdOptionExplanation = thirdOptionExplanation;
        this.fourthOption = fourthOption;
        this.fourthOptionPoints = fourthOptionPoints;
        this.fourthOptionExplanation = fourthOptionExplanation;
    }
    public int getChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println(question);
        System.out.println("1) " + firstOption);
        System.out.println("2) " + secondOption);
        System.out.println("3) " + thirdOption);
        System.out.println("4) " + fourthOption);
        int answer = input.nextInt();
        input.nextLine();
        if (answer >= 1 && answer <= 4) {
            return answer;
        } else {
            System.out.println("Invalid answer, please try again");
            return getChoice();
        }
    }
    public int getPoints(int choice) {
        if (choice == 1) {
            return firstOptionPoints;
        } else if (choice == 2) {
            return secondOptionPoints;
        } else if (choice == 3) {
            return thirdOptionPoints;
        } else {
            return fourthOptionPoints;
        }
    }
    public String getExplanation(int choice) {
        if (choice == 1) {
            return firstOptionExplanation;
        } else if (choice == 2) {
            return secondOptionExplanation;
        } else if (choice == 3) {
            return thirdOptionExplanation;
        } else {
            return fourthOptionExplanation;
        }
    }
}