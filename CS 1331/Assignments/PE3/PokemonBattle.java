import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
    public static void main(String[] args) {
        Random rd = new Random(); // random object
        Scanner sc = new Scanner(System.in); // new scanner object

        String rivalName; // rival's pokemon's name
        String yourName; // your pokemon's name

        // generate health between 40.0 and 60.0 for rival pokemon's health
        double rivalHealth = roundDigits(rd.nextDouble() * 20, 2) + 40;

        System.out.print("Enter your Pokemon\'s nickname:  ");
        yourName = sc.nextLine().trim();


        System.out.print("Enter your rival Pokemon\'s nickname:  ");
        rivalName = sc.nextLine().trim();


        System.out.printf("Your rival has chosen %s to fight, which has %.2f health.\n",
                            rivalName, roundDigits(rivalHealth, 2));

        // num of turns taken
        int numTurns = 0;


        // num of damage this turn
        double totalDmg = 0;

        do {
            numTurns += 1;

            // generate random rival attack
            AttackType attack = AttackType.values()[rd.nextInt(3)];

            // add damage of attack to totalDmg
            switch (attack) {
            case SCRATCH:
                int attackNum = rd.nextInt(3) + 1; // number of time to scratch
                double scratchDmg = roundDigits(rd.nextDouble() * 5, 2) + 1; // damage per scratch

                // damage number of scratches * damage per scratch
                totalDmg = roundDigits(attackNum * scratchDmg, 2);
                break;

            case SURF:
                totalDmg = roundDigits(rd.nextDouble() * 9, 2) + 2; // damage betweeen [2.0 and 11.0)
                break;

            default:
                totalDmg = roundDigits(rd.nextDouble() * 2, 2) + 7; // damage between [7.0 and 9.0]
            }

            rivalHealth -= totalDmg; // new health of rival after damage

            System.out.printf("%s used %s and did %.2f damage. Your rival has %.2f health remaining.\n",
                                yourName, attack, totalDmg, Math.max(0, rivalHealth));

        } while (rivalHealth > 0);

        System.out.printf("%s fainted after %d turns!\n", rivalName, numTurns);

        double prizeMoney = roundDigits(rd.nextDouble() * 1200, 2) + 1200;
        System.out.printf("You have earned $%.2f!", prizeMoney);
    }

    private static double roundDigits(double d, int digits) {
        return  ((double) Math.round(d * Math.pow(10, digits))) / Math.pow(10, digits);
    }
}
