package no.noroff.accelerate;

import no.noroff.accelerate.models.Mage;
import no.noroff.accelerate.models.Warrior;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Warrior Ole = new Warrior("Ole",1);
        System.out.println(Ole);
        Ole.levelUp();
        System.out.println(Ole);
        Mage Caro = new Mage("Caro",1);
        System.out.println(Caro);
        Caro.levelUp();
        System.out.println(Caro);
    }
}
