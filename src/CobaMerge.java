public class CobaMerge {


    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int[] arr, int kiri, int tengah, int kanan)
    {

        // Find sizes of two subarrays to be merged
        int nilai1 = tengah - kiri + 1;
        int nilai2 = kanan - tengah;

        // Create temp arrays
        int[] arrayKiri = new int[nilai1];
        int[] arrayKanan = new int[nilai2];

        // Copy data to temp arrays
        for (int i = 0; i < nilai1; i++)
            arrayKiri[i] = arr[kiri + i];
        for (int j = 0; j < nilai2; j++)
            arrayKanan[j] = arr[tengah + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = kiri;
        while (i < nilai1 && j < nilai2) {
            if (arrayKiri[i] <= arrayKanan[j]) {
                arr[k] = arrayKiri[i];
                i++;
            }
            else {
                arr[k] = arrayKanan[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < nilai1) {
            arr[k] = arrayKiri[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < nilai2) {
            arr[k] = arrayKanan[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[kiri..kanan] using
    // merge()
    void sort(int[] arr, int kiri, int kanan)
    {
        if (kiri < kanan) {

            // Find the middle point
            int tengah = kiri + (kanan - kiri) / 2;

            // Sort first and second halves
            sort(arr, kiri, tengah);
            sort(arr, tengah + 1, kanan);

            // Merge the sorted halves
            merge(arr, kiri, tengah, kanan);
        }
    }

    // A utility function to print array of size n
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void onStart(){
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is");
        printArray(arr);

        CobaMerge ob = new CobaMerge();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}
