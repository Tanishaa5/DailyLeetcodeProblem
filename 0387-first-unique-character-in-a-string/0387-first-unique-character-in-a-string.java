class Solution {
    public int firstUniqChar(String s) {
       int [] hash=new int[26];//26 alphabets
       for(char c:s.toCharArray()){
        hash[c-'a']++;//jaha pe character store hoga hash me vaha pe value 1 ho ja rhi h phir
        //increase hoti jyegi

        
       }
       for(int i=0;i<s.length();i++){
        if(hash[s.charAt(i)-'a']==1){
            return i;
        }
       }
        return -1;



        
    }
}