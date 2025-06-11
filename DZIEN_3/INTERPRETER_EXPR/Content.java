import java.util.Stack;

public class Context {
    public static Expression parse(String expr) {
        String[] tokens = expr.split(" ");
        Stack<Expression> stack = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            
            if (token.equals("+")) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(new PlusExpression(left,right));
            }
            else if (token.equals("-")) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(new MinusExpression(left,right));
            }
            else if (token.equals("*")) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(new MultiplyExpression(left,right));
            }
            else {
                stack.push(new NumberExpression(Integer.parseInt(token)));
            }
        }
        return stack.pop();
    }
}
