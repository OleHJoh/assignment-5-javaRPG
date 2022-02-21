package no.noroff.accelerate.models.characters;

//Imports classes
import no.noroff.accelerate.exceptions.custom.InvalidArmorException;
import no.noroff.accelerate.exceptions.custom.InvalidWeaponException;
import no.noroff.accelerate.models.items.Armor;
import no.noroff.accelerate.models.items.Weapon;

//Ranger class extends Character class
public class Ranger extends Character {

    //Ranger constructor
    public Ranger(String name) {
        super(name);
        level = 1;
        role = "Ranger";
        strength = 1;
        dexterity = 7;
        intelligence = 1;
    }

    //Set weapon function
    public boolean setWeapon(Weapon weapon) throws InvalidWeaponException {
        //Checks if the weapon is a valid weapon type for the ranger
        if ((weapon.weaponType == Weapon.WeaponTypes.Bows)){
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
            //Throws InvalidWeaponException if the weapon's weapon type can't be equipped by a ranger
            throw new InvalidWeaponException("This weapon cannot be equipped by a ranger");
    }

    //Set armor function
    public boolean setArmour(Armor armor) throws InvalidArmorException {
        //Checks if the armor is a valid armor type for the ranger
        if ((armor.armorType == Armor.ArmorTypes.Leather) || (armor.armorType == Armor.ArmorTypes.Mail)){
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
            //Throws InvalidArmorException if the armor type can't be equipped by a ranger
            throw new InvalidArmorException("This armor can not be equipped by a ranger");
        return false;
    }

    //Get character dps function
    public double getCharacterDPS(){
        //Runs setTotalAttributes function
        setTotalAttributes();
        //Checks if the character have a weapon equipped
        if (weapon == null){
            return 1 + totalAttributes/100;
        }
        double weaponDPS = weapon.getDPS();
        return weaponDPS * (1 + totalAttributes/100);
    }

    //Set total attributes function
    private void setTotalAttributes(){
        int legDexterity = 0;
        int headDexterity = 0;
        int bodyDexterity = 0;

        //Checks if the character have armor equipped
        if (legs != null)
            legDexterity = legs.getDexterity();
        if (head != null)
            headDexterity = head.getDexterity();
        if (body != null)
            bodyDexterity = body.getDexterity();
        totalAttributes = dexterity + legDexterity + headDexterity + bodyDexterity;
    }

    //Level up function
    @Override
    public void levelUp() {
        level++;
        strength += 1;
        dexterity += 5;
        intelligence += 1;
    }

    //To string function
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
