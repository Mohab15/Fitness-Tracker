package app;

public class Athlete {
     int caloriesBurnt;
     double heartBeats;
    public Athlete(int caloriesBurnt, double heartBeats) {
        this.caloriesBurnt = caloriesBurnt;
        this.heartBeats = heartBeats;
    }
    public int getCaloriesBurnt() {
        return caloriesBurnt;
    }
    public void setCaloriesBurnt(int caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }
    public double getHeartBeats() {
        return heartBeats;
    }
    public void setHeartBeats(double heartBeats) {
        this.heartBeats = heartBeats;
    }
    public void Swimming(int time){
        caloriesBurnt += 4*time;
        heartBeats += 0.002*heartBeats*time;
    }
    public void Running(int time){
        caloriesBurnt += 5*time;
        heartBeats += 0.003*heartBeats*time;
    }
    public void KickBoxing(int time){
        caloriesBurnt += 3*time;
        heartBeats += 0.005*heartBeats*time;
    }
    public void StrengthTraining(int time){
        caloriesBurnt += 5*time;
        heartBeats += 0.006*heartBeats*time;
    }
}

