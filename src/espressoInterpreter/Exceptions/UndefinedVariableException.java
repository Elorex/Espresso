package espressoInterpreter.Exceptions;

public class UndefinedVariableException extends Exception {
	
	public UndefinedVariableException() {}
	
	public UndefinedVariableException(String message) {
		
		super(message);
	}

}
