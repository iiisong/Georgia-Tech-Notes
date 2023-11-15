/**
* Creates AlreadyWatchedExcpetion.
*
* @author iiisong
* @version 1.0.0
*/
public class AlreadyWatchedException extends RuntimeException {
    /**
     * Exception Constructor.
     */
    public AlreadyWatchedException() {
        super("You've already seen this movie here!");
    }
}
