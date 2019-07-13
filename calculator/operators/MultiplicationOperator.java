/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import Evaluator.Operand;

/**
 *
 * @author newuser
 */
public class MultiplicationOperator extends Operator{

    //defines the priority of this operator
    private final int PRIORITY = 2;

    @Override
    public int priority() {
        return PRIORITY;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        //applies the supposed operation to the parameters
        return new Operand(op1.getValue() * op2.getValue());
    }
    
}
