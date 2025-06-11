package model;

import java.util.*;

public class BattleContext {
    private final Map<String, House> houses = new HashMap<>();
    private final Map<String, Location> locations = new HashMap<>();

    public House getOrCreateHouse(String name) {
        return houses.computeIfAbsent(name, House::new);
    }

    public Location getOrCreateLocation(String name) {
        return locations.computeIfAbsent(name, Location::new);
    }

    public Collection<House> getHouses() {
        return houses.values();
    }

    public Collection<Location> getLocations() {
        return locations.values();
    }
}
