class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate(n, 0, 0, "", result);
        return result;
    }

    public static void generate(int n, int open, int close, String current, ArrayList<String> result) {
        // Base case: when the current string reaches length 2 * n
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Include an open parenthesis if we haven't used all
        if (open < n) {
            generate(n, open + 1, close, current + "(", result);
        }

        // Include a close parenthesis only if there are more open ones
        if (close < open) {
            generate(n, open, close + 1, current + ")", result);
        }
    }
}
