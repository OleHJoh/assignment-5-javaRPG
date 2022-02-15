package no.noroff.accelerate.models;

public class Weapon extends Item{

    enum WeaponTypes{
        Axes,
        Bows,
        Daggers,
        Hammers,
        Staffs,
        Swords,
        Wands
    }

    private String WeaponType;
    private int Damage;
    private int AttackSpeed;

    public int getDPS(){
        return this.Damage * this.AttackSpeed;
    }

}
