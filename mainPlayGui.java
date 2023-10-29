

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class mainPlayGui extends Application {
	Scene mainQuiz, playModes, stats, questionIO, home;
	public static void main(String[] args) {
		launch(args);  //method in application class that sets up javafx app (setup)

	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("The CUiz"); //Window title
		
		//Controls
		//------------------------------------------------------------------------
			//mainQuiz controls
		Button playButton = new Button("-Play-");
        playButton.setOnAction(e -> stage.setScene(playModes));
        
        Button statsButton = new Button("Play statistics");
        statsButton.setOnAction(e -> stage.setScene(stats));
		
        Button questionIOButton = new Button("Input your own questions");
        questionIOButton.setOnAction(e -> stage.setScene(questionIO));
        
        Button logoutButton = new Button("Log out");
        logoutButton.setOnAction(e -> stage.setScene(home));
        
        Label currentUserLabel = new Label("Currently Logged in: " + "username" ); //Add username display
        
        Label trademarkLabel = new Label("Made by Jack Casey and Ellice Nelson\r\n"
        		+ "“CUiz” is a registered trademark ™\r\n");
        
        Image CUizLogo = new Image("CUiz Logo.png");
        ImageView CUizView = new ImageView();
        CUizView.setFitWidth(200); 
        CUizView.setFitHeight(150); 
		CUizView.setImage(CUizLogo);
		
		Image CUizPenguin = new Image("CUizPenguin.png");
		ImageView CUizPenguinView = new ImageView();
		CUizPenguinView.setFitWidth(200); 
		CUizPenguinView.setFitHeight(150); 
		CUizPenguinView.setImage(CUizPenguin);
		
		
			//playModes controls
		Button incDifficultyButton = new Button("Increasing\n" 
				+ "Difficulty");
		//incDifficultyButton.setOnAction(e -> stage.setScene());
		
		Button incScoreButton = new Button("Increasing\n" 
				+ "Score");
		//incScoreButton.setOnAction(e -> stage.setScene());
		
		Button randomPlayButton = new Button("Random\n" 
				+ "Play");
		//randomPlayButton.setOnAction(e -> stage.setScene());
		
        ImageView CUizView1 = new ImageView();
		CUizView1.setImage(CUizLogo);
		
		ImageView CUizPenguinView1 = new ImageView();
		CUizPenguinView1.setImage(CUizPenguin);
		
		Label chooseModeLabel= new Label("Choose a Game Mode");
		
		
			//questionIO controls
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
		returnMainButton.setOnAction(e -> stage.setScene(mainQuiz));
		
        ImageView CUizView2 = new ImageView();
		CUizView2.setImage(CUizLogo);
		
        Insets offset = new Insets(10,10,10,10);
		
		//Layouts
		//---------------------------------------------------------------------------
			//mainQuiz layout
		GridPane CenterMainQuizLay = new GridPane();
		CenterMainQuizLay.setPadding(offset);  
		CenterMainQuizLay.setVgap(10);
		CenterMainQuizLay.setHgap(5);
		CenterMainQuizLay.setAlignment(Pos.CENTER);
		CenterMainQuizLay.setConstraints(playButton, 1, 0);
		CenterMainQuizLay.setConstraints(statsButton, 1, 2);
		CenterMainQuizLay.setConstraints(questionIOButton, 1, 3);
		CenterMainQuizLay.setConstraints(logoutButton, 1, 4);
		CenterMainQuizLay.getChildren().addAll(playButton, statsButton, questionIOButton, logoutButton);

		
		GridPane BottomMainQuizLay = new GridPane();
		BottomMainQuizLay.setPadding(offset);  
		BottomMainQuizLay.setVgap(10);
		BottomMainQuizLay.setHgap(5);
		BottomMainQuizLay.setAlignment(Pos.CENTER);
		BottomMainQuizLay.setConstraints(CUizPenguinView, 0, 0);
		BottomMainQuizLay.setConstraints(currentUserLabel, 1, 0);
		BottomMainQuizLay.setConstraints(trademarkLabel, 8, 0);
		BottomMainQuizLay.getChildren().addAll(CUizPenguinView, currentUserLabel,trademarkLabel);

		
		BorderPane MainQuizLay = new BorderPane();
		MainQuizLay.setTop(CUizView);
		MainQuizLay.setBottom(BottomMainQuizLay);
		MainQuizLay.setCenter(CenterMainQuizLay);
		MainQuizLay.getChildren().addAll(playButton, statsButton, questionIOButton, logoutButton, CUizPenguinView, currentUserLabel,trademarkLabel);
		
		mainQuiz = new Scene(MainQuizLay, 500, 500);
		stage.setScene(mainQuiz);
		stage.show();
		
		
		
		
		
		
		
		
		
		
		
	}

}
