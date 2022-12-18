package modernjava.chap09;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryMain {

    public static void main(String[] args) {
        Product p1 = ProductFactory.createProduct("loan");
        System.out.printf("p1: %s%n", p1.getClass().getSimpleName());

        Supplier<Product> loanSupplier = Loan::new;
        Product p2 = loanSupplier.get();
        System.out.printf("p2: %s%n", p2.getClass().getSimpleName());

        Product p3 = ProductFactory.createProductLambda("loan");
        System.out.printf("p3: %s%n", p3.getClass().getSimpleName());
    }

    static private class ProductFactory {

        public static Product createProduct(String name) {
            return switch (name) {
                case "loan" -> new Loan();
                case "stock" -> new Stock();
                case "bond" -> new Bond();
                default -> throw new RuntimeException("No such product " + name);
            };
        }

        public static Product createProductLambda(String name) {
            Supplier<Product> p = MAP.get(name);
            if (p != null) {
                return p.get();
            }
            throw new RuntimeException("No such product " + name);
        }
    }

    private interface Product { }

    static private class Loan implements Product { }

    static private class Stock implements Product { }

    static private class Bond implements Product { }

    final static private Map<String, Supplier<Product>> MAP = new HashMap<>();

    static {
        MAP.put("loan", Loan::new);
        MAP.put("stock", Stock::new);
        MAP.put("bond", Bond::new);
    }

}