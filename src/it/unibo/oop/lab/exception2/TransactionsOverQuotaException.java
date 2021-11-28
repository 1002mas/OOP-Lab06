package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

    /**
     * 
     */
    private static final long serialVersionUID = 8793893516725356934L;
    
    private final int totalTransactionCount;
    private final int maximumAllowedATMTransactions;

    public TransactionsOverQuotaException(int totalTransactionCount, int maximumAllowedATMTransactions) {
	super();
	this.totalTransactionCount = totalTransactionCount;
	this.maximumAllowedATMTransactions = maximumAllowedATMTransactions;
    }

    @Override
    public String toString() {
	return "Executed " + totalTransactionCount + "operations. Max allowed transactions: "
		+ maximumAllowedATMTransactions;
    }

    public String getMessage() {
	return this.toString();
    }
}
