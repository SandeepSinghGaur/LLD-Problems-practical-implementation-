package CoffeeVendingMachine;

public class CoffeeFactory {
    public Coffee createCoffee(String type){
        switch (type.toLowerCase()){
            case "espresso":
                return new Espresso();
            case "cappuccino":
                return new Cappuccino();
            case "latte":
                return new Latte();
            default:
                throw new IllegalArgumentException(STR."Unknown coffee type \{type}");
        }
    }
}
