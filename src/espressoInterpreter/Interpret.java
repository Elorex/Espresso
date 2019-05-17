package espressoInterpreter;

import java.util.ArrayList;
import java.util.Scanner;

public class Interpret {
	
	ArrayList<Variable> varsList;
	private String line;
	private int lineNumber = 0;
	private int index;
	
	InfixToPostfix convert = new InfixToPostfix();
	PostfixEvaluation evaluate = new PostfixEvaluation();
	
	public Interpret( ArrayList<Variable> varsList) {
        this.varsList = varsList;
    }
	
	public Interpret(String line, int lineNumber, int index) {
		this.line = line;
		this.lineNumber = lineNumber;
		this.index = index;	
	}
	
	public void interpret(String line) {
		setLineNumber(getLineNumber() + 1);
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
					syntaxError(getLineNumber(), line);
				}
				//Read in user input for a given "tempExpression
				System.out.println("Enter a value for " + temp + ": ");
				String temp1 = scan.nextLine();
				temp1 = this.convert.infixToPostfix(varsList, temp1, getLineNumber(), getLine());
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
				real = this.convert.infixToPostfix(varsList, temp, getLineNumber(), getLine()); 				
				System.out.println(real);						
			}

			else if (line.contains(" = ")) {
				index = line.indexOf('=');
				int tempValue;
				
				tempLine = line.substring(0, index - 1);
				System.out.println("tempLine: " +tempLine);
				temp = line.substring(index + 2, line.length());

				if (tempLine.length() > 1) {
					syntaxError(getLineNumber(), line);
				}
				temp = convert.infixToPostfix(varsList, temp, getLineNumber(), getLine());
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
					syntaxError(getLineNumber(), line);
				}
			} else {
				syntaxError(getLineNumber(), line);
			}
		} catch (Exception e) {
			syntaxError(getLineNumber(), line);

		}
	}
	
	private void syntaxError(int lineNumber, String line) {
		System.out.println("Line " + lineNumber + ". " + line);
		System.out.println("Syntax Error");
		System.exit(0);

	}
	
	public Variable varExists(char c) {
		Variable tempVar;
		for (int i = 0; i < varsList.size(); i++) {
			tempVar = varsList.get(i);
			if (tempVar.varSet() == c) {
				return tempVar;
			}
		}
		return null;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
	
	public ArrayList<Variable> getVarsList(){
		return varsList;
	}
	
	


}
