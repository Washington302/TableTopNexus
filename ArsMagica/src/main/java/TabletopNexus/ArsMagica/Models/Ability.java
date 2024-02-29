package TabletopNexus.ArsMagica.Models;

public class Ability {

    private int experiance;
    private String name;
    private String specialty;
    private int score;

    public Ability(String name, String specialty, int score) {
        this.name = name;
        this.specialty = specialty;
        this.score = score;
        experiance = 0;
    }

    // Getters and setters (or use public fields if preferred)


    public int getExperiance() {
        return experiance;
    }

    public void setExperiance(int experiance) {
        this.experiance = experiance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}

