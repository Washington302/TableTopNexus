package TabletopNexus.Login.Models;

public class PersonalityTrait {

    private String name;
    private int score;

    public PersonalityTrait(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Getters and setters (or use public fields if preferred)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

