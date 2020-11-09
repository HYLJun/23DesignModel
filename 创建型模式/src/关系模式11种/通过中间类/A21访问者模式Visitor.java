package 关系模式11种.通过中间类;



/**
 * 访问者模式：把数据结构和作用于数据结构上的操作解耦合，使得操作集合可相对自由的演化，
 *
 * 简单地说：访问者模式是一种分离数据结构和行为的方法，通过这种分离，可达到为一个访问者动态添加新
 * 的操作而无需做其他的修改的效果
 */

interface Visitor{
    void visitor(Subject subject);
}

class MyVisitor implements Visitor{

    @Override
    public void visitor(Subject subject) {
        System.out.println("visit the subject " + subject.getSubject());
    }
}

interface Subject {
    void accept(Visitor visitor);
    String getSubject();
}

class MySubject implements Subject {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }


}
public class A21访问者模式Visitor {
    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject subject = new MySubject();
        subject.accept(visitor);

    }
}
