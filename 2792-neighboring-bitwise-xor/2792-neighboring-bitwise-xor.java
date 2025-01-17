class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        // Check if assuming original[0] = 0 works
        if (isValid(derived, 0)) {
            return true;
        }
        // Check if assuming original[0] = 1 works
        if (isValid(derived, 1)) {
            return true;
        }
        return false;
    }

    private boolean isValid(int[] derived, int firstValue) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = firstValue;

        // Compute the rest of the original array
        for (int i = 1; i < n; i++) {
            original[i] = derived[i - 1] ^ original[i - 1];
        }

        // Check the circular condition
        return (derived[n - 1] == (original[n - 1] ^ original[0]));
    }
}
