class Solution {
    public String largestOddNumber(String num) {

        // Start checking from the last digit
        for (int i = num.length() - 1; i >= 0; i--) {

            // Convert character into an integer
            int digit = num.charAt(i) - '0';

            // Check whether the digit is odd
            if (digit % 2 != 0) {

                // Return the string from index 0 to i
                return num.substring(0, i + 1);
            }
        }

        // If no odd digit is found, return empty string
        return "";
    }
}