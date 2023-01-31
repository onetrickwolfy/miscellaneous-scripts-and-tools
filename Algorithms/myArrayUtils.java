package sort;

/**
 * Useful methods I made to learn sorting algorithms.
 */
public class myArrayUtils {
    // Prints an array
    public static void print_array(int[] array) {
        System.out.print("Array: [");
        for(int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print(array[array.length - 1] + "]\n");
    }

    // Concats one int[] with an int.
    public static int[] concat(int element, int[] arr_b) {
        int res[] = new int[1 + arr_b.length];

        res[0] = element;

        for(int i = 0; i < arr_b.length; i++) {
            res[i + 1] = arr_b[i];
        }

        return res;
    }
    
    // Concats two int[]
    public static int[] concat(int[] arr_a, int[] arr_b) {
        int res[] = new int[arr_a.length + arr_b.length];

        for(int i = 0; i < arr_a.length; i++) {
            res[i] = arr_a[i];
        }

        for(int i = 0; i < arr_b.length; i++) {
            res[arr_a.length + i] = arr_b[i];
        }

        return res;
    }

    // Concats n * int[] 
    public static int[] concat(int[]... arrays) {
        int[] res = {};
        for(int[] arr : arrays) {
            res = concat(res, arr);
        }

        return res;
    }
}
