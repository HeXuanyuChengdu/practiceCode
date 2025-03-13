package com.guoxinan.practice;

public class DiamondInheritance {
    public static void main(String[] args) {
        D d = new D();
        d.method();
    }

}
interface A {
    void method();
}

class B implements A {
    public void method() {
        System.out.println("B's method");
    }
}

class C implements A {
    public void method() {
        System.out.println("C's method");
    }
}

class D implements A {
    private B b = new B();
    private C c = new C();

    public void method() {
        b.method(); // 或者 c.method()
        c.method();
    }
}