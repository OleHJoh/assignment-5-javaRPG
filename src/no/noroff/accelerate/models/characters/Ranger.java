package no.noroff.accelerate.models.characters;

import no.noroff.accelerate.models.items.Weapon;

public class Ranger extends Character {

    public Ranger(String name) {
        super(name);
        level = 1;
        role = "Ranger";
        strength = 1;
        dexterity = 7;
        intelligence = 1;
    }

    public void setWeapon(Weapon weapon){
        if ((weapon.WeaponType == Weapon.WeaponTypes.Bows)){
            if(level != weapon.getEquipLevel())
                System.out.println("Character level is to low for this weapon");
            else
                this.weapon = weapon;
        }
        else
            System.out.println("This weapon cannot be equipped by a ranger");
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
        dexterity += 5;
        intelligence += 1;
    }

    @Override
    public String toString() {
        return "Ranger{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", DPS=" + getCharacterDPS() +
                '}';
    }
}
