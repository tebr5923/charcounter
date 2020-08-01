package com.foxminded.storage;

import java.util.Map;

public interface Storage<T> {
    Map<T, Long> getCountResult();

    String getInputSting();
}
