
//brute-nested loops
//better-hashmap
// class Solution {
//     public int[] twoSum(int[] arr, int k) {
//         int []ans=new int[2];
//          Arrays.sort(arr);
//         int n =arr.length;
//         int left=0;
//         int right=n-1;
//         int sum=0;
//         while(left<right){
//             sum=arr[left]+arr[right];
//             if(sum==k){
//                 ans[0]=left;
//                 ans[1]=right;

//             }

//             else if(sum>k){
//                 right--;
//             }
//             else{
//                   left++;
//             }
//         }
//         return ans;


        
//     }
// }

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[i] + nums[j] == target) {
//                     return new int[]{i, j};
//                 }
//             }
//         }
//         return new int[]{}; // No solution found
//     }
// }

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // Find the maximum possible value in nums to define the hash array size
//         int maxVal = 0;
//         for (int num : nums) {
//             if (num > maxVal) {
//                 maxVal = num;
//             }
//         }
        
//         int[] hash = new int[maxVal + 1]; // Create hash array based on the maximum value
        
//         // Initialize hash array with -1 to indicate "not seen"
//         for (int i = 0; i <= maxVal; i++) {
//             hash[i] = -1;
//         }

//         // Traverse the array
//         for (int i = 0; i < nums.length; i++) {
//             int diff = target - nums[i];

//             // Check if the complement exists in hash
//             if (diff >= 0 && diff < hash.length && hash[diff] != -1) {
//                 return new int[] {hash[diff], i};
//             }

//             // Mark the current number's index in the hash array
//             if (nums[i] < hash.length) {
//                 hash[nums[i]] = i;
//             }
//         }

//         // If no solution is found, return an empty array
//         return new int[] {};
//     }
// }

class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap <Integer,Integer> map=new HashMap<>();
    for(int i=0;i<nums.length;i++){
        int diff=target-nums[i];
        if(map.containsKey(diff)){
           return new int[] {map.get(diff), i};//create an intialize the array on go

        }
         map.put(nums[i], i);
    }
     return new int[] {};//return an empty

  }}


    