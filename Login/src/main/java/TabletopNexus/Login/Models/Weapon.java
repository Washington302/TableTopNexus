package TabletopNexus.Login.Models;

public class Weapon {

    private String weaponName;
    private int weapModifier;
    private int qikModifier;
    private int dexModifier;
    private int abilityModifier;
    private int strModifier;
    private int encumbrance;
    private int load;
    private String range;

    private int initiative = getInitiative();
    private int attack = getAttack();

    private  int defense = getDefense();
    private int damage = getDamage();


    public Weapon(String weaponName, int weapModifier, int qikModifier, int dexModifier, int abilityModifier, int strModifier, int encumbrance, int load, String range) {
        this.weaponName = weaponName;
        this.weapModifier = weapModifier;
        this.qikModifier = qikModifier;
        this.dexModifier = dexModifier;
        this.abilityModifier = abilityModifier;
        this.strModifier = strModifier;
        this.encumbrance = encumbrance;
        this.load = load;
        this.range = range;
    }

    // Getters and setters (or use public fields if preferred)

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeapModifier() {
        return weapModifier;
    }

    public void setWeapModifier(int weapModifier) {
        this.weapModifier = weapModifier;
    }

    public int getQikModifier() {
        return qikModifier;
    }

    public void setQikModifier(int qikModifier) {
        this.qikModifier = qikModifier;
    }

    public int getDexModifier() {
        return dexModifier;
    }

    public void setDexModifier(int dexModifier) {
        this.dexModifier = dexModifier;
    }

    public int getAbilityModifier() {
        return abilityModifier;
    }

    public void setAbilityModifier(int abilityModifier) {
        this.abilityModifier = abilityModifier;
    }

    public int getStrModifier() {
        return strModifier;
    }

    public void setStrModifier(int strModifier) {
        this.strModifier = strModifier;
    }

    public int getEncumbrance() {
        return encumbrance;
    }

    public void setEncumbrance(int encumbrance) {
        this.encumbrance = encumbrance;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getInitiative() {
        return qikModifier + weapModifier - encumbrance;
    }

    public int getAttack() {
        return dexModifier + abilityModifier + weapModifier;
    }

    public int getDefense() {
        return qikModifier + abilityModifier + weapModifier;
    }

    public int getDamage() {
        return strModifier + weapModifier;
    }
}
