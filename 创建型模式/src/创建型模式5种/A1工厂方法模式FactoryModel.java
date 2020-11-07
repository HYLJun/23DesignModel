package 创建型模式5种;

public class A1工厂方法模式FactoryModel {
    public interface Sender{
        public void sender();
    }
    //两个实现类
    public class MailSender implements Sender {

        @Override
        public void sender() {
            System.out.println("this is mail sender");
        }
    }

    public class SmsSender implements Sender {

        @Override
        public void sender() {
            System.out.println("this is sms sender");
        }
    }

    //工厂接口
    public interface Provider {
        public Sender produce();
    }
    //工厂类
    public class SendMailFactory implements Provider {

        @Override
        public Sender produce() {
            return new MailSender();
        }
    }
    public class SendSmsFactory implements Provider {

        @Override
        public Sender produce() {
            return new SmsSender();
        }
    }

    //测试类
    public static void main(String[] args) {
       Provider provider = new A1工厂方法模式FactoryModel().new SendMailFactory();
       Sender sender = provider.produce();
       sender.sender();
    }
}
