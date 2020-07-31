package com.foxminded.util;

import java.util.HashMap;
import java.util.Map;

public class HashMapBuilder<T> {
    private final HashMap<T, Long> hashMap;

    public HashMapBuilder() {
        this.hashMap = new HashMap<>();
    }

    public HashMapBuilder<T> add(T var, long count) {
        hashMap.put(var, count);
        return this;
    }

    public Map<T, Long> build() {
        return hashMap;
    }
}
