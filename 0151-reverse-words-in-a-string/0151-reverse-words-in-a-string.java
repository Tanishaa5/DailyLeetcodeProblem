class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String []arr=s.split("\\s+");
        int start=0;
        int n=arr.length;
        int end=n-1;
        
        while(start<end){
            String temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return String.join(" ",arr);//This line joins the elements of the words array into a single string, with a space (" ") separating each word.

        


        
        
        
        
    }
}