package CoffeeVendingMachine;

// Inventory.java
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static Inventory instance;
    private Map<String, Integer> ingredients;

    private Inventory() {
        ingredients = new HashMap<>();
        ingredients.put("Milk", 10);
        ingredients.put("Sugar", 10);
    }

    public static synchronized Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public boolean checkIngredient(String ingredient) {
        return ingredients.getOrDefault(ingredient, 0) > 0;
    }

    public void useIngredient(String ingredient) {
        if (checkIngredient(ingredient)) {
            ingredients.put(ingredient, ingredients.get(ingredient) - 1);
        }
    }
}
