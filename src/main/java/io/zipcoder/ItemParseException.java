package io.zipcoder;


public class ItemParseException extends Exception {

    public static int numberOfExceptionsThrown;

    public ItemParseException(){
        numberOfExceptionsThrown++;
    }
    public static int getNumberOfTimesThrown(){
        return numberOfExceptionsThrown;
    }

}
