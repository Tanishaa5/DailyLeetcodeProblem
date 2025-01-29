//brute 
// class Solution {
//     public boolean increasingTriplet(int[] arr) {
//         int n=arr.length;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 for(int k=j+1;k<n;k++){
//                    if ((arr[i] < arr[j] && arr[j] < arr[k]) && (i < j && j < k)) {
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;

        
//     }
// }
//optimal
class Solution {
    public boolean increasingTriplet(int[] arr) {
        int n = arr.length;
        int first = Integer.MAX_VALUE;  // smallest number found so far
        int second = Integer.MAX_VALUE; // second smallest number found so far
        
        for (int i = 0; i < n; i++) {
            if (arr[i] <= first) {
                // Update the first value if we find a smaller number
                first = arr[i];
            } else if (arr[i] <= second) {
                // Update the second value if the current number is between first and second
                second = arr[i];
            } else {
                // If we find a number larger than both first and second, we've found a triplet
                return true;
            }
        }
        
        return false; // No triplet found
    }
}
