/**
* Testing File.
*
* @author iiisong
* @version 1
*/
public class Headquarters {
    /**
    * Main.
    *
    * @param args command line args
    */
    public static void main(String[] args) {
        SuperheroRecruit sr1 = new SuperheroRecruit("Aquaman", 20, 50, 40);
        SuperheroRecruit sr2 = new SuperheroRecruit(sr1);

        FlyingHero fh1 = new FlyingHero("Superman", 70, 100, 80, 90);
        FlyingHero fh2 = new FlyingHero(fh1);
        FlyingHero fh3 = new FlyingHero("Batman", 50);

        Brawler br1 = new Brawler("Hulk", 25);

        Catchphrase catchphrase = new Catchphrase("LMAO", 50);

        Brawler br2 = new Brawler("Hulk", 5, 100, 10, catchphrase);

        br1.statChange();
        br2.statChange();

        System.out.println(catchphrase);
        System.out.println(fh3);
    }
}
