/**
* Creates InvalidPartyMemberException extends Exception.
*
* @author iiisong
* @version 1.0.0
*/
public class InvalidPartyMemberException extends RuntimeException {
    /**
     * Main Exception Constructor.
     *
     * @param msg error msg
     */
    public InvalidPartyMemberException(String msg) {
        super(msg);
    }

    /**
     * Chain constructor.
     */
    public InvalidPartyMemberException() {
        this("Invalid Party Member!");
    }
}
