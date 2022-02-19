package no.noroff.accelerate.models.items;

public class Weapon extends Item{

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

    public enum WeaponTypes{
        Axes,
        Bows,
        Daggers,
        Hammers,
        Staffs,
        Swords,
        Wands
    }

    public WeaponTypes weaponType;
    private int damage;
    private double attackSpeed;

    public Weapon() {
        setWeaponType();
        setDamage();
        setAttackSpeed();
        slot = "Weapon";
        setEquipLevel();
    }

    public Weapon(String weaponType){
        this.weaponType = WeaponTypes.valueOf(weaponType);
        setDamage();
        setAttackSpeed();
        slot = "Weapon";
        setEquipLevel();
        setName();

    }

    public Weapon(int damage, double attackSpeed, int equipLevel, String weaponType){
        this.weaponType = WeaponTypes.valueOf(weaponType);
        setName();
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        slot = "Weapon";
        this.equipLevel = equipLevel;
    }

    public double getDPS(){
        return this.damage * this.attackSpeed;
    }

    private void setWeaponType() {
        weaponType = WeaponTypes.values()[getRandomInteger(7)];
        setName();
    }

    private void setDamage(){
        damage = getRandomInteger(10);
    }

    private void setAttackSpeed(){
        attackSpeed = getRandomInteger(4);
    }

    private void setEquipLevel(){
        equipLevel = (int) Math.round(getDPS()/4);
    }

    private void setName(){
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

    private int getRandomInteger(int max){
        return ((int) (Math.random()*(max - 1))) + 1;
    }

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
