package no.noroff.accelerate.models;

public abstract class Item {

    protected String name;
    protected int equipLevel;
    protected String slot;

    public String getName() {
        return name;
    }

    public int getEquipLevel() {
        return equipLevel;
    }

    public String getSlot() {
        return slot;
    }
}
