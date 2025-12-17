package unit4.sort;

public class NaturalMergeSort {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; // Auxiliary array for merging
        int n = a.length;

        while (true) {
            int i = 0;
            int numRuns = 0; // Count of runs merged in the current pass

            // Find and merge pairs of runs
            while (i < n) {
                // Find the start of the left run
                int leftRunStart = i;
                while (i < n - 1 && a[i].compareTo(a[i + 1]) <= 0) {
                    i++;
                }
                int leftRunEnd = i;

                // If only one run left, we're done with this pass
                if (leftRunEnd == n - 1 && leftRunStart == 0 && numRuns == 0) {
                    return; // Array is fully sorted
                }
                if (leftRunEnd == n - 1) {
                    break; // End of current pass, remaining elements form a single run
                }

                i++; // Move to the start of the next potential run

                // Find the start of the right run
                int rightRunStart = i;
                while (i < n - 1 && a[i].compareTo(a[i + 1]) <= 0) {
                    i++;
                }
                int rightRunEnd = i;

                // Merge the two runs
                merge(a, aux, leftRunStart, rightRunStart, rightRunEnd);
                numRuns++;
            }
            // If only one run was found in the entire pass, the array is sorted
            if (numRuns == 0) { // This condition handles cases where the array is already sorted
                return;
            }
        }
    }

    // Standard merge function
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // Copy to auxiliary array
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid;
        for (int k = lo; k <= hi; k++) {
            if (i >= mid) { // Left run exhausted, take from right
                a[k] = aux[j++];
            } else if (j > hi) { // Right run exhausted, take from left
                a[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) { // Right element smaller
                a[k] = aux[j++];
            } else { // Left element smaller or equal
                a[k] = aux[i++];
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        Integer[] arr1 = {3, 1, 4, 1, 5, 9, 2, 6};
        NaturalMergeSort.sort(arr1);
        for (int x : arr1) {
            System.out.print(x + " "); // Output: 1 1 2 3 4 5 6 9
        }
        System.out.println();

        Integer[] arr2 = {1, 2, 3, 4, 5}; // Already sorted
        NaturalMergeSort.sort(arr2);
        for (int x : arr2) {
            System.out.print(x + " "); // Output: 1 2 3 4 5
        }
        System.out.println();
    }
}
