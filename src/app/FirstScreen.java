package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FirstScreen {
    public static int i=0;
    Scene scene;
    Stage stage;
    SecondScreen secondScreen;
    ThirdScreen thirdScreen;
    Athlete athlete = new Athlete(0,80);
    Activity[] myactivities = new Activity[100];
    public FirstScreen(Stage stage) {
        this.stage = stage;
    }
    public void representation(){

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Swimming","Running","KickBoxing","StrengthTraining");
        Label activityLabel = new Label("Activity :");
        Label timeLabel = new Label("Time :");
        TextField timeTextField = new TextField();
        Button record = new Button("Record");
        Button sort = new Button("Sort");
        Button ranking = new Button("Activity Ranking");
        Button calculate = new Button("Calculate");
        Label error = new Label();
        Label result = new Label();
        Label result2 = new Label();
        Label sortLabel = new Label();
        Label rankLabel = new Label();

        GridPane gridPane = new GridPane();
        gridPane.add(activityLabel,0,0);
        gridPane.add(timeLabel,0,1);
        gridPane.add(choiceBox,1,0);
        gridPane.add(timeTextField,1,1);
        gridPane.add(record,0,2);
        gridPane.add(sort,0,3);
        gridPane.add(ranking,0,4);
        gridPane.add(calculate,0,5);
        gridPane.add(error,0,6);
        gridPane.add(result,0,7);
        gridPane.add(result2,0,8);
        gridPane.add(sortLabel,1,6);
        gridPane.add(rankLabel,2,6);

        scene = new Scene(gridPane,600,400);

        record.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String sport=choiceBox.getValue();
                String t = timeTextField.getText();
                int time = Integer.parseInt(t);
                if(t==null)
                    error.setText("Error");
                if(sport.equals("Swimming")&&time>0){
                    athlete.Swimming(time);
                    myactivities[i]=new Activity();
                    myactivities[i].activity="Swimming";
                    myactivities[i].calories=athlete.getCaloriesBurnt();
                    myactivities[i].heartBeats=athlete.getHeartBeats();
                    athlete.setCaloriesBurnt(0);
                    i++;
                    stage.setScene(secondScreen.getScene());
                }
                else if(sport.equals("Running")&&time>0){
                    athlete.Running(time);
                    myactivities[i]=new Activity();
                    myactivities[i].activity="Running";
                    myactivities[i].calories=athlete.getCaloriesBurnt();
                    myactivities[i].heartBeats=athlete.getHeartBeats();
                    athlete.setCaloriesBurnt(0);
                    i++;
                    stage.setScene(secondScreen.getScene());
                }
                else if(sport.equals("KickBoxing")&&time>0){
                    athlete.KickBoxing(time);
                    myactivities[i]=new Activity();
                    myactivities[i].activity="KickBoxing";
                    myactivities[i].calories=athlete.getCaloriesBurnt();
                    myactivities[i].heartBeats=athlete.getHeartBeats();
                    athlete.setCaloriesBurnt(0);
                    i++;
                    stage.setScene(secondScreen.getScene());
                }
                else if(sport.equals("StrengthTraining")&&time>0){
                    athlete.StrengthTraining(time);
                    myactivities[i]=new Activity();
                    myactivities[i].activity="StrengthTraining";
                    myactivities[i].calories=athlete.getCaloriesBurnt();
                    myactivities[i].heartBeats=athlete.getHeartBeats();
                    athlete.setCaloriesBurnt(0);
                    i++;
                    stage.setScene(secondScreen.getScene());
                }
                else
                    error.setText("Time error");
            }
        });
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent2) {
                if(i==1)
                {
                    result.setText("Total Calories Burnt = "+myactivities[0].calories );
                    result2.setText("Total Heart Beats now =" + myactivities[i-1].getHeartBeats() + " Beats/min");
                }
                else {
                    int j;
                    int sum = 0;
                    for (j = 0; j < i; j++)
                        sum += myactivities[j].calories;
                    result.setText("Total Calories Burnt = " + sum);
                    result2.setText("Total Heart Beats now =" + myactivities[i - 1].getHeartBeats() + " Beats/min");
                }
            }
        });
        sort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent3) {
                sortLabel.setText("Sorted Activities :\n--------------------");
                int x;
                int y;
                if(i==1)
                {
                    Label label = new Label();
                    gridPane.add(label,1,7);
                    label.setText(" "+myactivities[0].activity);
                }
                else {
                    for (x = 0; x < i - 1; x++) {
                        for (y = 0; y < i - 1 - x; y++) {
                            if (myactivities[y].calories > myactivities[y + 1].calories) {
                                Activity temp = new Activity();
                                temp = myactivities[y];
                                myactivities[y] = myactivities[y + 1];
                                myactivities[y + 1] = temp;
                            }
                            if (myactivities[y].calories == myactivities[y + 1].calories) {
                                if (myactivities[y].heartBeats > myactivities[y + 1].heartBeats) {
                                    Activity temp = new Activity();
                                    temp = myactivities[y];
                                    myactivities[y] = myactivities[y + 1];
                                    myactivities[y + 1] = temp;
                                }
                            }
                        }
                        for (x = 0; x < i; x++) {
                            Label label = new Label();
                            gridPane.add(label, 1, 7 + x);
                            label.setText(" " + myactivities[i-1-x].activity);
                        }
                    }
                }
            }
        });
        ranking.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent4) {
                rankLabel.setText("Ranked Activities : \n----------------------");
                Activity [] ranking = new Activity[4];
                int x,y;
                for(x=0;x<4;x++)
                    ranking[x]=new Activity();
                ranking[0].activity="Swimming";ranking[0].calories=0;
                ranking[1].activity="Running";ranking[1].calories=0;
                ranking[2].activity="KickBoxing";ranking[2].calories=0;
                ranking[3].activity="StrengthTraining";ranking[3].calories=0;
                for(x=0;x<4;x++)
                {
                    for(y=0;y<i;y++)
                    {
                        if(ranking[x].activity.equals(myactivities[y].activity))
                        {   ranking[x].calories+=myactivities[y].calories;
                            ranking[x].heartBeats+=myactivities[y].heartBeats;
                        }
                    }
                }
                for(x=0;x<3;x++)
                {
                    for(y=0;y<3-x;y++)
                    {
                        if(ranking[y].calories>ranking[y+1].calories)
                        {
                            Activity temp = new Activity();
                            temp = ranking[y];
                            ranking[y] = ranking[y + 1];
                            ranking[y + 1] = temp;
                        }
                        if (ranking[y].calories == ranking[y + 1].calories)
                        {
                            if (ranking[y].heartBeats > ranking[y + 1].heartBeats)
                            {
                                Activity temp = new Activity();
                                temp = ranking[y];
                                ranking[y] = ranking[y + 1];
                                ranking[y + 1] = temp;
                            }
                        }
                    }
                }
                for(x=0;x<4;x++)
                {
                    Label label = new Label();
                    gridPane.add(label,2,7+x);
                    label.setText(". " + (x+1) + ". " + ranking[3-x].activity + "\n           Calories Burnt = "+ ranking[3-x].calories + "\n           Heart Beats inc = " + ranking[x].heartBeats );
                }
            }
        });
    }
    public Scene getScene() {
        return scene;
    }
    public void setSecondScreen(SecondScreen secondScreen) {
        this.secondScreen = secondScreen;
    }
    public void setThirdScreen(ThirdScreen thirdScreen) {
        this.thirdScreen = thirdScreen;
    }
    public Athlete getAthlete() {
        return athlete;
    }
    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }
}
