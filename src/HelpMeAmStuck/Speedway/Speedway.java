package HelpMeAmStuck.Speedway;

import java.util.ArrayList;
import java.util.List;

public class Speedway {
    String Name;
    int Points;
    List<Object> Players = new ArrayList<Object>();

    String PlayerName;
    int PlayerScore;

    public Speedway(String name, int Points, List<Object> Players){
       this.Name = name;
       this.Points = Points;
    }

    public Speedway(String name, int points){
        this.PlayerName = name;
        this.PlayerScore = points;
    }





}
