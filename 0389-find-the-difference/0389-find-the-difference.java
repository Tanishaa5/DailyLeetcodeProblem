class Solution {
    public char findTheDifference(String s, String t) {
        int[] hash = new int[26];

        // Step 1: Count frequency in s
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }

        // Step 2: Decrease frequency for t and find the extra character
        for (char c : t.toCharArray()) {
            hash[c - 'a']--;  
            if (hash[c - 'a'] < 0) { // The extra character will have a negative frequency
                return c;
            }
        }
        
        return ' '; // This will never be reached
    }
}
