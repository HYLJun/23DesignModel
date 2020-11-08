package 关系模式11种.类之间的关系;


/**
 * 迭代器模式就是顺序访问聚集中的对象，集合中非常常见
 * 包含2层意思：一是需要遍历的对象，即聚集对象；二是迭代器对象 用于对聚集对象进行遍历访问
 */

/*2个接口*/
interface Collection {
    Iterator iterator();

    /*取得集合元素*/
    Object get(int i);

    /*取得集合的大小*/
    int size();
}

interface Iterator {
    /*前移*/
    Object previous();

    /*后移*/
    Object next();

    boolean hasNext();

    /*取得第一个元素*/
    Object first();
}

/*2个实现*/
class MyCollection implements Collection {

    public String[] strings = {"A", "B", "C", "D", "E"};

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return strings[i];
    }

    @Override
    public int size() {
        return strings.length;
    }
}

class MyIterator implements Iterator {
    private Collection collection;
    private int pos = -1;

    public MyIterator(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if (pos > 0) {
            pos--;
        }
        return collection.get(pos);
    }

    @Override
    public Object next() {
        if (pos < collection.size() - 1) {
            pos++;
        }
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if (pos < collection.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object first() {
        pos = 0;
        return collection.get(pos);
    }
}

public class A16迭代子模式Iterator {
    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();
        Iterator iterator = myCollection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
