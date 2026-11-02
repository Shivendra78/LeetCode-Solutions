
class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Take the first string as the starting prefix
        String prefix = strs[0];

        // Compare the prefix with every remaining string
        for (int i = 1; i < strs.length; i++) {

            // Keep shortening prefix until it matches the start
            // of the current string
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, no common prefix exists
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
