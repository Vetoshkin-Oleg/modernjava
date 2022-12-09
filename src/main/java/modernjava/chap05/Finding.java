package modernjava.chap05;

import static modernjava.chap04.Dish.MENU;

import java.util.Optional;

import modernjava.chap04.Dish;

public class Finding {

    public static void main(String... args) {
        if (isVegetarianFriendlyMenu()) {
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());

        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }

    private static boolean isVegetarianFriendlyMenu() {
        return MENU.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return MENU.stream().allMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return MENU.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return MENU.stream().filter(Dish::isVegetarian).findAny();
    }

}