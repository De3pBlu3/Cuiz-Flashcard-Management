
import javafx.application.Application; //Setting up!! Make sure you dont have src folder and that when making package, you click the second option
import javafx.stage.Stage;

	//Scenes = start lowercase
	//Layouts = Start uppercase
	//Controls = start lowercase

	public class launcher extends Application {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			launch(args);  //method in application class that sets up javafx app (setup)
		}

		@Override
		public void start(Stage window) throws Exception {
			window.setTitle("CUiz"); //Window title


			//MainQuiz layout
			window.setScene(homeScene.createScene(window));
			window.show();

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
