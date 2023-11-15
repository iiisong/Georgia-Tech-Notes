import java.util.Scanner;

public class StudentCenter {
    public static void main(String[] args) {
        double activityPrice = 0;
        double foodPrice = 0;
        double foodTip = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Student Center!");

        System.out.println("Activities");
        System.out.println("Bowling: $4.00 ($2 to rent bowling shoes)");
        System.out.println("Billiards: $5.00");
        System.out.println("Food");        
        System.out.println("Pizza: $8.50");
        System.out.println("Salad: $7.00\n\n");

        System.out.print("What activity would you like to do? ");
        String activity = sc.nextLine();

        if (activity.toLowerCase().equals("bowling")) {
            activityPrice += 4;
            System.out.print("Do you need bowling shoes? ");
            if (sc.nextLine().toLowerCase().equals("yes")) {
                activityPrice += 2;
            }
        } else {
            activityPrice += 5;
        }

        System.out.print("\n\nWhat food would you like? ");
        String food = sc.nextLine();

        if (food.toLowerCase().equals("pizza")) {
            foodPrice += 8.5;
            System.out.print("Choose a topping (mushrooms: $1.5, pepperoni:$1, none:$0) ");
            switch (sc.nextLine().toLowerCase()) {
            case "mushrooms":
                foodPrice += 1.5;
                break;
            case "pepperoni":
                foodPrice += 1;
                break;
            default:
                break;
            }
        } else {
            foodPrice += 7;
        }

        System.out.print("\n\nWhat percentage would you like to tip for the food? ");
        double percentage = Double.parseDouble(sc.nextLine());

        if (percentage < 0) {
            percentage = .18;
        }

        foodTip = percentage;

        System.out.print("\n\nHow many people are with you? ");
        int people = Integer.parseInt(sc.nextLine());

        if (people < 0) {
            people = 0;
        }

        double subtotal = (activityPrice + foodPrice) * (people + 1);
        double tip = (people + 1) * foodPrice * (foodTip);
        System.out.printf("\n\nSubtotal: $%.2f\n",to2decimals(subtotal));
        System.out.printf("Food Tip: $%.2f\n", + to2decimals(tip));
        System.out.printf("Total: $%.02f",to2decimals(subtotal + tip));
    }

    private static double to2decimals(double d) {
        return ((double) Math.round(d * 100) / 100);
    }
}