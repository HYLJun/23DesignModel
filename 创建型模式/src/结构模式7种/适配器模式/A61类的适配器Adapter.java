package 结构模式7种.适配器模式;

/**
 *  核心思想就是：
 *      有一个Source类，拥有一个方法，待适配，目标接口就是targetable，
 *      通过Adapter类，将Source的功能扩展到Targetable里
 */
public class A61类的适配器Adapter {

    public void method1() {
        System.out.println("this is original method1");
    }

    interface Targetable {
        public void method1();
        public void method2();
    }

    class Adatper extends A61类的适配器Adapter implements Targetable {

        @Override
        public void method2() {
            System.out.println("this is targetable method2");
        }

    }

    public static void main(String[] args) {
        Targetable targetable = new A61类的适配器Adapter().new Adatper();
        targetable.method1();
        targetable.method2();

    }
}
