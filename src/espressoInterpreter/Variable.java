package espressoInterpreter;
import espressoInterpreter.Exceptions.UndefinedVariableException;

public class Variable {

	private char set;
	private int value;
	private boolean flag;

	public Variable() {

		flag = false;
	}

	public void setValue(char c, int v) {

		this.set = c;
		this.value = v;
		this.flag = true;
	}

	public int getValue() throws UndefinedVariableException {

		if (!flag) {
			throw new UndefinedVariableException();
		} else {
			return this.value;
		}

	}
	
	public int varSet()/* throws UndefinedVariableException */{
        if (!flag){
            return -1;
            /* throw new UndefinedVariableException();*/
        }
        else {
            return set;
        }

	}

}
