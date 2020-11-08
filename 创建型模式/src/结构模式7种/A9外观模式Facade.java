package 结构模式7种;

/**
 * 是为了解决类与类之间的依赖关系
 * 外观模式就是将类与类的关系放在Facade类中，降低了类与类之间的耦合关系
 * 该模式中没有涉及到接口
 *
 * 如果没有computer类，那么cpu、memory、disk之间就要相互持有实例，造成严重的依赖，
 * 有了Computer类，她们之间的关系就放在了Computer中，起到解耦的作用。
 */
class CPU {
    public void startup() {
        System.out.println("cpu start");
    }

    public void shutdown() {
        System.out.println("cpu shutdown");
    }
}

class Memory {
    public void startup() {
        System.out.println("memory start");
    }

    public void shutdown() {
        System.out.println("memory shutdown");
    }
}

class Disk {
    public void startup() {
        System.out.println("disk start");
    }

    public void shutdown() {
        System.out.println("disk shutdown");
    }
}

class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup() {
        System.out.println("start computer");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finish");
    }

    ;

    public void shutdown() {
        System.out.println("shutdown computer");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("shutdown computer finish");
    }

    ;
}

public class A9外观模式Facade {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}


