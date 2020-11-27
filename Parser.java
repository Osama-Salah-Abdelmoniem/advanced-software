package com.company;

import java.util.ArrayList;

public class Parser {   // Dear {x} ,your booking of the {y} is confirmed. thanks for using our store :)
    private static ArrayList<Integer> PlaceHolders = new ArrayList<>();

    public   boolean Parse(String template) {
        boolean found = false;
        String[] splittemp = template.split(" ");
        if (splittemp.length == 0) return false;
        else {
            for (int i = 0; i < splittemp.length; i++) {
                if (splittemp[i].contains("{")) {
                    if (splittemp[i].contains("}")) {
                        String[] splitregx = splittemp[i].split("");
                        if (splitregx.length == 3 && !splitregx[1].equals(" ")) {
                            PlaceHolders.add(i);
                        } else return false;
                    } else return false;
                } else if (splittemp[i].contains("}") && !splittemp[i].contains("{")) return false;

            }
            return true;
        }
    }

    public   String getPlaceHolders() {
        String placeholders=  PlaceHolders.toString();
        return placeholders;
    }
}