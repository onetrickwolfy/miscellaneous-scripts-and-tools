package sort;

public class insertionSort {

    public static int[] sort(int[] array) {
        // selecting the first unsorted, shifting it to the right place.
        // compared to selectionSort, the first part of the array is in the right order
        // though more elements might need to be inserted in between.
        // We just go through each element, shift it to the right place and start again.
        // Bubble & insertionSort have the same worst case complexity
        // though Bubble sorts does n*n swaps in every case unlike insertionSort.
        for(int pivot = 1; pivot < array.length; pivot++) {
            int j = pivot;
            // let's swap/shift the pivot until it's at the right place
            // Doing it this way we don't have to recreate an array
            // In am guessing using linked lists would be smarter
            // As we'd save a hell lot of swaps.
            while(j > 0 && array[j-1] >= array[j]) {
                int prev = j-1;
                int next = j;
                array = myArrayUtils.swap(array, prev, next);
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