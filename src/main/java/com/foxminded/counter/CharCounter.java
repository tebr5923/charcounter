package com.foxminded.counter;

import com.foxminded.storage.CharStorage;
import com.foxminded.storage.Storage;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter extends AbstractCharCounter {
    @Override
    protected Storage<Character> countChars(String string) {
        Map<Character, Long> map = new LinkedHashMap<>();
        for (char ch : string.toCharArray()) {
            long count = map.getOrDefault(ch, 0L);
            map.put(ch, count + 1);
        }
        return new CharStorage(string, map);
    }
}
