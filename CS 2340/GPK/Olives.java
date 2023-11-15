public class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) { this.pizza = pizza; }

    @Override
    public String getDescription() { return pizza.getDescription() + ", Olives"; }

    @Override
    public double cost() { return pizza.cost() + .3; }
}
