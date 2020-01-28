package src;
import java.io.*;
public class FixedCapacityStackOfItem<Item>
{
    private Item[] a;
    private int N;

    public FixedCapacityStackOfItem(int cap) {
        a = (Item[])new Object[cap];
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if(N==a.length)
            transfer(2*a.length);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;//避免对象游离，将其设置为null，java垃圾回收知晓这个引用的对象没法在被访问，就会回收
        if(N == a.length / 4)
        {
            transfer(a.length/2);
        }
        return item;
    }

    public boolean isFull()
    {
        return N == a.length;
    }

    private void transfer(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;//将引用a指向temp引用指向的对象
    }

    public static void main(String[] args) {
        src.FixedCapacityStackOfItem s;
        s = new src.FixedCapacityStackOfItem<String>(100);
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
            while(s.size()!=0){
                System.out.printf(s.pop() + " ");
            }
        }
        catch(IOException e){
                e.printStackTrace();
            }
        }
    }
