class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0;
        int r=0;
        int maxl=0;
        


        HashMap <Character,Integer> map=new HashMap<>();
        while(r<n){
            if(map.containsKey(s.charAt(r))){
                l=Math.max(l,map.get(s.charAt(r))+1);

           

            }
            map.put(s.charAt(r),r);
            int len=r-l+1;
            maxl=Math.max(maxl,len);
            r++;
            }
            return maxl;

        }
      


        
    }



// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int[] hash = new int[256];
//         for (int i = 0; i < 256; i++) {
//             hash[i] = -1;
//         }

//         int n = s.length();
//         int l = 0, r = 0;
//         int maxlen = 0;

//         while (r < n) {
//             if (hash[s.charAt(r)] != -1 && hash[s.charAt(r)] >= l) {
//                 l = hash[s.charAt(r)] + 1;
//             }
//             // Update the position of the character in the hash array
//             hash[s.charAt(r)] = r;

//             // Calculate the current length and update max length
//             maxlen = Math.max(maxlen, r - l + 1);

//             r++; // Move the right pointer
//         }

//         return maxlen; // Return the maximum length after the loop
//     }
// }
