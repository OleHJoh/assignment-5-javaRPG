package no.noroff.accelerate;

import no.noroff.accelerate.models.characters.Mage;
import no.noroff.accelerate.models.characters.Warrior;
import no.noroff.accelerate.models.items.Weapon;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Mage caro = new Mage("Caro");
        System.out.println(caro);
        Weapon weapon = new Weapon("Staffs");
        System.out.println(weapon);
        caro.setWeapon(weapon);
        System.out.println(caro);
    }
}
