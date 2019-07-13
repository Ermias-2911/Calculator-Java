package operators;

import Evaluator.Operand;
import java.util.HashMap;

public abstract class Operator {
  // The Operator class should contain an instance of a HashMap
  public static final HashMap<String, Operator> operators = new HashMap<>();
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.
  // ALL subclasses of operator MUST be in their own file.
  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );


  //adding all the data to static hashmap when program is loaded
    static{
        //add each sub-class with the key token
        operators.put("+",new AdditionOperator());
        operators.put("-",new SubtractionOperator());
        operators.put("*",new MultiplicationOperator());
        operators.put("/",new DivisionOperator());
        operators.put("^",new PowerOperator());
        operators.put("(",new OpenBracketOperator());
        operators.put(")",new CloseBracketOperator());
       
    }
   
    
  public abstract int priority();
  public abstract Operand execute( Operand op1, Operand op2 );

  public static boolean check( String token ) {
      //returns true only if the operator is one of the added to hashmaps
      return operators.containsKey(token);
      
  }
}
