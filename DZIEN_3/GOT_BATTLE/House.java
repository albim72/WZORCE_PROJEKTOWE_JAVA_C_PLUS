package model;

public class House {
    private final String name;
    private int armySize;

    public House(String name) {
        this.name = name;
        this.armySize = 0;
    }

    public String getName() {
        return name;
    }

    public int getArmySize() {
        return armySize;
    }

    public void addArmy(int count) {
        armySize += count;
    }

    public void removeArmy(int count) {
        armySize -= count;
        if (armySize < 0) armySize = 0;
    }
}
