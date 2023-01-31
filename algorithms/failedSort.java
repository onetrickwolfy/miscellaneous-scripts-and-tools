package sort;

import java.util.ArrayList;
import java.util.Arrays;

// A failed attempt to make the quick sort algorithm.
// It works though I wanted to redo-it without "cheating" using new arrays! Please check quickSort.java
public class failedSort {

    public static int[] sort(int[] array) {
        // if {a} or {} we're done breaking them down.
        if (array.length <= 1) {
            return array;
        }

        int pivot = array[0];
        // creating three partions
        // one for elements smaller than pivot
        // one for elements that are equal
        // one for bigger elements.
        ArrayList<Integer> arr_a = new ArrayList<>();
        ArrayList<Integer> arr_b = new ArrayList<>();
        ArrayList<Integer> arr_elem = new ArrayList<>();

        // Inserting elements in the right partition.
        for(int i = 0; i < array.length; i++) {
            if(array[i] < pivot) {
                arr_a.add(array[i]);
            } else if (array[i] > pivot) {
                arr_b.add(array[i]);
            } else {
                arr_elem.add(array[i]);
            }
        }

        // Converting them to primitive array.
        int[] native_arr_a = arr_a.stream().mapToInt(Integer::intValue).toArray();
        int[] native_arr_b = arr_b.stream().mapToInt(Integer::intValue).toArray();
        int[] native_arr_elem = arr_elem.stream().mapToInt(Integer::intValue).toArray();

        // concating the results: [lesser][equal][bigger]
        // and breaking down the arrays utils they're 1 or 0 elements.
        // using linked lists would seem smarter though I wanted to stick to primitive arrays
        // hence he "unnecessary conversion"
        // I'm trying to learn so the logic matters less.
        return myArrayUtils.concat(sort(native_arr_a), native_arr_elem, sort(native_arr_b));
    }
    
    public static void main(String[] args) {
        int to_sort[] = {1, 45, 6, 9, 76, 16, 2, 2, 0, 4,65 ,7, 21, 87, 54, 1, 2, 0, 3};

        myArrayUtils.print_array(sort(to_sort));
    }
}
