class Solution {
    public void moveZeroes(int[] nums) {
        int insertValue=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[insertValue]=nums[i];
                insertValue++;
            }
        }

        for(int i=insertValue;i<nums.length;i++){
            nums[i]=0;
        }
    }
}