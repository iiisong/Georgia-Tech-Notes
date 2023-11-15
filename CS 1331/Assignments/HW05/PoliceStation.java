import java.util.ArrayList;

/**
* Creates PoliceStation as driver.
*
* @author iiisong
* @version 1.0.0
*/
public class PoliceStation {
    private String name;
    private ArrayList<Suspect> suspects;
    private ArrayList<Accomplice> accomplices;

    /**
     * main constructor.
     *
     * @param name name of police station
     */
    public PoliceStation(String name) {
        this.suspects = new ArrayList<>();
        this.accomplices = new ArrayList<>();
        this.name = name == null ? "Station 1331" : name;
    }

    /**
     * Add Suspect or Accomplice to Arrlists based on type.
     *
     * @param poi suspect or accomplice
     */
    public void addPersonOfInterest(PersonOfInterest poi) {
        if (poi instanceof Suspect) {
            suspects.add((Suspect) poi);
            return;
        }

        if (poi instanceof Accomplice) {
            accomplices.add((Accomplice) poi);
            return;
        }
    }

    /**
     * Sort suspects based off of poi compareTo.
     */
    public void sortSuspects() {
        // ============================================================================
        // Selection  Sort

        for (int i = 0; i < suspects.size(); i++) {
            int minIndex = i;

            for (int j = minIndex + 1; j < suspects.size(); j++) {
                if (suspects.get(j).compareTo(suspects.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // taking advantage of arraylist
            // suspects.add(i, suspects.get(minIndex));
            // suspects.remove(minIndex + 1);

            // proper method
            Suspect temp = suspects.get(i);
            suspects.set(i, suspects.get(minIndex));
            suspects.set(minIndex, temp);
        }

        // ===========================================================================
        // Insertion  Sort

        // start at index 1
        // for (int i = 1; i < suspects.size(); i++) {
        //     int insertIn = i; // insert at index

        //     // shift insertIndex left until
        //     while (insertIn > 0 && suspects.get(i).compareTo(suspects.get(insertIn - 1)) < 0) {
        //         insertIn -= 1;
        //     }

        //     suspects.add(insertIn, suspects.get(i)); // insert element
        //     suspects.remove(i + 1); // i + 1 because added one element earlier
        // }


        // ============================================================================
        // Bubble Sort

        // int passes = 0;

        // boolean swapped = true;
        // // go until no swaps
        // while (swapped) {
        //     swapped = false;

        //     // each pass ensures max at end
        //     for (int i = 1; i < suspects.size() - passes; i++) {
        //         // right is smaller than left
        //         if (suspects.get(i).compareTo(suspects.get(i - 1)) < 0) {
        //             // swapping mechanism
        //             Suspect temp = suspects.get(i);
        //             suspects.set(i, suspects.get(i - 1));
        //             suspects.set(i - 1, temp);

        //             swapped = true; // have swapped
        //         }
        //     }

        //     passes += 1;
        // }
    }

    /**
     * Remove duplicate suspects.
     *
     * @return list of duplicated suspects
     */
    public ArrayList<Suspect> removeDuplicates() {
        // non-in-place implementation with O(n^2/2)

        // ArrayList<Suspect> uniques = new ArrayList<>();
        // ArrayList<Suspect> dupes = new ArrayList<>();

        // for (int i = 0; i < suspects.size(); i++) {
        //     // check if first instance of suspect
        //     if (!uniques.contains(suspects.get(i))) {
        //         uniques.add(suspects.get(i));

        //     // check if first instance of a duplicate
        //     } else if (!dupes.contains(suspects.get(i))) {
        //         dupes.add(suspects.get(i));
        //     }
        // }

        // suspects = uniques;
        // return dupes;

        // in-place sorting solution with O(n^2)

        sortSuspects();
        ArrayList<Suspect> duplicates = new ArrayList<>();

        for (int i = 1; i < suspects.size(); i++) {
            // check if same back to back
            if (suspects.get(i).equals(suspects.get(i - 1))) {
                System.out.println(suspects.get(i));

                // check if first instance of duplicate
                if (!duplicates.contains(suspects.get(i))) {
                    duplicates.add(suspects.get(i));
                }

                suspects.remove(i--); // quirky way to account for removal of current element in index
            }
        }

        return duplicates;
    }

    /**
     * Find suspect with amtching proximity and hair color.
     *
     * @param sus target suspect
     * @return suspect with matching proximity and hair
     */
    public Suspect findSuspect(Suspect sus) {
        removeDuplicates();
        sortSuspects();

        int min = 0;
        int max = suspects.size() - 1;
        int mid;

        while (min <= max) {
            mid = (min + max) / 2;

            if (sus.compareTo(suspects.get(mid)) == 0) {
                return suspects.get(mid);
            }

            if (sus.compareTo(suspects.get(mid)) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return null;
    }

    /**
     * Find accomplice with matching rubber duck.
     *
     * @param sus suspect
     * @return accomplice with matching duck
     */
    public Accomplice findMastermind(Suspect sus) {
        for (Accomplice a : accomplices) {
            if (a.getRubberDuck().equals(sus.getRubberDuck())) {
                return a;
            }
        }

        return null;
    }

    /**
     * Main Driver.
     *
     * @param args console input
     */
    public static void main(String[] args) {
        PoliceStation ps = new PoliceStation("Cop Building");

        // Suspect sus1 = new Suspect(10, new RubberDuck()); // ඞ
        // Suspect sus2 = new Suspect(15, new RubberDuck()); // ඞ
        // Suspect sus3 = new Suspect(20, new RubberDuck()); // ඞ
        // Suspect sus4 = new Suspect(25, new RubberDuck()); // ඞ
        // Suspect sus5 = new Suspect(25, new RubberDuck()); // ඞ
        // Suspect sus6 = new Suspect(30, new RubberDuck()); // ඞ
        // Suspect sus7 = new Suspect(Color.GREEN, 40, new RubberDuck(), 160); // ඞ
        // Suspect sus8 = new Suspect(Color.GREEN, 40, new RubberDuck(), 159); // ඞ
        // Suspect sus9 = new Suspect(40, new RubberDuck()); // ඞ
        // Suspect sus10 = new Suspect(-10, new RubberDuck()); // ඞ
        // // Suspect[] susses = {sus1, sus2, sus3, sus4, sus5, sus6, sus7, sus8, sus9, sus10};
        // Suspect[] susses = {sus8, sus2, sus9, sus6, sus7, sus1, sus4, sus3, sus5, sus10};

        Suspect[] susses = {
            new Suspect(10, new RubberDuck()),
            new Suspect(Color.CYAN, 10, new RubberDuck(Color.BLACK, true), 155),
            new Suspect(Color.CYAN, 10, new RubberDuck(Color.BLACK, true), 155),
            new Suspect(Color.CYAN, 10, new RubberDuck(Color.GREEN, true), 155),
            new Suspect(Color.CYAN, 13, new RubberDuck(Color.BLACK, true), 155),
            new Suspect(Color.GREEN, 10, new RubberDuck(Color.BLACK, true), 155),

            new Suspect(Color.CYAN, 10, new RubberDuck(Color.BLACK, true), 155),
            new Suspect(Color.CYAN, 10, new RubberDuck(Color.BLACK, true), 155),
            new Suspect(Color.CYAN, 10, new RubberDuck(Color.BLACK, true), 155),
            new Suspect(Color.CYAN, 10, new RubberDuck(Color.BLACK, true), 155),
            new Suspect(Color.CYAN, 10, new RubberDuck(Color.GREEN, true), 155),
            new Suspect(Color.CYAN, 13, new RubberDuck(Color.BLACK, true), 155),
            new Suspect(Color.GREEN, 10, new RubberDuck(Color.BLACK, true), 155),

            new Suspect(10, new RubberDuck()),
            new Suspect(10, new RubberDuck()),
            new Suspect(10, new RubberDuck()),
            new Suspect(10, new RubberDuck())
        };

        Accomplice acc1 = new Accomplice(Color.CYAN, 10, new RubberDuck(), true);
        Accomplice acc2 = new Accomplice(Color.CYAN, 15, new RubberDuck(), true);
        Accomplice acc3 = new Accomplice(Color.CYAN, 20, new RubberDuck(), true);
        Accomplice acc4 = new Accomplice(Color.CYAN, 25, new RubberDuck(), true);
        Accomplice acc5 = new Accomplice(Color.CYAN, 25, new RubberDuck(), true);
        Accomplice acc6 = new Accomplice(Color.CYAN, 30, new RubberDuck(), true);
        Accomplice acc7 = new Accomplice(Color.CYAN, 35, new RubberDuck(), true);
        Accomplice acc8 = new Accomplice(Color.CYAN, 40, new RubberDuck(), true);
        Accomplice acc9 = new Accomplice(Color.CYAN, 40, new RubberDuck(), true);
        Accomplice acc10 = new Accomplice(Color.CYAN, -10, new RubberDuck(), true);
        Accomplice[] acces = {acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9, acc10};

        // for (Suspect sus : susses) {
        //     ps.addPersonOfInterest(sus);
        // }

        for (Accomplice acc : acces) {
            ps.addPersonOfInterest(acc);
        }

        // System.out.println(sus1.compareTo(sus2));
        // System.out.println(sus2.compareTo(sus3));
        // System.out.println(sus3.compareTo(sus1));

        // List<Suspect> temp = Arrays.asList(susses);
        // Collections.shuffle(temp);
        // temp.toArray(susses);

        // for (Suspect sus : susses) {
        //     ps.addPersonOfInterest(sus);
        // }

        System.out.println("shuffled: ");
        for (Suspect sus : susses) {
            ps.addPersonOfInterest(sus);
            System.out.println(sus);
        }

        System.out.println();
        System.out.println();

        ps.sortSuspects();
        ps.removeDuplicates();

        System.out.println();
        System.out.println();

        System.out.println("sorted: ");
        for (Suspect sus : ps.suspects) {
            System.out.println(sus);
        }

        System.out.println("find existing suspect blonde and 20 distance");
        System.out.println(ps.findSuspect(new Suspect(Color.BLONDE, 20, null, 50)));
        System.out.println("find non-exisiting suspect blonde and 21 distance");
        System.out.println(ps.findSuspect(new Suspect(Color.BLONDE, 21, null, 101)));

        System.out.println("find existing accomplice default rubber duck");
        System.out.println(ps.findMastermind(new Suspect(Color.BLONDE, 20, new RubberDuck(), 50)));
        System.out.println("find nonexisting accomplice green rubber duck");
        System.out.println(ps.findSuspect(new Suspect(Color.BLONDE, 21, new RubberDuck(Color.GREEN, true), 101)));

        RubberDuck duck1 = new RubberDuck(Color.BLUE, true);
        RubberDuck duck2 = new RubberDuck(Color.RED, true);

        PoliceStation police2 = new PoliceStation("Your mom");
        Suspect a1 = new Suspect(Color.CYAN, 5, duck1, 140);
        Suspect a2 = new Suspect(Color.GREEN, 10, duck2, 140);
        Suspect a3 = new Suspect(Color.GREEN, 10, duck2, 140);
        Suspect a4 = new Suspect(Color.GREEN, 10, duck2, 140);

        police2.addPersonOfInterest(a1);
        police2.addPersonOfInterest(a2);
        police2.addPersonOfInterest(a3);
        police2.addPersonOfInterest(a4);

        System.out.println("the thing before: " + police2.suspects.toString());
        System.out.println("the duplicates after" + police2.removeDuplicates().toString());
        System.out.println("the list after" + police2.suspects.toString());
    }
}
