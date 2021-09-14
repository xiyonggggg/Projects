package newpackage;

public class Schedule {

    private String date;        // show date
    private String time;        // show time
    private String showHall;    // hall showing that movie
    private boolean[][] availableSeat = new boolean[5][10];     // seat available for a particular schedule

    public Schedule() {
    }

    public Schedule(String date, String time, String showHall) {
        this.date = date;
        this.time = time;
        this.showHall = showHall;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShowHall() {
        return showHall;
    }

    public void setShowHall(String showHall) {
        this.showHall = showHall;
    }

    public boolean[][] getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(boolean[][] availableSeat) {
        this.availableSeat = availableSeat;
    }

    public boolean checkseatavailable() {
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 10; j++) {
                if (availableSeat[i][j] == false) {
                    return true;
                }

            }
        }
        return false;
    }

    public int countSeatAvailable() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (availableSeat[i][j] == false) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("%10s %10s %10s", date, time, showHall);
    }

}