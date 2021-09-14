package newpackage;

public class Movie implements Comparable {

    private String movieName;
    private String Description;
    private String duration;
    private String director;
    private String movieType;
    private Schedule[] movieSchedule;

    public Movie() {

    }

    public Movie(String movieName, String Description, String duration, String director, String movieType, Schedule[] movieSchedule) {
        this.movieName = movieName;
        this.Description = Description;
        this.duration = duration;
        this.director = director;
        this.movieType = movieType;
        this.movieSchedule = movieSchedule;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDuration() {
        return duration;
    }

    public Schedule[] getMovieSchedule() {
        return movieSchedule;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public void setMovieSchedule(Schedule[] movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    @Override
    public int compareTo(Object o) {
        Movie movie = (Movie) o;
        return movieName.compareTo(movie.movieName);
    }

    @Override
    public String toString() {
        return  movieName + "\n------------------" + "\nDescription: " + Description + "\nDuration: " + duration + "\nDirector: " + director + "\nMovie Type: " + movieType;
    }

}