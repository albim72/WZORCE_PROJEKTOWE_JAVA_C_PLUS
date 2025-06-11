package model;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final String name;
    private final Map<String, Integer> armies = new HashMap<>();

    public Location(String name) {
        this.name = name;
    }

    public void addArmy(String houseName, int count) {
        armies.put(houseName, armies.getOrDefault(houseName, 0) + count);
    }

    public int getArmy(String houseName) {
        return armies.getOrDefault(houseName, 0);
    }

    public void removeArmy(String houseName, int count) {
        int current = armies.getOrDefault(houseName, 0);
        current = Math.max(0, current - count);
        armies.put(houseName, current);
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getArmies() {
        return armies;
    }
}
