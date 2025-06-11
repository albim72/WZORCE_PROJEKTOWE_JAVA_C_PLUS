package interpreter;

import model.BattleContext;
import model.House;
import model.Location;

public class ReportExpression implements Expression {
    @Override
    public void interpret(BattleContext context) {
        System.out.println("=== RAPORT WOJSK ===");
        for (House h : context.getHouses()) {
            System.out.printf("Ród %s: %d wojsk%n", h.getName(), h.getArmySize());
        }
        System.out.println("=== LOKACJE ===");
        for (Location loc : context.getLocations()) {
            System.out.print(loc.getName() + ": ");
            loc.getArmies().forEach((k, v) ->
                    System.out.print(k + "=" + v + " "));
            System.out.println();
        }
        System.out.println("====================");
    }
}
