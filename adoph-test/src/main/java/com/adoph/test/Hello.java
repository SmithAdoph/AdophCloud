package com.adoph.test;

class Pink {
    static {
        System.out.println("pink static");
    }

    public Pink() {
        System.out.println("ping construct");
    }
}

class BlackPink extends Pink {
    static {
        System.out.println("BlackPink static");
    }

    public BlackPink() {
        System.out.println("BlackPink construct");
    }
}

public class Hello {
    public static void main(String[] args) {
        Pink ab = new BlackPink();
        ab = new BlackPink();
    }
}