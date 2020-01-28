public class ex13 {
    public static void printTransposeMatrix(int[][] matrix)
    {
        for(int i = 0; i < matrix[0].length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[][] a = {{1, 2, 3, 4},{1,2,3,4}};
        printTransposeMatrix(a);
    }
}
