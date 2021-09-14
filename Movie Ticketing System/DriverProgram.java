package newpackage;

import java.util.*;

public class DriverProgram {

    protected static Staff admin = new Staff("S0001", "admin", "Super Admin", "Admin_1", 50, 123456789, 'M', "012-3456789");

    protected static Schedule[] movie1Schedule = {new Schedule("5/9/2020", "20:00", "Hall 1"),
        new Schedule("5/9/2020", "22:00", "Hall 2")};

    protected static Schedule[] movie2Schedule = {new Schedule("5/9/2020", "20:00", "Hall 3"),
        new Schedule("5/9/2020", "22:00", "Hall 4")};

    protected static Schedule[] movie3Schedule = {new Schedule("5/9/2020", "20:00", "Hall 5"),
        new Schedule("5/9/2020", "22:00", "Hall 6")};

    protected static Schedule[] movie4Schedule = {new Schedule("5/9/2020", "20:00", "Hall 7"),
        new Schedule("5/9/2020", "22:00", "Hall 8")};

    protected static Schedule[] movie5Schedule = {new Schedule("5/9/2020", "20:00", "Hall 9 "),
        new Schedule("5/9/2020", "22:00", "Hall 10")};

    protected static Movie[] movieArr = {new Movie("Tenant", "A secret agent embarks on a dangerous, time-bending mission to prevent the start of World War III.", "2.5 hours", "Christopher Nolan", "Science Fiction", movie1Schedule),
        new Movie("Joker", "Forever alone in a crowd, failed comedian Arthur Fleck seeks connection as he walks the streets of Gotham City.", "2 hours", "Todd Phillips", "Psychological Thriller", movie2Schedule),
        new Movie("Mulan", "A fearless young woman disguises herself as a man to battle northern invaders in China.", "2 hours", "Niki Caro", "Action", movie3Schedule),
        new Movie("Peninsula", "A soldier and his team battle hordes of post-apocalyptic zombies in the wastelands of the Korean Peninsula.", "2 hours", "Yeon Sang-ho", "Action", movie4Schedule),
        new Movie("Takut Ke Tak", "It tells the story of five university students who shoots an authentic horror movie in a haunted house.", "1.5 hours", "Muzzamer Rahman", "Comedy/Horror", movie5Schedule)};

    protected static MovieList movieList = new MovieList(movieArr);

    protected static Booking[] booking = new Booking[100];
    protected static SalesReport SR = new SalesReport(booking);
    private static int count = 0;

    public static void main(String[] args) {

        boolean contd = true;
        do {
            try {
                int choice = MainMenu();
                switch (choice) {
                    case 1:
                        stafflogin();
                        break;
                    case 2:
                        newbooking();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid input. Try Again.");
                }
            } catch (Exception e) {
                System.out.println("Please enter proper input.");
            }

        } while (contd == true);
    }

    public static int MainMenu() {
        System.out.println("");
        System.out.println("     =============================");
        System.out.println("     ||       TARCINEMAX        ||");
        System.out.println("     =============================");
        System.out.println("Please enter integer 1, 2 or 3");
        System.out.println("1. Admin");
        System.out.println("2. Book Ticket");
        System.out.println("3. Exit");

        Scanner myscanner = new Scanner(System.in);

        System.out.print("Please enter your choice: ");
        int choice = myscanner.nextInt();
        return choice;
    }

    public static void stafflogin() {
        Scanner myscanner = new Scanner(System.in);
        String password;
        do {
            System.out.print("Please enter the password :");
            password = myscanner.nextLine();
            if (password.equals(admin.getPassword()) == false) {
                System.out.println("Incorrect Password. Please enter again.");
            }
        } while (password.equals(admin.getPassword()) == false);

        int input;

        do {
            do {
                try {
                    System.out.println("\n\n*************************");
                    System.out.println("       STAFF LOGIN       ");
                    System.out.println("*************************");
                    System.out.println("1. View Movie List");
                    System.out.println("2. View Sales Report");
                    System.out.println("3. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    input = myscanner.nextInt();

                    if (input < 1 || input > 3) {

                        System.out.println("Please enter valid integer.");
                        myscanner.nextLine();
                        input = 0;

                    }

                } catch (Exception e) {

                    System.out.println("Please enter valid input.");
                    input = 0;
                    myscanner.nextLine();
                }
            } while (input == 0);

            switch (input) {

                case 1: {
                    movieArr = MovieList.selectionSort(movieArr);

                    movieList.PrintMovieList();
                    break;
                }
                case 2: {
                    SR.PrintReport(count);
                    break;
                }
                
            }
        } while (input != 3);

    }

    public static void newbooking() {
        Scanner myscanner = new Scanner(System.in);
        char contd = 'y';
        do {
            booking[count] = new Booking();
            System.out.println("\nCustomer's Details");
            System.out.println("-----------------------");
            System.out.print("Enter name: ");
            String name = myscanner.nextLine();
            System.out.print("Enter H/P No.: ");
            String phoneNo = myscanner.nextLine();
            Customer cust = new Customer(name, phoneNo);
            booking[count].setCustomer(cust);
            booking[count].BookMovie(movieArr);   // call method from Booking class to make a new booking

            // call method from Seat to get seat number to book 
            Seat seatNo = new Seat();
            movieArr[booking[count].getMovieChoose()].getMovieSchedule()[booking[count].getScheduleChoose()].setAvailableSeat(seatNo.Seating(movieArr[booking[count].getMovieChoose()].getMovieSchedule()[booking[count].getScheduleChoose()], booking[count].getCount()));
            booking[count].setTicketSeatNo(seatNo);

            // print total amount to pay
            System.out.printf("\nTotal: RM %.2f\n", +booking[count].getTotal());

            // select payment method
            int payChoice;
            do {
                System.out.println("\nSelect Payment Type: ");
                System.out.println("1. Cash");
                System.out.println("2. Credit Card");
                System.out.print("Enter your choice: ");
                try {
                    payChoice = myscanner.nextInt();
                    payChoice = booking[count].Pay(payChoice);

                } catch (Exception e) {

                    System.out.println("Invalid input. Please reenter again.");
                    payChoice = 1;
                    myscanner.nextLine();
                }

            } while (payChoice == 1);

            // after payment done, print ticket
            booking[count].PrintTicket();
            count++;

            // ask for another new booking
            do {
                System.out.print("Another booking?(y/n) ");
                contd = myscanner.next().charAt(0);
                contd = Character.toLowerCase(contd);
            } while (contd != 'y' && contd != 'n');
            myscanner.nextLine();
        } while (contd == 'y');

    }
}
