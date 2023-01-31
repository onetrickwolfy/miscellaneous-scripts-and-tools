package sort;

public class bubbleSort {

    public static int[] sort(int[] array) {
        // on va chercher a swapper les elements 1 a 1 a partir d'une point de depart
        // de sorte que a la derniere itteration de la boule [i], le dernier est au bon endroit.
        // on recommande jusqu'a i-1
        // on va jusqu'a taille - 1 pour eviter une erreur sur array[j+1]
        for(int i = 0; i < array.length-1; i++) {
            for (int j = 0; j <  array.length-1-i; j++) {
                int previous = array[j];
                int next = array[j+1];

                // [15, 10]... prev = 15, next = 10... if 15 > 10
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
