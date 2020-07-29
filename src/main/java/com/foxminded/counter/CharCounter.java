package com.foxminded.counter;

import java.util.HashMap;
import java.util.Map;

public class CharCounter implements Counter<Character> {

    @Override
    public Map<Character, Integer> count(String inputString) {
        checkInputString(inputString);
        return countChars(inputString);
    }

    private void checkInputString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("null can't be counted");
        }
        if (string.equals("")) {
            throw new IllegalArgumentException("String is empty, can't be counted");
        }
    }

    private Map<Character, Integer> countChars(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : string.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        return map;
    }
}
