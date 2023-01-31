#include <stdio.h>

int len(char string[]) {
    int count = 0;
    int i = 0;
    while (string[i] != '\0') {
        count++;
        i++;
    }

    return count;
}

int palindrome(char string[]) {
    int lengh = len(string);
    int milieu = lengh/2;
    char debut;
    char fin;

    for(int i = 0; i < milieu; i++) {
        debut = string[i];
        fin = string[lengh - i - 1];

        if(debut != fin) return 0;
    }

    // C'est un palindrome.
    return 1;
}

int main(int argc, char *argv[])
{

    if (argc < 2) {
        printf("Il n'y pas d'arguments\n");
        return -1;
    }

    int est_palindrome = palindrome(argv[1]);
    
    printf("Le mot %s ", argv[1]);
    if (est_palindrome) {
        printf("est un palindrome.\n");
    } else {
        printf("n'est pas un palindrome.\n");
    }

    return 0;
}
