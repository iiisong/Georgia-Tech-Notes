public class test_java {
    public static void main(String[] args) {
        int res1, res2;
        int total = 5;

        res1 = total++;

        System.out.printf("res1: %s, total: %s\n", res1, total);

        total = 5;
        res2 = ++total;

        System.out.printf("res2: %s, total: %s\n", res2, total);
    }
}
