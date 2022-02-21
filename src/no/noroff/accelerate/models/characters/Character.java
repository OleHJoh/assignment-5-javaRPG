package no.noroff.accelerate.models.characters;

//Imports classes
import no.noroff.accelerate.interfaces.LevelUp;
import no.noroff.accelerate.models.items.Armor;
import no.noroff.accelerate.models.PrimaryAttribute;
import no.noroff.accelerate.models.items.Weapon;

//Character class extends PrimaryAttributes and implements LevelUp
public abstract class Character extends PrimaryAttribute implements LevelUp {

    //Class defined variables
    protected String name;
    protected int level;
    protected String role;
    protected Armor head;
    protected Armor body;
    protected Armor legs;
    protected Weapon weapon;
    protected int totalAttributes;

    //Character constructor
    public Character(String name) {
        this.name = name;
    }

    //To string function
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
