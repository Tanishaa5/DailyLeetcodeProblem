class Solution {
    public int[] searchRange(int[] arr, int k) {
        int ans[]=new int[2];
        ans[0]=first(arr,k);
        ans[1]=last(arr,k);
        return ans;

        
    }

    public static int  first(int[]arr,int k){
        int left=0;
        int n=arr.length;
        int right=n-1;
        int res=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==k){
                res=mid;
                right=mid-1;

            }
            else if(arr[mid]<k){
                left=mid+1;
            }
            else{
                right=mid-1;
            }


        }
        return res;
    }


public static int  last(int[]arr,int k){
        int left=0;
        int n=arr.length;
        int right=n-1;
        int res=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==k){
                res=mid;
                left=mid+1;

            }
            else if(arr[mid]<k){
                left=mid+1;
            }
            else{
                right=mid-1;
            }


        }
        return res;
    }
}
