class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Add elements to respective sets
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        // Find unique elements
        List<Integer> uniqueInNums1 = new ArrayList<>();
        List<Integer> uniqueInNums2 = new ArrayList<>();

        for (int num : set1) {
            if (!set2.contains(num)) uniqueInNums1.add(num);
        }

        for (int num : set2) {
            if (!set1.contains(num)) uniqueInNums2.add(num);
        }

        return Arrays.asList(uniqueInNums1, uniqueInNums2);
    }
}
