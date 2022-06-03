package uqac.dim.wikinba;

import java.util.List;

public class Teams {

    // variables for storing our data.
    private String name, arena, allTimeAssists, allTimeBlocks, allTimePoints, allTimeSteals, allTimeRebounds, city, gLeague, headCoach;
    private int championships, foundation, nbRetiredJerseys;
    private List<String> notablePlayers;
    private List<String> players, numbers, ages, positions;

    public Teams() {
        // empty constructor
        // required for Firebase.
    }

    // Constructor for all variables.


    public Teams(String name, String arena, String allTimeAssists, String allTimeBlocks,
                 String allTimePoints, String allTimeSteals, String allTimeRebounds, String city,
                 String gLeague, String headCoach, int championships, int foundation, int nbRetiredJerseys,
                 List<String> notablePlayers, List<String> players, List<String> numbers,
                 List<String> ages, List<String> positions) {
        this.name = name;
        this.arena = arena;
        this.allTimeAssists = allTimeAssists;
        this.allTimeBlocks = allTimeBlocks;
        this.allTimePoints = allTimePoints;
        this.allTimeSteals = allTimeSteals;
        this.allTimeRebounds = allTimeRebounds;
        this.city = city;
        this.gLeague = gLeague;
        this.headCoach = headCoach;
        this.championships = championships;
        this.foundation = foundation;
        this.nbRetiredJerseys = nbRetiredJerseys;
        this.notablePlayers = notablePlayers;
        this.players = players;
        this.numbers = numbers;
        this.ages = ages;
        this.positions = positions;
    }

    // getter methods for all variables.

    public String getName() {
        return name;
    }

    public String getArena() {
        return arena;
    }

    public String getAllTimeAssists() {
        return allTimeAssists;
    }

    public String getAllTimeBlocks() {
        return allTimeBlocks;
    }

    public String getAllTimePoints() {
        return allTimePoints;
    }

    public String getAllTimeSteals() {
        return allTimeSteals;
    }

    public String getAllTimeRebounds() {
        return allTimeRebounds;
    }

    public String getCity() {
        return city;
    }

    public String getgLeague() {
        return gLeague;
    }

    public String getHeadCoach() {
        return headCoach;
    }

    public int getChampionships() {
        return championships;
    }

    public int getFoundation() {
        return foundation;
    }

    public int getNbRetiredJerseys() {
        return nbRetiredJerseys;
    }

    public List<String> getNotablePlayers() {
        return notablePlayers;
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<String> getNumbers() { return numbers; }

    public List<String> getAges() { return ages; }

    public List<String> getPositions() { return positions; }
}
