/**
* Creates FilmNotFoundException.
*
* @author iiisong
* @version 1.0.0
*/
public class FilmNotFoundException extends Exception {
    /**
     * Exception Constructor.
     *
     * @param movie movie is not playing
     */
    public FilmNotFoundException(String movie) {
        super(movie + " is not playing at this movie theater.");
    }
}
