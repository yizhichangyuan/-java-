import src.Counter;

public class test {
    //基本数据类型作为参数传递的是该变量的一个副本，方法不会改变终端变量的值
    //将实例化对象作为参数，则会传递该对象的一个引用，而非副本，调用对象里的方法，会改变对象里的值，终端对象也会改变
    public void change(int a,Counter d){
        a = a + 1;
        d.incresment();
    }

    public static void main(String[] args) {
        int a = 3;
        test c = new test();
        Counter d = new Counter();
        Counter[] matrix = new Counter[10];
        System.out.println(matrix);
        System.out.println("length"+matrix.length);
        System.out.println("Counter d" + d);
        c.change(a,d);
        System.out.println(a);
        System.out.println(d);
    }
}
