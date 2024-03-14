package com.appalianzaapi.utils;

public class BuildSharedKey {
    public static String buildSharedKey(String businessId) {
        String[] split = businessId.split("\\s");
        int countSplit = split.length;
        if(countSplit == 2 || countSplit == 3) {
            return Character.toString(split[0].charAt(0)).concat(split[1]).toLowerCase();
        }
        if(countSplit == 4) {
            return Character.toString(split[0].charAt(0)).concat(split[2]).toLowerCase();
        }
        return "";
    }
}
