package io.zipcoder;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;


public class Main {

    public ArrayList<String> readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        ItemParser itemParser = new ItemParser();
        ArrayList<String> myArray = itemParser.parseRawDataIntoStringArray(result);
        System.out.println(myArray);
        return myArray;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> output = (new Main()).readRawDataToString();
        ItemParser itemParser = new ItemParser();
        ArrayList<String> lastArray = itemParser.findKeyValuePairsInRawItemData(output.toString());
        for (String s : lastArray) {
            try{
            Item item = itemParser.parseStringIntoItem(s);

            } catch (ItemParseException e) {
                    continue;
                }
            }
            System.out.println();
            // TODO: parse the data in output into items, and display to console.
        }

    }



