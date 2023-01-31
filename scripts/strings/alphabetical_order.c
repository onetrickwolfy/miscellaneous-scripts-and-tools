#include <stdio.h>

int dans_ordre_alpha(char string[]) {

    int i = 1;
    while(string[i] != '\0') {

        // on convertit les majuscules vers des minuscules
        // Les valeurs dans la table sembles changer en fonction des systemes
        // J'ai donc fait des soustracters de characteres.
        // On compare aux valeurs, ce qui evite de les coder en dure.
        if(string[i] >= 'A' && string[i] <= 'Z') {
            string[i] = string[i] + ('a' - 'A');
        }
        if(string[i - 1] >= 'A' && string[i -1] <= 'Z') {
            string[i - 1] = string[i - 1] + ('a' - 'A');
        }

        // si la valeur ascii est inferieur a la lettre d'avant
        // ce n'est pas dans l'ordre.
        if(string[i] < string[i - 1]) return 0;

        i++;
    }

    return 1;
}

int main(int argc, char *argv[])
{
 if (argc < 2) {
        printf("Il n'y pas d'arguments\n");
        return -1;
    }

    int est_dans_ordre = dans_ordre_alpha(argv[1]);
    
    printf("Le mot %s ", argv[1]);
    if (est_dans_ordre) {
        printf("est dans l'ordre alphabetique.\n");
    } else {
        printf("n'est pas dans l'ordre alphabetique.\n");
    }

    return 0;
}
