package no.noroff.accelerate.exceptions.custom;

//Custom exception class for invalid weapon exceptions
public class InvalidWeaponException extends Exception{
    public InvalidWeaponException(String str){
        super(str);
    }
}
