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
public class PowerOperator extends Operator{
    //defining priority
    private final int PRIORITY = 3;

    @Override
    public int priority() {
        return PRIORITY;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
       //applying the power formula from math class
       //returning the result in integer format
        return new Operand((int)Math.round(Math.pow(op1.getValue(), op2.getValue())));
    }
    
}
