package model;

public class CalculatorUtil {
	
	public static Float solve(Float left, char op, Float right) {
		switch (op) {
	        case '%': return left % right;
	        case '*': return left * right;
	        case '/': return left / right;
	        case '+': return left + right;
	        case '-': return left - right;
	        default: throw new IllegalArgumentException("Unknown operator " + op);
		}
	}
}
