class Solution {
    public boolean canPlaceFlowers(int[]arr, int n) {
        int l=arr.length;
        if(n==0){
            return true;
        }
        for(int i=0;i<l;i++){
            if(arr[i]==0){
                if(((i==0) || (arr[i-1]==0)) && ((i==l-1) || (arr[i+1]==0))){
                    arr[i]=1;
                    n--;
                    if(n==0){
                        return true;
                    }
                }
            }
            

        }
        return false; //n<=0; //isko likhne ka matlab yhi h ki if its true then it will print true
        
    }
}
