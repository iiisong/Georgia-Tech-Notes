public class Mushrooms extends PizzaDecorator {
    public Mushrooms(Pizza pizza) { this.pizza = pizza; }

    @Override
    public String getDescription() { return pizza.getDescription() + ", Mushrooms"; }

    @Override
    public double cost() { return pizza.cost() + .2; }
}
