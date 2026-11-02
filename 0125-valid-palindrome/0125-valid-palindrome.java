class Solution {
    public boolean isPalindrome(String s) {
        String result=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int low=0;
        int high=result.length()-1;

        while(low<high){
            if(result.charAt(low)!=result.charAt(high)){
                return false;
            }
        low++;
        high--;
        }

        return true;

    }
}