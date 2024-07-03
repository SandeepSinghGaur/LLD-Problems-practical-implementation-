package CoffeeVendingMachine;

public class Cappuccino implements Coffee{
    @Override
    public String getDescription() {
        return "Cappuccino";
    }

    @Override
    public double cost() {
        return 2.50;
    }
}
