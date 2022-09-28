public class EuclideanAlgorithm {
    public static void main(String[] args) {
        // arbitary ints between 0-1000
        int num1 = 64; 
        int num2 = 101;
        
        int steps = 0; // stepper
        int dividend = num1; // divident
        int divisor = num2; // divisor

        int gcd; // greatest common divisor
        int quotient; // quotient
        int remainder; // remainder

        System.out.printf("Finding the greatest common divisor of %d and %d\n", num1, num2);

        // make sure divisor not greater than dividend, if so swap them
        if (divisor > dividend) {
            System.out.println("The inputs would have caused an unnecessary step.");


            int temp = dividend; // temporary variable to store the dividend

            // swap dividend and divisor
            dividend = divisor;
            divisor = temp;

        } else {
            System.out.println("An extra step was avoided.");
        }

        // calculate the gcd
        do {
            steps += 1; // increment steps

            // dividend = divisor * quotient + remainder
            quotient = dividend / divisor;
            remainder = dividend % divisor;

            // print "Step {steps}: {dividend} = {divisor} * {quotient} + {remainder}"
            System.out.printf("Step %d: %d = %d * %d + %d\n", steps, dividend, divisor, quotient, remainder);

            // update gcd, dividend, divisor to new values
            gcd = divisor;
            dividend = divisor;
            divisor = remainder;
        } while (remainder != 0);

        // print "The GCD is {gcd}."
        System.out.println("The GCD is " + gcd + ".");

        // print number of steps taken in a quirky way
        switch (steps) {
            case 1:
                System.out.println("Only one step was needed!");
                break;
            case 2:
                System.out.println(": Two steps were taken!");
                break;
            case 3:
                System.out.println("This process took three steps.");
                break;
            case 4:
                System.out.println("Wow! Four steps.");
                break;
            default:
                System.out.println(steps + " steps is a lot of steps!");
                break;
        }

        // check if relatively prime
        if (gcd == 1) {
            // print "{num1} and {num2} are relatively prime."
            System.out.printf("%d and %d are relatively prime.\n", num1, num2);

        } else {
            // print "{num1} and {num2} are not relatively prime."
            System.out.printf("%d and %d are not relatively prime.\n", num1, num2);
        }
    }
}
