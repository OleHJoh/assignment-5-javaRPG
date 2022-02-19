package no.noroff.accelerate.models.items;

import no.noroff.accelerate.models.PrimaryAttribute;

public abstract class Item extends PrimaryAttribute {

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
