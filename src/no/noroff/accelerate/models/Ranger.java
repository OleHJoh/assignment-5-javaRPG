package no.noroff.accelerate.models;

public class Ranger extends Character{

    public Ranger(String name, int level) {
        super(name, level);
        role = "Ranger";
        strength = 1;
        dexterity = 7;
        intelligence = 1;
    }

    public void setWeapon(Weapon weapon){
        if ((weapon.WeaponType == Weapon.WeaponTypes.Bows)){
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
