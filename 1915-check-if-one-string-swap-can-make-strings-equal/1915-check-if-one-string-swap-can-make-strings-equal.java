class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;  // Already equal

        int n = s1.length();
        int count = 0;
        int[] diff = new int[2];  // To store differing indices

        // Find differing indices
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count == 2) return false;  // More than 2 differences
                diff[count++] = i;
            }
        }

        // Check if swapping fixes the strings
        return count == 2 && s1.charAt(diff[0]) == s2.charAt(diff[1]) && s1.charAt(diff[1]) == s2.charAt(diff[0]);
    }
}
