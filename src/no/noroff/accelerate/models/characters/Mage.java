package no.noroff.accelerate.models.characters;

import no.noroff.accelerate.exceptions.custom.InvalidArmorException;
import no.noroff.accelerate.exceptions.custom.InvalidWeaponException;
import no.noroff.accelerate.models.items.Armor;
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

    public void setWeapon(Weapon weapon) throws InvalidWeaponException {
        if ((weapon.weaponType == Weapon.WeaponTypes.Staffs) || (weapon.weaponType == Weapon.WeaponTypes.Wands)){
            if(level != weapon.getEquipLevel())
                throw new InvalidWeaponException("Character level is to low for this weapon");
            else
                this.weapon = weapon;
        }
        else
            throw new InvalidWeaponException("This weapon cannot be equipped by a mage");
    }

    public void setArmour(Armor armor) throws InvalidArmorException {
        if ((armor.armorType == Armor.ArmorTypes.Cloth)){
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
            throw new InvalidArmorException("This armor can not be equipped by a mage");
    }

    public double getCharacterDPS(){
        setTotalAttributes();
        if (weapon == null){
            return 1 + intelligence/100;
        }
        double weaponDPS = weapon.getDPS();
        return weaponDPS * (1 + intelligence/100);
    }

    private void setTotalAttributes(){
        int legIntelligence = 0;
        int headIntelligence = 0;
        int bodyIntelligence = 0;

        if (legs != null)
            legIntelligence = legs.getIntelligence();
        if (head != null)
            headIntelligence = head.getIntelligence();
        if (body != null)
            bodyIntelligence = body.getIntelligence();
        totalAttributes = dexterity + legIntelligence + headIntelligence + bodyIntelligence;
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
