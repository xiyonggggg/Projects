package newpackage;

public class CreditCard extends Payment {

    private int cardNo;
    private String name;
    private int CVV;
    private static double amount = 0;

    public CreditCard() {
        
    }  
    
    public CreditCard(int cardNo, String name, int CVV) {
        this.cardNo = cardNo;
        this.name = name;
        this.CVV = CVV;
    }

    public boolean validity(int cardNo, String name, int cvv) {
        if (cardNo == this.cardNo) {
            if (name.equals(this.name)) {
                if (cvv == this.CVV) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void PaymentMethod() {
        System.out.println("Payment done.");
    }

}