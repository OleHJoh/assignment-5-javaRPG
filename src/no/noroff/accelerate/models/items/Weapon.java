package no.noroff.accelerate.models.items;

//Weapon class extends Item
public class Weapon extends Item{

    //Enumerations with weapon names
    enum AxeNames{
        Orenmir,
        Windreaper,
        Seism,
        Prideful_Axe,
        Haunted_Chopper,
        Possessed_Mithril_Broadaxe,
        Undead_Bronzed_Reaver
    }

    enum BowNames{
        Arrowsong,
        Trophy_Mark,
        Death_Whisperer,
        Driftwood_Straight_Bow,
        Bronzed_Recurve,
        Enchanted_Ebon_Crossbow,
        Hardwood_Bow
    }

    enum DaggerNames{
        Despair,
        Chaos,
        Nightbite,
        Bloodcursed_Scalpel,
        Judgement_Carver,
        Fireguard_Iron_Shanker,
        Zealous_Silver_Knife
    }

    enum HammerNames{
        Tenderiser,
        Blazeguard,
        Arondite,
        Dire_Greathammer,
        Smooth_Mace,
        Bloodlord_Iron_Battlehammer,
        Furious_Mithril_Hammer
    }

    enum StaffNames{
        Omen,
        Trinity,
        Branch_of_Wisdom,
        Rune_Forged_Branch,
        Crying_Staff,
        Greedy_Devilwood_Energy_Staff,
        Tyrannical_Devilwood_Cane
    }

    enum SwordNames{
        Worldslayer,
        Lightning,
        Final_Achievement,
        Rusty_Etcher,
        Soulless_Deflector,
        Thunderstorm_Obsidian_Katana,
        Haunted_Gold_Katana
    }

    enum WandNames{
        Lifebinder,
        Persuasion,
        Earthshadow,
        Crescent,
        Thunderguard_Paragon,
        Cataclysm_Seal,
        Spectral_Knapsack
    }

    //Enumeration with weapon types
    public enum WeaponTypes{
        Axes,
        Bows,
        Daggers,
        Hammers,
        Staffs,
        Swords,
        Wands
    }

    //Class defined variable
    public WeaponTypes weaponType;
    private int damage;
    private double attackSpeed;

    //Weapon constructors
    //Makes a random weapon
    public Weapon() {
        setWeaponType();
        setDamage();
        setAttackSpeed();
        slot = "Weapon";
        setEquipLevel();
    }

    //Makes a random weapon with defined weapon type
    public Weapon(String weaponType){
        this.weaponType = WeaponTypes.valueOf(weaponType);
        setDamage();
        setAttackSpeed();
        slot = "Weapon";
        setEquipLevel();
        setName();

    }

    //Makes a weapon with everything defined
    public Weapon(int damage, double attackSpeed, int equipLevel, String weaponType){
        this.weaponType = WeaponTypes.valueOf(weaponType);
        setName();
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        slot = "Weapon";
        this.equipLevel = equipLevel;
    }

    //Get dps function
    public double getDPS(){
        //Returns damage multiplied by attack speed
        return this.damage * this.attackSpeed;
    }

    //Set weapon type function
    private void setWeaponType() {
        //Randomly picks one of the seven weapon types
        weaponType = WeaponTypes.values()[getRandomInteger(7)];
        //Runs set name
        setName();
    }

    //Set damage function
    private void setDamage(){
        //Sets damage to a random number between 1 and 10
        damage = getRandomInteger(10);
    }

    //Set attack speed function
    private void setAttackSpeed(){
        //Sets attack speed to a random number between 1 and 4
        attackSpeed = getRandomDouble(4);
    }

    //Set equip level function
    private void setEquipLevel(){
        //Gets the weapon dps and divide it by 4
        equipLevel = (int) Math.round(getDPS()/4);
    }

    //Set name function
    private void setName(){
        //Checks what weapon type the weapon is, and picks one of the seven corresponding names to that type
        if (this.weaponType == WeaponTypes.Axes){
            name = String.valueOf(AxeNames.values()[getRandomInteger(7)]);
        }
        else if (this.weaponType == WeaponTypes.Bows){
            name = String.valueOf(BowNames.values()[getRandomInteger(7)]);
        }
        else if (this.weaponType == WeaponTypes.Daggers){
            name = String.valueOf(DaggerNames.values()[getRandomInteger(7)]);
        }
        else if (this.weaponType == WeaponTypes.Hammers){
            name = String.valueOf(HammerNames.values()[getRandomInteger(7)]);
        }
        else if (this.weaponType == WeaponTypes.Staffs){
            name = String.valueOf(StaffNames.values()[getRandomInteger(7)]);
        }
        else if (this.weaponType == WeaponTypes.Swords){
            name = String.valueOf(SwordNames.values()[getRandomInteger(7)]);
        }
        else if (this.weaponType == WeaponTypes.Wands){
            name = String.valueOf(WandNames.values()[getRandomInteger(7)]);
        }
    }

    //Get random integer value
    private int getRandomInteger(int max){
        //Returns a random integer between 1 and the value received
        return ((int) (Math.random()*(max - 1))) + 1;
    }

    //Get random double value
    private double getRandomDouble(int max){
        //Gets a random value between 1 and the value received
        double number = (Math.random() * (max -1 )) +1;
        System.out.println("Double before converted: " + number);
        //Returns the double with 1 decimal
        return (Math.round(number*10.0)/10.0);
    }

    //To string function
    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", equipLevel=" + equipLevel +
                ", slot='" + slot + '\'' +
                ", WeaponType=" + weaponType +
                ", Damage=" + damage +
                ", AttackSpeed=" + attackSpeed +
                '}';
    }
}
