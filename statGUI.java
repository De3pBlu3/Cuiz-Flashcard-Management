import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application; //Setting up!! Make sure you dont have src folder and that when making package, you click the second option
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.geometry.Orientation;
import javafx.stage.Popup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.util.Duration;
import java.util.Objects;
import javafx.scene.Group;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Label;

public class statGUI extends Application {
    Scene linePage; // All scenes
    Scene leaderboard;



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);  //method in application class that sets up javafx app (setup)
    }
    public static LineChart<String, Number> create_line_chart_player_history(String user_id) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Score");
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Score over time (Player)");
        history[] player_history = Statistics.get_player_history(user_id);
        XYChart.Series series = new XYChart.Series();
        series.setName("Date/Score");
        // line chart data
        for (int i = 0; i < player_history.length; i++) {
            series.getData().add(new XYChart.Data<>(player_history[i].getDate(), player_history[i].getScore_of_round()));
        }
        // line chart data
        lineChart.getData().add(series);
        return(lineChart);
    }

    public static LineChart<String, Number> create_line_chart_population_history() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Score");
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Score over time (population history)");
        history[] pop_history = Statistics.get_all_history();
        XYChart.Series series = new XYChart.Series();
        series.setName("Date/Score");
        // line chart data
        for (int i = 0; i < pop_history.length; i++) {
            series.getData().add(new XYChart.Data<>(pop_history[i].getDate(), pop_history[i].getScore_of_round()));
        }
        // line chart data
        lineChart.getData().add(series);
        return(lineChart);
    }

    @Override
    public void start(Stage window) throws Exception {
        String user_id = "sean";
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

        // create vertical seperator
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);

        Insets offset = new Insets(10,10,10,10);


        // x axis is date
        // y axis is score
        //
        // line chart



        GridPane chatLayout = getChartGrid(offset, separator, user_id);

        // create table view
        TableView table = new TableView();
        // make table not editable
        table.setEditable(false);

        // set table width
        table.setPrefWidth(300);

        // make sure table has 2 columns
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn userNameCol = new TableColumn("Username");
        TableColumn scoreCol = new TableColumn("Score");
        table.getColumns().addAll(userNameCol, scoreCol);

        // create table data
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("user_ID"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score_of_round"));
        history[] all_history = Statistics.get_all_history();
        for (int i = 0; i < all_history.length; i++) {
            table.getItems().add(all_history[i]);
        }

        GridPane leaderboardLay = new GridPane();
        // add table to the layout
        leaderboardLay.setConstraints(table, 0, 0);
        leaderboardLay.getChildren().add(table);

        // when user clicks on a row, show the line chart for that user on the right
        table.setOnMouseClicked(e -> {
            // remove the line chart from the previous layout if it exists
            leaderboardLay.getChildren().removeIf(node -> node instanceof LineChart);
            // get the selected row
            System.out.println("clicked on " + table.getSelectionModel().getSelectedItem());
            // get the selected row c
            history selectedRow = (history) table.getSelectionModel().getSelectedItem();
            // get the user id of the selected row
            String row_user_id = selectedRow.getUser_ID();
            // create a line chart for that user
            LineChart<String, Number> lineChart = create_line_chart_player_history(row_user_id);
            // add the line chart to the layout
            leaderboardLay.setConstraints(lineChart, 1, 0);
            leaderboardLay.getChildren().add(lineChart);

        });



        // create stats table, will contain stats for the user (mean, median, standard deviation)
        TableView statsTable = new TableView();
        // make table not editable
        statsTable.setEditable(false);

        // set table width
        statsTable.setPrefWidth(300);

        // make sure table has 2 columns
        statsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn statNameCol = new TableColumn("Stat");
        TableColumn statValueCol = new TableColumn("Value");
        statsTable.getColumns().addAll(statNameCol, statValueCol);

        // create table data
        statNameCol.setCellValueFactory(new PropertyValueFactory<>("type_of_stat"));
        statValueCol.setCellValueFactory(new PropertyValueFactory<>("value"));


        stat[] player_stat_data = Statistics.createPlayerStats(user_id);

        for (int i = 0; i < player_stat_data.length; i++) {
            statsTable.getItems().add(player_stat_data[i]);
        }

        // add table to the layout
        GridPane personalStatLayout = new GridPane();
        // add table to the layout
        personalStatLayout.setConstraints(statsTable, 0, 0);
        personalStatLayout.getChildren().add(statsTable);

        //---------------------------------------------------------------------------------------------------------------------//


        // create a tabpane
        TabPane tabpane = new TabPane();

        // create Tab
        Tab tab = new Tab("Leaderboard");
        // add label to the tab
        tab.setContent(leaderboardLay);
        tab.closableProperty().setValue(false);
        // add tab
        tabpane.getTabs().add(tab);

        // create Tab
        Tab tab2 = new Tab("Your Graphs");
        // add label to the tab
        tab2.setContent(chatLayout);
        tab2.closableProperty().setValue(false);
        // add tab
        tabpane.getTabs().add(tab2);
//
        Tab tab3 = new Tab("Your Stats");
        // add label to the tab
        tab3.setContent(statsTable);
        tab3.closableProperty().setValue(false);
        // add tab
        tabpane.getTabs().add(tab3);
//


        // -----------------------------------------------------------------------------------------------//

        linePage = new Scene(tabpane, 440, 250);//Homepage setup

        //Show the GUI
        window.setScene(linePage);
        window.show();

    }

        private static GridPane getChartGrid(Insets offset, Separator separator, String user_id) {
        LineChart<String, Number> lineChart_player = create_line_chart_player_history(user_id);
        LineChart<String, Number> lineChart_pop = create_line_chart_population_history();
        //You cannot use the same button on different scenes//


        //home layout
        GridPane homeLay = new GridPane();
        //General layout settings
        homeLay.setPadding(offset);
        homeLay.setVgap(10);
        homeLay.setHgap(5);
        homeLay.setAlignment(Pos.CENTER);
        //Children addition and positioning
//        homeLay.setConstraints(lineChart_player, 1, 3);
        homeLay.setConstraints(lineChart_player, 0, 2);
        homeLay.setConstraints(separator, 1, 2);
        homeLay.setConstraints(lineChart_pop, 2, 2);
        homeLay.getChildren().addAll(lineChart_player, separator, lineChart_pop);
        return homeLay;
    }

}