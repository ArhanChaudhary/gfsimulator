import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] tips = {
            "Wear clothes that make you feel comfortable and confident, don’t just go for what you think makes you seem rich or what you think other people enjoy",
            "Hygiene is a big thing. Girls like guys who know how to take care of themselves",
            "You don’t need to look like an Instagram model, be comfortable in your body, but that doesn’t mean you don’t strive to improve yourself",
            "Paying a little extra to get out of cheap services is almost always worth it. Make the experience worth the money, or don’t bother at all",
            "Chivalry is not dead. Practicing codes of chivalry is not being simp. Being down horrendous is being a simp",
            "Never be down bad for anyone in your life. Know your worth, and keep your head up, even if stuff doesn’t work out",
            "If you ever go through a toxic relationship, you know how that feels. Don’t continue the cycle, and be what you had to face in your next relationship",
            "If someone makes you feel uncomfortable based on your physical appearance or makes you change your morals or beliefs, move on king/queen",
            "If you have a sense of humor, take full advantage of it,  girls like funny guys and that's a fact",
            "Be able to strike up a conversation and communicate. Communication is the key to having a healthy relationship",
            "Get some good cologne and deodorant. How you smell makes a big impact on your first impression",
            "Don’t make any moves without consent",
            "Be an emotional valve for your partner, and vice versa. If your partner doesn’t care for your emotions, she’s not worth it",
            "Take pride in your work and put your effort into what you do. Relationships should not distract you from your individual dreams and goals",
            "Trust is hard to make and easy to break. Stay loyal to your partner, and if you feel like you are losing feelings, communicate. Don’t cheat. You ruin your own conscience and the heart of the person you cheat on",
            "Having a girl best friend is perfectly ok in a relationship, as long as your partner knows and you are open about it. The more you hide, the more the suspicion, and it may lead to confusion. Don’t let it get there"
        };

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Welcome to girlfriend simulator!");
        System.out.println("Do YOU feel lonely all the time?");
        System.out.println("If so, you've come to the right place!");
        System.out.println("Let's get started!");
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println("What is your age?");
        int userAge = input.nextInt();
        input.nextLine();
        User user = new User(name, userAge);

        System.out.println("What is your girlfriend's name?");
        String gfName = input.nextLine();
        
        int gfAge = -1;
        while (gfAge < 18 != user.getAge() < 18 || gfAge == -1) {
            System.out.println("How old is " + gfName + "?");
            gfAge = input.nextInt();
            input.nextLine();
            if (gfAge < 18 != user.getAge() < 18) System.out.println("thats kinda sus mate");
        }
        Girlfriend girlfriend = new Girlfriend(gfName, gfAge);

        System.out.println();
        System.out.println("Hello " + user.getName() + "! This simulator consists of two phases. In the first phase your personality will be evaluated, and in the second phase, you will have to respond to real-life situations with your own virtual girlfriend, featuring a completely different situation every time! It is important to answer everything with complete honesty.");
        System.out.println("Let's get started with phase one!");

        Question[] phaseOne = generatePhaseOne(girlfriend);
        for (Question questionToAsk: phaseOne) {
            System.out.println();
            int choice = questionToAsk.getChoice();
            System.out.println();
            System.out.println("+" + questionToAsk.getPoints(choice) + " points");
            System.out.println(questionToAsk.getExplanation(choice));
            user.setPersonalityScore(user.getPersonalityScore() + questionToAsk.getPoints(choice));
        }
        System.out.println();
        System.out.println("You have completed phase one! Let's get started with phase two!");
        System.out.println();

        dayPart[] phaseTwo = generatePhaseTwo(girlfriend);
        for (dayPart dayPart: phaseTwo) {
            System.out.println();
            System.out.println("GIRLFRIEND TIP: " + tips[(int) (Math.random() * tips.length)]);
            girlfriend.setHappiness(girlfriend.getHappiness() + dayPart.askAQuestion());
        }

        System.out.println("Please wait while we evaluate your responses...");
        System.out.println();
        System.out.println(chooseScenario(girlfriend));
        System.out.println();
        System.out.println(getEvaluation(girlfriend.getHappiness() + user.getPersonalityScore(), user));
    }

    public static String chooseScenario(Girlfriend girlfriend) {
        int happiness = girlfriend.getHappiness();
        double r = Math.random();
        if (r < 0.15) {
            happiness -= 30;
        } else if (r >= 0.15 && r < 0.4) {
            happiness -= 10;
        } else if (r > 0.6 && r <= 0.85) {
            happiness += 10;
        } else if (r > 0.85) {
            happiness += 30;
        }
        
        if (happiness > 310) {
            displayImage("propose.png");
            return "After seven more months of dating, " + girlfriend.getName() + " proposes to you and you accept!";
        } else if (happiness > 280) {
            displayImage("movingIn.png");
            return "After six more months of dating, " + girlfriend.getName() + " wants to completely move in with you!";
        } else if (happiness > 250) {
            displayImage("neutral.png");
            return "After one more year of dating, nothing major happens in the relationship. However, you and " + girlfriend.getName() + " still enjoy each other's company and get along well.";
        }  else if (happiness > 220) {
            displayImage("remainFriends.png");
            return "After ten more months of dating, " + girlfriend.getName() + " wants to break up with you. However, you still have a strong relationship with her and consider each other as good friends.";
        } else if (happiness > 190) {
            displayImage("normalBreakUp.png");
            return "After five more months of dating, " + girlfriend.getName() + " wants to break up with you. She blocks you on every social media.";
        } else {
            displayImage("angryBreakUp.png");
            return "You and " + girlfriend.getName() + " start to argue more every day. After one more month of dating, you both angrily break up.";
        }
    } 

    public static String getEvaluation(int totalScore, User user) {
        System.out.println(totalScore);
        if (totalScore > 575) {
            return user.getName() + ", after evaluating your responses from phase one and phase two, we have decided that you are ready to get a real-life girlfriend! Congrats!";
        } else if (totalScore > 415) {
            return user.getName() + ", after evaluating your responses from phase one and phase two, we have decided that you are somewhat ready to get a real-life girlfriend. Keep working on yourself!";
        } else {
            return user.getName() + ", after evaluating your responses from phase one and phase two, we have decided that you aren't yet ready to get a real-life girlfriend. Keep working on yourself!";
        }
    }

    public static Question[] generatePhaseOne(Girlfriend girlfriend) {
        Question[] phaseOne = {
            new Question("How would you introduce youself to more girls?",
                "Become an active part of your school through clubs and other activities", 60, "This is a good way to meet girls with similar interests",
                "Ask your friends to set you up", 40, "Not a bad option, although relying on the fact that the friends actually have female acquaintances",
                "Use an online dating app", 30, "Not bad, but this may be more of a causal option",
                "Show off your wealth", 0, "Worst way to attract someone who you genuinely get along with"
            ),
            new Question("What is the best way to approach a girl",
                "Confidently introduce yourself and start a conversation with her", 50, "Shows confidence and is respectful. Efficient and effective", 
                "DM", 35, "Depends on if you can split the game. In-person shows more confidence and willingness", 
                "Publicly address her in front of the class", 0, "That's just weird bruh", 
                "Be friendly and slowly transition into knowing each other better", 60, "Slow but steady wins the race. These relationships also turn out the best"
            ),
            new Question("How should you display yourself to a girl?", 
                "Be yourself, and take advantage of your features, without trying too hard", 50, "It’s important to stay true to yourself in any relationship. These types of relationships turn out the best", 
                "Find out the girl’s type, and try to be like her type until you get together with her", 10, "This seems to be a very tempting option, but remember that if she doesn’t want you for who you are, she is not worth it. Keep your head up king, be yourself and don’t change yourself for others", 
                "Show off your intelligence", 15, "Seems a bit egotistical",
                "Don’t display anything and play \"hard to get\"", 0, "Doesn’t really accomplish anything, not sure why you would do this"
            ),
            new Question("What is the ideal first date?", 
                "Movies", 10, "No interaction", 
                "Homemade meal", 70, "Great and unique date idea",
                "Dinner at a restaurant", 60, "Great opportunity to talk, eat some food, and make an initial impression for a girl",
                "Something fun, like an amusement park", 50, "Great date idea, but save it for a later date. Doesn’t give you as much time to talk face to face and get to know more about each other"
            ),
            new Question("What should you NOT do on a first date?", 
                "Make eye contact", 0, "This is something you're supposed to do",
                "Ask her about her day and how she’s doing", 0, "This is something you're supposed to do",
                "Keep your phone away", 0, "This is something you're supposed to do",
                "Keep complimenting her appearance", 50, "There is nothing wrong with complimenting her appearance, but continuously doing so may make you seem desperate and a bit cheap"
            ),
        };
        return phaseOne;
    }

    public static dayPart[] generatePhaseTwo(Girlfriend girlfriend) {
        Question[] dayPart1 = {
            new Question("You wake up and see that " + girlfriend.getName() + " is still sleeping on her bed. You both need to get ready for work. What do you do?",
                "Wake her up and go back to sleep", 10, "Kinda nonsensical",
                "Make breakfast for her and get ready for work", 80, "Husband material right there",
                "Go back to sleep", 0, "Nobody likes an irresponsible person.",
                "Wake up and get ready for work", 60, "Great individual responsibility, but help out your girl while you’re at it."
            ), 
            new Question("You wake up in your bed and see that " + girlfriend.getName() + " is already getting ready for work. What do you do?",
                "Go back to sleep, and ask her to wake you up in 10 minutes", 0, "Shows your irresponsibility, and putting more stress on your girlfriend for no reason. ",
                "Go back to sleep", 0, "Bruh moment. ",
                "Wake up and get ready for your work", 40, "Not bad, but completely ignoring her existence.",
                "Wake up, greet her, and help her get ready after getting ready for your work", 70, "Respectful and efficient."
            ),
            new Question("You wake up in your bed and realize you forgot to set your alarm clock last night. " + girlfriend.getName() + " overslept, too. You both need to get ready for work. What do you do?",
                "Blame " + girlfriend.getName() + " for forgetting to set the alarm", 0, "Bruh at this point why are you in a relationship.",
                "Get ready for work and show up late", 50, "You are going to be late, and at least late is better than never. However, you aren’t considering your girlfriend. ",
                "Help " + girlfriend.getName() + " also get ready for work but show up even later", 60, "You are going to be late anyway, might as well help you gf while you are at it. ",
                "Contemplate skipping work today and go back to sleep, still waking " + girlfriend.getName() + " up", 10, "Nobody likes a lazy person, but at least you woke up your girlfriend. "
            ),
        };
        Question[] dayPart2 = {
            new Question(girlfriend.getName() + " accidentally spills her entire breakfast all over the floor while making it. What do you do?",
                "Leave it there so you both don’t get late for work", 30, "You are focused on the grind, but a bit too focused.",
                "Clean it up with her and remake it, but risk both of you going to work late", 80, "You risk getting late, but secure your girl’s happiness. ",
                "Clean it up for her but go to work late", 60, "Not a bad option, but then your girl goes hungry. ",
                "Do nothing and let her clean it up herself", 0, ""
            ), 
            new Question(girlfriend.getName() + " wants you to make her favorite food for breakfast today. However, it takes a long time to make. What do you do?",
                "Say you can’t make it because you both might get late for work, but promise to do so later", 60, "Making the best of both worlds. ",
                "Quickly and sloppily make it for her so you both don’t get late for work", 45, "Might as well have waited to make it as good as possible, but appreciate the effort",
                "Ask her to make the food herself", 0, "crap boyfriend activities",
                "Neatly make it for her, but go to work late", 30, "Not a bad option, but it would be less stressful for both of you to enjoy the meal at a later time, and not stress about being late. "
            ),
            new Question(girlfriend.getName() + " makes bacon and eggs for you, but you know you hate bacon and eggs. What do you do?",
                "Eat it anyways and explain you dislike bacon and eggs afterwards", 80, "Great job of showing her you appreciate the gesture",
                "Don't eat it and kindly explain you dislike bacon and eggs", 50, "Being respectful, but appreciating the gesture would better preserve her feelings",
                "Get angry at her for making you bacon and eggs", 0, "Fake boyfriend",
                "Make up an excuse to get out of the situation and skip breakfast", 15, "Trying not to hurt feelings, but it doesn’t work. "
            ),
        };
        Question[] dayPart3 = {
            new Question(girlfriend.getName() + " acts aggressively over the phone while at work. What do you do?",
                "Offer to buy her favorite food and drink after getting home", 50, "Good, you don’t know what she's going through. ",
                "Ask why she’s acting this way and if anything is troubling her", 80, "Good, trying to help her and resolve her issues. ",
                "Act rude in response", 0, "Not being understanding. ",
                "Ignore her", 20, "Giving her time to cool off isn’t bad, but isn’t helping her immediately. "
            ), 
            new Question("At work, a co-worker makes a very insulting remark about how " + girlfriend.getName() + " looks. What do you do?",
                "Defend her", 70, "Best thing to do in the situation. Focus on the victim and not the aggressor.",
                "Ask them to screw off", 60, "Indirect consoling. Attacking the aggressor to make the victim feel better. ",
                "Punch them in the face", 15, "Kinda aggressive but kinda gets the job done too. However, putting a job in jeopardy, not the smartest thing. ",
                "Nothing", 20, "It's good to not take everything personally."
            ),
            new Question(girlfriend.getName() + " texts you while you’re talking with a customer over the phone at work. What do you do?",
                "Say you will call them back later so you can text her", 20, "Prioritizing your girl is ok, especially if it is urgent, but not in casual situations, when work is a priority.",
                "Ignore her and respond after the call", 45, "Not the worst decision. You are currently dealing with a customer, and as long as you respond after and your girl knows you are currently at work, all is well. ",
                "Text and converse with her while on the call", 10, "Not good. Won’t be 100% in either. ",
                "Text her you’re on a call, and call her after the customer is satisfied.", 60, "Best of both worlds. "
            ),
        };
        Question[] dayPart4 = {
            new Question(girlfriend.getName() + " wants to buy something but you are running low on money. What do you do?",
                "Agree to buy her whatever she wants, even if it is very expensive", 30, "Temporary happiness, but permanent lack of communication and money",
                "Reject her without explaining your situation", 0, "Just comes off as rude. Be open and communicate",
                "Explain your financial situation, but promise to buy it for her when you can", 70, "Communication is important, and so is mutual understanding",
                "Ask if she can split the bill", 70, "A lot of people will be ashamed to do this, but it is a viable option. Being able to be comfortable with this is a great sign that you are in a good relationship"
            ), 
            new Question(girlfriend.getName() + " wants to go to the mall, but you have already made plans with your homies",
                "Ditch your friends and take her to the mall", 35, "W boyfriend; L homie",
                "Ditch your gf without explaining your situation", 10, "Communication is important, and so is mutual understanding",
                "Explain you made plans with your friends earlier", 45, "Not bad, but girlfriend may feel left out.",
                "Take your homies and your girl, and reschedule a homies-only session", 70, "It helps your girl get more comfortable with your homies and get to know you better, and you can still have another night with the homies, especially since your girlfriend knows who you will hang out with"
            )
        };
        Question[] dayPart5 = {
            new Question("The homies call you while you guys are on a date. What do you do?",
                "Pick up and converse with them", 0, "Ignoring the focus of your night is not smart",
                "Decline and call back later", 50, "It's your girl's night, but your homies might feel ignored",
                "Pick up, but tell them you’re on a date and will call back later", 70, "Being responsive to both. Shows communication skills and respectfulness",
                "Pick up and ask them to join you", 10, "Don’t fumble the bag bruh"
            ),
            new Question("Someone hits on you while you and your girlfriend are waiting for food. What do you do?",
                "Say NO and make it very clear you are not interested", 70, "Proves your loyalty. Might almost be as loyal as a Kings fan. That's next level",
                "Ignore them", 30, "Shows your loyalty, but doesn’t give any satisfaction factor",
                "Kindly say no", 60, "Trying to be a good human, but being more assertive shows how much you truly care about YOUR girl",
                "Offer to be friends", 15, "Kinda seems unloyal"
            ),
            new Question("After finishing your meal. It’s finally time to pay. What do you do?",
                "Pay for both the meals", 60, "Cool move, shows your commitment to her",
                "Split the bill and pay for what you ordered for", 45, "Neutral option",
                "Make an excuse to go to the restroom and let your girlfriend pay for both meals", 10, "Ultra uncool move",
                "Stealthily leave the restaurant without paying", 0, "🤨 🤨 🤨"
            ),
        };
        Question[] dayPart6 = {
            new Question("After dinner, " + girlfriend.getName() + " wants you to drop her off at her house.",
                "Tell her no and leave her there", 0, "Why. Just why would you choose this.",
                "Agree and drive her home", 60, "This is what you are supposed to be. Be a gentleman and drop her off at her house. be chival.",
                "Call an uber for her, and drive home yourself.", 20, "You are sending her home, but it would be much more romantic and you can further show your interest by going with her or dropping her yourself.",
                "Walking her home, or taking an uber with him to your destination.", 60, "Not everyone has a car, and that is ok. Show you care about her and drop her off. Good choice."
            ),

            new Question("Before you go to sleep, you should: ",
                "Text her gn", 20, "Not bad, but text out the entire thing to show that you really care.",
                "Call her, but risk waking her up to tell her how much you appreciate her.", 60, "Although you risk waking her up, telling your girlfriend how much you appreciate her before she sleeps is a really cute way to reinforce you commitment and love for the relationship.",
                "Send her a couple sentences about how much you are looking forward to have a date like that again", 60, "You are sending her home, but it would be much more romantic and you can further show your interest by going with her or dropping her yourself.",
                "Do nothing.", 0, "Bruh moment."
            ),
        };
        dayPart[] phaseTwo = {
            new dayPart("It's the beginning of the day", dayPart1),
            new dayPart("You and " + girlfriend.getName() + " decide to get ready for work and then have breakfast", dayPart2),
            new dayPart("You leave your home and eventually arrive at work", dayPart3),
            new dayPart("Work ends and you meet up with " + girlfriend.getName(), dayPart4),
            new dayPart("You both decide to spend the night at a restaurant", dayPart5),
            new dayPart("After finishing your dinner, you and " + girlfriend.getName() + " finally decide to wrap the day up", dayPart6),
        };
        return phaseTwo;
    }

    public static void displayImage(String fileName) {
        try {
            BufferedImage image = ImageIO.read(new File(fileName));            
            ImageIcon imageIcon = new ImageIcon(image);
            JFrame jFrame = new JFrame();

            jFrame.setLayout(new FlowLayout());
            
            jFrame.setSize(500, 750);
            JLabel jLabel = new JLabel();

            jLabel.setIcon(imageIcon);
            jFrame.add(jLabel);
            jFrame.setVisible(true);

            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}