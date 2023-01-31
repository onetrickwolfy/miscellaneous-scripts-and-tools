package sort;

public class insertionSort {

    public static int[] sort(int[] array) {
        // selecting the first unsorted, putting it at the right place.
        for(int pivot = 1; pivot < array.length; pivot++) {
            int j = pivot;
            // let's swap/shift the pivot until it's at the right place
            // Doing it this way we don't have to recreate an arra
            while(j > 0 && array[j-1] >= array[j]) {
                int prev = array[j-1];
                int next = array[j];
                array[j-1] = next;
                array[j] = prev;
                j--;
            }

            myArrayUtils.print_array(array);
        }

        return array;
    }

    public static void main(String[] args) {
        int to_sort[] = {1, 45, 6, 9, 76, 16, 2, 2, 0, 4,65 ,7, 21, 87, 54, 1, 2, 0, 3};

        myArrayUtils.print_array(sort(to_sort));
    }
    
}
