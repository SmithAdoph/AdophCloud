package com.adoph.test.equals;

import java.util.Objects;

/**
 * equals
 * 总结：默认情况下也就是从超类Object继承而来的equals方法与‘==’是完全等价的，
 * 比较的都是对象的内存地址，但我们可以重写equals方法，使其按照我们的需求的方式进行比较，
 * 如String类重写了equals方法，使其比较的是字符的序列，而不再是内存地址
 * <p>
 * 传递性失效：
 * 1.父类与子类进行混合比较
 * 2.子类中声明了新变量，并且在子类equals方法使用了新增的成员变量作为判断对象是否相等的条件
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/11/8
 */
public class EqualsTest {
    public static void main(String[] args) {
        Car c1 = new Car(1);
        Car c2 = new Car(1);
        Car c3 = new Car(1);
////        自反性
//        System.out.println("1.自反性");
//        System.out.println(c1.equals(c1));
////        对称性
//        System.out.println("2.对称性");
//        System.out.println(c1.equals(c2) + "," + c2.equals(c1));
////        传递性
//        System.out.println("3.传递性");
//        System.out.println(c1.equals(c2) + "," + c2.equals(c3) + "," + c1.equals(c3));
////        一致性
//        System.out.println("4.一致性");
//        for (int i = 0; i < 2; i++) {
//            System.out.println(c1.equals(c3));
//        }
////        null
//        System.out.println("5.与null比较");
//        System.out.println(c1.equals(null));


        BMW b1 = new BMW(1, 10);
        BMW b2 = new BMW(1, 20);
        System.out.println(c1.equals(b2));
        System.out.println(b1.equals(c1));
        System.out.println(b1.equals(b2));
    }

}

class Car {
    public Car(int no) {
        this.no = no;
    }

    private int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Car) {
            Car c = (Car) o;
            return no == c.no;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}

class BMW extends Car {
    private int discount;

    public BMW(int no, int discount) {
        super(no);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof BMW) {
            BMW bmw = (BMW) o;
            return super.equals(o) && discount == bmw.discount;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}

/**
 * 曲线救国：满足equals的4大要求
 */
class BMWProxyCar {
    private Car c;
    private int discount;

    public BMWProxyCar(int no, int discount) {
        c = new Car(no);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
//        1.== 对象地址判断
        if (this == o) return true;
//        2.非空判断和class对象判断
        if (o == null || getClass() != o.getClass()) return false;
        BMWProxyCar that = (BMWProxyCar) o;
//        3.值判断
        return discount == that.discount && c.equals(that.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, discount);
    }
}
