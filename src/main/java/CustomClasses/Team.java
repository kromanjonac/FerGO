package CustomClasses;


import org.apache.poi.ss.usermodel.Row;

import java.util.*;

public class Team {

    String name;
    List<Rower> rowers;
    Set<Rower> rowerSet;
    String shortName;
    double totalTime = 0.;

    public Team (String name, Rower... rowers) {
        this.name = name;

        this.rowers = new LinkedList<>();

        this.rowers.addAll(Arrays.asList(rowers));
        rowerSet = new HashSet<Rower>(this.rowers);

    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public Team (String name) {
        this.name = name;

        this.rowers = new LinkedList<>();
    }

    public List<Rower> getRowers() {
        return rowers;
    }

    public void setRower (Rower rower) {
        rowers.add(rower);
    }

    public String getName() {
        return name;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
