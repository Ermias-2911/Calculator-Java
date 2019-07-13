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
public class DivisionOperator extends Operator{
    //division priority defined
    private final int PRIORITY = 2;

    @Override
    public int priority() {
        return PRIORITY;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        //divides the two parameters and returns result
        return new Operand(op1.getValue() / op2.getValue());
    }
    
}
