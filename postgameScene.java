import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class postgameScene extends Scene {

        public postgameScene(Stage primaryStage, int score) {
            super(new VBox(), 440, 350);
            //postGame contols
            Label gameOverLabel = new Label("Game Over");

            Label scoreLabel = new Label("Your total score is:");

            Label scoreDisplayLabel = new Label(score + "/18");

            Button viewStatsButton = new Button("View Statistics");
            viewStatsButton.setOnAction(e -> {
                    Stage stage = (Stage) viewStatsButton.getScene().getWindow();
            primaryStage.setScene(statGUI.createScene(stage));
        });

            Button returnToMainButton = new Button("Return to Main Menu");
            returnToMainButton.setOnAction(e -> {
                Stage stage = (Stage) returnToMainButton.getScene().getWindow();
            primaryStage.setScene(mainmenuScene.createScene(stage));
        });

            Insets offset = new Insets(10,10,10,10);

            VBox PostGameLay = new VBox();
            PostGameLay.setAlignment(Pos.CENTER);
            PostGameLay.getChildren().addAll(gameOverLabel, scoreLabel, scoreDisplayLabel, returnToMainButton, viewStatsButton );
            PostGameLay.setSpacing(10);

            // Add the button to the scene's layout
            VBox root = (VBox) this.getRoot();
            root.getChildren().addAll(PostGameLay);
        }

        public static Scene createScene(Stage primarystage, int score) {
            return new postgameScene(primarystage, score);
        }
}
