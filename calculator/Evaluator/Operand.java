package Evaluator;

public class Operand {
    //this value represents the value of this operand
    private int value;

    //initializes the integer value from string token
  public Operand( String token ) {
      value = Integer.parseInt(token);
  }

  //initializes the instance value of class
  public Operand( int value ) {
       this.value = value;
  }

  //returns the value variable of class
  public int getValue() {
      return value;
  }

  public static boolean check( String token ) {
      //returns true only if the token is digit from 0-9
      return Character.isDigit(token.charAt(0));
  }
}
