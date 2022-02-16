package no.noroff.accelerate.models;

public class Warrior extends Character{

    public Warrior(String name, int level) {
        super(name, level);
        role = "Warrior";
        strength = 5;
        dexterity = 2;
        intelligence = 1;
    }

    public void setWeapon(Weapon weapon){
        if ((weapon.WeaponType == Weapon.WeaponTypes.Axes) || (weapon.WeaponType == Weapon.WeaponTypes.Hammers) || (weapon.WeaponType == Weapon.WeaponTypes.Swords)){
            this.weapon = weapon;
        }
        else
            System.out.println("This weapon cannot be equipped by a warrior");
    }

    private double getCharacterDPS(){
        if (weapon == null){
            return 1 + strength/100;
        }
        int weaponDPS = weapon.getDPS();
        return weaponDPS * (1 + strength/100);
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
