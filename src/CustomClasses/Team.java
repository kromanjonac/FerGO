package CustomClasses;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Team {

    String name;
    List<Rower> rowers;

    public Team (String name, Rower... rowers) {
        this.name = name;

        this.rowers = new LinkedList<>();

        this.rowers.addAll(Arrays.asList(rowers));


    }

    public Team (String name) {
        this.name = name;

        this.rowers = new LinkedList<>();
    }


}
