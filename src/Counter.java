package src;
import java.util.List;
import java.util.ArrayList;

public class Counter
{
    //如果在类中声明变量可以不赋值，构造对象时会获得默认值
    //如果在方法中声明变量，必须赋初始值，对于成员变量是int，默认初始值是0
    public int count;
    public List list = new ArrayList<Integer>();
    public void incresment()
    {
        count++;
    }

    public String toString(){
        return Integer.toString(count);
    }

    public void record(int i){
        list.add(i);
    }

    public static void main(String[] args) {
        Counter a = new Counter();
        a.incresment();
        System.out.println(a);
    }
}