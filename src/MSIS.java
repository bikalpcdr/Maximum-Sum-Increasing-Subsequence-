import java.util.ArrayList;
import java.util.List;

public class MSIS {

    // Function to find the maximum sum of an increasing subsequence and the subsequence itself
    public static List<Integer> maxSumIS(int[] arr) {
        int n = arr.length;
        int[] msis = new int[n];
        int[] predecessor = new int[n];

        // Initialize msis values for all indexes and predecessor array
        for (int i = 0; i < n; i++) {
            msis[i] = arr[i];
            predecessor[i] = -1;
        }

        // Compute maximum sum values in a bottom-up manner
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                    predecessor[i] = j;
                }
            }
        }

        // Find the maximum value in msis array and its index
        int maxSum = msis[0];
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (msis[i] > maxSum) {
                maxSum = msis[i];
                maxIndex = i;
            }
        }

        // Trace the subsequence using the predecessor array
        List<Integer> sequence = new ArrayList<>();
        int currentIndex = maxIndex;
        while (currentIndex != -1) {
            sequence.add(0, arr[currentIndex]);
            currentIndex = predecessor[currentIndex];
        }

        // Print the maximum sum
        System.out.println("Maximum sum of increasing subsequence: " + maxSum);

        return sequence;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        List<Integer> sequence = maxSumIS(arr);
        System.out.println("Subsequence with maximum sum: " + sequence);
    }
}