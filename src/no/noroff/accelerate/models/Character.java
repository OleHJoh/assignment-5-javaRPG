package no.noroff.accelerate.models;

public abstract class Character extends PrimaryAttribute {

    private String name;
    private int level;
    private int basePrimaryAttributes;
    private int totalPrimaryAttributes;

    public String getName(){
        return name;
    }

    public int getLevel(){
        return level;
    }

    public int getBasePrimaryAttributes() {
        return basePrimaryAttributes;
    }

    public int getTotalPrimaryAttributes() {
        return totalPrimaryAttributes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setBasePrimaryAttributes(int basePrimaryAttributes) {
        this.basePrimaryAttributes = basePrimaryAttributes;
    }

    public void setTotalPrimaryAttributes(int totalPrimaryAttributes) {
        this.totalPrimaryAttributes = totalPrimaryAttributes;
    }


}
