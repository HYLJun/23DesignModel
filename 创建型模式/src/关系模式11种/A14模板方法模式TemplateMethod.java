package 关系模式11种;

/**
 * 模板方法模式：就是一个抽象类，有一个主方法，再定义1...n个方法，可以是抽象的，也可以是实际的方法，定义一个类。
 * 继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用，
 */

abstract class AbstractCalculator2{

    /*主方法，实现对本类其他方法的调用*/
    public final int calculate2(String exp,String opt){
        int[] array = split(exp, opt);
        return calculate2(array[0], array[1]);
    }

    /*被子类重写的方法*/
    abstract public int calculate2(int num1, int num2);

    public int[] split(String exp, String opt){
        String[] array = exp.split(opt);
        int[] arrayInt = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}

class Plus2 extends AbstractCalculator2 {

    @Override
    public int calculate2(int num1, int num2) {
        return num1 + num2;
    }
}

class Minus2 extends AbstractCalculator2 {

    @Override
    public int calculate2(int num1, int num2) {
        return num1 - num2;
    }
}
public class A14模板方法模式TemplateMethod {
    public static void main(String[] args) {
        String exp = "2+8";
        AbstractCalculator2 cal = new Plus2();
        int result = cal.calculate2(exp, "\\+");
        System.out.println(result);

        System.out.println("-------------");

        String exp2 = "2-8";
        AbstractCalculator2 cal2 = new Minus2();
        int result2 = cal2.calculate2(exp2, "\\-");
        System.out.println(result2);
    }
}
