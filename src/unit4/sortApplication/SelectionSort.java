package unit4.sortApplication;

public class SelectionSort {
    public static void sort(Crate[] crates) {
        int n = crates.length;

        for (int i = 0; i < n; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (crates[j].compareTo(crates[min]) < 0) {
                    min = j;
                }
            }

            Crate temp = crates[i];
            crates[i] = crates[min];
            crates[min] = temp;
        }
    }
}
