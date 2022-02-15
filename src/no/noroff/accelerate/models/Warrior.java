package no.noroff.accelerate.models;

public class Warrior extends Character{

    public Warrior(String name, int level) {
        super(name, level);
        this.strength = 5;
        this.dexterity = 2;
        this.intelligence = 1;
    }

    @Override
    public void levelUp() {
        this.level++;
        this.strength += 3;
        this.dexterity += 2;
        this.intelligence += 1;
    }
}
