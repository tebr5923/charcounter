package com.foxminded.counter;

import com.foxminded.storage.Storage;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedCharCounter implements Counter<Character> {
    private static final int MAX_ENTRIES = 10;
    private final Map<String, Storage<Character>> cachedMap;
    private final Counter<Character> charCounter;

    public CachedCharCounter(Counter<Character> charCounter) {
        this(charCounter, MAX_ENTRIES);
    }

    public CachedCharCounter(Counter<Character> charCounter, int maxEntries) {
        this.cachedMap = new LinkedHashMap<String, Storage<Character>>
                (maxEntries + 1, .75F, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxEntries;
            }
        };
        this.charCounter = charCounter;
    }

    @Override
    public Storage<Character> count(String inputString) {
        if (cachedMap.get(inputString) == null) {
            Storage<Character> newValue = charCounter.count(inputString);
            cachedMap.put(inputString, newValue);
        }
        return cachedMap.get(inputString);

        //I think it doesn't work in tests due to null validation in computeIfAbsent()
        //return cachedMap.computeIfAbsent(inputString, value -> charCounter.count(inputString));
    }
}
