// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         int []hash=new int[1001];
//         for(int num:nums1){
//             hash[num]++;
//         }
//         ArrayList <Integer> result=new ArrayList<>();
//         for(int num:nums2){
//             if(hash[num]>0){
//                 result.add(num);
//                 hash[num]--;
                
//             }
//         }
//         int arr[]=new int[result.size()];
//         for(int i=0;i<result.size();i++){
//             arr[i]=result.get(i);
//         }
//         return arr;



        
//     }
// }


//hashmap
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num: nums1){

            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);//count or frequency increment
            }
            else{
                map.put(num,1);
            }
        }
        ArrayList<Integer>result=new ArrayList<>();

        for(int num:nums2){
            if(map.containsKey(num) && map.get(num)>0){
                result.add(num);
                map.put(num,map.get(num)-1);
            }
        }
         int arr[]=new int[result.size()];
        for(int i=0;i<result.size();i++){
            arr[i]=result.get(i);
        }
        return arr;


    }}