package sort;
import java.util.Arrays;

public class mergeSort {

    // Merge two already already ordered arrays into.
    public static int[] merge(int[] arr_a, int[] arr_b) {
        
        // if arr_a is empty, only arr_b needs the be sorted.
        if(arr_a.length == 0) { return arr_b;}
        // if arr_b is empty, only arr_a needs the be sorted.
        if(arr_b.length == 0) {return arr_a;}

        // The two arrays are already ordered however 
        // We need to construct the final array.
        // we always look at the first element (always the smallest of each)
        // We compared them, the smallest being the smallest of both,
        // we can remove it from its respective array and go for another round
        // eventually one array will be empty triggering the final concat as each function
        // will be able to return.
        if(arr_a[0] < arr_b[0]) {
            int new_arr_a[] = Arrays.copyOfRange(arr_a, 1, arr_a.length);
            return myArrayUtils.concat(arr_a[0], merge(new_arr_a, arr_b));
        } else { // (arr_a[0] > arr_b[0])
            int new_arr_b[] = Arrays.copyOfRange(arr_b, 1, arr_b.length);
            return myArrayUtils.concat(arr_b[0], merge(new_arr_b, arr_a));
        }
    }

    public static int[] sort(int[] array) {
        // Already sorted.
        if(array.length <= 1) {
            return array;
        }

        // Breaking down the arrays until they're 1 or 0 elements.
        int arr_a[] = sort(Arrays.copyOfRange(array, 0, array.length / 2));
        int arr_b[] = sort(Arrays.copyOfRange(array, array.length / 2, array.length)); 


        // When both arrays are 0 or 1 element, we'll climb back up the recursive stack.
        // first merging arrays of 1 & 1/0 elements, then arrays of 2 & 2/1... then  3 & 3/2...
        // the goal is to start from 0/1 elements arrays as merge(a, b) can only sort already ordered arrays.
        // as we're going up the reccurive stack, arr_a & arr_b will be ordered, allowing us to converge
        // toward the final merge.
        return merge(arr_a, arr_b);
    }


    public static void main(String[] args) {
        int to_sort[] = {1, 45, 6, 9, 76, 16, 2, 2, 0, 4,65 ,7, 21, 87, 54, 1, 2, 0, 3};

        myArrayUtils.print_array(sort(to_sort));
    }
}