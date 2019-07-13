/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import Evaluator.Operand;

/**
 *
 * @author haseeb
 */
public class CloseBracketOperator extends Operator{

    @Override
    public int priority() {
        //no need of priority for this operator. so assigned -1
        return -1;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        //no need to perform action for this operator
         return null;
    }
    
}
