package newpackage;

public class SalesReport {
    private double totalSales;      // Total amount sales
    private int totalBooking;       // Total booking  made
    private Booking[] allBooking;             

    public SalesReport() {
        
    }

    public SalesReport(Booking[] allBooking) {
        this.allBooking = allBooking;
        this.totalBooking = 0;
        this.totalSales = 0;
    }
    
    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalBooking() {
        return totalBooking;
    }

    public void setTotalBooking(int totalBooking) {
        this.totalBooking = totalBooking;
    }

    public Booking[] getAllBooking() {
        return allBooking;
    }

    public void setAllBooking(Booking[] allBooking) {
        this.allBooking = allBooking;
    }
    
    @Override
    public String toString() {
        return "";
    }
    
    public void PrintReport(int count){
        this.totalSales=0;
        this.totalBooking=0;
        System.out.println("\nSales Report");
        System.out.println("------------");
        System.out.printf("%-3s %-9s %-27s %-18s %-12s %-6s %-6s %-6s\n", "No.", "Book No.", "Date and Time", "Customer Name", "Phone No.", "Adult", "Child", "Total");
        System.out.printf("%-3s %-9s %-27s %-18s %-12s %-6s %-6s %-6s\n", "---", "--------", "-------------", "-------------", "---------", "-----", "-----", "-----");
        for(int i = 0;i<count;i++){
            System.out.printf("%2d. %s\n",(i+1), allBooking[i].toString());
            totalSales += allBooking[i].getTotal();
            totalBooking ++ ;
        }
        System.out.println("\nTotal Sales   : RM "  + this.totalSales);
        System.out.println("Total Booking : " + this.totalBooking);
    }
}