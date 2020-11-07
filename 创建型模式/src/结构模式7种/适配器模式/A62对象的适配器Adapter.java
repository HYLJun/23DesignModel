package 结构模式7种.适配器模式;

/**
 * 核心思想就是：
 * 有一个Source类，拥有一个方法，待适配，目标接口就是targetable，
 * 只是Adapter类，不在继承Source类，而是持有Source类的实例，以达到兼容性的问题
 */
public class A62对象的适配器Adapter {

    public void method1() {
        System.out.println("this is original method1");
    }

    interface Targetable {

        public void method1();

        public void method2();
    }

    class Adatper implements Targetable {

        private A62对象的适配器Adapter a62对象的适配器Adapter;

        public Adatper(A62对象的适配器Adapter source) {
            this.a62对象的适配器Adapter = source;
        }

        @Override
        public void method1() {
            a62对象的适配器Adapter.method1();
        }

        @Override
        public void method2() {
            System.out.println("this is targetable method2");
        }

    }

    public static void main(String[] args) {
        A62对象的适配器Adapter a62对象的适配器Adapter = new A62对象的适配器Adapter();
        Adatper adatper = new A62对象的适配器Adapter().new Adatper(a62对象的适配器Adapter);
        adatper.method1();
        adatper.method2();
    }
}
