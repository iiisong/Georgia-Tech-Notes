/* Isaac Song
 * isong41@gatech.edu
 * 
 * I like wearing funny hats. Particularly frog hats.
 */

public class ShoppingMall {
    public static void main(String[] args) {
        String name = "Oswald"; // user name

        int cash = 100; // initial balance
        double taxRate = .13; // rate of tax
        double subtotal = 58.62; // cost of goods before tax

        // amount of cash remaining after taxes
        double change = cash - subtotal * (1 + taxRate);

        // truncate to 2 decimal places by *100, dropping decimals, then /100
        change = (int) (change * 100) / 100d;

        // print formatting
        System.out.println(name + " has $" + change + " dollars remaining!\n" + name + " started with $" + cash + " dollars!");
    }
}
