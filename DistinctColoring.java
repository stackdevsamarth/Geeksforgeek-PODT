//Distinct Coloring. //1-feb-2023


class Solution{
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        //code here
        
        long dp[][] = new long[N][3]; // bcoz given 3 colors.
        
        //s2  - fill 1st row of dp with 1st col of colors
        dp[0][0] = r[0]; dp[0][1] = g[0]; dp[0][2] = b[0];
        //
        
        //s3
        for(int i=1 ; i<N ;i++)
        {
            dp[i][0]  = r[i] + Math.min(dp[i-1][1] , dp[i-1][2]);
             dp[i][1]  = g[i] + Math.min(dp[i-1][0] , dp[i-1][2]);
              dp[i][2]  =  b[i] + Math.min(dp[i-1][0] , dp[i-1][1]);
        }
        
        return Math.min(Math.min(dp[N-1][0], dp[N-1][1]) , dp[N-1][2] );
        
    }
}
