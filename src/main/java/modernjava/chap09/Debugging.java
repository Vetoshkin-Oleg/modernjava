package modernjava.chap09;

import java.util.Arrays;
import java.util.List;

public class Debugging {

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(Point::getX).forEach(System.out::println);
    }

    private static class Point {

        private int x;

        private Point(int x, int y) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

    }

}