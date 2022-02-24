import java.util.*;
public class Main {
    public static Question[] questions = {
        new Question("Do you like your girlfriend?", 
        "test", 100,
        "tes2", 50,
        "test3", 0,
        "test5", -50),
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // This project is a girlfriend simulator.
        // We will first ask basic information about you

        System.out.println("Welcome to girlfriend simulator!");
        System.out.println("Do YOU feel lonely all the time?");
        System.out.println("");

        // First, we will ask for your girlfriend's name
        System.out.print("What is your dream girlfriend's name?");
        String name = input.nextLine();

        // Next, we will ask for your girlfriend's age
        int age = 0;
        while (age < 18) {
            System.out.print("How old is your dream girlfriend?");
            age  = input.nextInt();
            input.nextLine();
            if (age < 18)
                System.out.println("thats kinda sus man, please enter again before we call 911");
        }

        Girlfriend girlfriend = new Girlfriend(name, age);

        for (int questionsAsked = 0; girlfriend.getHappiness() > 0 && questionsAsked < 8; questionsAsked++) {
            int questionIndex = (int) (Math.random() * questions.length);
            int score = Main.questions[questionIndex].askQuestion();
            girlfriend.setHappiness(girlfriend.getHappiness() + score);
        }
        System.out.print(chooseScenario(girlfriend.getHappiness()));
        if (girlfriend.getHappiness() > 300) {
            System.out.println("You are ready to get a real-life girlfriend! Congrats!");
        } else if (girlfriend.getHappiness() > 250) {
            System.out.println("You are ready to get a real-life girlfriend!");
        } else if (girlfriend.getHappiness() > 200) {
            System.out.println("You are somewhat ready to get a real-life girlfriend, consider ");
        } else if (girlfriend.getHappiness() > 150) {
            System.out.println("You are aren't to get a real-life girlfriend!");
        } else if (girlfriend.getHappiness() > 100) {
            System.out.println("Your virtual girlfriend has fallen madly in love with you! You aren't yet ready to get a real-life girlfriend!");
        } else if (girlfriend.getHappiness() > 50) {
            System.out.println("Your virtual girlfriend cheats on you! You are ready to get a real-life girlfriend! ");
        } else if (girlfriend.getHappiness() > 0) {
            System.out.println("Your virtual girlfriend has fallen madly in love with you! You are ready to get a real-life girlfriend!");
        }
    }

    public static String chooseScenario(int happiness) {
        double r = Math.random();
        if (r < 0.15) {
            happiness -= 50;
        } else if (r >= 0.15 && r < 0.4) {
            happiness -= 20;
        } else if (r > 0.6 && r <= 0.85) {
            happiness += 20;
        } else if (r > 0.85) {
            happiness += 50;
        }

        String possibleScenarios[];

        if (happiness > 300) {
            // possibleScenarios = {"Your virtual girlfriend has fallen madly in love and proposed to you!", "5"};
        } else if (happiness > 250) {
            return "Your virtual girlfriend ";
        } else if (happiness > 200) {
            return "You are somewhat ready to get a real-life girlfriend, consider ";
        } else if (happiness > 150) {
            return "You are aren't to get a real-life girlfriend!";
        } else if (happiness > 100) {
            return "Your virtual girlfriend has fallen madly in love with you! You aren't yet ready to get a real-life girlfriend!";
        } else if (happiness > 50) {
            return "Your virtual girlfriend cheats on you! You are ready to get a real-life girlfriend! ";
        } else if (happiness > 0) {
            return "Your virtual girlfriend has fallen madly in love with you! You are ready to get a real-life girlfriend!";
        } else {
            return "Your virtual girlfriend has fallen madly in love with you! You are ready to get a real-life girlfriend!";
        }

        return "Your virtual girlfriend has fallen madly in love with you!";
    }
}