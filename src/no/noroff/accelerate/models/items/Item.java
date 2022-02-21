package no.noroff.accelerate.models.items;

//Imports class
import no.noroff.accelerate.models.PrimaryAttribute;

//Item class extends PrimaryAttribute
public abstract class Item extends PrimaryAttribute {

    //Class defined values
    protected String name;
    protected int equipLevel;
    protected String slot;

    //Get name function
    public String getName() {
        return name;
    }

    //Get equip level function
    public int getEquipLevel() {
        return equipLevel;
    }

    //Get gear slot function
    public String getSlot() {
        return slot;
    }
}
