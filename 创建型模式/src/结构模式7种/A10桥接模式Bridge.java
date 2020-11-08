package 结构模式7种;

/**
 * 桥接模式就是将事务和其具体实现分开，使他们可以各自独立的变化，
 * 桥接模式的作用：将抽象化与实现化解耦，使得二者可以独立的变化
 * 我们常常使用的JDBC的DriveManager就是
 *
 * 通过对Bridge类的调用，实现了对接口Sourceable5的实现类SourceSub1和SourceSub2的调用，
 */

interface Sourceable5 {
    void method();
}
/*定义2个实现类*/
class SourceSub1 implements Sourceable5{
    @Override
    public void method() {
        System.out.println("this is the first sub");
    }
}
class SourceSub2 implements Sourceable5{
    @Override
    public void method() {
        System.out.println("this is the second sub");
    }
}

/*定义一个桥，持有Sourceable5的实例*/
abstract class Bridge{
    private Sourceable5 sourceable5;

    public void method(){
        sourceable5.method();
    }

    public Sourceable5 getSourceable5() {
        return sourceable5;
    }

    public void setSourceable5(Sourceable5 sourceable5) {
        this.sourceable5 = sourceable5;
    }
}
class MyBridge extends Bridge {
    public void method() {
        getSourceable5().method();
    }
}

public class A10桥接模式Bridge {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        //调用第一个对象
        Sourceable5 sourceSub1 = new SourceSub1();
        bridge.setSourceable5(sourceSub1);
        bridge.method();

        //调用第二个对象
        Sourceable5 sourceSub2 = new SourceSub2();
        bridge.setSourceable5(sourceSub2);
        bridge.method();
    }
}
