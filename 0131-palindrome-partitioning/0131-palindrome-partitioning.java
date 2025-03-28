class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
         List<String> current = new ArrayList<>();
        helper(s,0,current,result);
        return result;
        }

        public static void helper(String s,int start,List<String>current,List<List<String>>result){
            //base case
            if(start==s.length()){
                result.add(new ArrayList<>(current));
                return;
            }
            for(int end=start;end<s.length();end++){
                if(isPalindrome(s,start,end)){
                    current.add(s.substring(start,end+1));
                    helper(s,end+1,current,result);//current end k possibilities ko explore 
                    //karna hi
                    current.remove(current.size()-1);
                }

            }
        }

        private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}