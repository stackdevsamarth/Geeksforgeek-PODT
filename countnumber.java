//8-feb //Count number of free cell

class Solution {
    long[] countZero(int N, int K, int[][] arr){
        // code here
        //1 
        Set<Integer> row = new HashSet<>(); //O(k)
        Set<Integer> col = new HashSet<>();
        
        int r=N; int c=N;
        long ans[] = new long[K];
        long curr_res =N*N;
        //s3
        for(int i=0; i<K; i++) //O(k)
        {
            int x = arr[i][0]; int y= arr[i][1];
            if(!row.contains(x) && !col.contains(y))
            {
                curr_res = curr_res - r -c +1;
                c--; r--;
            }
            if(row.contains(x) && !col.contains(y))
            {
                curr_res = curr_res -r; c--;
            }
            if(!row.contains(x) && col.contains(y))
            {
                 curr_res = curr_res -c; r--;
            }
            row.add(x); col.add(y);
             ans[i] = curr_res;
        }
        return ans;
    }
 }
