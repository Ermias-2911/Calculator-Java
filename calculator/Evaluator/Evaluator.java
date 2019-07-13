package Evaluator;

import operators.Operator;
import java.util.*;

public class Evaluator {
    
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/ ()";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }
 

  public int eval( String expression ) {
    String token;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    // initialize operator stack - necessary with operator priority schema
    // the priority of any operator in the operator stack other than
    // the usual mathematical operators - "+-*/" - should be less than the priority
    // of the usual operators

    // TODO Operator is abstract - this will need to be fixed:

    

    while ( this.tokenizer.hasMoreTokens() ) {
      // filter out spaces
          if ( !( token = this.tokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand
             if ( Operand.check( token )) {
          operandStack.push( new Operand( token ));
        } 
        else {
          if ( ! Operator.check( token )) {
            System.out.println( "*****invalid token******" );
            throw new RuntimeException("*****invalid token******");
          }
          
                  
          
          //if operator is opening bracket. simply add it to the operator stack
          if(token.equals("(")){
              operatorStack.push(Operator.operators.get(token));
              continue;
          }
          
          //if operator is closing bracket. evaluate untill the opening bracket
          if(token.equals(")")){
             process();
             continue;
          }
          
          //System.out.println(operatorStack.size());

          // TODO Operator is abstract - these two lines will need to be fixed:
          // The Operator class should contain an instance of a HashMap,
          // and values will be instances of the Operators.  See Operator class
          // skeleton for an example.
          
          
          
          //initiliaze the new operator by current token
          Operator newOperator = Operator.operators.get(token);
          
          //apply the calculator process if operator stack is not empty
          if(!operatorStack.isEmpty()){
              //if the top operator at stack has greater or equal priority. do calculation
          while (!operatorStack.isEmpty() && operatorStack.peek().priority() >= newOperator.priority() ) {
            // note that when we eval the expression 1 - 2 we will
            // push the 1 then the 2 and then do the subtraction operation
            // This means that the first number to be popped is the
            // second operand, not the first operand - see the following code
            Operator oldOpr = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();
            operandStack.push( oldOpr.execute( op1, op2 ));
          }
          }

          operatorStack.push( newOperator );
        }
        
      }
    }

    // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks (except
    // the init operator on the operator stack); that is, we should keep
    // evaluating the operator stack until it only contains the init operator;
    // Suggestion: create a method that takes an operator as argument and
    // then executes the while loop.
    
   //after iterating over expression
   //if there is operator left in operator stack. then do the calculations
   //untill operator stack is empty
    while(!operatorStack.isEmpty()){
        Operator oldOpr = operatorStack.pop();
        Operand op2 = operandStack.pop();
        Operand op1 = operandStack.pop();
        operandStack.push( oldOpr.execute( op1, op2 ));
        
    }
  
    //this returns the result value of expression
    return operandStack.pop().getValue();
  }

  public void process(){
      
      
      //do the calculations untill the ( bracket with priority 0 appears.
      while(operatorStack.peek().priority()!=0){
          Operator oldOpr = operatorStack.pop();
          Operand op2 = operandStack.pop();
          Operand op1 = operandStack.pop();
          operandStack.push(oldOpr.execute(op1, op2));
      }
      //remove the opening bracket from expression too
     operatorStack.pop();
  }
}
