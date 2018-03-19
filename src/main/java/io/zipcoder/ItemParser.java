package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {

    public ArrayList<String> parseRawDataIntoStringArray(String rawData){
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawData);
        return response;
    }

    public int countMatches(Matcher matcher){
        int count = 0;
        while (matcher.find()){
            count++;
        }
        return count;
    }
    public Item parseStringIntoItem(String rawItem) throws ItemParseException {
        String name;
        Double price;
        String type;
        String expiration;
        Item item = null;

        Matcher m = Pattern.compile(":([^,].+?)(\\W|;|\\^|!|%|\\*|@)").matcher(rawItem);

        int numberOfMatches = countMatches(m);
        final int REQUIRED_NUMBER_OF_FIELDS_FOR_ITEM = 4;
        if (numberOfMatches <  REQUIRED_NUMBER_OF_FIELDS_FOR_ITEM){
            throw  new ItemParseException();
        }
        m.reset();
            while (m.find()){
                name = m.group(1).toLowerCase();
                m.find();
                price = Double.parseDouble(m.group(1));
                m.find();
                type = m.group(1).toLowerCase();
                m.find();
                expiration = m.group(1);
                item = new Item(name, price, type, expiration);
            }
        return item;
        }


    public ArrayList<String> findKeyValuePairsInRawItemData(String rawItem){
        String stringPattern = "[;|^]";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawItem);
        return response;
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString){
        return new ArrayList<String>(Arrays.asList(inputString.split(stringPattern)));
    }



}
