package main;

import interpreter.BattleParser;
import interpreter.Expression;
import model.BattleContext;
import utils.BattleScriptLoader;

import java.util.List;

public class BattleInterpreterApp {
    public static void main(String[] args) {
        try {
            String scriptPath = "src/main/resources/example.battle";
            List<String> lines = BattleScriptLoader.loadScript(scriptPath);

            BattleContext context = new BattleContext();
            BattleParser parser = new BattleParser();
            List<Expression> expressions = parser.parse(lines);

            for (Expression expr : expressions) {
                expr.interpret(context);
            }
        } catch (Exception e) {
            System.err.println("Błąd: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
