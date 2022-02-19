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

    }

    enum armorTypes{
        Cloth,
        Leather,
        Mail,
        Plate
    }

    public Armor(){

    }


    private int getRandomInteger(int max){
        return ((int) (Math.random()*(max - 1))) + 1;
    }
}
