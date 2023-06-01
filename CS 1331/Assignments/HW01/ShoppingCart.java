public class ShoppingCart {
    // private variables
    private Dairy[] dairyItems;
    private Bakery[] bakeryItems;

    // constructor with no parameters, pipe to 2 parameters
    public ShoppingCart() {
        this(new Dairy[4], new Bakery[]{new Bakery("Bread", 1, 5.99), null});
    }

    // constructor with 2 parameters
    public ShoppingCart(Dairy[] dairyItems, Bakery[] bakeryItems) {
        this.dairyItems = dairyItems;
        this.bakeryItems = bakeryItems;
    }

    // add dairy items to index
    public Dairy addDairyItemAtIndex(int index, Dairy dairy) {
        // check parameter
        if ((index < 0 || index >= dairyItems.length || dairy.equals(null))) {
            System.out.println("Cannot add Dairy item!");
            return null;
        }

        // if no item at index previousl
        if (dairyItems[index] == null) {
            System.out.printf("%s was added here.\n", dairy.getName());
            dairyItems[index] = dairy;
            return null;
        }

        // replace existing item
        Dairy result = dairyItems[index];
        System.out.printf("There was %s here before.\n", result.getName());
        dairyItems[index] = dairy;
        return result;
    }

    public Bakery removeBakeryItemAtIndex(int index) {
        // invalid index
        if (index < 0 || index >= bakeryItems.length) {
            System.out.println("Invalid index entered.");
            return null;
        }

        // no item to remove at index
        if (bakeryItems[index].equals(null)) {
            System.out.println("No Bakery item exists at this index!");
            return null;
        }

        Bakery bakeryItem = bakeryItems[index];
        System.out.printf("%s was removed from the cart.\n", bakeryItem.getName());
        bakeryItems[index] = null; // remove from index
        return bakeryItem; // return removed object
    }

    // update quantity of dairy item in diaryItems given name and new quantity
    public void updateDairyQuantity(String productName, int newQuantity) {
        // check quantity validity
        if (newQuantity < 0) {
            System.out.println("Invalid quantity entered");
            return;
        }

        // check name valididty
        if (productName == null) {
            System.out.println("No such Dairy item exists in the cart!");
            return;
        }

        // iterate through items of list
        for (Dairy d : dairyItems) {
            // find when match
            if (d == null) {
                continue;
            }

            if (d != null && d.getName().toLowerCase().equals(productName.toLowerCase())) {
                System.out.printf("Quantity of %s was updated from %d to %d.\n",
                                             d.getName(), d.getQuantity(), newQuantity);
                d.setQuantity(newQuantity); // set new quantity
                return;
            }
        }

        // if product not found
        System.out.println("No such Dairy item exists in the cart!");
        return;
    }

    public void displayItems() {
        for (Dairy d : dairyItems) {
            if (d == null) {
                System.out.println("null");
                continue;
            }

            System.out.printf("Dairy Product: %s Quantity: %d Cost: %.2f\n", d.getName(), d.getQuantity(), d.getCost());
        }

        for (Bakery b : bakeryItems) {
            if (b == null) {
                System.out.println("null");
                continue;
            }

            System.out.printf("Bakery Product: %s Quantity: %d Cost: %.2f\n",
                                b.getName(), b.getQuantity(), b.getCost());
        }
    }

}
