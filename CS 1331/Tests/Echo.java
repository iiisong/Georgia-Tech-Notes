import java.util.*;

public class Echo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.print("enter your favorite number: ");
        
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("enter your favorite number: ");
        }
        num = sc.nextInt();

        System.out.println("you entered " + num);

        sc.nextLine();
        System.out.print("favorite phrase: ");
        String phrase = sc.nextLine();
        System.out.println("You entered: \"" + phrase + "\"");
    }
}
