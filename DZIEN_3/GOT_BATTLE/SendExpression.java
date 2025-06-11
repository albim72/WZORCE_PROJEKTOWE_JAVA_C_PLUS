package interpreter;

import model.BattleContext;
import model.House;
import model.Location;

public class SendExpression implements Expression {
    private final String houseName;
    private final int count;
    private final String locationName;

    public SendExpression(String houseName, int count, String locationName) {
        this.houseName = houseName;
        this.count = count;
        this.locationName = locationName;
    }

    @Override
    public void interpret(BattleContext context) {
        House house = context.getOrCreateHouse(houseName);
        Location location = context.getOrCreateLocation(locationName);

        house.addArmy(count);
        location.addArmy(houseName, count);
        System.out.printf("[SEND] %s wysłał %d wojsk do %s.%n", houseName, count, locationName);
    }
}
