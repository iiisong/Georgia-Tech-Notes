public class Driver {
    public static void main(String[] args) {
        Dairy[] dairyList = {new Dairy(), new Dairy("Milk", 3, 5.00, 5), new Dairy("Creamer", 10, 3.045, 2)};
        Bakery[] bakeryList = {new Bakery("Bread", 1, 1.00), new Bakery("Baguette", 3, 5.00), new Bakery("Bun", 2, 2.50)};

        ShoppingCart cart = new ShoppingCart(dairyList, bakeryList);

        cart.displayItems();
        cart.addDairyItemAtIndex(0, new Dairy("Cheese", 5, .5, 10));
        cart.displayItems();
        cart.removeBakeryItemAtIndex(0);
        cart.displayItems();
        cart.updateDairyQuantity("Milk", 5);
    }
}
