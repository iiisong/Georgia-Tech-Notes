/**
* Creates Groups.
*
* @author iiisong
* @version 1
*/
public class Group {
    private final String[] people;

    /**
     * Constructor.
     *
     * @param people array of people in group
     */
    public Group(String[] people) {
        if (people == null) {
            this.people = new String[0];
            return;
        }

        this.people = people.clone();
    }


    /**
     * gets size of group.
     *
     * @return size of group
     */
    public int size() {
        for (int i = 0; i < people.length; i++) {
            if (people[i] == null) {
                return i;
            }
        }

        return people.length;
    }

    @Override
    public String toString() {
        return String.join("/", people);
    }
}