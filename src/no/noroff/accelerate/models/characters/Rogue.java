package no.noroff.accelerate.models.characters;

import no.noroff.accelerate.models.items.Weapon;

public class Rogue extends Character {

    public Rogue(String name) {
        super(name);
        level = 1;
        role = "Rogue";
        strength = 2;
        dexterity = 6;
        intelligence = 1;
    }

    public void setWeapon(Weapon weapon){
        if ((weapon.WeaponType == Weapon.WeaponTypes.Daggers) || (weapon.WeaponType == Weapon.WeaponTypes.Swords)){
            if(level != weapon.getEquipLevel())
                System.out.println("Character level is to low for this weapon");
            else
                this.weapon = weapon;
        }
        else
            System.out.println("This weapon cannot be equipped by a rogue");
    }

    private double getCharacterDPS(){
        if (weapon == null){
            return 1 + dexterity/100;
        }
        int weaponDPS = weapon.getDPS();
        return weaponDPS * (1 + dexterity/100);
    }

    @Override
    public void levelUp() {
        level++;
        strength += 1;
        dexterity += 4;
        intelligence += 1;
    }

    @Override
    public String toString() {
        return "Rogue{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", DPS=" + getCharacterDPS() +
                '}';
    }
}
