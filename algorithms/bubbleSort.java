package sort;

public class bubbleSort {

    public static int[] sort(int[] array) {
        // Starting from index 0, if previous > next, swapping the elements.
        // At the end of the first iteration, the biggest has been pushed to the end of the array.
        for(int i = 0; i < array.length-1; i++) {
            // for each iteration, we have n-1 problem.
            for (int j = 0; j <  array.length-1-i; j++) {
                int previous = array[j];
                int next = array[j+1];

                if(previous > next) {
                    array[j] = next;
                    array[j+1] = previous;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int to_sort[] = {1, 45, 6, 9, 76, 16, 2, 2, 0, 4,65 ,7, 21, 87, 54, 1, 2, 0, 3};

        myArrayUtils.print_array(sort(to_sort));
    }
    
}
