package com.foxminded.counter;

import com.foxminded.storage.CharStorage;
import com.foxminded.storage.Storage;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter extends AbstractCharCounter {
    @Override
    protected Storage<Character, String> countChars(String string) {
        Map<Character, Long> map;
        map = new LinkedHashMap<>();
        for (char ch : string.toCharArray()) {
            long count;
            count = map.getOrDefault(ch, 0L);
            map.put(ch, count + 1);
        }
        return new CharStorage(string, map);
    }
}
