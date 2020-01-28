import java.util.Arrays;
public class ex30 {
    public static int gcd(int p, int q){
        if(q == 0)
            return p;
        if(p % q == 0)
            return q;
        else
            return gcd(q,p % q);
    }

    public static void main(String[] args) {
        int M = 10;
        int N = 8;
        boolean[][] a = new boolean[M][N];
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
            {
                int r = gcd(Math.max(i,j),Math.min(i,j));
                if(r == 1)
                    a[i][j] = false;
                else
                    a[i][j] = true;
            }
        System.out.println(Arrays.deepToString(a));
    }
}
