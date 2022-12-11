package modernjava.chap06;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {
        MEAT,
        FISH,
        OTHER
    }

    public static final List<Dish> MENU = asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 400, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static final Map<String, List<String>> DISH_TAGS = new HashMap<>();

    static {
        DISH_TAGS.put("pork", asList("greasy", "salty"));
        DISH_TAGS.put("beef", asList("salty", "roasted"));
        DISH_TAGS.put("chicken", asList("fried", "crisp"));
        DISH_TAGS.put("french fries", asList("greasy", "fried"));
        DISH_TAGS.put("rice", asList("light", "natural"));
        DISH_TAGS.put("season fruit", asList("fresh", "natural"));
        DISH_TAGS.put("pizza", asList("tasty", "salty"));
        DISH_TAGS.put("prawns", asList("tasty", "roasted"));
        DISH_TAGS.put("salmon", asList("delicious", "fresh"));
    }

}