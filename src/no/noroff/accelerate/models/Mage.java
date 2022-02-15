package no.noroff.accelerate.models;

public class Mage extends Character{

    public Mage(String name, int level) {
        super(name, level);
        this.strength = 1;
        this.dexterity = 1;
        this.intelligence = 8;
    }

    @Override
    public void levelUp() {
        this.level++;
        this.strength += 1;
        this.dexterity += 1;
        this.intelligence += 5;
    }
}
