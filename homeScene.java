import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class homeScene extends Scene{
    Insets offset = new Insets(10,10,10,10);
    Label Intro = new Label("Welcome to the quiz! Please Login or Sign up");
    static Button loginButton = new Button("Login");
    Button signUpButton = new Button("Sign Up");

    public homeScene(Stage primaryStage) {
        super(new VBox(), 440, 250);

        //home layout
        GridPane homeLay = new GridPane();

        signUpButton.setOnAction(e -> {
            Stage stage = (Stage) signUpButton.getScene().getWindow();
            primaryStage.setScene(signupScene.createScene(stage));

        });

        loginButton.setOnAction(e -> {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            primaryStage.setScene(loginScene.createScene(stage));
        });

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

        // Add the button to the scene's layout
        VBox root = (VBox) this.getRoot();
        root.getChildren().addAll(homeLay);

    }
    public static homeScene createScene(Stage primaryStage) {
        return new homeScene(primaryStage);
    }


}
