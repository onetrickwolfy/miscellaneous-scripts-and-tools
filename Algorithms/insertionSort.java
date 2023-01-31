package sort;

public class insertionSort {

    public static int[] sort(int[] array) {
        // on bouge le pivot a chaque itteration
        for(int pivot = 1; pivot < array.length; pivot++) {
            int j = pivot;
            // tant que precendent superieur a prochain
            // on swap et on decremente.
            // j > 0 pour arreter que si atteint la fin
            while(j > 0 && array[j-1] >= array[j]) {
                int prev = array[j-1];
                int next = array[j];
                array[j-1] = next;
                array[j] = prev;
                j--;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int to_sort[] = {1, 45, 6, 9, 76, 16, 2, 2, 0, 4,65 ,7, 21, 87, 54, 1, 2, 0, 3};

        myArrayUtils.print_array(sort(to_sort));
    }
    
}
