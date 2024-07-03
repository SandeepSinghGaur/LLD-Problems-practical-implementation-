package CoffeeVendingMachine;

public class Milk implements Coffee{
    private Coffee coffee;

    Milk(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return STR."\{coffee.getDescription()}, Milk";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.50;
    }
}
