package 结构模式7种.适配器模式;

/**
 * 核心思想就是：
 * 有一个Source类，拥有一个方法，待适配，目标接口就是targetable，
 * 只是Adapter类，不在继承Source类，而是持有Source类的实例，以达到兼容性的问题
 */


class Source2 {
    public void method1() {
        System.out.println("this is original method1");
    }
}
interface Targetable2 {

    public void method1();

    public void method2();
}

class Adatper2 implements Targetable {

    private Source2 source2;

    public Adatper2(Source2 source) {
        this.source2 = source;
    }

    @Override
    public void method1() {
        source2.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is targetable method2");
    }

}

public class A62对象的适配器Adapter {
    public static void main(String[] args) {
        Source2 source2 = new Source2();
        Adatper2 adatper2 = new Adatper2(source2);
        adatper2.method1();
        adatper2.method2();
    }
}
