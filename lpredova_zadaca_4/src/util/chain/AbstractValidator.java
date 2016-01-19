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
public abstract class AbstractValidator {

    protected AbstractValidator nextValidator;
    protected String errorMsg;

    public void setNextValidator(AbstractValidator nextValidator) {
        this.nextValidator = nextValidator;
    }

    public abstract boolean validate(String[] args);
    abstract protected void write(String message);
}
