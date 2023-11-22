import javafx.application.Application;
import javafx.stage.Stage;

	public class launcher extends Application {

		static String user_ID;
		public static void main(String[] args) {

			//initialize database and javafx
			Questions.main(args);
			launch(args);
		}

		@Override
		public void start(Stage window) {
			//window creation
			window.setTitle("CUiz");
			window.setScene(homeScene.createScene(window));
			window.show();

		}
	}