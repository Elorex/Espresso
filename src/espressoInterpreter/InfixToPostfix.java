package espressoInterpreter;

import java.util.ArrayList;
import java.util.Stack;
import espressoInterpreter.Exceptions.UndefinedVariableException;

public class InfixToPostfix {
	
	static String postfix = "";
	
	PostfixEvaluation evaluate = new PostfixEvaluation();
	//Interpret interpret = new Interpret();
	public String infixToPostfix(ArrayList<Variable> varsList, String infix, int lineNumber, String line) throws UndefinedVariableException, Exception {

		Stack<Character> stack = new Stack<Character>();
		Variable temp = new Variable();
		
		for (int i = 0; i < infix.length(); ++i) {
			char c = infix.charAt(i);			

			if (Character.isDigit(c) || c == ' ') {
				postfix += c;
				//System.out.println("c = " +c);
				//System.out.println("postfix = " + postfix);
			}

			
			else if (Character.isLetter(c)) {

				try {
					if (varExists(c, varsList) != null) {
						int n = getIndex(c, varsList);
						temp = varsList.get(n);
						postfix += temp.getValue();
					}

					else {
						throw new UndefinedVariableException(
								"Line " + lineNumber + ". " + line + "\n Error: variable " + c + " is not defined");
					}
				} catch (UndefinedVariableException e) {
					System.err.print(e);
					System.exit(0);
				}
			} else if (c == '(') {
				stack.push(c);
			//	System.out.println("stack = " + stack);
				//System.out.println("postfix = " + postfix);
			  }

			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					//System.out.println("postfix = " + postfix);
					postfix += stack.pop();
				}

				if (!stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression";
				}

				else {
					stack.pop();
				}
			}

			else {
				while (!stack.isEmpty() && pre(c) <= pre(stack.peek())) {
					postfix += stack.pop();
				}
				stack.push(c);
			}
		}

		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		int solution = evaluate.postfixEvaluation(postfix);	
		postfix = Integer.toString(solution);
		return postfix;
	}
	
	private int pre(Character c) {
		int pre = 0;

		if ((c == '*') || c == '/' || c == '%') {
			pre = 2;
		}

		else if ((c == '+') || c == '-') {
			pre = 1;
		}
		return pre;
	}
	
	public Variable varExists(char c, ArrayList<Variable> varsList) {
		Variable tempVar;
		for (int i = 0; i < varsList.size(); i++) {
			tempVar = varsList.get(i);
			if (tempVar.varSet() == c) {
				return tempVar;
			}
		}
		return null;
	}
	
	private int getIndex(char c, ArrayList<Variable> varsList) {
		Variable tempVar;
		for (int i = 0; i <= varsList.size(); i++) {
			tempVar = varsList.get(i);
			if (tempVar.varSet() == c) {
				return i;
			}
		}
		return -1;
	}

}
