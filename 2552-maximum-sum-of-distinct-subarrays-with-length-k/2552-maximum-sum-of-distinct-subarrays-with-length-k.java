class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long sum=0;
        long max=0;

        HashSet<Integer> set=new HashSet<>();
        int left=0;

        for(int i=0;i<n;i++){
            while(set.contains(nums[i])){
                set.remove(nums[left]);
                sum-=nums[left];
                left++;


            }//if set contain kiya h toh this 
            sum+=nums[i];
            set.add(nums[i]);

            if(set.size()==k){
                max=Math.max(sum,max);
                set.remove(nums[left]);
                sum-=nums[left];
                left++;


            }
           




        }
        return max;

        
    }
}