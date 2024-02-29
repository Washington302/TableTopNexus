package TabletopNexus.Login.Models;

public class MagicalArts {

    private int exp;
    private String name;
    private int score;

    public MagicalArts(int exp, String name, int score) {
        this.exp = exp;
        this.name = name;
        this.score = score;
    }

    // Getters and setters (or use public fields if preferred)

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

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

