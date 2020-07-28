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
        if (inputString == null) {
            throw new IllegalStateException("null can't be counted");
        }
        for (char ch : inputString.toCharArray()) {
            add(ch);
        }
        return map;
    }

    private void add(char ch) {
        int count = 1;
        if (map.containsKey(ch)) {
            count += map.get(ch);
        }
        map.put(ch, count);
    }
}
