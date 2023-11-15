public class PrimitiveOperations {
    public static void main(String[] args) {
        int intType = 3;
        double floatType = 2.5;

        System.out.println("int type: " + intType);
        System.out.println("float type: " + floatType);

        double product = intType * floatType;

        System.out.println("product: " + product);

        double newFloat = (double) intType;

        System.out.println("floatify int: " + newFloat);

        int newInt = (int) floatType;

        System.out.println("intify float: " + newInt);

        char upperCase = 'A';

        System.out.println("upper case: " + upperCase);

        System.out.println("lower case: " + (char) (upperCase + 32));
    }
}