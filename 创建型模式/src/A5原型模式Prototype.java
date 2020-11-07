import java.io.*;

/**
 * 原型模式虽然属于创建型的模式，但是与工程模式没关系
 * 该模式的思想：将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象
 */
public class A5原型模式Prototype implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private String string;

    /**
     * super.clone()调用的是object的clone()方法，而Object类的clone()方法是native的
     *
     * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向还是原来对象所指向的
     * 深复制：将一个对象复制后，不论是基本数据类型还是引用类型，都是重新创建
     *
     * 简单说，深复制进行了完全彻底的复制，而浅复制不彻底
     * @return
     * @throws CloneNotSupportedException
     */

    /*浅复制*/
    public Object clone() throws CloneNotSupportedException {
        A5原型模式Prototype prototype = (A5原型模式Prototype) super.clone();
        return prototype;
    }

    /**
     * 实现深复制，需要采用流的形式读入当前对象的二进制输入，再写入二进制数据对应的对象
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    /*深复制*/
    public Object deepClone() throws IOException, ClassNotFoundException {

        /*写入当前对象的二进制流*/
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /*读出二进制流产生的新对象*/
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}

