package no.noroff.accelerate.exceptions.custom;

//Custom exception class for invalid armor exceptions
public class InvalidArmorException extends Exception{
    public InvalidArmorException(String str){
        super(str);
    }
}
