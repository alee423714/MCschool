package lab;

public class SavingsAccount extends BankAccount {
	/** The annual interest rate (2.5% or 0.025) */
	private double rate = 0.025;

	/** Counter for the number of savings accounts for a given account number */
	private int savingsNumber = 0;

	/**
	 * Hides the accountNumber field inherited from BankAccount.
	 * This instance variable will store the full, formatted account number.
	 */
	private String accountNumber;

	/**
	 * Constructor that takes a name and an initial balance.
	 * Calls the superclass constructor and sets the initial savings account number.
	 *
	 * @param name the owner of the account
	 * @param amount the beginning balance
	 */
	public SavingsAccount(String name, double amount) {
		super(name, amount);
		// Get the accountNumber from the superclass (the hidden one)
		String superAccountNumber = super.getAccountNumber();
		// Initialize the local, hidden accountNumber field
		this.accountNumber = superAccountNumber + "-" + savingsNumber;
	}

	/**
	 * Copy constructor that creates another savings account for the same person.
	 *
	 * @param oldAccount the original savings account
	 * @param amount the beginning balance of the new account
	 */
	public SavingsAccount(SavingsAccount oldAccount, double amount) {
		// Call the copy constructor of the superclass
		super(oldAccount, amount);

		// Assign the rate
		this.rate = oldAccount.rate;

		// Assign savingsNumber to be one more than the original account's savingsNumber
		this.savingsNumber = oldAccount.savingsNumber + 1;

		// The superclass's constructor sets its accountNumber (which is unique for the owner).
		// We re-assign the local, hidden accountNumber using the superclass's account number
		// (which is the unique owner number) and the new savingsNumber.
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
	}

	/**
	 * Calculates one month's worth of interest on the balance and deposits it.
	 * Interest = (Balance * Annual Rate) / 12
	 */
	public void postInterest() {
		// Calculate one month's interest
		double interest = (getBalance() * rate) / 12.0;
		// Deposit the interest (using the inherited deposit method)
		deposit(interest);
	}

	/**
	 * Overrides the getAccountNumber method in the superclass.
	 * It returns the hidden accountNumber field of the SavingsAccount class.
	 *
	 * @return the full, formatted savings account number
	 */
	@Override
	public String getAccountNumber() {
		return this.accountNumber;
	}
}