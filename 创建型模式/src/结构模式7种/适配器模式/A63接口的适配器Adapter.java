package 结构模式7种.适配器模式;

/**
 * 接口的适配器是这样的：
 * 有时我们写的一个接口中有很多抽象方法，当我们写接口的实现类时，必须实现该接口的所有方法，
 * 这明显有时比较浪费，因为并不是所有的方法都是我们需要的，有时只需要某一些，此处为了解决这个问题
 * 我们引入接口的适配器模式，借助于一个抽象类，该抽象类实现了该接口，实现了所有的方法，而我们不和原始的接口打交道，
 * 只和该抽象类取得联系，所以我们写一个类，继承该抽象类，重写我们需要的方法即可
 */

interface Sourceable3 {
    public void method1();

    public void method2();
}

abstract class InterfaceAdatper implements Sourceable3 {
    public void method1(){}

    public void method2(){}

}

class SourceSub1 extends InterfaceAdatper {
    public void method1(){
        System.out.println("the sourceable interface's first Sub1");
    }

}

class SourceSub2 extends InterfaceAdatper {
    public void method2(){
        System.out.println("the sourceable interface's first Sub2");
    }

}


public class A63接口的适配器Adapter {
    public static void main(String[] args) {
        Sourceable3 sourceSub1 = new SourceSub1();
        Sourceable3 sourceSub2 = new SourceSub2();
        sourceSub1.method1();
        sourceSub1.method2();
        sourceSub2.method1();
        sourceSub2.method2();
    }
}
