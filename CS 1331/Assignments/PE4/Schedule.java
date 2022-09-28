import java.util.Scanner;

public class Schedule {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // initiate scanner

        System.out.print("Enter the number of classes: ");
        int numClasses = scan.nextInt(); // retrieve int
        scan.nextLine(); // clear nextline

        System.out.print("Enter this schedule's owner's name: ");
        String owner = scan.nextLine(); // retrieve owner

        // declare subjectList
        String[] subjectList =  {"English", "History", "Math", "CS", "Science", "Engineering", "Lab"};

        // generate 2 schedules
        String[] schedule1 = generateSchedule(subjectList, numClasses);
        String[] schedule2 = generateSchedule(subjectList, numClasses);

        // print confirmation message
        System.out.printf("Schedules created successfully. Here are the details:\nOwner: %s\nNumber of Classes: %d",
                          owner, numClasses);

        // Schedule 1
        System.out.println("\nSchedule 1:"); // print out schedule1
        int[] difficulty1 = computeDifficulties(schedule1, subjectList); // caluclate difficulties
        // loop through schedule 1
        for (int i = 0; i < numClasses; i++) {
            System.out.printf("%s %d\n", schedule1[i], difficulty1[i]); // print out class name and difficulty
        }

        // Schedule 2
        System.out.println("\nSchedule 2:"); // print out schedule2
        int[] difficulty2 = computeDifficulties(schedule2, subjectList); // caluclate difficulties
        // loop through schedule 1
        for (int i = 0; i < numClasses; i++) {
            System.out.printf("%s %d\n", schedule2[i], difficulty2[i]); // print out class name and difficulty
        }

        compareDifficulties(schedule1, schedule2, subjectList);
    }

    public static String[] generateSchedule(String[] subjectList, int numClasses) {
        String[] schedule = new String[numClasses]; // create schedule

        for (int i = 0; i < schedule.length; i++) {
            // if even, class in [0,3] index
            if (i % 2 == 0) {
                schedule[i] = subjectList[(int) (Math.random() * 4)];

            // if odd, class in [4,6] index
            } else {
                schedule[i] = subjectList[(int) (Math.random() * 3 + 4)];
            }
        }

        return schedule;
    }


    public static int[] computeDifficulties(String[] schedule, String[] subjectList) {
        int[] difficulties =  new int[schedule.length];

        // loop through classes in schedule
        for (int i = 0; i < schedule.length; i++) {
            // loop through classes in subjectLists
            for (int j = 0; j < subjectList.length; j++) {
                // check when class in schedule and class in subjectList
                if (schedule[i].equals(subjectList[j])) {
                    difficulties[i] = i + j; // assign difficulties
                    break;
                }
            }
        }

        return difficulties; // return the list of class difficulties
    }

    public static void compareDifficulties(String[] schedule1, String[] schedule2, String[] subjectList) {
        int sum1 = 0; // sum of schedule 1
        int sum2 = 0; // sum of schedule 2

        // sum all values of difficulties of schedule 1
        for (int n : computeDifficulties(schedule1, subjectList)) {
            sum1 += n;
        }

        // sum all values of difficulties of schedule 2
        for (int n : computeDifficulties(schedule2, subjectList)) {
            sum2 += n;
        }

        // print when first sum larger than second sum
        if (sum1 > sum2) {
            System.out.println("The first schedule is harder than the second schedule.");

        // print when second sum larger than first sum
        } else if (sum1 < sum2) {
            System.out.println("The second schedule is harder than the first schedule.");

        // print when sums equal
        } else {
            System.out.println("The two schedules are equally difficult.");
        }
    }
}