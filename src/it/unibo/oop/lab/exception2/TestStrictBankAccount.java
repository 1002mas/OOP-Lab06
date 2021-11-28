package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * JUnit test to test {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
	/*
	 * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a scelta,
	 * con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
	 * 
	 * 2) Effetture un numero di operazioni a piacere per verificare che le
	 * eccezioni create vengano lanciate soltanto quando opportuno, cioè in presenza
	 * di un id utente errato, oppure al superamento del numero di operazioni ATM
	 * gratuite.
	 */
	StrictBankAccount usr1 = new StrictBankAccount(1, 10000, 10);
	StrictBankAccount usr2 = new StrictBankAccount(2, 10000, 10);
	try {
	    //WrongAccountHolderException
	    usr1.deposit(5, 1000);
	    //TransactionsOverQuotaException
	    for (int i = 0; i < 100; i++) {
		usr2.withdrawFromATM(2, 1);
	    }
	    //NotEnoughFoundsException
	    usr1.withdraw(1, 50000);
	} catch (WrongAccountHolderException e) {
	    assertNotNull(e.getMessage());
	    assertFalse(e.getMessage().isEmpty());
//	    e.printStackTrace();
	} catch (TransactionsOverQuotaException e1) {
	    assertNotNull(e1.getMessage());
	    assertFalse(e1.getMessage().isEmpty());
//	    e1.printStackTrace();
	} catch (NotEnoughFoundsException e2) {
	    assertNotNull(e2.getMessage());
	    assertFalse(e2.getMessage().isEmpty());
//	    e2.printStackTrace();

	}
    }
}
