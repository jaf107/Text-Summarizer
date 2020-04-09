package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {
    private Label myLabel1;
    private Label myLabel2;
    private TextField inputTextField;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Text Summarizer");
        Button button1 = new Button();
        button1.setText("Summarize");

        // INITIALIZATIONS
        myLabel1 = new Label();
        myLabel2 = new Label();
        inputTextField = new TextField();


        //SET Text
        myLabel1.setText("Input Box");
        myLabel2.setText("Output Box");
        inputTextField.setPromptText("Enter the Content");

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String input = inputTextField.getText().trim();

                myLabel1.setText(input);

                //myLabel1.setText("Here You go ");
                myLabel2.setText("THE SUMMARY");
            }
        });

        //ROOT
        FlowPane root = new FlowPane(Orientation.VERTICAL,10,10);
        root.setAlignment(Pos.CENTER);
        //StackPane root = new StackPane();


        // PANE additions
        root.getChildren().add(inputTextField);
        root.getChildren().add(myLabel1);
        root.getChildren().add(button1);
        root.getChildren().add(myLabel2);


        Scene scene = new Scene(root,500,500);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
