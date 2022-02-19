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

    public WeaponTypes WeaponType;
    private int Damage;
    private int AttackSpeed;

    public int getDPS(){
        return this.Damage * this.AttackSpeed;
    }

    public Weapon() {
        setWeaponType();
        setDamage();
        setAttackSpeed();
        slot = "Weapon";
        setEquipLevel();
    }

    public Weapon(String weaponType){
        WeaponType = WeaponTypes.valueOf(weaponType);
        setDamage();
        setAttackSpeed();
        slot = "Weapon";
        setEquipLevel();
        setName();

    }

    public Weapon(int damage, int attackSpeed, int equipLevel,String weaponType){
        WeaponType = WeaponTypes.valueOf(weaponType);
        setName();
        Damage = damage;
        AttackSpeed = attackSpeed;
        slot = "Weapon";
        this.equipLevel = equipLevel;
    }

    private void setWeaponType() {
        WeaponType = WeaponTypes.values()[getRandomInteger(7)];
        setName();
    }

    private void setDamage(){
        Damage = getRandomInteger(10);
    }

    private void setAttackSpeed(){
        AttackSpeed = getRandomInteger(4);
    }

    private void setEquipLevel(){
        equipLevel = Math.round(getDPS()/4);
    }

    private void setName(){
        if (this.WeaponType == WeaponTypes.Axes){
            name = String.valueOf(AxeNames.values()[getRandomInteger(7)]);
        }
        else if (this.WeaponType == WeaponTypes.Bows){
            name = String.valueOf(BowNames.values()[getRandomInteger(7)]);
        }
        else if (this.WeaponType == WeaponTypes.Daggers){
            name = String.valueOf(DaggerNames.values()[getRandomInteger(7)]);
        }
        else if (this.WeaponType == WeaponTypes.Hammers){
            name = String.valueOf(HammerNames.values()[getRandomInteger(7)]);
        }
        else if (this.WeaponType == WeaponTypes.Staffs){
            name = String.valueOf(StaffNames.values()[getRandomInteger(7)]);
        }
        else if (this.WeaponType == WeaponTypes.Swords){
            name = String.valueOf(SwordNames.values()[getRandomInteger(7)]);
        }
        else if (this.WeaponType == WeaponTypes.Wands){
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
                ", WeaponType=" + WeaponType +
                ", Damage=" + Damage +
                ", AttackSpeed=" + AttackSpeed +
                '}';
    }
}
