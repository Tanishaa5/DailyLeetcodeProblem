class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans=ans^nums[i];//sare same number ko vo 0 kr dega and answer me bas 1 rhega 
        }
        return ans;
        
    }
}