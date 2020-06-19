public class demo1 {
    public static void main(String[] args) {
        //创建内部类对象
        //Body.heart s=new Body().new heart();
        //s.show();
        Body b=new Body();
        b.getheart();
    }

}
class Body{
    int num=1;
    private class heart{
        int num=2;
        public void show(){
            System.out.println("我是内部类中的方法");
            //访问外部类中的成员变量
            System.out.println(Body.this.num);
            //访问外部类中的成员方法
            Body.this.m1();
            System.out.println(this.num);
        }
    }
    //提供一个访问内部类的发式
    public void getheart(){
        heart h=new heart();
        h.show();
    }
    public void m1(){
        System.out.println("我是外部类成员");
    }
}