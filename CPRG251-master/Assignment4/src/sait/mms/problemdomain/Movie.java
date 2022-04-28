package sait.mms.problemdomain;

/**
 * Movie class that creates new Movie objects and manages the attributes of the objects
 * @author Allyssa Preece
 * @author Anusone Soula
 * @author Aiden Kopec
 *
 * @version April 13, 2022
 */
public class Movie {
    private int duration;
    private String title;
    private int year;

    /**
     * Gets the duration of the movie
     * @return the duration of the movie
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the movie
     * @param duration the duration of the movie
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets the title of the movie
     * @return the title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of hte movie
     * @param title the title of the movie
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the year the movie was released
     * @return the year was released
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year that the movie was released
     * @param year the year the movie was released
     */
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "duration=" + duration +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
