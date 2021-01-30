import java.util.Stack;

public class BaseballGame {

	public static void main(String[] args) {
		String[] strs = {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(strs));
	}
		
	public static int calPoints(String[] ops) {
		int sum = 0;
		
		Stack<Integer> stack = new Stack<>();
		for(String str : ops) {
			switch (str) {
			case "C": {
				stack.pop();
				break;
			}
			case "D": {
				stack.push(stack.peek() * 2);
				break;
			}
			case "+": {
				int a = stack.peek();
				stack.pop();
				int b = stack.peek();
				stack.push(a);
				stack.push(a+b);
				
				break;
			}
			default:
				stack.push(Integer.parseInt(str));
			}
		}
		
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		return sum;
	}
}
