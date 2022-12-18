package modernjava.chap10;

import java.util.Arrays;
import java.util.List;

public class PrintNumbers {

    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("one", "two", "three");

        System.out.println("Anonymous class:");
        numbers.forEach(System.out::println);

        System.out.println("Lambda expression:");
        numbers.forEach(System.out::println);

        System.out.println("Method reference:");
        numbers.forEach(System.out::println);
    }

}