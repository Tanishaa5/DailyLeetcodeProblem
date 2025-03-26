// class Solution{
//     public int findPeakElement(int[] nums) {
//     int left = 0, right = nums.length - 1;
    
//     while (left < right) {
//         int mid = left + (right - left) / 2;

//         if (nums[mid] > nums[mid + 1]) { 
//             right = mid; // Peak is in the left half or at mid
//         } else { 
//             left = mid + 1; // Peak is in the right half
//         }
//     }
    
//     return left; // `left` and `right` will converge to a peak
// }
// }
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int s=0;
        int e=n-1;
        while(s<=e){
            int mid=s+(e-s)/2;
           
            
                if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1]))

                return mid; //ya to mid greater hain aage wale eleemnet se ya mid k aage koi element hi nhi hai mid last element h
            
            else if(nums[mid]<nums[mid+1]){
                s=mid+1;

            }
            else{
                e=mid-1;
            }
        }
        return -1;

        
    }
}
