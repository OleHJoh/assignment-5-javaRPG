package no.noroff.accelerate.models;

import no.noroff.accelerate.interfaces.LevelUp;

public abstract class Character extends PrimaryAttribute implements LevelUp {

    protected String name;
    protected int level;
    protected String role;

    public Character(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", strength=" + getStrength() +
                ", dexterity=" + getDexterity() +
                ", intelligence=" + getIntelligence() +
                '}';
    }
}
