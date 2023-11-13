// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

   void countSort(int[] arr, int size){
       int[] output = new int[size + 1];

       int max = arr[0];
       for(int i = 1; i < size; i++){
           if (arr[i] > max){
               max = arr[i];
           }
       }

       int[] count = new int[max + 1];
       for(int i = 0; i < max; i++){
           count[i] = 0;
       }

       for (int i = 0; i < size; i++ ){
           count[arr[i]]++;
       }

       for (int i = 1; i <= max; i++){
           count[i] += count[i-1];
       }

       for (int i = size - 1;i >= 0; i--){
           output[count[arr[i]] - 1] = arr[i];
           count[arr[i]]--;
       }

       for(int i = 0; i < size; i++){
           arr[i] = output[i];
       }
   }

    static void printArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i< n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        int[] data = {4,2,2,8,3,3,1};
        int size =  data.length;

        Main ob = new Main();
        ob.countSort(data, size);

        System.out.println("Data urutnya");
        printArray(data);

    }
}