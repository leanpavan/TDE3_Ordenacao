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

        System.out.println("Bubble Sort\n");
        System.out.println("Iterações: " + iteracoes);
        System.out.println("Trocas: " + trocas);
    }

    static void bubbleSortMelhorado(int tamanho, int[] vetor) {
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
                System.out.println("Bubble Sort com Flag de Parada\n");
                System.out.println("Iterações: " + iteracoes);
                System.out.println("Trocas: " + trocas);
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

        System.out.println("Selection Sort\n");
        System.out.println("Iterações: " + iteracoes);
        System.out.println("Trocas: " + trocas);
    }

    static void cocktailSort(int tamanho, int[] vetor) {
        boolean trocou = true;
        int inicio = 0;
        int fim = tamanho - 1;
        int temp;

        int iteracoes = 0;
        int trocas = 0;

        while (trocou) {
            trocou = false;

            // Passagem da esquerda para direita

            for (int i = inicio; i < fim; i++) {
                iteracoes++;

                if (vetor[i] > vetor[i+1]) {
                    // Realiza troca
                    trocas++;

                    temp = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = temp;

                    trocou = true;
                }
            }

            if (!trocou) { break; }// Vetor ordenado 
                
            trocou = false;
            fim--; // Ultimo elemento esta na posicao correta

            // Passagem da direita para esquerda

            for (int i = fim; i > inicio; i--) {
                iteracoes++;

                if (vetor[i] < vetor[i-1]) {
                    // Realiza troca
                    trocas++;

                    temp = vetor[i];
                    vetor[i] = vetor[i-1];
                    vetor[i-1] = temp;

                    trocou = true;
                }
            }
            inicio++; // Primeiro elemento esta na posicao correta
        }

        System.out.println("Cocktail Sort");
        System.out.println("Iterações: " + iteracoes);
        System.out.println("Trocas: " + trocas);
    }

    static void combSort(int tamanho, int vetor[]) {
        double fatorDeEncolhimento = 1.2473309501039;
        int intervalo = tamanho;
        boolean trocou = true;

        int iteracoes = 0;
        int trocas = 0;

        while (intervalo > 1 || trocou) {
            if (intervalo > 1) {
                intervalo = (int) (intervalo / fatorDeEncolhimento);
            }

            trocou = false;
            for (int i=0; i < tamanho - intervalo; i++) {
                iteracoes++;

                if (vetor[i] > vetor[i + intervalo]) {
                    // Realiza troca
                    trocas++;

                    int temp = vetor[i + intervalo];
                    vetor[i + intervalo] = vetor[i];
                    vetor[i] = temp;

                    trocou = true;
                }
            }
        }

        System.out.println("Comb Sort");
        System.out.println("Iterações: " + iteracoes);
        System.out.println("Trocas: " + trocas);
    }

    static void gnomeSort(int tamanho, int[] vetor) {
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
        System.out.println("Gnome Sort\n");
        System.out.println("Iterações: " + iteracoes);
        System.out.println("Trocas: " + trocas);
    }

    static void imprimirVetor(int tamanho, int[] vetor) {
        System.out.print("Vetor = [");
        for (int i=0; i < tamanho; i++) {
            System.out.print(vetor[i]);

            if (i < tamanho - 1) {
                System.out.print(",");
            }
            
        }
        System.out.println("]\n");
    }

    public static void main(String[] args) {

        // Vetores (6 variáveis para cada vetor pois são 6 sorts.)
        int[] vetor1_1= {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor1_2= {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor1_3= {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor1_4= {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor1_5= {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor1_6= {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};

        int[] vetor2_1 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor2_2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor2_3 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor2_4 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor2_5 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor2_6 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};

        int[] vetor3_1 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        int[] vetor3_2 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        int[] vetor3_3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        int[] vetor3_4 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        int[] vetor3_5 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        int[] vetor3_6 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        System.out.println("===============================================================");
        System.out.println("Teste do desempenho dos algorítmos de ordenação.");
        System.out.println("===============================================================");

        System.out.println("Vetor 1");
        imprimirVetor(20, vetor1_1);
        System.out.println("===============================================================");

        bubbleSortMelhorado(20, vetor1_1);
        imprimirVetor(20, vetor1_1);

        selectionSort(20, vetor1_2);
        imprimirVetor(20, vetor1_2);

        cocktailSort(20, vetor1_3);
        imprimirVetor(20, vetor1_3);

        combSort(20, vetor1_4);
        imprimirVetor(20, vetor1_4);

        gnomeSort(20, vetor1_5);
        imprimirVetor(20, vetor1_5);
    }
}
