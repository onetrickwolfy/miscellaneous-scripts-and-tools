package sort;

public class selectionSort {
    public static int[] sort(int[] array) {
        
        // the last element is always the biggest after n - 1 itterations.
        // After each iterations, [0 : lengh - i] is sorted as we looked for the min
        // within the unsortored part of the array.
        // Altough they both have the same worst case complexity,
        // it seems this algorithm would perform better than bubbleSort as it requires less swaps.
        for(int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int index_min = i;

            // Looking for the min within [i+1:array.length] (unsorted)
            for(int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index_min = j;
                }
            }

            // Pushing the bigger values to the end
            // replacing them with the min.
            array[index_min] = array[i];
            array[i] = min;

        }

        return array;
    }

    
    public static void main(String[] args) {
        int to_sort[] = {1, 45, 6, 9, 76, 16, 2, 2, 0, 4,65 ,7, 21, 87, 54, 1, 2, 0, 3};

        myArrayUtils.print_array(sort(to_sort));
    }
}
