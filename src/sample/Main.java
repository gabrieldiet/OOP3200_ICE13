package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.FileInputStream;

public class Main extends Application
{
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Hello World");

        // Step 1 - create the controls
        Label imageLabel = new Label("We The North!");
        Label goodByeLabel = new Label("Goodbye!");
        Label anotherLabel = new Label("Another Label");
        Label yetAnotherLabel = new Label("Yet Another Label");


        // Step 1.1 - configure your controls
        Font font = Font.font("Consolas", FontWeight.BOLD, 15);
        Button clickMeButton = new Button("Click me!");
        clickMeButton.setFont(font);
        clickMeButton.setStyle("-fx-font-family: Arial;");

        FileInputStream imagePath = new FileInputStream("src/sample/raptors.png");

        // Step 1 for images - load an image
        Image raptors = new Image(imagePath);

        // Step 2 for images - setup an ImageView to "contain it"
        ImageView logoImageView = new ImageView(raptors);
        logoImageView.setFitWidth(400);
        logoImageView.setPreserveRatio(true);

        FileInputStream nbaPath = new FileInputStream("src/sample/nba.png");
        Image nba = new Image(nbaPath);
        ImageView nbaImageView = new ImageView(nba);

        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                imageLabel.setText("NBA");
                logoImageView.setImage(nba);
            }
        }

        clickMeButton.setOnAction(new ButtonClickHandler());

        // Step 1.2 - For button controls, or event-type controls, set the event
        /*clickMeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {

                imageLabel.setText("NBA");
                logoImageView.setImage(nba);
            }
        });*/

        // Step 2 - create the container
        HBox hbox = new HBox(10, imageLabel);
        //hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-alignment: center;");


        HBox hbox2 = new HBox(10, logoImageView);


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(6,8);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        gridPane.add(hbox, 0, 0);
        gridPane.add(hbox2, 0, 1);
        gridPane.add(logoImageView, 0, 2);
        gridPane.add(clickMeButton, 2, 2);

        gridPane.setStyle("-fx-border-color: black; -fx-font-size: 20; -fx-font-family: Consolas;");


        // Step 3 - Add container to scene
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        // Step 4 - Add scene to stage
        primaryStage.setScene(scene);

        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
