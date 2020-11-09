package 关系模式11种.类的状态;

/**
 * 核心思想：当对象的状态改变时，同时改变其行为
 * 很好理解，比如qq有几种状态：在线、隐身、忙碌等 每个状态对应不同的操作，而且你的好友也能看到你的状态，
 * 所以，状态模式有以下2种特点：
 * 1.通过改变状态来获得不同的行为；
 * 2.你的好友能同时看到你的变化
 * <p>
 * State类是状态类， Context类可以实现状态切换
 */

class State {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1() {
        System.out.println("execute the first opt");
    }

    public void method2() {
        System.out.println("execute the second opt");
    }
}

class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void method() {
        if ("state1".equals(state.getValue())) {
            state.method1();
        }
        else if ("state2".equals(state.getValue())) {
            state.method2();
        }
    }
}

public class A20状态模式State {
    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);

        /*设置第一种状态*/
        state.setValue("state1");
        context.method();

        /*设置第二种状态*/
        state.setValue("state2");
        context.method();
    }
}
