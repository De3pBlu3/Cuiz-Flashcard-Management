
import javafx.application.Application; //Setting up!! Make sure you dont have src folder and that when making package, you click the second option
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.stage.Popup;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.StackPane;
	import javafx.scene.layout.VBox;
	import javafx.stage.Stage;
	import javafx.scene.control.Label;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos; 
	import javafx.scene.control.TextField;
	import javafx.scene.control.PasswordField;

import java.util.Objects;

import javafx.animation.KeyFrame;
	import javafx.animation.Timeline;
	import javafx.scene.paint.Color;
	import javafx.util.Duration;

	//Scenes = start lowercase
	//Layouts = Start uppercase
	//Controls = start lowercase
	
	
	public class LogonGui extends Application {
		Scene home, login, signUp, mainQuiz, Fail; // All scenes
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			        launch(args);  //method in application class that sets up javafx app (setup)
			    }
			    @Override
		public void start(Stage window) throws Exception {
			        window.setTitle("The Quiz Logon"); //Window title
			       
			    //Labels and buttons creation  
	//------------------------------------------------------------------------------------//	        
			        Label Intro = new Label("Welcome to the quiz! Please Login or Sign up");
			        
			        Popup existingUserPopup = new Popup() ;
						
			        Label existingUserPLabel = new Label("Something has gone wrong, most likely the username already exists. Try again. ");
			        	existingUserPLabel.setStyle("-fx-background-color:#D5D5D5; -fx-font-size:10;");
			        	existingUserPopup.getContent().add(existingUserPLabel);
			        
			        TextField usernameField = new TextField();
			        usernameField.setPromptText("Username");
			        
			        TextField newUsernameField = new TextField();
			        newUsernameField.setPromptText("New username");
			        
			        PasswordField passwordField = new PasswordField();
			        passwordField.setPromptText("Password");
			        
			        PasswordField newPasswordField = new PasswordField();
			        newPasswordField.setPromptText("New password");
			        
			        PasswordField confirmPasswordField = new PasswordField();
			        confirmPasswordField.setPromptText("Confirm password");
			        
			        Button confirmButton = new Button("Confirm");
			        confirmButton.setOnAction(e -> {
			        	String user = usernameField.getText(); 		//Changes user input into String to check in db
			        	String pass = passwordField.getText();
		    		
			        	if (DB_UserInteract.loginCheck(user, pass)== false) { 	//Checks whether user name and password exists
			        		colorChange(usernameField, passwordField, confirmPasswordField, newPasswordField);			//If it doesnt exist then go red
			        		System.out.print("Username or password does not match. Try again"); //loop continues
			        	}else {
			        		System.out.print("Successful login");
			        		window.setScene(mainQuiz);
			        		window.setFullScreen(true);
			        	}
			        });
			        
			        Button createAccountButton = new Button("Create Account");
			        createAccountButton.setOnAction(e -> {
			        	String user = newUsernameField.getText(); 		//Changes user input into String to check in db
			        	String pass = newPasswordField.getText();
			        	String confirmPass = confirmPasswordField.getText();
			        	
			        	if (Objects.equals(confirmPass, pass)) { //tests whether the passwords  are equal
							if (DB_UserInteract.insert(user, pass)){ // new user name and password stored if it doesn't exist
							System.out.println("New user created successfully");
							window.setScene(home);
							}else {
								System.out.println("Something has gone wrong, most likely the username already exists. Try again. "); //user exists and was not stored again
								failPopUp(existingUserPopup,window);
							}
						}else {
							System.out.println("Passwords do not match.. ");
							colorChange(usernameField, passwordField, confirmPasswordField, newPasswordField);
							
							}
			        	
			        	//window.setScene(Fail);
			        });
			       
			        Button loginButton = new Button("Login");
			        loginButton.setOnAction(e -> window.setScene(login));
			        
			        Button signUpButton = new Button("Sign Up");
			        signUpButton.setOnAction(e -> window.setScene(signUp));
			        
			        Button ReturnloginButton = new Button("Back to Login Page");
			        ReturnloginButton.setOnAction(e -> window.setScene(login));
			        
			        Button ReturnsignUpButton = new Button("Back to Sign Up");
			        ReturnsignUpButton.setOnAction(e -> window.setScene(signUp));
			        
			        Button ReturnhomeButton = new Button("Return to Home");
			        ReturnhomeButton.setOnAction(e -> window.setScene(home));
			        
			        Insets offset = new Insets(10,10,10,10);

			        //You cannot use the same button on different scenes//
	//---------------------------------------------------------------------------------------------------------------------//	        
			        
			     //home layout
			        GridPane homeLay = new GridPane();
			        //General layout settings
			        homeLay.setPadding(offset);  
			        homeLay.setVgap(10);
			        homeLay.setHgap(5);
			        homeLay.setAlignment(Pos.CENTER);
			        //Children addition and positioning
			        homeLay.setConstraints(Intro, 1, 0);
			        homeLay.setConstraints(loginButton, 0, 2);
			        homeLay.setConstraints(signUpButton, 2, 2);
			        homeLay.getChildren().addAll(Intro, loginButton, signUpButton);
			      
			        home = new Scene(homeLay, 440, 250);//Homepage setup
			     
			     //Login layout
			        GridPane LoginLay = new GridPane();
			        //General layout settings
			        LoginLay.setPadding(offset);  
			        LoginLay.setVgap(10);
			        LoginLay.setHgap(5);
			        LoginLay.setAlignment(Pos.CENTER);
			        //Children addition and positioning
			        LoginLay.setConstraints(ReturnsignUpButton, 2 , 4);
			        LoginLay.setConstraints(usernameField, 2, 1);
			        LoginLay.setConstraints(passwordField, 2, 2);
			        LoginLay.setConstraints(confirmButton, 2, 3);
			        LoginLay.getChildren().addAll(ReturnsignUpButton, usernameField, passwordField, confirmButton);
			        
			        login = new Scene(LoginLay, 450, 250);
			   
			      //SignUp layout
			        GridPane SignUpLay = new GridPane();
			        //General layout settings
			        SignUpLay.setPadding(offset);  
			        SignUpLay.setVgap(10);
			        SignUpLay.setHgap(5);
			        SignUpLay.setAlignment(Pos.CENTER);
			        //Children addition and positioning
			        SignUpLay.setConstraints(ReturnloginButton, 3, 5);
			        SignUpLay.setConstraints(createAccountButton, 3, 4);
			        SignUpLay.setConstraints(newUsernameField, 3, 1);
			        SignUpLay.setConstraints(newPasswordField, 3, 2);
			        SignUpLay.setConstraints(confirmPasswordField, 3, 3);
			        SignUpLay.getChildren().addAll(ReturnloginButton, createAccountButton, newUsernameField, newPasswordField, confirmPasswordField);
			        
			        signUp = new Scene(SignUpLay, 450, 250);
			        
			     //MainQuiz layout
			        StackPane MainQuizLay = new StackPane();
			        MainQuizLay.setAlignment(Pos.CENTER);
			        MainQuizLay.getChildren().add(ReturnhomeButton);
			      
			        mainQuiz = new Scene(MainQuizLay, 1920, 1080);
			        
	//-------------------------------------------------------------------------------------------------------------------------//	        
  
			        
			    //Show the GUI
			        window.setScene(home);
			        window.show();
			       
			    }
		public static void colorChange(TextField usernameField, PasswordField passwordField, TextField confirmPasswordField, PasswordField newPasswordField) {
			Timeline colorChangeTimeline = new Timeline( //To store keyframes
		            new KeyFrame(Duration.seconds(0), e -> { // Change the text field's background color for 2 seconds
		                usernameField.setStyle("-fx-background-color: red;");
		                passwordField.setStyle("-fx-background-color: red;");
		                newPasswordField.setStyle("-fx-background-color: red;");
		                confirmPasswordField.setStyle("-fx-background-color: red;");
		            }),
		            new KeyFrame(Duration.seconds(1), e -> {// Revert the color after 3 seconds
		                usernameField.setStyle("");
		                passwordField.setStyle("");
		                newPasswordField.setStyle("");
		                confirmPasswordField.setStyle("");
		            }));
		            colorChangeTimeline.setCycleCount(1); //How many times it plays the sequence
		            colorChangeTimeline.playFromStart(); //play
					
		}
		public static void failPopUp(Popup existingUserPopup, Stage window) {	
			Timeline popupTimeline = new Timeline( //To store keyframes
		            new KeyFrame(Duration.seconds(0), e -> { // Change the text field's background color after 2 seconds
		            	existingUserPopup.show(window);
		            }),
		            new KeyFrame(Duration.seconds(3), e -> {// Revert the color after 3 seconds
		            	existingUserPopup.hide();
		            }));
			popupTimeline.setCycleCount(1); //How many times it plays the sequence
			popupTimeline.playFromStart();
		}

}	
	
	
	
//	Ellice 0-216
/*	 
  	- Stage = entire window
	- Scene = everything inside window
	- Button = an object
	- buttonName.setText("text on button"
	- .setOnAction(this) = envokes handle method
	- StackPane = object, simple layout
	- Scene = object, parameters, first one is layout name and next two is size
	- .setScene(sceneName) = primary stage command
	- .show() = primary stage command, displays scene
	- implements EventHandler<ActionEvent> = tells it what to do when an event happens
	- event.getSource() = checks what the source of the event was 
	OR 
	- .setOnAction(e -> THING TO DO) = e replaces the handle method, lambda
	- Label = text
	- .setStyle 
*/
