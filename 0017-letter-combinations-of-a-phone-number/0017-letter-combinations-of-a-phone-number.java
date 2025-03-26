import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        // Mapping of digits to letters
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        helper(digits, map, 0, current, result);
        return result;
    }

    // Helper function
    public static void helper(String digits, HashMap<Character, String> map, int i, StringBuilder current, List<String> result) {
        // Base case: If index reaches the length of digits, add to result
        if (i == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map.get(digits.charAt(i));

        // Recursive case: Iterate over each letter
        for (char c : letters.toCharArray()) {
            current.append(c);
            helper(digits, map, i + 1, current, result);
            current.deleteCharAt(current.length() - 1);  // Backtrack to remove the last added character
        }
    }
}
