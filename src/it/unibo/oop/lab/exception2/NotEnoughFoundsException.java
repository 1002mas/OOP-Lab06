package it.unibo.oop.lab.exception2;

//the state "balance" was not ready for the operation
public class NotEnoughFoundsException extends IllegalStateException {
    /**
     * 
     */
    private static final long serialVersionUID = -532392001206190885L;

    private final double amountLeft;

    public NotEnoughFoundsException(double amountLeft) {
	super();
	this.amountLeft = amountLeft;
    }

    @Override
    public String toString() {
	return "Not enough found to complete the operation. Amount left: " + amountLeft;
    }

    @Override
    public String getMessage() {
	return this.toString();
    }

}
