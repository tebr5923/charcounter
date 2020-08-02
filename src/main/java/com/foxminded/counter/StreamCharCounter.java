package com.foxminded.counter;

import com.foxminded.storage.CharStorage;
import com.foxminded.storage.Storage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCharCounter extends AbstractCharCounter {
    @Override
    protected Storage<Character> countChars(String string) {
        Stream<Character> stream = string.chars().mapToObj(ch -> (char) ch);
        Map<Character, Long> map;
        map = stream.collect(Collectors.groupingBy(Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()));
        return new CharStorage(string, map);
    }
}
