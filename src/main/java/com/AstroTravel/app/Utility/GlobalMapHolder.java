package com.AstroTravel.app.Utility;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GlobalMapHolder {

    private final Map<String, String> globalMap = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        globalMap.put(key, value);
    }

    public Object get(String key) {
        return globalMap.get(key);
    }

    public Map<String, String> getAll() {
        return globalMap;
    }

    public void remove(String key) {
        globalMap.remove(key);
    }

    public boolean containsKey(String key) {
        return globalMap.containsKey(key);
    }

}
