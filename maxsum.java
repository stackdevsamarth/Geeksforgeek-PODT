//4-Feb //Max Sum without Adjacents

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        
        if(n==1)
        return arr[0];
        
        //s1 -- pre processing for 1st ele
        int icl = arr[0]; //max sum includinf the 0th ele
        int ecl = 0; // max sum excluding 0th ele
        int new_icl=0;
        
        ////s2 - from 2nd ele onwards
        for(int i=1; i<n; i++)
        {
            new_icl = arr[i] + ecl; // taking ith ele + max sum poss from [0 to (i-2)]
            ecl = Math.max(icl, ecl); // if not considering ith-> u cant take and not take i-1 - and take its max
            
            
            icl = new_icl;
        }
        return Math.max(new_icl,ecl);
    }
}
