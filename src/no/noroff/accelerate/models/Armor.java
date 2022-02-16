package no.noroff.accelerate.models;

public class Armor extends Item {
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
