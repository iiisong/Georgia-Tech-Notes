public class Bakery {
    // private variables
    private String product;
    private int quantity;
    private double cost;

    // consructor with 3 parameters
    public Bakery(String product, int quantity, double cost) {
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
    }

    // get product name
    public String getName() {
        return this.product;
    }


    // get product quantity
    public int getQuantity() {
        return this.quantity;
    }

    // returns product name
    public double getCost() {
        return this.cost;
    }
}
