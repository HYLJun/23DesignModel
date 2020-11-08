package 关系模式11种.类之间的关系;

/**
 * 责任链模式：
 * 有多个对象，每个对象持有对下一个对象的引用，这样就会形成一条链，请求在这条链上岔村地，知道某一对象决定处理该请求，
 * 但是发出者并不清楚到底最终那个对象会处理该请求，所有责任链模式可以实现，在隐藏客户端的情况下，对系统进行动态的调整
 */

interface Handler{
    void operator();
}

abstract class AbstractHandler{
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}

class MyHandler extends AbstractHandler implements Handler{
    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name +"deal!");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
public class A17责任链模式ChainOfResponsibility {
    public static void main(String[] args) {
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");
        h1.setHandler(h2);
        h2.setHandler(h3);
        h1.operator();
    }
}
