package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException {

    /**
     * 
     */
    private static final long serialVersionUID = 7190620326792084901L;

    private final int receivedID;
    private final int expectedID;

    public WrongAccountHolderException(int receivedID, int expectedID) {
	super();
	this.receivedID = receivedID;
	this.expectedID = expectedID;
    }

    @Override
    public String toString() {
	return "Expected ID " + expectedID + " but " + receivedID + " found instead.";
    }

    public String getMessage() {
	return this.toString();
    }
}
