/**
* Creates QuestNotFoundException extends Exception.
*
* @author iiisong
* @version 1.0.0
*/
public class QuestNotFoundException extends Exception {
    /**
     * Main Exception Constructor.
     *
     * @param msg error msg
     */
    public QuestNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Chain constructor.
     */
    public QuestNotFoundException() {
        this("Selected Quest Not Found");
    }
}
