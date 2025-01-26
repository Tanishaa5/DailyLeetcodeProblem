class Solution {
    public String reverseWords(String s) {
        // Trim leading and trailing spaces and then split by one or more spaces
        s = s.trim();

        String[] words = s.split("\\s+");
        int left = 0;
        int right = words.length - 1;

        // Reverse the words array
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        // Join the words with a single space between them and return the result
        return String.join(" ", words);
    }    
}
