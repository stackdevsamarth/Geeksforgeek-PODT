class Solution
{
    Node primeList(Node head){
        //code here
        
        //pre processing - seive
        int n=100000;
        boolean isPrime[] = new boolean [n];
        Arrays.fill(isPrime, true);//every num is prime
        
        for(int i=2; i*i<n; i++)
        {
            if(isPrime[i]==true)
            {
                for(int j=i*i ;j<n; j+=i)
                isPrime[j]=false;
            }
        }
        ///
        Node  curr = head;
        while(curr!=null)
        {
            if(curr.val==1)
            {
                curr.val=2; curr=curr.next ; continue;
            }
            // else
            int x=curr.val; int y= curr.val;
            while(!isPrime[x]) //O(1)
            x--;
             while(!isPrime[y]) 
            y++;
            
            //chech the nearest one
            if(curr.val-x > y-curr.val)
            {
                curr.val=y;
            }
            else //<=
            curr.val=x;
            
            curr=curr.next;
        }
        return head;
        
    }
   
}
