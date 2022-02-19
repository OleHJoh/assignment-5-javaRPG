package no.noroff.accelerate.models.characters;

import no.noroff.accelerate.interfaces.LevelUp;
import no.noroff.accelerate.models.items.Armor;
import no.noroff.accelerate.models.PrimaryAttribute;
import no.noroff.accelerate.models.items.Weapon;

public abstract class Character extends PrimaryAttribute implements LevelUp {

    protected String name;
    protected int level;
    protected String role;
    protected Armor head;
    protected Armor body;
    protected Armor legs;
    protected Weapon weapon;

    public Character(String name) {
        this.name = name;
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
