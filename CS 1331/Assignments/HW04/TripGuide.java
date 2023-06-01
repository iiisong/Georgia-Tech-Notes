/**
* Creates TripGuide as driver.
*
* @author iiisong
* @version 1
*/
public class TripGuide {
    /**
     * Main test driver.
     *
     * @param args console.
     */
    public static void main(String[] args) {
        Attraction[] atts = {new Attraction("fee", 5.0), new Attraction("fi", 5.0), new Museum("fo", 5.0, 10),
                                new Attraction("fa", 3.0), new Museum("fo", 2.0, 30)};

        String[] names1 = {"Adam", "Ben", "Cade", "Dan"};
        String[] names2 = {"Egg", "Milk", "Yogurt", "Bread", "Jam"};
        String[] names3 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"};
        String[] names4 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                              "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"};

        String[][] namesList = {names1, names2, names3, names4};

        for (Attraction att : atts) {
            for (String[] names : namesList) {
                att.admit(names);
                att.printVisitors();
                System.out.println("");
            }
            System.out.println("=======\n");
        }

        atts[0].rateAndExit(0, 5);
        atts[1].rateAndExit(0, 5);
        System.out.println(atts[0].compareTo(atts[1]));

        atts[2].rateAndExit(0, 11);
        atts[3].rateAndExit(1, -1);
        System.out.println(atts[2].compareTo(atts[3]));


        for (Attraction att : atts) {
            System.out.println(att.toString());
            att.printVisitors();
            System.out.println("======================");
        }

        System.out.println(atts[0].compareTo(atts[1]));
        System.out.println(atts[0].compareTo(atts[2]));

        int[] test = new int[3];
        test[1] = 3;
        System.out.println(test.length);

    }
}
