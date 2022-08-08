public class dayPart {
    private Question[] questions;
    private String premise;

    public dayPart(String premise, Question[] questions) {
        this.questions = questions;
        this.premise = premise;
    }
    public int askAQuestion() {
        int questionIndex = (int) (Math.random() * questions.length);
        Question questionToAsk = questions[questionIndex];
        System.out.println();
        System.out.println(premise);
        System.out.println();
        int choice = questionToAsk.getChoice();
        System.out.println();
        System.out.println("+" + questionToAsk.getPoints(choice) + " points");
        System.out.println(questionToAsk.getExplanation(choice));
        return questionToAsk.getPoints(choice);
    }
}
