package interpreter;

import model.BattleContext;

public interface Expression {
    void interpret(BattleContext context);
}
