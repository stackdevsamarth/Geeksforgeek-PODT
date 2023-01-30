// Minimum times A has to be repeated such that B is a substring of it

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        int count=1;   
        String rep =A; // O(b)
        
        //s2
        while(rep.length() < B.length())  // A = 'c'  and b= 10ch
        {
            rep+=A;  // O(n) = O(B * a)
            count++;
        }
        if(rep.contains(B))  // O(b)
        {
            return count;
        }
        //2nd poss
        rep+=A;
        if(rep.contains(B)) return count+1; //o(b)
        
        //
        return -1;
    }
};
