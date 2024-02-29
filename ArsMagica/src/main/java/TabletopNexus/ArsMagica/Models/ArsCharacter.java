package TabletopNexus.ArsMagica.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArsCharacter {

    @Id
    UUID id;
    private String birthName;
    private int yearBorn;
    private String gender;
    private String raceNationality;
    private String placeOfOrigin;
    private String religion;
    private String titleProfession;

    // Physical attributes
    private double height;
    private double weight;
    private String hair;
    private String eyes;
    private String handedness;

    // Character details
    private String name;
    private String player;
    private String saga;
    private String setting;
    private int currentYear;

    private int warping;

    // Covenant details
    private String covenant;
    private int age;
    private int size;
    private int confidence;

    // Characteristics
    private int intelligence;
    private int perception;
    private int strength;
    private int stamina;
    private int presence;
    private int communication;
    private int dexterity;
    private int quickness;
    private int fatiguePenalty = 0;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private String equipment;
    private List<Ability> abilities = new ArrayList<>();
    private List<Trait> virtues = new ArrayList<>();
    private List<Trait> flaws = new ArrayList<>();
    private List<PersonalityTrait> personalityTraits = new ArrayList<>();
    private List<Reputation> reputations = new ArrayList<>();
    private List<Wound> wounds = Wound.setDefaultWoundLevel();

    private FatigueLevel currentFatigueLevel = FatigueLevel.Fresh;

    public int calculateFatiguePenalty(FatigueLevel currentFatigueLevel) {
        int penalty = 0;
        switch (currentFatigueLevel) {
            case Fresh:
            case Winded:
                penalty = 0;
                break;
            case Weary:
                penalty = -1;
                break;
            case Tired:
                penalty = -3;
                break;
            case Dazed:
                penalty = -5;
                break;
            case Unconscious:
                penalty = 0;
                break;
        }
        return penalty;
    }


    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRaceNationality() {
        return raceNationality;
    }

    public void setRaceNationality(String raceNationality) {
        this.raceNationality = raceNationality;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getTitleProfession() {
        return titleProfession;
    }

    public void setTitleProfession(String titleProfession) {
        this.titleProfession = titleProfession;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getHandedness() {
        return handedness;
    }

    public void setHandedness(String handedness) {
        this.handedness = handedness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public String getCovenant() {
        return covenant;
    }

    public void setCovenant(String covenant) {
        this.covenant = covenant;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getCommunication() {
        return communication;
    }

    public void setCommunication(int communication) {
        this.communication = communication;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getQuickness() {
        return quickness;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setQuickness(int quickness) {
        this.quickness = quickness;
    }

    public int getFatiguePenalty() {
        return fatiguePenalty;
    }

    public void setFatiguePenalty(int fatiguePenalty) {
        this.fatiguePenalty = fatiguePenalty;
    }

    public FatigueLevel getCurrentFatigueLevel() {
        return currentFatigueLevel;
    }

    public void setCurrentFatigueLevel(FatigueLevel currentFatigueLevel) {
        this.currentFatigueLevel = currentFatigueLevel;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public List<Trait> getVirtues() {
        return virtues;
    }

    public List<Trait> getFlaws() {
        return flaws;
    }

    public List<PersonalityTrait> getPersonalityTraits() {
        return personalityTraits;
    }

    public List<Reputation> getReputations() {
        return reputations;
    }

    public List<Wound> getWounds() {
        return wounds;
    }
}

