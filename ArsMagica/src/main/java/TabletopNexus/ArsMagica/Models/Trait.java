package TabletopNexus.ArsMagica.Models;

public class Trait {

    private String title;
    private String type;
    private String magnitude;
    private String description;

    public Trait(String title, String type, String magnitude, String description) {
        this.title = title;
        this.type = type;
        this.magnitude = magnitude;
        this.description = description;
    }

    // Getters and setters (or use public fields if preferred)

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


