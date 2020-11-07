package 结构模式7种;

/**
 * 代理模式就是多一个代理类出来，替原对象进行一系列操作
 *
 * 代理模式的场景：
 * 1.修改原有的方法类适应，这违反了“对扩展开发，对修改关闭”的原则
 * 2.就是采用一个代理类来调用原有的方法，且对产生的后果进行控制，这种方法就是代理模式，
 * 使用代理模式，可以将功能划分的更加清晰，有助于后期的维护。
 */

interface Sourceable4 {
    void method();
}

class SourceProxy implements Sourceable4 {

    @Override
    public void method() {
        System.out.println("the original method");

    }
}

class Proxy implements Sourceable4 {
    private SourceProxy sourceProxy;

    public Proxy() {
        super();
        this.sourceProxy = new SourceProxy();
    }

    @Override
    public void method() {
        before();
        sourceProxy.method();
        after();
    }

    private void before() {
        System.out.println("before proxy");
    }

    private void after() {
        System.out.println("after proxy");
    }
}

public class A8代理模式Proxy {

    public static void main(String[] args) {
        Sourceable4 sourceable4 = new Proxy();
        sourceable4.method();

    }
}

