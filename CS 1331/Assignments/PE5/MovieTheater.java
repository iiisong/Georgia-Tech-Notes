import java.util.ArrayList;

/**
* Creates MovieTheater.
*
* @author iiisong
* @version 1.0.0
*/
public class MovieTheater {
    private ArrayList<String> movies;
    private ArrayList<String> watched;

    /**
     * MovieTheater Cosntructor.
     *
     * @param movies movies showing
     * @param watched movies watched
     */
    public MovieTheater(ArrayList<String> movies, ArrayList<String> watched) {
        this.movies = new ArrayList<>(movies);
        this.watched = new ArrayList<>(watched);
    }

    /**
     * throws if movie missing.
     *
     * @param interestingMovies list of movies to check for
     * @throws FilmNotFoundException throws excpetion when movie not found
     */
    public void throwIfMoviesMissing(ArrayList<String> interestingMovies) throws FilmNotFoundException {
        for (String movie : interestingMovies) {
            if (!movies.contains(movie)) {
                throw new FilmNotFoundException(movie);
            }
        }
    }

    /**
     * Watch movie.
     *
     * @param movie movie to watch
     * @throws AlreadyWatchedException already watched movie
     * @throws FilmNotFoundException movie not found
     */
    public void watchMovie(String movie) throws AlreadyWatchedException, FilmNotFoundException {
        if (watched.contains(movie)) {
            throw new AlreadyWatchedException();
        }

        if (!movies.contains(movie)) {
            throw new FilmNotFoundException(movie);
        }

        movies.remove(movie);
        watched.add(movie);
    }

    /**
     * adds movies that are showing and havent been seen.
     *
     * @param recommendedMovies recommended movies
     * @return list of movies to see
     */
    public ArrayList<String> selectRecommended(ArrayList<String> recommendedMovies) {
        ArrayList<String> willSee = new ArrayList<>();
        for (String movie : recommendedMovies) {
            if (movies.contains(movie) || watched.contains(movies)) {
                willSee.add(movie);
            }
        }

        return willSee;
    }

    /**
     * main testing.
     *
     * @param args console input
     */
    public static void main(String[] args) {
        ArrayList<String> movies = new ArrayList<>();
        movies.add("RHPS");
        movies.add("Jaws");
        movies.add("Star Wars");
        movies.add("Apocalypse Now");
        movies.add("Lebowski");

        ArrayList<String> watched = new ArrayList<>();
        watched.add("Totoro");
        watched.add("Kiki's");

        MovieTheater mt = new MovieTheater(movies, watched);

        try {

            ArrayList<String> interesting = new ArrayList<>();
            interesting.add("RHPS");
            interesting.add("Lebowski");
            // interesting.add("Forrest Gump"); // FilmNotFoundException

            mt.throwIfMoviesMissing(interesting);

            mt.watchMovie("Jaws");
            // mt.watchMovie("Jaws"); // AlreadyWatchedException
            // mt.watchMovie("Casablanca"); // FilmNotFoundException

            ArrayList<String> recced = new ArrayList<>();
            recced.add("Aladdin");
            recced.add("Cinderella");
            recced.add("Star Wars");
            mt.selectRecommended(recced);

        } catch (FilmNotFoundException | AlreadyWatchedException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Took a look at the movies!");
        }
    }
}
