package newpackage;

public class Cash extends Payment{
    
    private double amount;  //amount paid by customer
    private double total;   //total to pay

    public Cash() {
    
    }
   
    public Cash(double amount, double total) {
        this.amount = amount;
        this.total = total;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    @Override
    public void PaymentMethod() {
        double change =  amount - total; 
        System.out.println("Change: RM "+ change);
    }
    
}