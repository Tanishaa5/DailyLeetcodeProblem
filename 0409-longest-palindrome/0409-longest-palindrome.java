class Solution {
    public int longestPalindrome(String s) {
        HashMap <Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        int length=0;
         for (int count : map.values()) {
            if (count % 2 == 0) {
                length += count;  // If the count is even, add it entirely
            } else {
                length += count - 1;  // If the count is odd, add (count - 1)
            }
        }
        if (length < s.length()) {
            length += 1;  // We can add one odd character to the center
        }
        return length;



        
    }
}