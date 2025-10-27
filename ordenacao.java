public class ordenacao {

    static void bubblesort(int tamanho, int[] vetor) {
        int temp = 0;
        int iteracoes = 0;
        int trocas = 0;
        for (int i=0; i<tamanho;i++) {
            for (int j=1; j<tamanho-i; j++) {
                iteracoes++;
                if(vetor[j-1] > vetor [j]) {
                    temp = vetor[j-1];
                    vetor[j-1] = vetor[j];
                    vetor[j] = temp;

                    trocas++;
                }
            }
            
        }
        System.out.println("BUBBLE SORT\n");
        System.out.printf("Iteracoes: %d , Trocas: %d\n", iteracoes, trocas);
    }

    static void bubblesortMelhorado(int tamanho, int[] vetor) {
        int temp = 0;
        int iteracoes = 0;
        int trocas = 0;
        boolean ordenado = false;
        for (int i=0; i<tamanho;i++) {
            for (int j=1; j<tamanho-i; j++) {
                iteracoes++;
                if(vetor[j-1] > vetor [j]) {
                    temp = vetor[j-1];
                    vetor[j-1] = vetor[j];
                    vetor[j] = temp;

                    trocas++;
                    ordenado = true;
                }
            }
            if(ordenado) {
                ordenado = false;
            } else {
                System.out.println("BUBBLE SORT COM MELHORIA\n");
                System.out.printf("Iteracoes: %d , Trocas: %d\n", iteracoes, trocas);
                return;
            }
        }
    }

    static void selectionSort(int tamanho, int[] vetor) {
        int iteracoes = 0;
        int trocas = 0;
        for (int i=0; i < tamanho - 1; i++) {
            int minIndice = i;
            for (int j = i + 1; j < tamanho; j++) {
                iteracoes++;
                if (vetor[j] < vetor[minIndice]) {
                    minIndice = j;
                    
                }
            }
            if (minIndice != i) {
                int temp = vetor[i];
                vetor[i] = vetor[minIndice];
                vetor[minIndice] = temp;
                trocas++;
            }
        }
        System.out.println("SELECTION SORT\n");
        System.out.printf("Iteracoes: %d , Trocas: %d\n", iteracoes, trocas);
    }

    static void cocktailSort(int tamanho, int[] vetor) {
        boolean trocou = true;
        int inicio = 0;
        int fim = tamanho - 1;
        int temp;

        while (trocou) {
            trocou = false;

            // Passagem da esquerda para direita
            
        }
    }

    static void ordernarGnomos(int vetor[], int tamanho) {
        int indice = 0;
        int iteracoes = 0;
        int trocas = 0;
        while (indice < tamanho) {
            iteracoes++;
            if (indice == 0) {
                indice++;
            }
            if (vetor[indice] >= vetor[indice - 1]) {
                indice++;
            }
            else {
                int temp = vetor[indice];
                vetor[indice] = vetor[indice - 1];
                vetor[indice -1] = temp;
                indice--;
                trocas++;
            }
        }
        System.out.println("GNOME SORT\n");
        System.out.printf("Iteracoes: %d , Trocas: %d\n", iteracoes, trocas);
    }

    public static void main(String[] args) {
        int[] vetor1= {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor12= {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};

        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};

        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        //bubblesort(19, vetor1);
        //bubblesortMelhorado(19, vetor12);
        //selectionSort(19, vetor1);
        //ordernarGnomos(vetor1, 19);
    }
}
