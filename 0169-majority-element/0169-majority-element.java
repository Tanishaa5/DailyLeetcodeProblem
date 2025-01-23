class Solution {
//     public int majorityElement(int[] nums) {
//         int n=nums.length;
//         Arrays.sort(nums);
//         return nums[n/2];

        
//     }
// }
//bayers voting algo
public int majorityElement(int[] arr) {
    int candi=0;
    int count=0;
    int n=arr.length;

    for(int i=0;i<n;i++){
        if(count==0){
            candi=arr[i];
            count++;
        }
        else if(arr[i]==candi){
            count++;
        }
        else{
            count--;
        }



    }
    return candi;
        

        
    }
    }