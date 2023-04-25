//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            int ans = ob.goodSubsets(a, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public int goodSubsets(int[] arr, int n) {
        // Code here
        int mm[]= new int[31];
        mm[2] = 1;
        mm[3] = 2;
        mm[5] = 4;
        mm[6] = 3;
        mm[7] = 8;
        mm[10] = 5;
        mm[11] = 16;
        mm[13] = 32;
        mm[14] = 9;
        mm[15] = 6;
        mm[17] = 64;
        mm[19] = 128;
        mm[21] = 10;
        mm[22] = 17;
        mm[23] = 256;
        mm[26] = 33;
        mm[29] = 512;
        mm[30] = 7;
        int f[] = new int[31];
        int c=0;
        for(int x:arr){
            if(x==1)c++;
            else f[x]++;
        }
        long dp[] = new long[1024];
        int mod = 1000000007;
        dp[0]=1;
        for(int j=2;j<31;j++){
            if(f[j]!=0 && mm[j]!=0){
                for(int i=0;i<1024;i++){
                    if((mm[j]&i)==0){
                        dp[(mm[j]|i)]+=(f[j]*dp[i]);
                        dp[(mm[j]|i)]%=mod;
                    }
                }
            }
        }
        int ans=0;
        for(int i=1;i<1024;i++){
            ans+=dp[i];
            ans%=mod;
        }
        while(c!=0){
            ans*=2;
            ans%=mod;
            c--;
        }
        return ans;
    }
};
