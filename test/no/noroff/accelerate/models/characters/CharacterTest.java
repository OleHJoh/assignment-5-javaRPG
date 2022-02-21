package no.noroff.accelerate.models.characters;

import no.noroff.accelerate.exceptions.custom.InvalidArmorException;
import no.noroff.accelerate.exceptions.custom.InvalidWeaponException;
import no.noroff.accelerate.models.items.Armor;
import no.noroff.accelerate.models.items.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    public void testCreatingWarrior_ValidData_ShouldPass(){
        //Arrange
        String name = "test";
        //Act
        Warrior test = new Warrior(name);
        //Assert
        assertNotNull(test);
    }

    @Test
    public void equippingAWeaponWithTooHighLevel_toHighEquipLevel_shouldThrowInvalidWeaponException(){
        //Arrange
        Warrior test = new Warrior("test");
        Weapon weapon = new Weapon(2,2,2,"Axes");
        String expected = "Character level is to low for this weapon";
        //Act
        Exception exception = assertThrows(InvalidWeaponException.class,
                () -> test.setWeapon(weapon));
        String actual = exception.getMessage();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void equippingATooHighLevelArmor_toHighEquipLevel_shouldThrowInvalidArmorException(){
        //Arrange
        Warrior test = new Warrior("test");
        Armor armor = new Armor(1,1,1,2,"Plate");
        String expected = "Character level is to low for this armor";
        //Act
        Exception exception = assertThrows(InvalidArmorException.class,
                () -> test.setArmour(armor));
        String actual = exception.getMessage();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void equippingAWrongWeaponType_wrongWeaponTypeForCharacter_shouldThrowInvalidWeaponException(){
        //Arrange
        Warrior test = new Warrior("test");
        Weapon weapon = new Weapon(1,1,1,"Bows");
        String expected = "This weapon cannot be equipped by a warrior";
        //Act
        Exception exception = assertThrows(InvalidWeaponException.class,
                () -> test.setWeapon(weapon));
        String actual = exception.getMessage();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void equippingAWrongArmorType_wrongArmorTypeForCharacter_shouldThrowInvalidArmorException(){
        //Arrange
        Warrior test = new Warrior("test");
        Armor armor = new Armor(1,1,1,1,"Leather");
        String expected = "This armor cannot be equipped by a warrior";
        //Act
        Exception exception = assertThrows(InvalidArmorException.class,
                () -> test.setArmour(armor));
        String actual = exception.getMessage();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void equippingAValidWeaponForWarrior_validWeaponForWarrior_shouldReturnTrue() throws InvalidWeaponException {
        //Arrange
        Warrior test = new Warrior("test");
        Weapon weapon = new Weapon(1,1,1,"Axes");
        boolean expected = true;
        //Act
        boolean actual = test.setWeapon(weapon);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void equippingAValidArmorForWarrior_validArmorForWarrior_shouldReturnTrue() throws InvalidArmorException {
        //Arrange
        Warrior test = new Warrior("test");
        Armor armor = new Armor(1,1,1,1,"Plate");
        boolean expected = true;
        //Act
        boolean actual = test.setArmour(armor);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void calculatingTheDpsForWarriorWithNoWeapon_creatingAWarriorWithNoEquipment_shouldReturnDamageWithNoEquipment(){
        //Arrange
        Warrior test = new Warrior("test");
        double expected = 1 * (1 + (5/100));
        //Act
        double actual = test.getCharacterDPS();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void calculatingTheDpsForWarriorWithWeapon_warriorWithValidWeapon_shouldReturnDamageWithTheWeapon() throws InvalidWeaponException {
        //Arrange
        Warrior test = new Warrior("test");
        Weapon weapon = new Weapon(7,1.1,1,"Axes");
        double expected = (7 * 1.1) * (1 + (5/100));
        //Act
        test.setWeapon(weapon);
        double actual = test.getCharacterDPS();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void calculatingTheDpsForWarriorWithWeaponAndArmor_warriorWithValidWeaponAndArmor_shouldReturnDamageWithTheWeaponAndArmor() throws InvalidWeaponException, InvalidArmorException {
        //Arrange
        Warrior test = new Warrior("test");
        Weapon weapon = new Weapon(7,1.1,1,"Axes");
        Armor armor = new Armor(1,1,1,1,"Plate");
        double expected = (7 * 1.1) * (1 + ((5+1)/100));
        //Act
        test.setWeapon(weapon);
        test.setArmour(armor);
        double actual = test.getCharacterDPS();
        //Assert
        assertEquals(expected, actual);
    }
}