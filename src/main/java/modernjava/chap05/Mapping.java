package modernjava.chap05;

import static java.util.stream.Collectors.toList;
import static modernjava.chap04.Dish.MENU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modernjava.chap04.Dish;

public class Mapping {

    public static void main(String... args) {
        // map
        List<String> dishNames = MENU.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs = new ArrayList<>();
        for (Integer i : numbers1) {
            for (Integer j : numbers2) {
                int[] ints = new int[]{i, j};
                if ((ints[0] + ints[1]) % 3 == 0) {
                    pairs.add(ints);
                }
            }
        }
        pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
    }

}