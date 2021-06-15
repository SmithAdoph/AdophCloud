package com.adoph.test.lambda.evolution;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * lambda 化繁为简
 *
 * @author tangqd
 * @version 1.0
 * @since 2021/6/10
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        List<Person> roster = Lists.newArrayList();

        // test1 by interface
        // 提前书写实现类，没有复杂的逻辑，很别扭
        Person.printPersons(roster, new CheckPersonEligibleForSelectiveService());

        // test2 by anonymous class
        // 省略实现类，匿名实现类，根据实际情况书写逻辑
        Person.printPersons(roster, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                // do something
                return false;
            }
        });

        // test3 by lambda
        // 省略实现类，省略new，只写实现
        Person.printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );

        // test predicate
        // 省略接口，只写实现
        Person.printPersonsWithPredicate(roster, p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);
    }

    /**
     * Predicate<T> 断言逻辑 test sth
     */
    @org.junit.Test
    public void testPredicate() {
        // Predicate and ex
        // Predicate negate ex
        // Predicate or ex
        Predicate<Person> predicate1 = o -> o.getGender() == Person.Sex.MALE;
        Predicate<Person> predicate2 = o -> o.getAge() > 10;

        Person p1 = new Person();
        p1.setAge(9);
        p1.setGender(Person.Sex.MALE);

        Person p2 = new Person();
        p2.setAge(11);
        p2.setGender(Person.Sex.FEMALE);

        Person p3 = new Person();
        p3.setAge(11);
        p3.setGender(Person.Sex.MALE);

        Predicate<Person> and = predicate1.and(predicate2);

        log.info("valid p1:{}", and.test(p1));
        log.info("valid p2:{}", and.test(p2));
        log.info("valid p3:{}", and.test(p3));
    }

    /**
     * Consumer<T> 消费逻辑 to do sth
     */
    @org.junit.Test
    public void testProcess() {
        List<Person> roster = Lists.newArrayList();

        Person p3 = new Person();
        p3.setAge(11);
        p3.setGender(Person.Sex.MALE);

        roster.add(p3);

        Person.processPersons(roster, p -> p.getAge() > 10, Person::printPerson);
    }

    /**
     * Function<X, Y> 输入X, 输出Y
     */
    @org.junit.Test
    public void testProcessPersonsWithFunction() {
        List<Person> roster = Lists.newArrayList();

        Person p3 = new Person();
        p3.setAge(11);
        p3.setGender(Person.Sex.MALE);
        p3.setEmailAddress("aa@gmail.com");

        roster.add(p3);

        Person.processPersonsWithFunction(roster, p -> p.getAge() > 10, Person::getEmailAddress, System.out::println);
    }

    @org.junit.Test
    public void testProcessElements() {
        List<Person> roster = Lists.newArrayList();

        Person p3 = new Person();
        p3.setAge(11);
        p3.setGender(Person.Sex.MALE);
        p3.setEmailAddress("aa@gmail.com");

        roster.add(p3);

        Person.processElements(roster, p -> p.getAge() > 10, Person::getEmailAddress, System.out::println);
    }

    @org.junit.Test
    public void testLambda() {
        List<Person> roster = Lists.newArrayList();

        Person p3 = new Person();
        p3.setAge(11);
        p3.setGender(Person.Sex.MALE);
        p3.setEmailAddress("aa@gmail.com");

        roster.add(p3);

        roster.stream()
                .filter(p -> p.getAge() > 10)// Predicate
                .map(Person::getEmailAddress)// Function
                .forEach(System.out::println);// Consumer
    }

    @org.junit.Test
    public void testMethod() {
        List<Person> roster = Lists.newArrayList();

        Person p3 = new Person();
        p3.setAge(11);
        p3.setGender(Person.Sex.MALE);
        p3.setEmailAddress("aa@gmail.com");

        roster.add(p3);

        Person[] rosterAsArray = roster.toArray(new Person[0]);

        Arrays.sort(rosterAsArray,
                (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );

        Arrays.sort(rosterAsArray,
                (a, b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );

        Arrays.sort(rosterAsArray, Comparator.comparing(Person::getBirthday));

    }

}
