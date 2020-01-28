import src.Queue;

public class ex2214 {
    public static Queue merge(Queue<Integer> a, Queue<Integer> b) {
        if (a.isEmpty() && b.isEmpty())
            return null;
        Queue<Integer> newQueue = new Queue<Integer>();
        boolean flag1 = true;
        boolean flag2 = true;
        int val1 = 0;
        int val2 = 0;

        while (!a.isEmpty() && !b.isEmpty()) {
            if (flag1) {
                val1 = a.dequeue();
                System.out.println("val1 " + val1);
            }

            if (flag2) {
                val2 = b.dequeue();
                System.out.println("val2 " + val2);
            }

            if (val1 < val2) {
                newQueue.enqueue(val1);
                flag2 = false;
                flag1 = true;
            } else {
                newQueue.enqueue(val2);
                flag1 = false;
                flag2 = true;
            }
        }

        if (a.isEmpty()) {
            boolean flagVal1NotEnqueue = true;
            while (!b.isEmpty()) {
                int cur = b.dequeue();
                if (flagVal1NotEnqueue && val1 >= cur)
                    newQueue.enqueue(cur);
                if (flagVal1NotEnqueue && val1 < cur) {
                    newQueue.enqueue(val1);
                    flagVal1NotEnqueue = false;
                }
                if (!flagVal1NotEnqueue)
                    newQueue.enqueue(cur);
            }
        }

        if (b.isEmpty()) {
            boolean flagVal2NotEnqueue = true;
            while (!a.isEmpty()) {
                int cur = a.dequeue();
                if (flagVal2NotEnqueue && val1 >= cur)
                    newQueue.enqueue(cur);
                if (flagVal2NotEnqueue && val1 < cur) {
                    newQueue.enqueue(val1);
                    flagVal2NotEnqueue = false;
                }
                if (!flagVal2NotEnqueue)
                    newQueue.enqueue(cur);
            }
        }
        return newQueue;
    }


    public static void main(String[] args) {
        Queue<Integer> a = new Queue<Integer>();
        Queue<Integer> b = new Queue<Integer>();
        a.enqueue(2);
        a.enqueue(9);
        b.enqueue(1);
        b.enqueue(10);
        Queue<Integer> c = merge(a,b);
        for(Integer each : c)
           System.out.print(each + " ");
    }
}
