import java.util.HashSet;

/**
 * A class that represents a bank.
 * 
 * @author 		Priscilla Ng
 * @copyright	10/2/2017
 * @version		1.0
 * 
 */
public class Bank {
	private String id;						// This bank's ID
	private HashSet<BankAccount> accounts;	// Each customer's respective bank account within this bank
	
	/**
	 * Constructs a bank with an ID.
	 * @param id		the ID of the bank
	 */
	public Bank(String id) {
		this.id = id;
		this.accounts = new HashSet<BankAccount>();
	}
	
	/**
	 * Gets the ID for this bank.
	 * @return		the ID of this bank
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Adds a new bank account to this bank.
	 * @param account	the bank account to be added
	 */
	public void addBankAccount(BankAccount account) {
		accounts.add(account);
	}
	
	/**
	 * Validates if a cash card exists in the bank accounts of this bank.
	 * @param cardNumber	the number of the cash card to be checked
	 * @return				the bank account that the cash card belongs to
	 */
	public BankAccount validateAccount(String cardNumber) {
		BankAccount acc = null;
		for (BankAccount account : accounts) {
			if (account.getAssociatedCashCard().getCardNumber().toLowerCase().equals(cardNumber)) {
				return account;
			}
		}
		return acc;
	}
	
	/**
	 * Withdraws money and logs the transaction with the bank account specified.
	 * Sends error messages if the amount is negative, or if there are insufficient funds.
	 * @param account	the bank account to withdraw from
	 * @param amount	the amount to withdraw
	 */
	public void withdraw(BankAccount account, double amount) {
		if (amount < 0) {
			System.out.println("Invalid input. Re-enter the amount to withdraw.");
			return;
		}
		if (account.getBalance() >= amount) {
			System.out.print("Withdraw successful. ");
			System.out.printf("$%.2f", amount);
			System.out.print(" withdrawn from your account.\n");
			account.setBalance(account.getBalance() - amount);
		}
		else {
			System.out.println("Insufficient funds in your bank account for this transaction. Please enter the amount or quit.");
		}
	}
	
	/**
	 * Gets the state of this bank (each bank account in this bank)
	 * Prints each customer's bank ID, account ID, cash card expiration date, and password.
	 */
	public void getStateOfBank() {
		int i = 1;
		// Prints the state of all the accounts of this bank account
		for (BankAccount account : accounts) {
			System.out.println("Customer " + i + " with Cash Card: ");
			System.out.println("\tBank ID: " + account.getAssociatedBank().getId());
			System.out.println("\tAccount ID: " + account.getAssociatedCashCard().getCardNumber());
			System.out.println("\tExpiration date: " + account.getAssociatedCashCard().getExpirationDate());
			System.out.println("\tPassword : " + account.getPassword());
			i++;
		}
	}
	
}