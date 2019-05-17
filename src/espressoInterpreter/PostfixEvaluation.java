package espressoInterpreter;

import java.util.Stack;

public class PostfixEvaluation {
	
	
	public int postfixEvaluation(String postfix) throws Exception {
	Stack<Integer> stack = new Stack<Integer>();

	for (int i = 0; i < postfix.length(); i++) {
		char c = postfix.charAt(i);
		//System.out.println("postfix = " +postfix);
		System.out.println("c = " +c);
		if (c == ' ') {
			continue;
		}

		else if (Character.isDigit(c)) {
			int num = 0;

			while (Character.isDigit(c)) {
				//System.out.println(postfix);
				num = num * 10 + (int)(c - '0');
				//System.out.println(num);
				i++;

				if (i == postfix.length()) {
					break;
				}
				c = postfix.charAt(i);
			}
			i--;
			System.out.println("stack = " +stack);
			stack.push(num);
		}

		else {
			System.out.println("stack = " +stack);
			int temp1 = stack.pop();
			System.out.println("stack = " +stack);
			int temp2 = stack.pop();
						System.out.println("temp1 = " +temp1);
			System.out.println("temp2 = " +temp2);
			if (c == '+')
				stack.push(temp2 + temp1);

			else if (c == '-')
				stack.push(temp2 - temp1);

			else if (c == '*')
				stack.push(temp2 * temp1);

			else if (c == '/')
				stack.push(temp2 / temp1);

			else if (c == '%')
				stack.push(temp2 % temp1);

		}
	}

	if (stack.size() != 1) {
		throw new Exception();
	}
	return stack.pop();
}

}
