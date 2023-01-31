package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class quickSort {


    public static int[] sort(int[] array, int min, int max) {
        if (max != min) {
            // let's choose a pivot
            int pivot = array[max];
            int left = min;
            int right = max - 1; // we should certainly not swap the pivot before knowing it's position...

            while (left < right) {
                // if the number on the left is greater or equal than the pivot
                if(array[left] >= pivot) {
                    // if equal, the number on the left is at the right place.
                    // let's find the potential next number we can swap for the number on the right
                    if (array[right] == array[left] && array[left] == pivot) {
                        left++;
                    // if the number on the right is greater than the pivot
                    // it aint a good deal
                    // let's decrement the right hoping to find a smaller number
                    // it's already on the right side
                    } else if (array[right] > pivot) {
                        right--;
                    // otherwise that mean we can swap both number
                    // making it is each is on the right side
                    } else {
                        array = myArrayUtils.swap(array, left, right);
                        right--;
                        left++;
                    }
                // in case the number on the left is less than the pivot
                } else {
                    // if the right is bigger, it's already at the right place
                    if (array[right] > pivot) {
                        right--;
                    // in every other case the number on the left is at the right place
                    } else {
                        left++;
                    }
                }
            }
    
            array = myArrayUtils.swap(array, left + 1, max);
            array = sort(array, min, left);
            array = sort(array, right+1, max);  
        }

        return array;
    }
    
    public static void main(String[] args) {
        int to_sort[] = {1, 45, 6, 9, 76, 16, 2, 2, 0, 4,65 ,7, 21, 87, 54, 1, 2, 3, 1, 2, 4, 0};
        sort(to_sort, 0, to_sort.length - 1);
        myArrayUtils.print_array(sort(to_sort, 0, to_sort.length - 1));
    }
}
