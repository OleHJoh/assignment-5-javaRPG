package no.noroff.accelerate.models.characters;

import no.noroff.accelerate.models.items.Weapon;

public class Mage extends Character {

    public Mage(String name) {
        super(name);
        level = 1;
        role = "Mage";
        strength = 1;
        dexterity = 1;
        intelligence = 8;
    }

    public void setWeapon(Weapon weapon){
        if ((weapon.WeaponType == Weapon.WeaponTypes.Staffs) || (weapon.WeaponType == Weapon.WeaponTypes.Wands)){
            if(level != weapon.getEquipLevel())
                System.out.println("Character level is to low for this weapon");
            else
                this.weapon = weapon;
        }
        else
            System.out.println("This weapon cannot be equipped by a mage");
    }

    private double getCharacterDPS(){
        if (weapon == null){
            return 1 + intelligence/100;
        }
        int weaponDPS = weapon.getDPS();
        return weaponDPS * (1 + intelligence/100);
    }

    @Override
    public void levelUp() {
        level++;
        strength += 1;
        dexterity += 1;
        intelligence += 5;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", DPS=" + getCharacterDPS() +
                '}';
    }
}
