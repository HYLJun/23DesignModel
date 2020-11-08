package 关系模式11种.类之间的关系;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 司令下令让士兵去干事情，司令的作用是发出口令，口令经过传递 传到士兵的耳朵，士兵去执行，
 * 这个过程好在，三者之间相互解耦，任何一方都不用去医疗其他人，只需要组好自己的事情就行
 *
 * invoker 是调用者（司令员） Receiver是被调用者（士兵），MyCommand是命令，实现了Command接口，持有接收对象
 *
 * 命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分离
 * Struts其实就是一种将请求和呈现分离的技术，其中必然涉及命令模式的思想
 */

interface Command{
    void exce();
}

class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exce() {
        receiver.action();
    }
}

class Receiver {
    public void action(){
        System.out.println("command receiver");
    }
}

class Invoker{
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }
    public void action(){
        command.exce();
    }
}

public class A18命令模式Command {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        MyCommand myCommand = new MyCommand(receiver);
        Invoker invoker = new Invoker(myCommand);
        invoker.action();
    }
}
