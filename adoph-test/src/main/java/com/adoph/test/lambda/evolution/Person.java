package com.adoph.test.lambda.evolution;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Slf4j
@Data
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    Integer age;

    public void printPerson() {
        // ...
        log.info("printPerson ..." + this.emailAddress);
    }

    public void printPerson(String input) {
        // ...
        log.info("printPerson ...{}", input);
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static Person getPersonInfo(Supplier<Person> supplier) {
        return supplier.get();
    }
}