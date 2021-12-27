package CustomClasses;

import java.util.LinkedList;
import java.util.List;

public class RaceEvent {

    //DATA

    private int numberOfTeams;
    private int numberOfRowers;
    private int numberOfErgs;

    private String name;


    private int length;
    private int splits;


    List<Team> teamList;


    // CONSTRUCTOR

    public RaceEvent (int numberOfTeams, int numberOfRowers, int numberOfErgs,String name, int length, int splits) {
        this.name = name;

        this.numberOfTeams = numberOfTeams;
        this.numberOfRowers = numberOfRowers;
        this.numberOfErgs = numberOfErgs;

        teamList = new LinkedList<>();
    }


    // GETTERS
    public int getNumberOfErgs() {
        return numberOfErgs;
    }

    public int getNumberOfRowers() {
        return numberOfRowers;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public String getName() {
        return name;
    }
}
