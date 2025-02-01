class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int []hash=new int[1001];
        for(int num:nums1){
            hash[num]++;
        }
        ArrayList <Integer> result=new ArrayList<>();
        for(int num:nums2){
            if(hash[num]>0){
                result.add(num);
                hash[num]--;
                
            }
        }
        int arr[]=new int[result.size()];
        for(int i=0;i<result.size();i++){
            arr[i]=result.get(i);
        }
        return arr;



        
    }
}