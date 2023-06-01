public class Dairy {
    // private object variables
    private String product;
    private int quantity;
    private double cost;
    private int daysToExpiration;
    private boolean isConsumable;

    // constructor with no parameters, pipe to 4
    public Dairy() {
        this("yoghurt", 4, 3.99, 3);
    }

    // construcotr with 2 parameters, pipe to 4
    public Dairy(String product, int quantity) {
        this(product, quantity, 5.59, 5);
    }

    // construtor with 4 parameters
    public Dairy(String product, int quantity, double cost, int daysToExpiration) {
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
        this.daysToExpiration = daysToExpiration;

        if (daysToExpiration < 3) {
            this.isConsumable = false;
            System.out.println("Check the expiration date");
        } else {
            this.isConsumable = true;
            System.out.println("Good choice!");
        }
    }

    // returns product name
    public String getName() {
        return this.product;
    }

    // returns product quantity
    public int getQuantity() {
        return this.quantity;
    }

    // returns product name
    public double getCost() {
        return this.cost;
    }

    // set new quantity
    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}
