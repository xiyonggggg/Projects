package newpackage;

public class Ticket {

    private Movie movie;        
    private Schedule schedule;
    private String seatNo;      // seat choosen 
    private static double price = 10.00;      // price of an adult ticket(20% discount for child)

    public Ticket() {

    }

    public Ticket(Movie movie, Schedule schedule) {
        this.movie = movie;
        this.schedule= schedule;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public static double getAdultPrice() {
        return price;
    }

    public static double getChildPrice() {
        return price * 0.8;
    }

    public static void printTicketPrice() {
        System.out.println("");
        System.out.println("Price List:");
        System.out.printf("%-10s %-1s\n","Category", "Price");
        System.out.printf("%-10s %-1s\n","--------", "-----");
        System.out.printf("%-10s RM %.2f \n","Adult",getAdultPrice());
        System.out.printf("%-10s RM %.2f \n","Child", getChildPrice());
    }

    public static double calculatePrice(int adQty, int chQty) {
        return getAdultPrice() * adQty + getChildPrice() * chQty;
    }
    
    public void PrintAdultTicket() {
        System.out.println("=============================================");
        System.out.println("Movie Name: " + this.movie.getMovieName());
        System.out.println("Schedule: " + this.schedule.toString());
        System.out.println("Adult Seat");
        System.out.println("Seat No: " + this.seatNo);
        System.out.println("=============================================");
    }

    public void PrintChildTicket() {
        System.out.println("=============================================");
        System.out.println("Movie Name: " + this.movie.getMovieName());
        System.out.println("Schedule: " + this.schedule.toString());
        System.out.println("Child Seat");
        System.out.println("Seat No: " + this.seatNo);
        System.out.println("=============================================");
    }
}