package interpreter;

import java.util.ArrayList;
import java.util.List;

public class BattleParser {
    public List<Expression> parse(List<String> lines) {
        List<Expression> expressions = new ArrayList<>();
        for (String line : lines) {
            String[] tokens = line.trim().split("\\s+");
            if (tokens.length == 0 || tokens[0].startsWith("#") || tokens[0].isEmpty()) continue;
            switch (tokens[0].toUpperCase()) {
                case "SEND":
                    if (tokens.length >= 5) {
                        String house = tokens[1];
                        int count = Integer.parseInt(tokens[2]);
                        String location = tokens[4];
                        expressions.add(new SendExpression(house, count, location));
                    }
                    break;
                case "ATTACK":
                    if (tokens.length >= 4) {
                        String attacker = tokens[1];
                        String defender = tokens[2];
                        int count = Integer.parseInt(tokens[3]);
                        expressions.add(new AttackExpression(attacker, defender, count));
                    }
                    break;
                case "REPORT":
                    expressions.add(new ReportExpression());
                    break;
                default:
                    System.err.println("Nieznane polecenie: " + tokens[0]);
            }
        }
        return expressions;
    }
}
