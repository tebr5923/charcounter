package com.foxminded.counter;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter extends AbstractCharCounter {
    @Override
    protected Map<Character, Long> countChars(String string) {
        Map<Character, Long> map = new LinkedHashMap<>();
        for (char ch : string.toCharArray()) {
            long count = map.getOrDefault(ch, 0L);
            map.put(ch, count + 1);
        }
        return map;
    }
}
