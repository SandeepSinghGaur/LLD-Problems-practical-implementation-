package CoffeeVendingMachine;

public class Espresso implements Coffee{
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 1.5;
    }
}
