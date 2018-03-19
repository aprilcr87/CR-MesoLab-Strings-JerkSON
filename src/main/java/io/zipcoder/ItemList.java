package io.zipcoder;

import java.util.ArrayList;

public class ItemList {

    ArrayList<String> itemList = new ArrayList<String>();

    public ArrayList<String> getItemList() {
        return itemList;
    }
    public void addItem(String s){
        itemList.add(s);
    }
}
