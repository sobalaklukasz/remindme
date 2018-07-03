package com.hoshi.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TextNumberMapper {

    private static final Map<String, Integer> TEXT_NUMBER_TO_INT = new HashMap<>();

    static {
        TEXT_NUMBER_TO_INT.put("one", 1);
        TEXT_NUMBER_TO_INT.put("two", 2);
        TEXT_NUMBER_TO_INT.put("three", 3);
        TEXT_NUMBER_TO_INT.put("four", 4);
        TEXT_NUMBER_TO_INT.put("five", 5);
        TEXT_NUMBER_TO_INT.put("six", 6);
        TEXT_NUMBER_TO_INT.put("seven", 7);
        TEXT_NUMBER_TO_INT.put("eight", 8);
        TEXT_NUMBER_TO_INT.put("nine", 9);
        TEXT_NUMBER_TO_INT.put("ten", 10);
        TEXT_NUMBER_TO_INT.put("eleven", 11);
        TEXT_NUMBER_TO_INT.put("twelve", 12);
        TEXT_NUMBER_TO_INT.put("thirteen", 13);
        TEXT_NUMBER_TO_INT.put("fourteen", 14);
        TEXT_NUMBER_TO_INT.put("fifteen", 15);
        TEXT_NUMBER_TO_INT.put("sixteen", 16);
        TEXT_NUMBER_TO_INT.put("seventeen", 17);
        TEXT_NUMBER_TO_INT.put("eighteen", 18);
        TEXT_NUMBER_TO_INT.put("nineteen", 19);

        TEXT_NUMBER_TO_INT.put("twenty", 20);
        TEXT_NUMBER_TO_INT.put("thirty", 30);
        TEXT_NUMBER_TO_INT.put("forty", 40);
        TEXT_NUMBER_TO_INT.put("fifty", 50);
        TEXT_NUMBER_TO_INT.put("sixty", 60);
        TEXT_NUMBER_TO_INT.put("seventy", 70);
        TEXT_NUMBER_TO_INT.put("eighty", 80);
        TEXT_NUMBER_TO_INT.put("ninety", 90);

        TEXT_NUMBER_TO_INT.put("hundred", 100);
    }

    public static int getIntForTextNumber(String textNumber) {
        return TEXT_NUMBER_TO_INT.get(textNumber);
    }
}
