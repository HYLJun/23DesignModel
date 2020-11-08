package 结构模式7种;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 享元模式主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用
 * <p>
 * FlyWeightFactory 负责创建和管理享元单元，当一个客户端请求时，工厂需要检查当前对象池中是否有符合条件的对象。
 * 如果有，就返回已经存在的对象，如果没有，则创建一个新对象。
 * FlyWeight是超类，
 * Java里面的JDBC连接池就是
 * <p>
 * 总结：
 * 适用于作共享的一些对象，他们有一些共有的属性，拿数据库连接池来说
 * url、dirveClassName、username、password以及dbname 这些属性对于每个连接来说都是一样的，所以适合享元模式来处理，
 * 建一个工厂类，将上述属性作为内部数据，其他的作为外部数据，在方法调用时，当作参数传进来，这样就节省了空间，减少了实例的数量
 *
 * 通过连接池的管理，实现了数据库连接的共享，不需要每次都重新创建连接，节省了数据库重新创建的开销，提升了系统的性能
 */

class ConnectionPool {
    private Vector<Connection> pool;

    /*共有属性*/
    private String url = "djbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "root";
    private String driveClassName = "com.mysql.jdbc.Driver";
    private int poolSize = 100;
    private static ConnectionPool instance = null;
    Connection conn = null;

    private ConnectionPool() {
        pool = new Vector<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driveClassName);
                conn = DriverManager.getConnection(url, username, password);
                pool.add(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /*释放连接*/
    public synchronized void release (){
        pool.add(conn);
    }
    /*返回连接池中的一个数据库连接*/
    public synchronized Connection getConnection(){
        if (pool.size() > 0) {
            Connection connection = pool.get(0);
            pool.remove(connection);
            return connection;
        } else {
            return null;
        }
    }
}

public class A12享元模式Flyweight {
}
