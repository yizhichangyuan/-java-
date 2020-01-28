package src;
import java.io.*;
import java.util.Iterator;

public class IterableFixedCapacityStackOfItem<Item> implements Iterable<Item>
{
    private Item[] a;
    private int N;

    //构造函数，指定大小，创建相应大小空间的栈
    public IterableFixedCapacityStackOfItem(int cap) {
        a = (Item[])new Object[cap];
    }

    //可以迭代输出for(Item each: s)
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    //返回栈已经存储元素的个数
    public int size() {
        return N;
    }

    //从栈顶压入元素
    public void push(Item item) {
        if(N==a.length)
            transfer(2*a.length);
        a[N++] = item;
    }

    //从栈顶弹出
    public Item pop() {
        Item item = a[--N];
        a[N] = null;//避免对象游离，将其设置为null，java垃圾回收知晓这个引用的对象没法在被访问，就会回收
        if(N == a.length / 4)
        {
            transfer(a.length/2);
        }
        return item;
    }

    //动态根据栈使用情况改变栈的大小
    private void transfer(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;//将引用a指向temp引用指向的对象
    }

    //嵌套类，实现Iterator，必须含有next(),hasNext();
    private class ReverseArrayIterator implements Iterator<Item>
    {//嵌套类可以访问它的类的实例的变量
        private int count = N;
        public boolean hasNext() {return count > 0;}
        public Item next() {return a[--count];}
    }

    //测试函数
    public static void main(String[] args) {
        IterableFixedCapacityStackOfItem s;
        s = new IterableFixedCapacityStackOfItem<String>(100);
        File file = new File(args[0]);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                String[] strList = str.split(" ");
                for (String each : strList){
                    if (!each.equals("-"))
                    {
                        System.out.println(each);
                        s.push(each);
                    }
                }
            }
            System.out.println();
            for(Object str1 : s)
            {
                System.out.println(str1);
            }
            while(s.size()!=0){
                System.out.print(s.pop()+ " ");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
