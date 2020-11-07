package 创建型模式.单例模式Singleton;

/**
 *
 */
public class A3懒汉式Singleton {

    /*持有私有静态实例，防止被引用，此处赋值为null,目的是实现延迟加载*/
    private static A3懒汉式Singleton instance = null;

    /*私有构造方法*/
    private A3懒汉式Singleton() {
    }

    /**
     * 本实现方式 是线程不安全的类，放入多线程就会出问题
     * @return
     */
    /*静态工厂方法，创建实例*/
    public static A3懒汉式Singleton getInstance() {
        if (instance == null) {
            instance = new A3懒汉式Singleton();
        }
        return instance;
    }

    /**
     * synchronized关键字锁的是这个对象，这样的方法性能会有所下降，每次调用getSynInstance，都要对对象上锁，
     * 事实上只要在第一次创建对象的时候需要加锁，之后就不需要了，改进为方法getSynInstance2
     * @return
     */
    public static synchronized A3懒汉式Singleton getSynInstance() {
        if (instance == null) {
            instance = new A3懒汉式Singleton();
        }
        return instance;
    }

    /**
     * 此处还是有问题  a3懒汉式Singleton = new A3懒汉式Singleton();是分2步执行的，但是JVM不保证这2个操作的先后顺讯
     * 比如 JVM为新的A3懒汉式Singleton实例分配空间，在赋值给instance成员，然后再去初始化这个Singleton实例，这个时候就会出错
     *
     * 比如 如线程A、B同时进行if 判断
     * A 先进入 synchronized 由于instance为null，执行 instance = new A3懒汉式Singleton(); JVM先画出一些分配给Singleton实例的空白内存，
     * 并赋值给instance成员，注意此时JVM没有初始化instance实例，然后A离开了synchronized,
     * B进入synchronized，此时instance 不是null，因此B离开synchronized ，并将结果放回给调用该方法的线程，此时B打算使用Singleton实例，
     * 却发现它没有初始化，于是发生错误了
     */
    public static synchronized A3懒汉式Singleton getSynInstance2() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new A3懒汉式Singleton();
                }
            }
        }
        return instance;
    }


    /**
     * 实际情况是用内部类来维护单例模式，JVM内部机制能够保证当一个类被加载时，这个类的加载过程是互斥的，
     * 这样我们第一次调用instance时，JVM能够保证我instance值创建一次，并且会保存把赋值给instance的内存初始化完毕，
     * 这样就不会担心上面的问题，同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了性能低的问题
     * 这只是暂时完美的单例模式
     *
     * 其实说完美也不一定，如果构造函数出现异常，实例将永远得不到创建
     */
    private static class SingletonFacrty {
        private static A3懒汉式Singleton instance = new A3懒汉式Singleton();

    }
    public static A3懒汉式Singleton getInstance2 () {
        return SingletonFacrty.instance;
    }























}

