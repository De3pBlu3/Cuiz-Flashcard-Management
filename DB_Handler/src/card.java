import java.util.Arrays;

public class card {

    //    - card id
    //    - Question_content
    //    - Question_answers
    //    - Question_correct_answer
    //    - Question_category
    //    - Question _difficulty

    String card_id;
    String Question_content;
    String[] Question_answers_arr;
    int Question_correct_answer; // index of Question_answers which is the correct answer
    int Question_category; // Discrete Mathematics, Computer Science, and Computer Organisation
    int Question_difficulty; // 0 = novice 1 = intermediate 2 = expert

    public card(String card_id, String question_content, String question_answers, int question_correct_answer, int question_category, int question_difficulty) {
        this.card_id = card_id;
        this.Question_content = question_content;
        this.Question_answers_arr = question_answers.split(";");
        this.Question_correct_answer = question_correct_answer;
        this.Question_category = question_category;
        this.Question_difficulty = question_difficulty;
    }

    @Override
    public String toString() {
        return "Card id: \t\t\t" + card_id + "\n" +
                "Question: \t\t\t" + Question_content + "\n" +
                "Answers: \t\t\t" + Arrays.toString(Question_answers_arr) + "\n" +
                "Correct answer: \t\t\t" + Question_answers_arr[Question_correct_answer] + "\n" +
                "Category: \t\t\t" + Question_category + "\n" +
                "Difficulty: \t\t\t" + Question_difficulty + "\n";
    }
}
