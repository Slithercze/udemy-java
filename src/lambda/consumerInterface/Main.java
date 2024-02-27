package lambda.consumerInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("------");
        list.forEach((String myString) -> System.out.println(myString));

        System.out.println("-------");
        String prefix = "nato";
//        String myString = "enclosing Method's myString"; wont work in lambda as parameter
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });
//        prefix = "NATO"; doesnt work because in lambda its final

        int result = calculator((a, b) -> a + b, 5, 2);
        var result2 = calculator((a,b) -> a / b, 10.0, 2.5);
        var result3 = calculator((a,b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "Kramden");

        var coords = Arrays.asList(
                new double[]{47.2160,-95.2348},
                new double[]{29.2160,-89.2348},
                new double[]{35.2160,-90.2348}
        );
        coords.forEach(s-> System.out.println(Arrays.toString(s)));

        BiConsumer<Double,Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng); //consumer exe codes without returning data
        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        System.out.printf("%13s%n", " - ");
        coords.forEach(s -> processPoint(s[0], s[1], (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        list.addAll(List.of("echo","easy","ernest"));
        list.forEach(s -> System.out.println(s));

        System.out.println("-------");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {

        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1,t2);
    }
}
