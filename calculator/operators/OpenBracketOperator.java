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
public class OpenBracketOperator extends Operator{

    // 0 priority to this operator.
    private final int PRIORITY = 0;

    @Override
    public int priority() {
        return PRIORITY;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        //no need of operation on this operator 
        return null;
    }
    
}
