package lab;

public class CheckingAccount extends BankAccount {
	/** Cost of clearing one check (15 cents) */
	public static final double FEE = 0.15;

	/**
	 * Constructor that takes a name and an initial amount.
	 * Calls the superclass constructor and sets the checking account specific
	 * account number.
	 *
	 * @param name the owner of the account
	 * @param amount the beginning balance
	 */
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		// accountNumber is private in BankAccount, so we use the mutator method
		setAccountNumber(getAccountNumber() + "-10");
	}

	/**
	 * Overrides the withdraw method to add the check clearing fee.
	 *
	 * @param amount the amount to withdraw from the account
	 * @return true if there was sufficient funds to complete the transaction, false otherwise
	 */
	@Override
	public boolean withdraw(double amount) {
		// Calculate the total withdrawal amount including the fee
		double totalWithdrawal = amount + FEE;

		// Call the withdraw method from the superclass (BankAccount)
		return super.withdraw(totalWithdrawal);
	}
}
