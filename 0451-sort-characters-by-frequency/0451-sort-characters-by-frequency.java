class Solution {
    public String frequencySort(String s) {
        int [] freq=new int[128];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch]++;
        }

        StringBuilder res=new StringBuilder();
         while(res.length()<s.length()){
            int maxFreq=0;
            char maxChar=0;

            for(int i=0;i<128;i++){
                if(freq[i]>maxFreq){
                    maxFreq=freq[i];
                    maxChar=(char)i;
                }
            }

            for(int j=0;j<maxFreq;j++){
                res.append(maxChar);
            }

            freq[maxChar]=0;


         }
         return res.toString();
    }
}