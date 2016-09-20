package java8.lambda;

import java.util.Optional;
import java.util.function.*;

public class RunnerLambda {
    public static void main(String[] args) {
        customWithDefault();
        runnable();
        optional();
        //predefined interfaces;
        operators();
        supplierAndConsumer();
        function();
        predicate();
    }

    private static void customWithDefault() {
        CustomLambda defaultLambda = System.out::println;
        defaultLambda.def();
        defaultLambda.go("hello");
        CustomLambda cl = new CustomLambda() {
            @Override
            public void go(String s) {
                System.out.println(s);
            }

            @Override
            public void def() {
                System.out.println("not default");
            }
        };
        cl.def();
    }

    private static void predicate() {
        Predicate<String> emptyCheck = String::isEmpty;
        System.out.println("check empty string: " + emptyCheck.test(""));
        Predicate<String> nullCheck = s -> s == null;
        Predicate<String> notNullAndNotEmpty = nullCheck.negate().and(emptyCheck.negate());
        System.out.println("not null and not empty: " + notNullAndNotEmpty.test("zu"));
        System.out.println("the same for null one: " + notNullAndNotEmpty.test(null));
    }

    private static void function() {
        Function<String, Integer> f = String::length;
        System.out.println("length of string: " + f.apply("something"));
    }

    private static void supplierAndConsumer() {
        Supplier<String> supplier = () -> "data";
        Consumer<String> consumer = s -> System.out.println("consuming " + s);
        consumer.accept(supplier.get());
    }

    private static void operators() {
        UnaryOperator<String> u = name -> "hello, user " + name;
        System.out.println(u.apply("John"));
        BinaryOperator<String> b = (name, n) -> "hello, user " + name + ". your number is " + n;
        System.out.println(b.apply("John", "5"));
    }

    private static void optional() {
        Optional<Object> optional = Optional.ofNullable(null);
        System.out.println("empty:" + optional.isPresent());
        System.out.println("default: " + optional.orElse("default"));
        try {
            optional.orElseThrow(RuntimeException::new);
        } catch (RuntimeException e) {
            System.out.println("or else throw: thrown");
        }
        optional = Optional.of("something");
        System.out.println("get non empty: " + optional.get());
        Integer hash = optional.map(Object::hashCode).get();
        System.out.println("mapped: " + hash);
    }

    private static void runnable() {
        Runnable r = () -> System.out.println("thread run");
        new Thread(r).start();
    }

    private static interface CustomLambda {
        void go(String s);

        default void def() {
            System.out.println("default one");
        }
    }

}
