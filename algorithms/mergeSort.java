package sort;
import java.util.Arrays;

public class mergeSort {

    // Fusionne deux tableaux dans l'ordre en convervant l'ordre.
    public static int[] merge(int[] arr_a, int[] arr_b) {
        
        // si arr_a est vide, arr_b est le seul element a trier.
        if(arr_a.length == 0) { return arr_b;}
        // si arr_b est vide, arr_a est le seul element a trier.
        if(arr_b.length == 0) {return arr_a;}

        // si arr_a[0] < arr_b[0]
        // on va placer le premier element, et on appel reccursivement
        // jusqu'a tout parcourir. eventuellement, l'un des tab sera vide.
        // ce qui provoquera l'une des deux conditions du dessus.
        if(arr_a[0] < arr_b[0]) {
            int new_arr_a[] = Arrays.copyOfRange(arr_a, 1, arr_a.length);
            return myArrayUtils.concat(arr_a[0], merge(new_arr_a, arr_b));
        } else { // (arr_a[0] > arr_b[0])
            int new_arr_b[] = Arrays.copyOfRange(arr_b, 1, arr_b.length);
            return myArrayUtils.concat(arr_b[0], merge(new_arr_b, arr_a));
        }
    }
    
    public static int[] sort(int[] array) {
        // il n'y a pas de trie possible.
        if(array.length <= 1) {
            return array;
        }

        // on casse en deux.
        // jusqu'a obtenir des tableaus de 1 ou 0 elements.
        int arr_a[] = sort(Arrays.copyOfRange(array, 0, array.length / 2));
        int arr_b[] = sort(Arrays.copyOfRange(array, array.length / 2, array.length)); 


        // quand a[] et a[b], ou inversement, la concatenation commence.
        // On merge des tableaux de 1, puis de 2, puis 3....
        // la fonctionne merge ne peux trier que des tableaux deja l'ordre
        // d'ou le fait casser en deux x fois jusqu'a avoir un tableau vide, et un de 1.
        return merge(arr_a, arr_b);
    }


    public static void main(String[] args) {
        int to_sort[] = {1, 45, 6, 9, 76, 16, 2, 2, 0, 4,65 ,7, 21, 87, 54, 1, 2, 0, 3};

        myArrayUtils.print_array(sort(to_sort));
    }
}