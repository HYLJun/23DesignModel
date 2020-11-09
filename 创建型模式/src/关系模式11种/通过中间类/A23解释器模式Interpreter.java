package 关系模式11种.通过中间类;

/**
 * 解释器模式 主要应用于OOP开发中的编译器的开发中，所以适用面比较窄
 * <p>
 * Context类是一个上下文环境类，Plus和Minus分别是用来计算的实现
 */

interface Expression {
    int interpret(Context context);
}
class Plus implements Expression {

    @Override
    public int interpret(Context context) {
        return context.getNum1() + context.getNum2();
    }
}

class Minus implements Expression {

    @Override
    public int interpret(Context context) {
        return context.getNum1() - context.getNum2();
    }
}

class Context {
    private int num1;
    private int num2;

    public Context(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}

public class A23解释器模式Interpreter {
    public static void main(String[] args) {
        /*计算 9+2-8*/
        int reslut = new Minus().interpret(new Context(new Plus().interpret(new Context(9, 2)), 8));
        System.out.println(reslut);
    }
}
