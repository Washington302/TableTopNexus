package TabletopNexus.Login.Models;

public class Spell {

    private Technique technique;
    private Form form;
    private int level;
    private int bonus;
    private String range;
    private String duration;
    private String target;
    private int experience;
    private int mastery;
    private String notes;

    public Spell(Technique technique, Form form, int level, int bonus, String range, String duration, String target,
            int experience, int mastery, String notes) {
        this.technique = technique;
        this.form = form;
        this.level = level;
        this.bonus = bonus;
        this.range = range;
        this.duration = duration;
        this.target = target;
        this.experience = experience;
        this.mastery = mastery;
        this.notes = notes;
    }

    // Getters and setters (or use public fields if preferred)

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getMastery() {
        return mastery;
    }

    public void setMastery(int mastery) {
        this.mastery = mastery;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
