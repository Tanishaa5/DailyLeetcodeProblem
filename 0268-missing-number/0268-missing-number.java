class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        boolean found;
        for(int i=0;i<=n;i++){
            found=false;
            for(int j=0;j<n;j++){
                if(nums[j]==i){
                    found=true;
                    break;

                }
            }
            if(found==false){
                return i;
            }



            
            

        }
        return -1;
        
    }
}