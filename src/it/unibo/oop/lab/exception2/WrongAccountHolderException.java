package it.unibo.oop.lab.exception2;

//state "holder" not corresponding to the account holder 
public class WrongAccountHolderException extends IllegalStateException {

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
