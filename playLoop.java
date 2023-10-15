import java.util.Scanner;
public class playLoop {
    public static void main(String[] args) {


        // we are going to aasume user has been logged in, we might pass this as a parameter when the user logs in
        // so for now, we will create user_id var and assign it a temp value
        String user_id = "Sean";

        // we will also assume the player has chosen a game mode, and will run a different method depdning on the game mode
        // for now, we will create a random mode and call it
        random_play();
    }

    public static void shuffle_array(card[] cards_array){
        // shuffle array
        for (int i = 0; i < cards_array.length; i++) {
            int randomIndexToSwap = (int) (Math.random() * cards_array.length);
            card temp = cards_array[randomIndexToSwap];
            cards_array[randomIndexToSwap] = cards_array[i];
            cards_array[i] = temp;
        }
    }
    public static void random_play(){
        Scanner scan = new Scanner(System.in);
        // take all cards from database, create array of objects, shuffle array, and then play through the array, remoiving cards as they are played

        card[] cards_array = DB_CardInteract.returnAllCards();
        int score = 0;
        shuffle_array(cards_array);

        // loop through the array,
        for (int i = 0; i < cards_array.length; i++) {
            // show card
            // enter 1, 2 ,3 ,4
            // check if correct index (i.e index +1)
            // if correct, add 1 to score, and add win to scores_db and change score_db by 1
            // if incorrect, add loss to scores_db and change score_db by -1

            // show card
            System.out.println(cards_array[i].Question_content);
            for (int answer = 0; answer < cards_array[i].Question_answers_arr.length; answer++) {
                System.out.println(answer + 1 + ": \t" + cards_array[i].Question_answers_arr[answer]);
            }

            // enter 1, 2 ,3 ,4
            System.out.print("Enter your answer: ");
            int user_answer = scan.nextInt();

            // check if correct index (i.e index +1)
            if (user_answer == cards_array[i].Question_correct_answer + 1){
                // if correct, add 1 to score, and add win to scores_db and change score_db by 1
                //                DB_ScoreInteract.addWin(user_id, cards_array[i].card_id);
//                DB_ScoreInteract.changeScore(user_id, 1);
                score++;
                System.out.println("\nCorrect!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            else {
                // if incorrect, add loss to scores_db and change score_db by -1
//                DB_ScoreInteract.addLoss(user_id, cards_array[i].card_id);
//                DB_ScoreInteract.changeScore(user_id, -1);
                System.out.println("\nIncorrect!");
                // wait 3 seconds
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }




    }

}
