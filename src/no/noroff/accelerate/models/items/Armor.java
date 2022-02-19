package no.noroff.accelerate.models.items;

import no.noroff.accelerate.models.PrimaryAttribute;

public class Armor extends Item {

    enum ClothLegNames{
        Britches_of_Burning_Freedom,
        Robes_of_Endless_Vengeance,
        Linen_Leggings_of_Haunted_Ancestors,
        Linen_Britches_of_Blessed_Power
    }

    enum ClothBodyNames{
        Firesoul_Cloth_Vest,
        Desolation_Linen_Tunic,
        Tunic_of_the_Occult,
        Cursed_Linen_Raiment
    }

    enum ClothHelmetNames{
        Cap_of_Shattered_Hells,
        Mask_of_Hallowed_Bloodlust,
        Mourning_Linen_Cap,
        Champion_Padded_Bandana
    }

    enum LeatherLegNames{
        Lightning_Padded_Pants,
        Vindication_Hide_Britches,
        Destiny_Quilted_Breeches,
        Twilight_Padded_Pants
    }

    enum LeatherBodyNames {
        Leather_Tunic_of_Cursed_Whispers,
        Tormented_Hide_Raiment,
        Bloodied_Leather_Vest,
        Shadow_Leather_Vest
    }

    enum LeatherHelmetNames{
        Rune_Forged_Hide_Hood,
        Wicked_Rugged_Leather_Helm,
        Lightning_Hide_Mask,
        Warped_Hide_Hood
    }

    enum MailLegNames{
        Trainee_Golden_Legguards,
        Phantom_Chainmail_Graves,
        Feral_Bronzed_Greaves,
        Bandit_Chainmail_Greaves
    }

    enum MailBodyNames{
        Victor_Scaled_Cuirass,
        Guard_Chainmail_Greatplate,
        Victor_Chainmail_Breastplate,
        Yearning_Chainmail_Vest
    }

    enum MailHelmetNames{
        Judgement_Scaled_Helm,
        Shadow_Scaled_Helm,
        Spectral_Silver_Jaws,
        Demonic_Golden_Visage
    }

    enum PlateLegNames{
        Nightmare_Titanium_Greaves,
        Arcane_Adamant_Legplates,
        Honed_Mithril_Greaves,
        Warrior_Adamantite_Leggings
    }

    enum PlateBodyNames{
        Prime_Titanium_Vest,
        Obsidian_Batteplate,
        Sentinel_Mithril_Breastplate,
        Hopeless_Titanium_Tunic
    }

    enum PlateHelmetNames{
        Ruby_Infused_Adamantite_Jaws,
        Unholy_Adamantite_Visage,
        Promised_Adamantite_Crown,
        Infused_Demon_Faceguard
    }

    public enum ArmorTypes{
        Cloth,
        Leather,
        Mail,
        Plate
    }

    public Armor(){
        setSlot();
        setArmorType();
        setName();
        setPrimaryAttributes();
        setEquipLevel();
    }

    public Armor(String armorTYpe){
        setSlot();
        this.armorType = ArmorTypes.valueOf(armorTYpe);
        setName();
        setPrimaryAttributes();
        setEquipLevel();
    }

    public Armor(int strength, int dexterity, int intelligence, int equipLevel, String armorType){
        setSlot();
        this.armorType = ArmorTypes.valueOf(armorType);
        setName();
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.equipLevel = equipLevel;
    }

    public ArmorTypes armorType;

    private void setSlot(){
        int number = getRandomInteger(100);
        if(number <= 33){
            slot = "Legs";
        }
        else if(number <= 66){
            slot = "Body";
        }
        else
            slot = "Head";
    }

    private void setArmorType(){
        armorType = ArmorTypes.values()[getRandomInteger(4)];
    }

    private void setName(){
        if (armorType == ArmorTypes.Cloth){
            if (slot == "Legs"){
                name = String.valueOf(ClothLegNames.values()[getRandomInteger(4)]);
            }
            else if (slot == "Body"){
                name = String.valueOf(ClothBodyNames.values()[getRandomInteger(4)]);
            }
            else if (slot == "Head"){
                name = String.valueOf(ClothHelmetNames.values()[getRandomInteger(4)]);
            }
        }
        else if (armorType == ArmorTypes.Leather){
            if (slot == "Legs"){
                name = String.valueOf(LeatherLegNames.values()[getRandomInteger(4)]);
            }
            else if (slot == "Body"){
                name = String.valueOf(LeatherBodyNames.values()[getRandomInteger(4)]);
            }
            else if (slot == "Head"){
                name = String.valueOf(LeatherHelmetNames.values()[getRandomInteger(4)]);
            }
        }
        else  if (armorType == ArmorTypes.Mail){
            if (slot == "Legs"){
                name = String.valueOf(MailLegNames.values()[getRandomInteger(4)]);
            }
            else if (slot == "Body"){
                name = String.valueOf(MailBodyNames.values()[getRandomInteger(4)]);
            }
            else if (slot == "Head"){
                name = String.valueOf(MailHelmetNames.values()[getRandomInteger(4)]);
            }
        }
        else if (armorType == ArmorTypes.Plate){
            if (slot == "Legs"){
                name = String.valueOf(PlateLegNames.values()[getRandomInteger(4)]);
            }
            else if (slot == "Body"){
                name = String.valueOf(PlateBodyNames.values()[getRandomInteger(4)]);
            }
            else if (slot == "Head"){
                name = String.valueOf(PlateHelmetNames.values()[getRandomInteger(4)]);
            }
        }
    }

    private void setPrimaryAttributes(){
        if (armorType == ArmorTypes.Cloth){
            strength = getRandomInteger(3);
            dexterity = getRandomInteger(3);
            intelligence = getRandomInteger(8);
        }
        else if (armorType == ArmorTypes.Leather){
            strength = getRandomInteger(3);
            dexterity = getRandomInteger(8);
            intelligence = getRandomInteger(3);
        }
        else if (armorType == ArmorTypes.Mail){
            strength = getRandomInteger(6);
            dexterity = getRandomInteger(6);
            intelligence = getRandomInteger(3);
        }
        else if (armorType == ArmorTypes.Plate){
            strength = getRandomInteger(8);
            dexterity = getRandomInteger(3);
            intelligence = getRandomInteger(3);
        }
    }

    private void setEquipLevel(){
        equipLevel = Math.round((strength + dexterity + intelligence)/3);
    }

    private int getRandomInteger(int max){
        return ((int) (Math.random()*(max - 1))) + 1;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name=" + name +
                ", equipLevel=" + equipLevel +
                ", slot=" + slot +
                ", armorType=" + armorType +
                ", strength='" + strength + '\'' +
                ", dexterity=" + dexterity +
                ", intelligence='" + intelligence + '\'' +
                '}';
    }
}
