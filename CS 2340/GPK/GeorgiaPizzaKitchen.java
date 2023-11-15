public class GeorgiaPizzaKitchen {
    public static void main(String[] args) {
        Pizza pizza = new ThinCrust();
        pizza = new ExtraCheese(pizza);
        pizza = new Olives(pizza);
        pizza = new Jalepenos(pizza);
        pizza = new Mushrooms(pizza);
        System.out.println(pizza);
    }
}
