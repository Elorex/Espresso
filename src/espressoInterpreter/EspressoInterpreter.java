package espressoInterpreter;

import java.io.File;
import java.io.IOException;
import espressoInterpreter.Exceptions.InputException;
import espressoInterpreter.Exceptions.UndefinedVariableException;

public class EspressoInterpreter {

	public static void main(String[] args) throws IOException, UndefinedVariableException, NullPointerException,
			 InputException {

		        File fr = new File(args[0]);
		        FileInput interpreter = new FileInput(fr);

		    }
		
	}


