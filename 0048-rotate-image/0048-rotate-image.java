class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int rows=n;
        int columns=n;
       int[][] ans=new int[rows][columns];
       for(int i=0;i<n;i++)
       {
        for(int j=0;j<n;j++)
        {
            ans[j][n-1-i]=matrix[i][j];
        }
       }
       for(int i=0;i<n;i++)
       {
        for(int j=0;j<n;j++)
        {
            matrix[i][j]=ans[i][j];
        }
       }
    }
}