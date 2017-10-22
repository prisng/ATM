import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A class that represents an ATM.
 * 
 * @author 		Priscilla Ng
 * @copyright	10/2/2017
 * @version		1.0
 * 
 */
public class ATM {
	private Bank associatedBank;	// The associated bank with this ATM
	private int maxWithdrawAmount;	// The max amount of money that can be withdrawn from this ATM
	
	/**
	 * Constructs an ATM with its associated bank and a maximum withdrawal amount
	 * @param associatedBank		the bank that this ATM is associated with
	 * @param maxWithdrawAmount		the maximum amount that can be withdrawn from this ATM
	 */
	public ATM(Bank associatedBank, int maxWithdrawAmount) {
		this.associatedBank = associatedBank;
		this.maxWithdrawAmount = maxWithdrawAmount;
	}
	
	/**
	 * Gets the bank associated with this ATM.
	 * @return	the bank associated with this ATM
	 */
	public Bank getAssociatedBank() {
		return this.associatedBank;
	}
	
	/**
	 * Checks if the bank associated with this ATM has the valid cash card entered.
	 * @param cashCard	the cash card to be validated
	 * @return			true if the cash card exists with this ATM's associated bank and has not expired
	 * 					false if the cash card does not exist or if the cash card has expired
	 */
	public boolean validateCard(String cashCard) {
		if (this.associatedBank.validateAccount(cashCard) != null) {
			BankAccount acc = this.associatedBank.validateAccount(cashCard);
			CashCard card = acc.getAssociatedCashCard();
			if (checkExpiration(card) == true) {
				System.out.println("This card is expired and returned to you.");
				return false;
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Authorizes the entered cash card with its password.
	 * @param cashCard	the cash card to be authorized
	 * @param password	the password of the cash card to be checked
	 * @return			true if the cash card's password is @param password
	 * 					false if the cash card's password is not equal to @param password
	 */
	public boolean authorizeCard(String cashCard, String password) {
		BankAccount acc = this.associatedBank.validateAccount(cashCard);
		if (acc.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks whether or not a cash card is expired.
	 * @param card	the cash card to be checked
	 * @return		true if the cash card's expiration date is today or before today's date
	 * 				false if the cash card's expiration date is beyond today's date
	 */
	public boolean checkExpiration(CashCard card) {
		Date expirationDate = card.getExpirationDate();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date todaysDate = new Date();
		dateFormat.format(todaysDate);
		if (expirationDate.before(todaysDate)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Sends a withdraw request to the bank associated with this ATM.
	 * If the amount entered is greater than this ATM's max withdrawal amount, sends an error message.
	 * @param account	the bank account requested to be withdrawn from
	 * @param amount	the amount requested to be withdrawn
	 */
	public void withdrawRequest(BankAccount account, double amount) {
		if (amount <= this.maxWithdrawAmount) {
			associatedBank.withdraw(account, amount);
		}
		else if (amount > account.getBalance()) {
			System.out.println("Insufficient funds in your bank account for this transaction. Please enter the amount or quit.");
		}
		else {
			System.out.println("This amount exceeds the maximum amount you can withdraw per transaction.");
		}
	}
	
	/**
	 * Gets the state of this ATM.
	 * Prints the ATM's associated bank and the maximum withdrawal amount of this ATM.
	 */
	public void getStateOfATM() {
		System.out.println("ATM from Bank " + this.getAssociatedBank().getId());
		System.out.println("\tThe maximum amount that a cash card can withdraw per transaction: " + "$" + this.maxWithdrawAmount + ".00");
	}
}