package no.noroff.accelerate.models.characters;

//Imports classes
import no.noroff.accelerate.exceptions.custom.InvalidArmorException;
import no.noroff.accelerate.exceptions.custom.InvalidWeaponException;
import no.noroff.accelerate.models.items.Armor;
import no.noroff.accelerate.models.items.Weapon;

//Mage class extends Character class
public class Mage extends Character {

    //Mage constructor
    public Mage(String name) {
        super(name);
        level = 1;
        role = "Mage";
        strength = 1;
        dexterity = 1;
        intelligence = 8;
    }

    //Set weapon function
    public boolean setWeapon(Weapon weapon) throws InvalidWeaponException {
        //Checks if the weapon is a valid weapon type for the mage
        if ((weapon.weaponType == Weapon.WeaponTypes.Staffs) || (weapon.weaponType == Weapon.WeaponTypes.Wands)){
            //Checks if the character level is high enough to equip the weapon
            if(level != weapon.getEquipLevel())
                //Throws InvalidWeaponException if the character's level ain't high enough
                throw new InvalidWeaponException("Character level is to low for this weapon");
            else {
                //Equips the weapon
                this.weapon = weapon;
                return true;
            }
        }
        else
            //Throws InvalidWeaponException if the weapon's weapon type can't be equipped by a mage
            throw new InvalidWeaponException("This weapon cannot be equipped by a mage");
    }

    //Set armor function
    public boolean setArmour(Armor armor) throws InvalidArmorException {
        //Checks if the armor is a valid armor type for the mage
        if ((armor.armorType == Armor.ArmorTypes.Cloth)){
            //Checks if character level is high enough to equip the armor
            if (level < armor.getEquipLevel())
                //Throws InvalidArmorException if character's level is too low
                throw new InvalidArmorException("Character level is to low for this armor");
            else {
                //Checks what gear slot the armor is, and equips the armor in that slot
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
            //Throws InvalidArmorException if the armor type can't be equipped by a mage
            throw new InvalidArmorException("This armor can not be equipped by a mage");
        return false;
    }

    //Get character dps function
    public double getCharacterDPS(){
        //Runs setTotalAttributes function
        setTotalAttributes();
        //Checks if the character have a weapon equipped
        if (weapon == null){
            return 1 + intelligence/100;
        }
        double weaponDPS = weapon.getDPS();
        return weaponDPS * (1 + intelligence/100);
    }

    //Set total attributes function
    private void setTotalAttributes(){
        int legIntelligence = 0;
        int headIntelligence = 0;
        int bodyIntelligence = 0;

        //Checks if the character have armor equipped
        if (legs != null)
            legIntelligence = legs.getIntelligence();
        if (head != null)
            headIntelligence = head.getIntelligence();
        if (body != null)
            bodyIntelligence = body.getIntelligence();
        totalAttributes = dexterity + legIntelligence + headIntelligence + bodyIntelligence;
    }

    //Level up function
    @Override
    public void levelUp() {
        level++;
        strength += 1;
        dexterity += 1;
        intelligence += 5;
    }

    //To string function
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
