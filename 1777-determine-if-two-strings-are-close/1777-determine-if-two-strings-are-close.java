class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        // map to store character frequency
        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        // Count freq of each character in word1
        for (char c : word1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }
        // Count frequency of each character in word2
        for (char c : word2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }

        // Step 1: Both words should have the same set of characters
        if (!freq1.keySet().equals(freq2.keySet())) return false;

        // Step 2: Both words should have the same frequency distribution
        List<Integer> values1 = new ArrayList<>(freq1.values());
        List<Integer> values2 = new ArrayList<>(freq2.values());

        Collections.sort(values1);
        Collections.sort(values2);

        return values1.equals(values2);
    }
}
