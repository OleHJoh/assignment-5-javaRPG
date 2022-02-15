package no.noroff.accelerate.models;

public class PrimaryAttribute {

    protected int strength;
    protected int dexterity;
    protected int intelligence;

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    protected void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    protected void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }
}
