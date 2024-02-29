package TabletopNexus.ArsMagica.Models;

public class Reputation {

    private String name;
    private String type;
    private int score;

    public Reputation(String name, String type, int score) {
        this.name = name;
        this.type = type;
        this.score = score;
    }

    // Getters and setters (or use public fields if preferred)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

