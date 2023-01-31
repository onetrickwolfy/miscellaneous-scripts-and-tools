#include <stdio.h>

//
// I don't have any accents on my keyboard...
// Therefore it seemed easier to write everything down
// in english D";
//

int len(char string[]) {
    int count = 0;
    int i = 0;
    while (string[i] != '\0') {
        count++;
        i++;
    }

    return count;
}


int find_pattern(char array[]) {
    
    int lengh = len(array);
    
    // let's find the first occurrence of the first char
    int i = 1;
    while (i < lengh && array[i] != array[0]) {
        i++;
    }

    // there's no repetition
    if (i == lengh) { return 0; }

    // We know where the second first char is.
    // if it ain't divisible then we can assert there's no repetition
    // as the subtring would not ne contained n time.
    int pivot = i;
    if (lengh % pivot != 0) return 0; 

    // [subtring][phrase]
    // Let's compare each letter of the subtring
    // with each letter of the phrase
    i = 1;
    for(int c = pivot + 1; c < lengh; c++) {
        if (array[i] != array[c]) {
            return 0;
        }
        i++;
    }

    // this is how many times we can break down the array.
    return lengh / pivot;
}

int main(int argc, char *argv[])
{
 if (argc < 2) {
        printf("Il n'y pas d'arguments\n");
        return -1;
    }

    int nb_sous_chaine = find_pattern(argv[1]);
    printf("Il y a %d sous chaines.", nb_sous_chaine);

}
