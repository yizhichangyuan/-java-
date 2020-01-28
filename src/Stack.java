package src;
import java.util.Scanner;
import java.util.Iterator;
import java.lang.Iterable;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int N;

    //链表结构
    private class Node{
        Item item;
        Node next;
    }
    public Stack()
    {
        first = null;
        N = 0;
    }

    //拷贝构造函数
    public Stack(Stack<Item> stack)
    {
        //类里面可以访问stack.first，但如果实在类外，就不可以访问
        System.out.println("stack first " + stack.first.item);
        for(Node x = stack.first; x != null; x = x.next) {
            Node oldfirst = first;
            first = new Node();
            first.item = x.item;
            first.next = oldfirst;
            N++;
        }
    }

    //压入栈顶
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    //弹出栈顶
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    //返回栈大小
    public int size(){
        return N;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return N == 0;
        //return first == null;
    }


    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        private int i = N;
        private Node k = first;

        public boolean hasNext(){
            return k != null;
        }

        public Item next(){
            if(!hasNext()) throw new NoSuchElementException();
            Item element = k.item;
            k = k.next;
            return element;
        }
    }

    //访问栈顶元素
    public Item peek(){
        if(first != null)
            return first.item;
        else
            return null;
    }

//    //拷贝一个栈
//    public static Stack copy(Stack stack){
//        Stack<Object> stackCopy = new Stack<Object>();
//        Object[] array = new Object[stack.size()];
//        int index = 0;
//        for(Object each:stack){
//            array[index] = each;
//            index++;
//        }
//        for(int i = array.length - 1; i >= 0; i--)
//            stackCopy.push(array[i]);
//        return stackCopy;
//    }

    //删除栈中自栈顶的第K个元素
    public void delete(int k){
        if (k > N)
            System.out.println("栈中没有该元素");
        else {
            int i = 1;
            for (Node x = first; x != null; x = x.next){
                if(k == 1){
                    x = x.next;
                    N--;
                    break;
                }
                if(i == k - 1){
                    x.next = x.next.next;
                    N--;
                    break;
                }
                i++;
            }
        }
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for(Item each:this)
        {
            s.append(each);
            s.append(" ");
        }
        return s.toString();


    }
    //测试函数
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        System.out.println("please input string to push to stack");

        //不断压入栈顶，直到不再输入，command + D
        while(scan.hasNext()){
            String str = scan.next();
            stack.push(str);
            System.out.println("push string: " + str + " stack size: " + stack.size());
        }

        System.out.println("从栈顶遍历栈元素到栈底");
        //遍历
        for(String each : stack)
            System.out.print(each + " ");
        System.out.println();

        //访问栈顶元素
        System.out.println("栈顶元素" + stack.peek());

        //创建字符串栈型数组
        Stack<String>[] a = (Stack<String>[]) new Stack[10];

        //拷贝栈
        Stack<String> stack2 = new Stack<String>(stack);
//        Stack<String> stack2 = Stack.copy(stack);
        System.out.println(stack2.size());
        for(String each:stack2)
            System.out.println("copy " + each);

        //测试toString
        System.out.println("test toString");
        System.out.println(stack);

        //验证在类的成员函数里可以访问一个同类实例对象的私有成员
        System.out.println("stack first " + stack.first.item);

        //不断弹出，直到栈空
        while(!stack.isEmpty()){
            String str1 = stack.pop();
            System.out.println("pop string: " + str1 + " stack size: " + stack.size());
        }

        //删除栈中自栈顶第二个元素
        stack2.delete(2);

        System.out.println("删除指定元素后的栈");
        for(String each:stack2)
            System.out.println("copy " + each);
        System.out.println("end");

//        //测试拷贝构造函数
//        Stack<String> stack3 = new Stack<String>(stack2);
//        for(String each:stack3)
//            System.out.print(each + " ");
    }
}
