package no.noroff.accelerate.models.characters;

import no.noroff.accelerate.exceptions.custom.InvalidArmorException;
import no.noroff.accelerate.exceptions.custom.InvalidWeaponException;
import no.noroff.accelerate.models.items.Armor;
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

    public void setWeapon(Weapon weapon) throws InvalidWeaponException {
        if ((weapon.weaponType == Weapon.WeaponTypes.Daggers) || (weapon.weaponType == Weapon.WeaponTypes.Swords)){
            if(level != weapon.getEquipLevel())
                throw new InvalidWeaponException("Character level is to low for this weapon");
            else
                this.weapon = weapon;
        }
        else
            throw new InvalidWeaponException("This weapon cannot be equipped by a rogue");
    }

    public void setArmour(Armor armor) throws InvalidArmorException {
        if ((armor.armorType == Armor.ArmorTypes.Leather) || (armor.armorType == Armor.ArmorTypes.Mail)){
            if (level < armor.getEquipLevel())
                throw new InvalidArmorException("Character level is to low for this armor");
            else {
                if (armor.getSlot() == "Legs")
                    legs = armor;
                else if (armor.getSlot() == "Body")
                    body = armor;
                else if (armor.getSlot() == "Head")
                    head = armor;
            }
        }
        else
            throw new InvalidArmorException("This armor can not be equipped by a rogue");
    }

    public double getCharacterDPS(){
        setTotalAttributes();
        if (weapon == null){
            return 1 + totalAttributes/100;
        }
        double weaponDPS = weapon.getDPS();
        return weaponDPS * (1 + totalAttributes/100);
    }

    private void setTotalAttributes(){
        int legDexterity = 0;
        int headDexterity = 0;
        int bodyDexterity = 0;

        if (legs != null)
            legDexterity = legs.getDexterity();
        if (head != null)
            headDexterity = head.getDexterity();
        if (body != null)
            bodyDexterity = body.getDexterity();
        totalAttributes = dexterity + legDexterity + headDexterity + bodyDexterity;
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
