import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;


public class questionioScene extends Scene {

    public questionioScene(Stage primaryStage) {
        super(new VBox(), 440, 350);

        //questionIO controls
        Insets offset = new Insets(10,10,10,10);

        Image CUizLogo = new Image("CUiz Logo.png");
        ImageView CUizView = new ImageView();
        CUizView.setFitWidth(440);
        CUizView.setFitHeight(250);
        CUizView.setImage(CUizLogo);

        TextField questionInTextfield= new TextField();
        questionInTextfield.setPromptText("Input Question");

        TextField rightAnswerInTextfield= new TextField();
        rightAnswerInTextfield.setPromptText("Input Correct Answer");

        TextField wrongAnswer1InTextfield= new TextField();
        wrongAnswer1InTextfield.setPromptText("Input Wrong Answer 1");

        TextField wrongAnswer2InTextfield= new TextField();
        wrongAnswer2InTextfield.setPromptText("Input Wrong Answer 2");

        TextField wrongAnswer3InTextfield= new TextField();
        wrongAnswer3InTextfield.setPromptText("Input Wrong Answer 3");

        Button returnMainButton = new Button("Return to Main Menu");
        returnMainButton.setOnAction(e -> {
        Stage stage = (Stage) returnMainButton.getScene().getWindow();
        primaryStage.setScene(mainmenuScene.createScene(stage));
        });

        Button doneButton = new Button("Done");//******************************
        doneButton.setOnAction(e -> {
            // generate string USR+random number
            // add card to database
            int rand = (int)(Math.random() * 500)+1;
            // string
            String card_id= "usr" + rand;

            card user_manual = new card(card_id, questionInTextfield.getText(), rightAnswerInTextfield.getText() + ";" + wrongAnswer1InTextfield.getText() + ";" + wrongAnswer2InTextfield.getText() + ";" + wrongAnswer3InTextfield.getText(), 0, 0, 0);
            DB_CardInteract.addCardToDB(user_manual);
            Popup successfulQAddp = new Popup();
            Label successfulQAddpLabel = new Label("Question Successfully added");
            successfulQAddp.getContent().add(successfulQAddpLabel);
            SuccessPopUp(successfulQAddp, primaryStage);
        });
        ImageView CUizView2 = new ImageView();
        CUizView2.setImage(CUizLogo);


        VBox CenterQuestionIOLay = new VBox();
        CenterQuestionIOLay.setAlignment(Pos.CENTER);
        CenterQuestionIOLay.getChildren().addAll(questionInTextfield, rightAnswerInTextfield, wrongAnswer1InTextfield, wrongAnswer2InTextfield, wrongAnswer3InTextfield, doneButton);


        BorderPane QuestionIOLay = new BorderPane();
        QuestionIOLay.setStyle("-fx-background-color: #FFD966;");
        QuestionIOLay.setPadding(offset);
        QuestionIOLay.setTop(CUizView2);
        QuestionIOLay.setCenter(CenterQuestionIOLay);
        QuestionIOLay.setBottom(returnMainButton);




        // Add the button to the scene's layout
        VBox root = (VBox) this.getRoot();
        root.getChildren().addAll(QuestionIOLay);

    }
    public static questionioScene createScene(Stage primaryStage) {
        return new questionioScene(primaryStage);
    }

    public static void SuccessPopUp(Popup successfulQAddp, Stage stage) {
        Timeline popupTimeline = new Timeline( //To store keyframes
                new KeyFrame(Duration.seconds(0), e -> {
                    successfulQAddp.show(stage);
                }),
                new KeyFrame(Duration.seconds(3), e -> {
                    successfulQAddp.hide();
                }));
        popupTimeline.setCycleCount(1); //How many times it plays the sequence
        popupTimeline.playFromStart();
    }

}


