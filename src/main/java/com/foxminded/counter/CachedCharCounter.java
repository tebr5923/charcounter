package com.foxminded.counter;

import java.util.HashMap;
import java.util.Map;

public class CachedCharCounter implements Counter<Character> {
    private final Map<String, Map<Character, Integer>> cachedMap;
    private final Counter<Character> charCounter;

    public CachedCharCounter(Counter<Character> charCounter) {
        this.cachedMap = new HashMap<>();
        this.charCounter = charCounter;
    }

    @Override
    public Map<Character, Integer> count(String inputString) {

        if (cachedMap.containsKey(inputString)) {
            return cachedMap.get(inputString);
        }
        Map<Character, Integer> map = charCounter.count(inputString);
        cachedMap.put(inputString, map);
        return map;
    }
}
