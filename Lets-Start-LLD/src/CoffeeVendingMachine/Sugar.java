package CoffeeVendingMachine;

public class Sugar implements Coffee{
    private Coffee coffee;

    Sugar(Coffee coffee){
        this.coffee = coffee;
    }


    @Override
    public double cost() {
        return coffee.cost() + 0.20;
    }

    @Override
    public String getDescription() {
        return STR."\{coffee.getDescription()}, Sugar";
    }
}
