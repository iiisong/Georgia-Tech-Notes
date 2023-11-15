public class TimeCalculator {
    public static void main(String[] args) {
        int hours = 104; // # of hours
        int minutes = 52; // # of minutes
        int seconds = 37; // # of seconds
        int timeCalculation = seconds;

        // calculations
        timeCalculation += 43;
        timeCalculation /= 2;
        timeCalculation += seconds * 8;
        timeCalculation += minutes;
        timeCalculation -= 20;
        timeCalculation *= 13;
        timeCalculation /= hours % 100;
        timeCalculation -= 631;

        System.out.println("Time: " + timeCalculation);
    }
}
