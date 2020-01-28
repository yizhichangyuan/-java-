import java.util.Scanner;
import java.util.Arrays;
public class ex21 {
    public static void printExcel(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = n;
//        System.out.println();
        String[] name = new String[n];
        double[] val1 = new double[n];
        double[] val2 = new double[n];
        int i = 0;
        while(n != 0)
        {
            name[i] = scan.next();
            val1[i] = scan.nextDouble();
            val2[i] = scan.nextDouble();
            i++;
            n--;
        }
        System.out.println(Arrays.toString(val1));
        for(int j= 0; j < m; j++) {
            System.out.printf("%4s %4f %4f %4f",name[j],val1[j],val2[j],val1[j] / val2[j]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printExcel();
    }

}
