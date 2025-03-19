class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }

        int s=1;
        int e=max;
        int finalans=-1;

        while(s<=e){
            
            int mid=s+(e-s)/2;
            int val=sum(nums,mid);
            if(val<=threshold){
                finalans=mid;
                e=mid-1;


            }
            else {
                s=mid+1;
            }


            


        }
        return finalans;
    }

        public static int sum(int []nums,int mid){
            int ans=0;
            for(int i=0;i<nums.length;i++){
                ans += (nums[i] + mid - 1) / mid;//
            }
            return ans;
        }


        
    
}