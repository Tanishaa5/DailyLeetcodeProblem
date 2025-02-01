class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // int offset=100000;//bigger value
        // int hash[]=new int[2*offset+1];//negative number k liye jagah positive index
        // for(int i=0;i<hash.length;i++){
        //     hash[i]=-1;
        // }

        // for(int i=0;i<nums.length;i++){
        //     int num=nums[i];
        //     if(hash[num+offset]!=-1 && i-hash[num+offset]<=k){
        //         return true;
        //     }
        //     else{
        //         hash[num+offset]=i;
        //     }
        // }
        // return false;

        //hashMap to handle large inputs
        HashMap <Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
             if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return false;
        
    }
}