package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SecondScreen {
    Scene scene;
    Stage stage;
    FirstScreen firstScreen;
    ThirdScreen thirdScreen;
    public SecondScreen(Stage stage) {
        this.stage = stage;
    }
    public void representation(){
        Label result = new Label("Activity Recorded Successfully !");
        Button done = new Button("Done");
        Button adder = new Button("Add another activity");

        GridPane gridPane = new GridPane();
        gridPane.add(result,0,0);
        gridPane.add(done,0,1);
        gridPane.add(adder,0,2);

        scene = new Scene(gridPane,600,400);

        adder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(firstScreen.getScene());
            }
        });
        done.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(thirdScreen.getScene());
            }
        });
    }
    public Scene getScene() {
        return scene;
    }
    public void setFirstScreen(FirstScreen firstScreen) {
        this.firstScreen = firstScreen;
    }
    public void setThirdScreen(ThirdScreen thirdScreen) {
        this.thirdScreen = thirdScreen;
    }
}
