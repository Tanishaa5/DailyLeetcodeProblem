class Solution {

    public static final long M = 1000000007;

    public long power(long x, long y) { // Change return type to long
        if (y == 0) {
            return 1; // Base case
        }

        long half = power(x, y / 2);
        half = (half * half) % M;

        if (y % 2 == 1) { // If y is odd
            half = (half * x) % M;
        }

        return half; // Return long value
    }

    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = n / 2 + n % 2;

        long result = (power(5, even) * power(4, odd)) % M;
        return (int) result; // Cast result to int before returning
    }
}
