import java.util.Arrays;

public class ex27 {
    public static int Count = 0;
    public static double[][] matrix;
    public static double binomial(int N, int k, double p)
    {
        Count++;
        if(N == 0 && k == 0)
            return 1.0;
        if(N < 0 || k < 0)
            return 0.0;
        matrix[N][k] = (1.0 - p) * binomial(N-1, k, p) + p * binomial(N-1, k-1,p);
        return matrix[N][k];
    }

    public static double betterBinomial(int N, int k, double p){
        matrix = new double[N+1][k+1];
        return binomial(N,k,p);
    }

    public static void main(String[] args) {
        System.out.println(betterBinomial(100,3,0.25));
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("迭代次数"+Count);
    }
}
