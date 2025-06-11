package interpreter;

import model.BattleContext;
import model.House;

public class AttackExpression implements Expression {
    private final String attacker;
    private final String defender;
    private final int count;

    public AttackExpression(String attacker, String defender, int count) {
        this.attacker = attacker;
        this.defender = defender;
        this.count = count;
    }

    @Override
    public void interpret(BattleContext context) {
        House attackingHouse = context.getOrCreateHouse(attacker);
        House defendingHouse = context.getOrCreateHouse(defender);

        int attackingForce = Math.min(attackingHouse.getArmySize(), count);
        int defendingForce = defendingHouse.getArmySize();

        int loss = Math.min(defendingForce, attackingForce);

        attackingHouse.removeArmy(loss);
        defendingHouse.removeArmy(loss);

        System.out.printf("[ATTACK] %s zaatakował %s (%d wojsk). Straty: %s: %d, %s: %d%n",
                attacker, defender, count, attacker, loss, defender, loss);
    }
}

