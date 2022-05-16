package app;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainC extends Application {
    public static void main(String[] args){launch(args);}
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Fitness");

        FirstScreen firstScreen = new FirstScreen(primaryStage);
        SecondScreen secondScreen = new SecondScreen(primaryStage);
        ThirdScreen thirdScreen = new ThirdScreen(primaryStage);

        firstScreen.representation();
        secondScreen.representation();
        thirdScreen.representation();

        firstScreen.setSecondScreen(secondScreen);
        firstScreen.setThirdScreen(thirdScreen);
        secondScreen.setFirstScreen(firstScreen);
        secondScreen.setThirdScreen(thirdScreen);
        thirdScreen.setFirstScreen(firstScreen);
        thirdScreen.setSecondScreen(secondScreen);

        primaryStage.setScene(firstScreen.getScene());
        primaryStage.show();
    }
}
