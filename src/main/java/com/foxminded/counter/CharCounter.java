package com.foxminded.counter;

import java.util.HashMap;
import java.util.Map;

public class CharCounter implements Counter<Character> {
    private final Map<Character, Integer> map;

    public CharCounter() {
        this.map = new HashMap<>();
    }

    @Override
    public Map<Character, Integer> count(String inputString) {
        checkInputString(inputString);
        clearMap();
        countChars(inputString);
        return map;
    }

    private void checkInputString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("null can't be counted");
        }
        if (string.equals("")) {
            throw new IllegalArgumentException("String is empty, can't be counted");
        }
    }

    private void clearMap() {
        map.clear();
    }

    private void countChars(String string) {
        for (char ch : string.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
    }
}
