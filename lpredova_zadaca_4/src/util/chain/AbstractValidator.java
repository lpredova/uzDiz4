/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.chain;

/**
 *
 * @author lovro
 */
abstract class AbstractValidator {

    protected AbstractValidator nextValidator;
    protected String errorMsg;

    public void setNextLogger(AbstractValidator nextValidator) {
        this.nextValidator = nextValidator;
    }

    abstract protected void write(String message);

}
