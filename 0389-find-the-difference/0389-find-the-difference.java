// class Solution {
//     public char findTheDifference(String s, String t) {
//         int[] hash = new int[26];

//         // Step 1: Count frequency in s
//         for (char c : s.toCharArray()) {
//             hash[c - 'a']++;
//         }

//         // Step 2: Decrease frequency for t and find the extra character
//         for (char c : t.toCharArray()) {
//             hash[c - 'a']--;  
//             if (hash[c - 'a'] < 0) { // The extra character will have a negative frequency
//                 return c;
//             }
//         }
        
//         return ' '; // This will never be reached
//     }
// }
//Hashmap
class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);


            }else{
                map.put(c,1);
            }
        }
        for(char c:t.toCharArray()){
            if (!map.containsKey(c) || map.get(c) == 0) {
                return c;  // This is the extra character
            } else {
                map.put(c, map.get(c) - 1);  // Decrement the count as we find a match
            }
        }
        return ' ';
    }}

