package no.noroff.accelerate;

import no.noroff.accelerate.models.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Warrior Ole = new Warrior("Ole",1);
        System.out.println(Ole);
        Weapon weapon = new Weapon();
        System.out.println(weapon);
        Ole.setWeapon(weapon);
        System.out.println(Ole);
    }
}
