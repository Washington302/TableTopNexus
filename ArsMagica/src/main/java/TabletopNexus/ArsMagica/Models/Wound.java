package TabletopNexus.ArsMagica.Models;

import java.util.ArrayList;
import java.util.List;

public class Wound {

    private String type;
    private String range;
    private int maxWounds;
    private int currentWounds;
    private int penalty;

    public Wound(String type, String range, int maxWounds, int penalty) {
        this.type = type;
        this.range = range;
        this.maxWounds = maxWounds;
        this.penalty = penalty;
    }

    public static List<Wound> wounds = new ArrayList<>();

    public static List<Wound> setDefaultWoundLevel() {
        wounds.add(new Wound("Light Wounds", "1-4", 5, -1));
        wounds.add(new Wound("Medium Wounds", "5-7", 5, -3));
        wounds.add(new Wound("Heavy Wounds", "8-10", 5, -5));
        wounds.add(new Wound("Incapacitated", "11-13", 1, 0));
        wounds.add(new Wound("Dead", "14+", 1, 0));

        return wounds;
    }

    // Getters and setters (or use public fields if preferred)

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getMaxWounds() {
        return maxWounds;
    }

    public void setMaxWounds(int maxWounds) {
        this.maxWounds = maxWounds;
    }

    public int getCurrentWounds() {
        return currentWounds;
    }

    public void setCurrentWounds(int currentWounds) {
        this.currentWounds = currentWounds;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}

