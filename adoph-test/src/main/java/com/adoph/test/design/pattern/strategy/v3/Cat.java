package com.adoph.test.design.pattern.strategy.v3;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/2
 */
public class Cat implements Comparable<Cat> {
    private Comparator<Cat> comparator = new CatComparator();

    public Cat(int length, String name) {
        this.length = length;
        this.name = name;
    }

    private int length;
    private String name;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "length=" + length +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        return comparator.compare(this, o);
    }
}
