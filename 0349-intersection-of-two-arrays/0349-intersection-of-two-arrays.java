class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int []hash=new int[1001];
        for(int num:nums1){
            hash[num]=1;//mark the presence
        }
        ArrayList <Integer> result=new ArrayList<>();
        for(int num:nums2){
            if(hash[num]==1){//check if second array element also exist in first array
                result.add(num);
                hash[num]=0;//to avoid duplicate
            }
        }
        int arr[]=new int[result.size()];
        for(int i=0;i<result.size();i++){
            arr[i]=result.get(i);
        }
        return arr;

        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int num:nums1){
        //     map.put(num,1);//and if it is already present in hashmap then it won't do anything
        // }
        // ArrayList<Integer>result=new ArrayList<>();
        // for(int num:nums2){
        //     if(map.containsKey(num) && map.get(num)==1){
        //         result.add(num);
        //        map.put(num, map.get(num) - 1);

        //     }
        // }
        // int []ans=new int[result.size()];
        // for(int i=0;i<result.size();i++){
        //     ans[i]=result.get(i);
        // }
        // return ans;




        
    }
}