package newpackage;

public class MovieList {

    private static int count = 0;        // total movie available
    private Movie[] movieArr;          

    public MovieList() {

    }

    public MovieList(Movie[] movieArr) {
        this.movieArr = movieArr;
    }

    public int getCount() {
        return count;
    }

    public Movie[] getMovieArr() {
        return movieArr;
    }

    public void setMovieArr(Movie[] movieArr) {
        this.movieArr = movieArr;
    }

    // Movie(s) that shown in our theater
    public void PrintMovieList() {
        this.count = 0;
        System.out.println("\nMovie List:");

        for (int i = 0; i < movieArr.length; i++) {

            System.out.println((i + 1) + ". " + movieArr[i].toString());
            System.out.println("");
            count++;
        }
        System.out.println("Total Movie: " + count);
    }

    public static Movie[] selectionSort(Movie[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            Movie temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

}