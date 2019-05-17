package espressoInterpreter;
import java.io.*;
import java.util.*;

public class FileInput {

	 ArrayList<Variable> vars = new ArrayList<Variable>();
	 Variable tempvar = new Variable(); //it adds the under the same tempvar name, creating an issue. If i rewrite a lot of code, var name can be identifier.

	 public FileInput(File file) throws FileNotFoundException {
	        Scanner sc = new Scanner(file);
	        Interpret lineEvaluator = new Interpret(this.vars);
	      //ExpressionCalculator lineEvaluator = new ExpressionCalculator(this.vars);
	        while (sc.hasNext()) {
	            lineEvaluator.interpret(sc.nextLine());
	        }

	        sc.close();
	    }

}