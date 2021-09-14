package newpackage;

import java.util.*;

public class Booking {

    private static int bookCount = 1;  // count for bookingNo
    private String bookingNo;          // bookingNo that will generate automatically for each booking
    private Date bookingDate;
    private Customer customer;
    private Ticket[] custTicket;
    private double Total;        // Total amount to pay
    private int count;           // total seat needed
    private int AdQty;           // adult seat needed
    private int ChQty;           // children seat needed
    private int movieChoose;     // index for choosen movie (to put into movieArr)
    private int scheduleChoose;  // index for choosen schedule (to put into schedule for that movie)
    private Cash cash;
    private final CreditCard[] cc = {new CreditCard(11111111, "Lee Cheng Zhan", 111),
        new CreditCard(22222222, "Phua Lih Jang", 222)};

    ;

    public Booking() {
        this.bookingNo = "BK" + Integer.toString(bookCount);  // will become bk1, bk2, bk3, ...
        bookCount++;
        this.bookingDate = new Date();
        this.customer = new Customer();
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Ticket[] getCustTicket() {
        return custTicket;
    }

    public void setCustTicket(Ticket[] custTicket) {
        this.custTicket = custTicket;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getCount() {
        return count;
    }

    public int getAdQty() {
        return AdQty;
    }

    public int getChQty() {
        return ChQty;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAdQty(int AdQty) {
        this.AdQty = AdQty;
    }

    public void setChQty(int ChQty) {
        this.ChQty = ChQty;
    }

    public int getMovieChoose() {
        return movieChoose;
    }

    public void setMovieChoose(int movieChoose) {
        this.movieChoose = movieChoose;
    }

    public int getScheduleChoose() {
        return scheduleChoose;
    }

    public void setScheduleChoose(int scheduleChoose) {
        this.scheduleChoose = scheduleChoose;
    }

    public void setTicketSeatNo(Seat seatNo) {
        for (int i = 0; i < this.count; i++) {
            this.custTicket[i].setSeatNo(seatNo.getSeatNo()[i]);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return String.format("%-8s  %tB %<te, %<tY, %<tT %-5s %-6d %-6d RM %.2f", bookingNo, this.bookingDate, customer.toString(), AdQty, ChQty, Total);
    }

    public void BookMovie(Movie[] movieArr) {
        Scanner myscanner = new Scanner(System.in);

        // print movie shown 
        System.out.println("\nMovie Available:");
        for (int i = 0; i < movieArr.length; i++) {
            System.out.println((i + 1) + ". " + movieArr[i].getMovieName());
        }

        // select a movie to book
        int movie_choose = 0;
        do {
            try {
                System.out.print("Select a movie: ");
                movie_choose = myscanner.nextInt();
                if (movie_choose < 1 || movie_choose > movieArr.length + 1) {

                    System.out.println("Please enter valid integer.");
                    movie_choose = 0;

                } else {
                    setMovieChoose(movie_choose - 1);
                }
            } catch (Exception e) {
                System.out.println("Please enter proper input.");
                myscanner.nextLine();
            }
        } while (movie_choose == 0);

        // select a schedule for movie choosen
        System.out.println("\nSchedule of the Movie:");
        boolean checkseat;

        for (int i = 0; i < movieArr[this.movieChoose].getMovieSchedule().length; i++) {
            checkseat = movieArr[this.movieChoose].getMovieSchedule()[i].checkseatavailable();
            if (checkseat == true) {
                System.out.println((i + 1) + ". " + movieArr[this.movieChoose].getMovieSchedule()[i].toString() + " " + movieArr[this.movieChoose].getMovieSchedule()[i].countSeatAvailable() + " seat(s)");
            } else {
                System.out.println((i + 1) + ". " + movieArr[this.movieChoose].getMovieSchedule()[i].toString() + " [FULL]");
            }
        }
        int schedule_choose = 0;
        do {
            try {

                System.out.print("Select a schedule: ");
                schedule_choose = myscanner.nextInt();
                if (schedule_choose < 1 || schedule_choose > movieArr[movieChoose].getMovieSchedule().length) {

                    System.out.println("Please enter valid integer.");
                    schedule_choose = 0;
                } else {
                    setScheduleChoose(schedule_choose - 1);
                }
            } catch (Exception e) {
                System.out.println("Please enter proper input.");
                myscanner.nextLine();
            }
        } while (schedule_choose == 0);

        // print price for adult and child ticket
        Ticket.printTicketPrice();

        // get number of adult ticket(s) to book
        int adQty = -1;
        int chQty = -1;
        boolean validQty;

        do {
            do {
                try {

                    System.out.print("Quantity of Adult Ticket to book: ");
                    adQty = myscanner.nextInt();
                    if (adQty < 0) {

                        System.out.println("Do not enter negative number.");
                        adQty = -1;
                    } else {
                        setAdQty(adQty);
                    }

                } catch (Exception e) {
                    System.out.println("Please enter proper input.");
                    myscanner.nextLine();
                }
            } while (adQty == -1);

            // get number of child ticket(s) to book
            do {
                try {
                    System.out.print("Quantity of Child Ticket to book: ");
                    chQty = myscanner.nextInt();
                    if (chQty < 0) {

                        System.out.println("Do not enter negative number.");
                        chQty = -1;
                    } else {
                        setChQty(chQty);
                    }

                } catch (Exception e) {
                    System.out.println("Please enter proper input.");
                    myscanner.nextLine();
                }

            } while (chQty == -1);

            if (adQty + chQty > movieArr[this.movieChoose].getMovieSchedule()[this.scheduleChoose].countSeatAvailable()) {

                System.out.println("Not enough seats. Please enter again.\n");
                validQty = false;
            } else if (adQty + chQty == 0) {

                System.out.println("You didn't buy any ticket. Please buy at least 1 ticket.\n");
                validQty = false;

            } else {
                // set total seat booked
                this.count = (adQty + chQty);
                validQty = true;
            }

        } while (validQty == false);

        // set total amount need to pay
        this.Total = Ticket.calculatePrice(adQty, chQty);

        // declare Ticket array to print later 
        this.custTicket = new Ticket[count];
        for (int i = 0; i < count; i++) {
            this.custTicket[i] = new Ticket(movieArr[this.movieChoose], movieArr[this.movieChoose].getMovieSchedule()[this.scheduleChoose]);
        }

    }

    public int Pay(int choice) {

        Scanner myscanner = new Scanner(System.in);
        int input = 0;
        
        // choice 1 for cash, 2 for credit card
        switch (choice) {
            case 1: {
                double amt;
                do {
                    try {
                        System.out.print("\nEnter amount: RM ");
                        amt = myscanner.nextDouble();
                        if (amt < this.Total) {

                            System.out.printf("\nPlease enter exact amount or more than RM %.2f.", this.Total);
                            amt = 0;
                        } else {

                            cash = new Cash(amt, this.Total);
                            cash.PaymentMethod();
                            input = 0;
                        }

                    } catch (Exception e) {

                        System.out.println("Please enter proper amount.");
                        amt = 0;
                        myscanner.nextLine();
                    }

                } while (amt == 0);

                break;
            }

            case 2:

                int cardNo = 0,
                 cvv = 0;
                String name = "";
                boolean invalidInput;
                do {
                    try {
                        System.out.print("\nEnter Card Number      : ");
                        cardNo = myscanner.nextInt();
                        invalidInput = true;

                    } catch (Exception e) {

                        System.out.println("Invalid input.");
                        invalidInput = false;
                        myscanner.nextLine();
                    }
                } while (invalidInput == false);

                myscanner.nextLine();

                do {
                    try {
                        System.out.print("Enter CardHolder's Name: ");
                        name = myscanner.nextLine();
                        invalidInput = true;

                    } catch (Exception e) {

                        System.out.println("Invalid input.");
                        invalidInput = false;
                        myscanner.nextLine();
                    }
                } while (invalidInput == false);

                do {
                    try {
                        System.out.print("Enter CVV              : ");
                        cvv = myscanner.nextInt();
                        invalidInput = true;

                    } catch (Exception e) {

                        System.out.println("Invalid input.");
                        invalidInput = false;
                        myscanner.nextLine();
                    }
                } while (invalidInput == false);

                boolean valid = false;
                int ccCount;
                ccCount = 0;
                do {
                    valid = cc[ccCount].validity(cardNo, name, cvv);
                    ccCount++;
                } while (valid == false && ccCount < cc.length);

                if (valid == false) {
                    System.out.println("No such card.\n");
                    System.out.println("Payment unsuccessful. Please choose payment type again.");
                    input = 1;
                    //System.out.print("Type 1 to try again. Else exit Program.");

                } else {
                    System.out.println("Payment Succeed.");
                    input = 0;
                }

                break;

            default:
                System.out.println("Invalid input.Try again.");
                input = 1;
        }

        return input;
    }

    public void PrintTicket() {
        int n = 0;
        System.out.println("\nYour ticket(s) here.");
        for (int i = 0; i < this.AdQty; i++) {
            this.custTicket[n].PrintAdultTicket();
            n++;
        }

        for (int i = 0; i < this.ChQty; i++) {
            this.custTicket[n].PrintChildTicket();
            n++;
        }
    }
}
