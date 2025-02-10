class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k);//max size k
     for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }

        return minHeap.peek(); // The root of the heap is the kth largest
    }
}