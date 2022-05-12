package leetcode;

public class Child extends Parent{
    // 静态变量
    public static String c_StaticField = "子类--静态变量";

    // 变量
    public String c_Field = "子类--变量";

    // 静态初始化块
    static {
        System.out.println(c_StaticField);
        System.out.println("子类--静态初始化块");
    }

    // 初始化块
    {
        System.out.println(c_Field);
        System.out.println("子类--初始化块");
    }

    // 构造方法
    public Child(){
        System.out.println("子类--构造方法");
    }

    public static void main(String[] args) {
        System.out.println("子类--构造方法之前");
        new Child();
    }
}
