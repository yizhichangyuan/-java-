import src.Queue;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for(int i = 0; i < n; i++)
            queue.enqueue(i);
        while(!queue.isEmpty())
        {
            for(int i = 0; i < m -1 ; i++)
                queue.enqueue(queue.dequeue());
            System.out.print(queue.dequeue() + " ");
        }

    }
}
