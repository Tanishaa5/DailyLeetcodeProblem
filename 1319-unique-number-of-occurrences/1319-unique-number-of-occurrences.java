import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        //to count occurence 
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> freqSet = new HashSet<>();

        // Check if occurrences are unique
        for (int freq : freqMap.values()) {
            if (!freqSet.add(freq)) {
                return false; // Duplicate frequency found
            }
        }
        
        return true;
    }
}
