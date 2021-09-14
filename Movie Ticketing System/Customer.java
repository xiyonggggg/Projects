package newpackage;

public class Customer extends Person {

    public Customer() {
        
    }

    public Customer(String Name, String PhoneNo) {
        super(Name, PhoneNo);
    }

    @Override
    public String toString() {
        return String.format("%-18s %-12s", super.getName(), super.getPhoneNo());
    }
}