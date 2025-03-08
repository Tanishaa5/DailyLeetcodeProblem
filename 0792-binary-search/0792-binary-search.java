class Solution {
    public int search(int[] nums, int target) {
        return recursiveBinary(nums, 0, nums.length - 1, target);
    }

    public int recursiveBinary(int[] nums, int start, int end, int target) {
        // Base case: If the search space is exhausted
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2; // To prevent integer overflow

        if (nums[mid] == target) {
            return mid; // Target found
        } else if (nums[mid] > target) {
            return recursiveBinary(nums, start, mid - 1, target); // Search left half
        } else {
            return recursiveBinary(nums, mid + 1, end, target); // Search right half
        }
    }
}



// class Solution {
//     public int search(int[] nums, int target) {
//         int start=0;
//         int end=nums.length-1;
//         while(start<=end){
//             int mid=(start+end)/2;

//             if(nums[mid]==target){
//                 return mid;
//             }
//             else if(nums[mid]>target){
//                 end=mid-1;
//             }
//             else{
//                 start=mid+1;
//             }
//         }
//         return -1;

        
//     }
// }