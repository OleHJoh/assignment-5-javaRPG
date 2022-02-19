package no.noroff.accelerate.models.characters;

import no.noroff.accelerate.exceptions.custom.InvalidArmorException;
import no.noroff.accelerate.exceptions.custom.InvalidWeaponException;
import no.noroff.accelerate.models.items.Armor;
import no.noroff.accelerate.models.items.Weapon;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        level = 1;
        role = "Warrior";
        strength = 5;
        dexterity = 2;
        intelligence = 1;
    }

    public boolean setWeapon(Weapon weapon) throws InvalidWeaponException {
        if ((weapon.weaponType == Weapon.WeaponTypes.Axes) || (weapon.weaponType == Weapon.WeaponTypes.Hammers) || (weapon.weaponType == Weapon.WeaponTypes.Swords)){
            if(level < weapon.getEquipLevel())
                throw new InvalidWeaponException("Character level is to low for this weapon");
            else
                this.weapon = weapon;
                return true;
        }
        else
            throw new InvalidWeaponException("This weapon cannot be equipped by a warrior");
    }

    public boolean setArmour(Armor armor) throws InvalidArmorException {
        if ((armor.armorType == Armor.ArmorTypes.Plate) || (armor.armorType == Armor.ArmorTypes.Mail)){
            if (level < armor.getEquipLevel())
                throw new InvalidArmorException("Character level is to low for this armor");
            else {
                if (armor.getSlot() == "Legs") {
                    legs = armor;
                    return true;
                }
                else if (armor.getSlot() == "Body") {
                    body = armor;
                    return true;
                }
                else if (armor.getSlot() == "Head") {
                    head = armor;
                    return true;
                }
            }
        }
        else
            throw new InvalidArmorException("This armor cannot be equipped by a warrior");
        return false;
    }

    public double getCharacterDPS(){
        setTotalAttributes();
        if (weapon == null){
            return 1 * (1 + (totalAttributes/100));
        }
        double weaponDPS = weapon.getDPS();
        return weaponDPS * (1 + totalAttributes/100);
    }

    private void setTotalAttributes(){
        int legStrength = 0;
        int headStrength = 0;
        int bodyStrength = 0;

        if (legs != null)
            legStrength = legs.getStrength();
        if (head != null)
            headStrength = head.getStrength();
        if (body != null)
            bodyStrength = body.getStrength();
        totalAttributes = strength + legStrength + headStrength + bodyStrength;
    }

    @Override
    public void levelUp() {
        level++;
        strength += 3;
        dexterity += 2;
        intelligence += 1;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", DPS=" + getCharacterDPS() +
                '}';
    }
}
