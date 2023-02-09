class Solution
{
    public int maximumMatch(int[][] G)
    {
        // Code here
        int M= G.length;
        int N=G[0].length;
        int ans = fun(G, M,N);
        return ans;
    }
    // fun
    int fun(int G[][], int M, int N)
    {
        //vis for each job
        int match[] = new int[N]; // mactch[i] = applicant numbr ass to i;
        for(int i=0; i<N; i++)
        match[i] =-1;
         
         int res =0; 
         for(int u=0; u<M; u++) // itr for every person
         {
             boolean seen[] = new boolean[N]; // mark all jibs as not vis
            
            //find if u can get a job
            if(bpm(G, u, seen, match, M, N)) //-O(n^3)
            res++;
         }
        //  for(int x : match)
        //  System.out.print(x+" ");
         return res;
      }
      boolean bpm(int G[][], int u, boolean seen[], int match[], int M, int N)
      {
          //try every job
          for(int v= 0;v<N ;v++)
          {
              if(G[u][v]==1 && !seen[v]) // poss and not vis => assign
              {
                  seen[v] =true;
              
              //if job v is ont assig || assigned app has no other job available
              if(match[v]<0 || bpm(G, match[v], seen, match, M, N))
              {
                  match[v] =u;
                  return true;
              }
             }
              
          }
          return false;
      }
      
      
      
}
