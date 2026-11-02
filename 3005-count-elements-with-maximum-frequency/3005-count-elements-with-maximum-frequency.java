
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxCount = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean seenBefore = false;

            // Check if this element was already counted
            for (int k = 0; k < i; k++) {
                if (nums[k] == nums[i]) {
                    seenBefore = true;
                    break;
                }
            }

            if (seenBefore) {
                continue;
            }

            // Count the frequency of nums[i]
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            // Update maximum frequency and answer
            if (count > maxCount) {
                maxCount = count;
                ans = count;
            } else if (count == maxCount) {
                ans += count;
            }
        }

        return ans;
    }
}
