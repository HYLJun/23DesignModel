package 关系模式11种.类之间的关系;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 简单讲：当一个对象发生变化时，其他依赖对象的对象都会收到通知，并且随着变化！对象之间是一种一对多的关系
 * <p>
 * MySubject类就是我们的助对象，Observer1和Observer2是依赖于MySubject的对象，当MySubject变化时，Observer1和Observer2必然变化。
 * AbstractSubject类中定义着需要监控的对象列表，可以对其进行将修改，增加或者删除被监控对象，且当MySubject变化时，负责同志在列表内存在的对象。
 */
/*一个Observer接口*/
interface Observer {
    void update();
}

/*两个实现类*/
class Observer1 implements Observer {

    @Override
    public void update() {
        System.out.println("observer1 has received");
    }
}

class Observer2 implements Observer {

    @Override
    public void update() {
        System.out.println("observer2 has received");
    }
}

/*Subject接口及实现类*/

interface Subject {
    /*增加观察者*/
    void add(Observer observer);

    /*删除观察者*/
    void remove(Observer observer);

    /*通知所有的观察者*/
    void notifyObserver();
}

abstract class AbstractSubject implements Subject {
    private Vector<Observer> vector = new Vector<Observer>();

    /*增加观察者*/
    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    ;

    /*删除观察者*/
    @Override
    public void remove(Observer observer) {
        vector.remove(observer);
    }

    ;

    /*通知所有的观察者*/
    @Override
    public void notifyObserver() {
        Enumeration<Observer> elements = vector.elements();
        while (elements.hasMoreElements()) {
            elements.nextElement().update();
        }
    }
}

class MySubject extends AbstractSubject {
    public void operation() {
        System.out.println("update self");
        notifyObserver();
    }
}

public class A15观察者模式Observer {
    public static void main(String[] args) {
        MySubject mySubject = new MySubject();
        mySubject.add(new Observer1());
        mySubject.add(new Observer2());
        mySubject.operation();
    }
}
