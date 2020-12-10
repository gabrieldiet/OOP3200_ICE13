package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Main extends Application
{
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        // Step 1 - create the controls
        Label helloLabel = new Label("Hello World");
        Label goodByeLabel = new Label("Goodbye!");

        // Step 1.1 - configure your controls
        Font font = Font.font("Consolas", FontWeight.BOLD, 15);
        Button clickMeButton = new Button("Click me!");
        clickMeButton.setFont(font);

        // Step 1.2 - For button controls, or event-type controls, set the event
        clickMeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                System.out.println("ClickMe Button Clicked");

                helloLabel.setText("Clicked");
            }
        });

        // Step 2 - create the container
        //HBox hbox = new HBox(helloLabel, clickMeButton);
        //VBox vbox = new VBox(helloLabel, clickMeButton);

        GridPane gridpane = new GridPane();

        gridpane.add(helloLabel, 1, 0);
        gridpane.add(goodByeLabel, 1, 1);
        gridpane.add(clickMeButton, 2, 2);


        // Step 3 - Add container to scene
        Scene scene = new Scene(gridpane, WIDTH, HEIGHT);

        // Step 4 - Add scene to stage
        primaryStage.setScene(scene);

        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
