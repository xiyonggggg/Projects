package newpackage;

import java.util.Scanner;

public class Seat {

    private String[] seatNo;    // seat booked by customer 

    public Seat() {

    }

    public String[] getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String[] seatNo) {
        this.seatNo = seatNo;
    }

    public boolean[][] Seating(Schedule sc, int count) {
        Scanner myInput = new Scanner(System.in);
        boolean[][] seatArr = sc.getAvailableSeat();
        int rowChoose = 0;
        int colChoose;
        this.seatNo = new String[count];

        char c = 'A';
        System.out.print("\n       |Screen|\n\n  ");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println("");

        for (int i = 0; i < 5; i++) {
            System.out.print(c + " ");
            for (int j = 0; j < 10; j++) {
                if (seatArr[i][j] == false) {
                    System.out.print("o ");
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println("");
            c++;
        }
        System.out.println("");
        System.out.println("o - Available");
        System.out.println("x - Unavailable\n");

        int k = 0;
        for (int n = 0; n < count; n++) {
            boolean valid = false;
            while (valid == false) {

                System.out.println("Seat " + (n + 1) + ": ");
                
                //for row
                char row;
                do {

                    System.out.print("Select row (A - E): ");
                    String input = myInput.nextLine();
                    int length = input.length();

                    if (length == 1) {

                        row = input.charAt(0);
                        row = Character.toUpperCase(row);
                        if (row < 'A' || row > 'E') {

                            System.out.println("Please enter A - E only.");
                            row = 'F';
                        }

                    } else {
                        System.out.println("Please enter proper input.");
                        row = 'F';
                    }

                } while (row == 'F');

                //for column
                int col;
                do {
                    try {

                        System.out.print("Select column (1 - 10): ");
                        col = myInput.nextInt();
                        if (col < 1 || col > 10) {

                            System.out.println("Please enter 1 - 10 only.");
                            col = -1;
                        }

                    } catch (Exception e) {

                        System.out.println("Please enter proper input only.");
                        col = -1;
                        myInput.nextLine();
                    }
                } while (col == -1);

                switch (row) {
                    case 'A':
                        rowChoose = 0;
                        break;
                    case 'B':
                        rowChoose = 1;
                        break;
                    case 'C':
                        rowChoose = 2;
                        break;
                    case 'D':
                        rowChoose = 3;
                        break;
                    case 'E':
                        rowChoose = 4;
                    default:
                        break;
                }

                colChoose = col - 1;
                if (seatArr[rowChoose][colChoose] == true) {        
                    System.out.println("This seat has been choosen. Please choose another. ");

                } else {
                    valid = true;
                    seatArr[rowChoose][colChoose] = true;       //the boolean array is initially all false, if the seat is choosen, we set it to true
                    this.seatNo[k] = row + Integer.toString(col);
                    k++;
                }

                myInput.nextLine();

            }
            System.out.println("");
        }

        System.out.print("\nYour seat number is: ");
        for (int i = 0; i < count; i++) {
            System.out.print(this.seatNo[i] + " ");
        }
        return seatArr;
    }

}