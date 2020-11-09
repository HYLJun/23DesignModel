package 关系模式11种.通过中间类;

import javax.xml.transform.Source;

/**
 * 中介者模式也是用来降低类与类之间的耦合的，因为类与类之间有依赖关系，不利于扩展与维护
 * 中介者模式只关心和Mediator的关系，具体类与类之间的关系及调度交给Mediator就行，有点像Spring容器
 *
 * User类统一接口 User1和User2分别是不同的对象，二者之间有关联，如果不采用中介者模式，则需要二者相互持有引用，这样二者的耦合度很高
 * 为了解耦，引入Mediator类，通过统一的接口，MyMediator为其实现类，里面持有User1和User2的实例，用来实现User1和User2的实例，
 * 这样User1和User2两个对象相互独立，他们只需要保持好和Mediator之间的关系就行，剩下的完全由MyMeditor类维持
 */

interface Mediator {
    void createMediator();

    void workAll();
}

class MyMediator implements Mediator {

    private User user1;
    private User user2;

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    @Override
    public void createMediator() {
        user1 = new User1(this);
        user2 = new User2(this);
    }

    @Override
    public void workAll() {
        user1.work();
        user2.work();
    }
}

abstract class User {
    private Mediator mediator;

    public Mediator getMediator() {
        return mediator;
    }

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void work();
}

class User1 extends User {

    public User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 exec");
    }
}

class User2 extends User {

    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exec");
    }
}

public class A22中介者模式Mediator {
    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}
