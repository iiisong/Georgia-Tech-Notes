public class Jalepenos extends PizzaDecorator {
    public Jalepenos(Pizza pizza) { this.pizza = pizza; }

    @Override
    public String getDescription() { return pizza.getDescription() + ", Jalepenos"; }

    @Override
    public double cost() { return pizza.cost() + .1; }
}
