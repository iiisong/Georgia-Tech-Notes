public class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) { this.pizza = pizza; }

    @Override
    public String getDescription() { return pizza.getDescription() + ", Extra Cheese"; }

    @Override
    public double cost() { return pizza.cost() + .2; }
}
