package com.foxminded.counter;

import com.foxminded.storage.Storage;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedCharCounter implements Counter<Character> {
    private static final int MAX_ENTRIES = 10;
    private final Map<String, Storage<Character, String>> cachedMap;
    private final Counter<Character> charCounter;

    public CachedCharCounter(Counter<Character> charCounter) {
        this(charCounter, MAX_ENTRIES);
    }

    public CachedCharCounter(Counter<Character> charCounter, int maxEntries) {
        this.cachedMap = new LinkedHashMap<String, Storage<Character, String>>
                (maxEntries + 1, .75F, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxEntries;
            }
        };
        this.charCounter = charCounter;
    }

    @Override
    public Storage<Character, String> count(String inputString) {
        return cachedMap.computeIfAbsent(inputString, value -> charCounter.count(inputString));
    }
}
