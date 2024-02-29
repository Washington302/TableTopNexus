package TabletopNexus.ArsMagica.Models;

public class Magi extends ArsCharacter {

    private String house;
    private String wizardsSigil;
    private String domusMagna;
    private String primus;
    private String parens;
    private String covenantOfApprenticeship;

    

    private Technique creo = new Technique(0, "Creo", 0);
    private Technique intellego = new Technique(0, "Intellego", 0);
    private Technique muto = new Technique(0, "Muto", 0);
    private Technique perdo = new Technique(0, "Perdo", 0);
    private Technique rego = new Technique(0, "Rego", 0);

    private Form animal = new Form(0, "Animal", 0);
    private Form aquam = new Form(0, "Aquam", 0);
    private Form auram = new Form(0, "Auram", 0);
    private Form corpus = new Form(0, "Corpus", 0);
    private Form herbam = new Form(0, "Herbam", 0);
    private Form ignem = new Form(0, "Ignem", 0);
    private Form imaginem = new Form(0, "Imaginem", 0);
    private Form mentem = new Form(0, "Mentem", 0);
    private Form terram = new Form(0, "Terram", 0);
    private Form vis = new Form(0, "Vis", 0);

    // Constructors

    public Magi() {
        // Default constructor
    }

    public Magi(String house, String covenant, String wizardsSigil, String domusMagna, String primus, String parens,
            String covenantOfApprenticeship) {
        this.house = house;
        this.wizardsSigil = wizardsSigil;
        this.domusMagna = domusMagna;
        this.primus = primus;
        this.parens = parens;
        this.covenantOfApprenticeship = covenantOfApprenticeship;
    }

    // Getters and setters (or use public fields if preferred)

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
    public String getWizardsSigil() {
        return wizardsSigil;
    }

    public void setWizardsSigil(String wizardsSigil) {
        this.wizardsSigil = wizardsSigil;
    }

    public String getDomusMagna() {
        return domusMagna;
    }

    public void setDomusMagna(String domusMagna) {
        this.domusMagna = domusMagna;
    }

    public String getPrimus() {
        return primus;
    }

    public void setPrimus(String primus) {
        this.primus = primus;
    }

    public String getParens() {
        return parens;
    }

    public void setParens(String parens) {
        this.parens = parens;
    }

    public String getCovenantOfApprenticeship() {
        return covenantOfApprenticeship;
    }

    public void setCovenantOfApprenticeship(String covenantOfApprenticeship) {
        this.covenantOfApprenticeship = covenantOfApprenticeship;
    }

    public Technique getCreo() {
        return creo;
    }

    public Technique getIntellego() {
        return intellego;
    }

    public Technique getMuto() {
        return muto;
    }

    public Technique getPerdo() {
        return perdo;
    }


    public Technique getRego() {
        return rego;
    }


    public Form getAnimal() {
        return animal;
    }

    public Form getAquam() {
        return aquam;
    }

    public Form getAuram() {
        return auram;
    }

    public Form getCorpus() {
        return corpus;
    }

    public Form getHerbam() {
        return herbam;
    }

    public Form getIgnem() {
        return ignem;
    }

    public Form getImaginem() {
        return imaginem;
    }

    public Form getMentem() {
        return mentem;
    }

    public Form getTerram() {
        return terram;
    }

    public Form getVis() {
        return vis;
    }
}
