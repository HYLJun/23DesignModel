package 结构模式7种;

/**
 * 装饰模式，就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，
 * 装饰对象有被装饰对象的实例
 *
 * 应用场景：
 * 1.需要扩展一个类的功能
 * 2.动态的为一个对象增加功能，而且还能动态的撤销，继承不能做到这一点，继承的功能是静态的，不能动态的增删
 *
 * 缺点：
 * 产生过多相似的对象，不易排错
 */


interface Sourceable {
    public void method();
}

class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method !");
    }
}

class Decorator implements Sourceable {

    private Sourceable sourceable;

    public Decorator(Sourceable sourceable){
        this.sourceable = sourceable;
    }
    @Override
    public void method() {
        System.out.println("before decorator!");
        sourceable.method();
        System.out.println("after decorator!");
    }
}

public class A7装饰模式Decorator {
    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}

