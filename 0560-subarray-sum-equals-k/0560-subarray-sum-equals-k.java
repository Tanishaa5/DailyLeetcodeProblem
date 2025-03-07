class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        int psum=0;
        int count=0;

        for(int i=0;i<n;i++){
            psum+=nums[i];

            if(map.containsKey(psum-k)){
                count+=map.get(psum-k);
            }
            map.put(psum,map.getOrDefault(psum,0)+1);
        }
        return count;

        
    }
}

//brute 
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int n=nums.length;
//         int count=0;
//         for(int i=0;i<n;i++){
//             int sum=0;
//             for(int j=i;j<n;j++){
//                 sum+=nums[j];
//                 if(sum==k){
//                     count++;
//                 }
//                 }
//         }
//         return count;
//     }
// }

