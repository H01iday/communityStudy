package leetcode;

public class test {

    // 静态变量
    public static String staticField = "静态变量";

    // 变量
    public String field = "变量";

    // 静态初始化块
    static {
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

    // 初始化块
    {
        System.out.println(field);
        System.out.println("初始化块");
    }

    // 构造函数
    public test(){
        System.out.println("构造函数");
    }

    // main方法
    public static void main(String[] args) {
        System.out.println("构造函数之前");
        new test();
    }


}
