package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ThirdScreen {
    Scene scene;
    Stage stage;
    FirstScreen firstScreen;
    SecondScreen secondScreen;

    public ThirdScreen(Stage stage) {
        this.stage = stage;
    }
    public void representation(){

        Button adder = new Button("Return to first page");
        Label done = new Label("Thanks for using");
        
        GridPane gridPane = new GridPane();

        gridPane.add(adder,0,0);
        gridPane.add(done,1,1);

        scene = new Scene(gridPane,600,400);

        adder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(firstScreen.getScene());
            }
        });
    }

    public Scene getScene() {
        return scene;
    }
    public void setFirstScreen(FirstScreen firstScreen) {
        this.firstScreen = firstScreen;
    }
    public void setSecondScreen(SecondScreen secondScreen) {
        this.secondScreen = secondScreen;
    }
}
