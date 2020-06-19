/**
 * 匿名内部类
 * 用法：多线程
 *
 *
 * 我是接口的实现方法
 * 我是匿名内部类中的方法
 * 使用匿名内部类创建抽象类对象
 * 调用m1(Student student)
 * 使用匿名内部类创建抽象类对象
 * 我是匿名内部类中的方法
 *
 */
public class demo3 {
    public static void main(String[] args) {
        //正常方式
        Zi zi=new Zi();
        zi.show();
        //匿名内部类
        Inter inter=new Inter(){
            //快捷键Alt+Enter
            @Override
            public void show() {
                System.out.println("我是匿名内部类中的方法");
            }
        };
        inter.show();
        Abstractclass a=new Abstractclass() {
            @Override
            void show() {
                System.out.println("使用匿名内部类创建抽象类对象");
            }
        };
        a.show();
        //普通类
        Student student=new Student(){
            @Override
            public void show() {
                System.out.println("调用m1(Student student)");
            }
        };
        m1(student);
        m2(a);
        m3(inter);
    }
    public static void m1(Student student){
        student.show();
    }
    public  static void m2(Abstractclass aclass){
        aclass.show();
    }
    public static void m3(Inter inter){
        inter.show();
    }
}
interface Inter{
    void show();
}
class Zi implements Inter{
    public void show(){
        System.out.println("我是接口的实现方法");
    }
}
abstract class Abstractclass{
    abstract void show();
}
class Student{
    public void  show(){
        System.out.println("我是普通类");
    }
}