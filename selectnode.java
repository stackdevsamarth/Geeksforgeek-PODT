// Select nodes

class Solution{
    public int countVertex(int N, int[][] edges){
        // code here
        
        ArrayList<Integer> adj[]=new ArrayList[N+1];
        for(int i=0;i<=N;i++)
        adj[i]=new ArrayList<>();
        for(int i=0;i<N-1;i++)
        {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        
        //s2
        int[][]val=new int[N+1][2];
        for(int i=1;i<=N;i++)
        val[i][1]=1;
        
        //s3
        dfs(adj, 1,1, val);
        return Math.min(val[1][0], val[1][1]);
    }
    // we don't process the leaf notes
    public void dfs(ArrayList<Integer>adj[], int scr, int par, int val[][])
    {
        for(Integer v:adj[scr])
        { if(v!=par) //don't process the leaf nodes
        {
            dfs(adj, v, scr, val);
        }
        }
        for(Integer v:adj[scr])
        {
            if(v!=par)
            {
                val[scr][0] +=val[v][1]; //camera++;
                val[scr][1] +=Math.min(val[v][1], val[v][0]);
            }
        }
    }
}
