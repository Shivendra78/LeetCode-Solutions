class Solution {
    public int countOdds(int low, int high) {
        int diff=high-low;
        if(diff==1){
            return 1;
        }
        int quotient=(int)diff/2;
        int ans;
        if((low%2!=0 && high%2!=0) || (low%2==0 && high%2!=0) || (low%2!=0 && high%2==0)){
         ans=quotient+1;
       }else{
        ans=quotient;
       }

       
        return ans;
    }
}