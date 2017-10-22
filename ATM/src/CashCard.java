import java.util.Date;

/**
 * A class that represents a single cash card.
 * 
 * @author 		Priscilla Ng
 * @copyright	10/2/2017
 * @version		1.0
 * 
 */
public class CashCard {
	private String bankID;			// The bank's ID that this card belongs to
    private String cardNumber;
    private Date expirationDate;

    /**
     * Constructs a cash card with an associated bank ID, card number, and expiration date.
     * @param bankID			the ID of the bank that this card is connected to
     * @param cardNumber		the card number of this card card
     * @param expirationDate	the date that this cash card expires
     */
    public CashCard(String bankID, String cardNumber, Date expirationDate){
    	this.bankID = bankID;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }
    
    /**
     * Gets the bank ID that this card is connected to.
     * @return	the bank ID of this cash card
     */
    public String getBankID() {
    	return this.bankID;
    }
    
    /**
     * Gets the card number of this cash card.
     * @return	the card number of this cash card
     */
    public String getCardNumber(){
        return cardNumber;
    }
    
    /**
     * Gets the expiration date of this cash card in the form YYYY-MM-DD.
     * @return	the expiration date of this cash card in the form YYYY-MM-DD
     */
    public Date getExpirationDate(){
        return expirationDate;
    }
}