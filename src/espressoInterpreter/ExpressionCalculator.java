package espressoInterpreter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import espressoInterpreter.Exceptions.UndefinedVariableException;

public class ExpressionCalculator {
/*
	ArrayList<Variable> varsList;
	private int lineNumber = 0;
	private String line;
	private int index;

	public ExpressionCalculator(ArrayList<Variable> varsList) {
		this.varsList = varsList;
	}

	//Pass file from FileInput, converted to String, process values and pass values to other methods
	public void interpret(String line) {
		lineNumber++;
		this.line = line;

		String temp;
		String tempLine;
		
		//Read through file converting each line into a String
		try {
			
			//check for "read" at beginning of line
			if (line.startsWith("read")) {
				Scanner scan = new Scanner(System.in);
				index = 3; 									//set to value at end of "read"
				tempLine = line.substring(0, index + 1);
				temp = line.substring(index + 2, line.length());
				char c = temp.charAt(0);

				if (temp.length() > 1) {
					scan.close();
					syntaxError(lineNumber, line);
				}
				//Read in user input for a given "tempExpression
				System.out.println("Enter a value for " + temp + ": ");
				String temp1 = scan.nextLine();
				temp1 = this.infixToPostfix(temp1);
				int temp2 = Integer.parseInt(temp1);
				Variable tempVar = new Variable();
				tempVar.setValue(c, temp2);
				varsList.add(tempVar);
			}
			//check for "print" at beginning of line
			else if (line.startsWith("print")) {
				String real = "";
				index = 4;										//set to value at end of "print"
				tempLine = line.substring(0, index);
				temp = line.substring(index + 2, line.length());
				real = this.infixToPostfix(temp); 				
				System.out.println(real);						
			}

			else if (line.contains(" = ")) {
				index = line.indexOf('=');
				int tempValue;
				tempLine = line.substring(0, index - 1);
				temp = line.substring(index + 2, line.length());

				if (tempLine.length() > 1) {
					syntaxError(lineNumber, line);
				}

				temp = this.infixToPostfix(temp);
				char c = tempLine.charAt(0);
				Variable tempVar = this.varExists(c);

				if (tempVar != null) {
					tempValue = Integer.parseInt(temp);
					tempVar.setValue(c, tempValue);
					int f = varsList.indexOf(tempLine);
					varsList.set(f, tempVar);
				}

				else if (Character.isLetter(c)) {
					tempValue = Integer.parseInt(temp);
					tempVar = new Variable();
					tempVar.setValue(c, tempValue);

					varsList.add(tempVar);
				} else {
					syntaxError(lineNumber, line);
				}
			} else {
				syntaxError(lineNumber, line);
			}
		} catch (Exception e) {
			syntaxError(lineNumber, line);

		}
	}

	//Take in an infix notation String and convert to postfix notation via a Stack
	private String infixToPostfix(String infix) throws UndefinedVariableException, Exception {

		Stack<Character> stack = new Stack<Character>();
		Variable temp = new Variable();
		String postfix = new String("");

		for (int i = 0; i < infix.length(); ++i) {
			char c = infix.charAt(i);

			if (Character.isDigit(c) || c == ' ') {
				postfix += c;
			}

			else if (Character.isLetter(c)) {

				try {
					if (this.varExists(c) != null) {
						int n = this.getIndex(c);
						temp = this.varsList.get(n);
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
			  }

			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
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

		int solution = postfixEvaluation(postfix);
		postfix = Integer.toString(solution);
		return postfix;
	}

	private int postfixEvaluation(String postfix) throws Exception {

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if (c == ' ') {
				continue;
			}

			else if (Character.isDigit(c)) {
				int num = 0;

				while (Character.isDigit(c)) {
					num = num * 10 + (int) (c - '0');
					i++;

					if (i == postfix.length()) {
						break;
					}
					c = postfix.charAt(i);
				}
				i--;

				stack.push(num);
			}

			else {
				int temp1 = stack.pop();
				int temp2 = stack.pop();

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

	private void syntaxError(int lineNumber, String line) {
		System.out.println("Line " + lineNumber + ". " + line);
		System.out.println("Syntax Error");
		System.exit(0);

	}

	private Variable varExists(char c) {
		Variable tempVar;
		for (int i = 0; i < varsList.size(); i++) {
			tempVar = varsList.get(i);
			if (tempVar.varSet() == c) {
				return tempVar;
			}
		}
		return null;
	}

	private int getIndex(char c) {
		Variable tempVar;
		for (int i = 0; i <= varsList.size(); i++) {
			tempVar = varsList.get(i);
			if (tempVar.varSet() == c) {
				return i;
			}
		}
		return -1;
	}
*/
}
