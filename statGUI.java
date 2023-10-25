import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application; //Setting up!! Make sure you dont have src folder and that when making package, you click the second option
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
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
import javafx.util.Duration;
import java.util.Objects;
import javafx.scene.Group;


public class statGUI extends Application {
    Scene home; // All scenes


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);  //method in application class that sets up javafx app (setup)
    }
    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Cuiz stats"); //Window title

        //Labels and buttons creation
        //------------------------------------------------------------------------------------//
//        Label Intro = new Label("Welcome to Cuiz stats");

//        Popup existingUserPopup = new Popup() ;
//
//        Label existingUserPLabel = new Label("Something has gone wrong, most likely the username already exists. Try again. ");
//        existingUserPLabel.setStyle("-fx-background-color:#D5D5D5; -fx-font-size:10;");
//        existingUserPopup.getContent().add(existingUserPLabel);
//
//        TextField usernameField = new TextField();
//        usernameField.setPromptText("Username");
//
//        TextField newUsernameField = new TextField();
//        newUsernameField.setPromptText("New username");
//
//        PasswordField passwordField = new PasswordField();
//        passwordField.setPromptText("Password");
//
//        PasswordField newPasswordField = new PasswordField();
//        newPasswordField.setPromptText("New password");
//
//        PasswordField confirmPasswordField = new PasswordField();
//        confirmPasswordField.setPromptText("Confirm password");
//
//        Button confirmButton = new Button("Confirm");
//        confirmButton.setOnAction(e -> {
//            String user = usernameField.getText(); 		//Changes user input into String to check in db
//            String pass = passwordField.getText();
//
//            if (DB_UserInteract.loginCheck(user, pass)== false) { 	//Checks whether user name and password exists
//                colorChange(usernameField, passwordField, confirmPasswordField, newPasswordField);			//If it doesnt exist then go red
//                System.out.print("Username or password does not match. Try again"); //loop continues
//            }else {
//                System.out.print("Successful login");
//                window.setScene(mainQuiz);
//                window.setFullScreen(true);
//            }
//        });
//
//        Button createAccountButton = new Button("Create Account");
//        createAccountButton.setOnAction(e -> {
//            String user = newUsernameField.getText(); 		//Changes user input into String to check in db
//            String pass = newPasswordField.getText();
//            String confirmPass = confirmPasswordField.getText();
//
//            if (Objects.equals(confirmPass, pass)) { //tests whether the passwords  are equal
//                if (DB_UserInteract.insert(user, pass)){ // new user name and password stored if it doesn't exist
//                    System.out.println("New user created successfully");
//                    window.setScene(home);
//                }else {
//                    System.out.println("Something has gone wrong, most likely the username already exists. Try again. "); //user exists and was not stored again
//                    failPopUp(existingUserPopup,window);
//                }
//            }else {
//                System.out.println("Passwords do not match.. ");
//                colorChange(usernameField, passwordField, confirmPasswordField, newPasswordField);
//
//            }
//
//            //window.setScene(Fail);
//        });
//
//        Button loginButton = new Button("Login");
//        loginButton.setOnAction(e -> window.setScene(login));
//
//        Button signUpButton = new Button("Sign Up");
//        signUpButton.setOnAction(e -> window.setScene(signUp));
//
//        Button ReturnloginButton = new Button("Back to Login Page");
//        ReturnloginButton.setOnAction(e -> window.setScene(login));
//
//        Button ReturnsignUpButton = new Button("Back to Sign Up");
//        ReturnsignUpButton.setOnAction(e -> window.setScene(signUp));
//
//        Button ReturnhomeButton = new Button("Return to Home");
//        ReturnhomeButton.setOnAction(e -> window.setScene(home));

        Insets offset = new Insets(10,10,10,10);


        // x axis is date
        // y axis is score
        //
        // line chart
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Score");

        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Score over time");

        history[] player_history = Statistics.get_player_history("sean");

        XYChart.Series series = new XYChart.Series();

        series.setName("Date/Score");
        // line chart data
        for (int i = 0; i < player_history.length; i++) {
            series.getData().add(new XYChart.Data<>(player_history[i].getDate(), player_history[i].getScore_of_round()));
        }

        // line chart data
        lineChart.getData().add(series);

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
//        homeLay.setConstraints(lineChart, 1, 0);
//        homeLay.setConstraints(loginButton, 0, 2);
//        homeLay.setConstraints(signUpButton, 2, 2);
        homeLay.getChildren().addAll(lineChart);

        home = new Scene(homeLay, 440, 250);//Homepage setup

        //Show the GUI
        window.setScene(home);
        window.show();

    }

}