package CoffeeVendingMachine;

import java.util.Scanner;

public class CoffeeVendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        Inventory inventory = Inventory.getInstance();

        System.out.println("Welcome to the Coffee Vending Machine!");
        System.out.println("Please select a coffee type: Espresso, Cappuccino, Latte");
        String coffeeType = scanner.nextLine();
        // coffee contain the CoffeeType Object Currently
        Coffee coffee = coffeeFactory.createCoffee(coffeeType);

        System.out.println("Would you like to add Milk? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            if (inventory.checkIngredient("Milk")) {
                coffee = new Milk(coffee);
                inventory.useIngredient("Milk");
            } else {
                System.out.println("Sorry, Milk is not available.");
            }
        }

        System.out.println("Would you like to add Sugar? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            if (inventory.checkIngredient("Sugar")) {
                coffee = new Sugar(coffee);
                inventory.useIngredient("Sugar");
            } else {
                System.out.println("Sorry, Sugar is not available.");
            }
        }

        System.out.println(STR."Your order: \{coffee.getDescription()}");
        System.out.println(STR."Total cost: $\{coffee.cost()}");
    }
}

