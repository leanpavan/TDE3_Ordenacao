

public class ordenacao {

    static void bubblesort(int tamanho, int[] vetor) { // Nao utilizado
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

    static ResultadoOrdenacao bubbleSortMelhorado(int tamanho, int[] vetor) {
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
            }
        }
        return new ResultadoOrdenacao("Bubble Sort", iteracoes, trocas);
    }

    static ResultadoOrdenacao selectionSort(int tamanho, int[] vetor) {
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

        return new ResultadoOrdenacao("Selection Sort", iteracoes, trocas);
    }

    static ResultadoOrdenacao cocktailSort(int tamanho, int[] vetor) {
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

        return new ResultadoOrdenacao("Cocktail Sort", iteracoes, trocas);
    }

    static ResultadoOrdenacao combSort(int tamanho, int vetor[]) {
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

        return new ResultadoOrdenacao("Comb Sort", iteracoes, trocas);
    }

    static ResultadoOrdenacao gnomeSort(int tamanho, int[] vetor) {
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
        return new ResultadoOrdenacao("Gnome Sort", iteracoes, trocas);
    }

    // Implementação de Lista Ligada para o Bucket Sort

    private static class Node {
        int info;
        Node proximo;

        public Node(int info) {
            this.info = info;
            this.proximo = null;
        }
    }

    private static ResultadoBucket inserirOrdenado(Node cabeca) {
        int iteracoes = 0;
        int trocas = 0;

        if (cabeca == null || cabeca.proximo == null) {return new ResultadoBucket(cabeca, iteracoes, trocas);} // Lista ja esta ordenada

        Node cabecaOrdenada = null; // Cabeca da nova lista ordenada
        Node noAtual = cabeca;

        while (noAtual != null) {
            iteracoes++;
            Node noProximo = noAtual.proximo;

            iteracoes++;
            if (cabecaOrdenada == null || noAtual.info <= cabecaOrdenada.info) {
                // Inserir no inicio da lista ordenada
                noAtual.proximo = cabecaOrdenada;
                cabecaOrdenada = noAtual;
                trocas++;
            } else {
                // Procura no meio ou no final da lista
                Node buscar = cabecaOrdenada;
                while (buscar.proximo != null && buscar.proximo.info < noAtual.info) {
                    iteracoes++;
                    buscar = buscar.proximo;
                }

                noAtual.proximo = buscar.proximo;
                buscar.proximo = noAtual;
                trocas++;
            }

            noAtual = noProximo;
        }

        return new ResultadoBucket(cabecaOrdenada, iteracoes, trocas);
    }

    private static class ResultadoBucket {
        Node cabecaOrdenada;
        int iteracoes;
        int trocas;

        public ResultadoBucket(Node cabecaOrdenada, int iteracoes, int trocas) {
            this.cabecaOrdenada = cabecaOrdenada;
            this.iteracoes = iteracoes;
            this.trocas = trocas;
        }
    }

    static ResultadoOrdenacao bucketSort(int tamanho, int[] vetor) {
        // Definir um tamanho padrao para os baldes
        if (tamanho == 0) {return new ResultadoOrdenacao("Bucket Sort", 0, 0);}

        int iteracoes = 0;
        int trocas = 0;

        // Encontrar valores minimos e maximos
        int valorMin = vetor[0];
        int valorMax = vetor[0];
        for (int i = 1; i < tamanho; i++) {
            iteracoes++;
            if (vetor[i] < valorMin) {
                valorMin = vetor[i];
            } else if (vetor[i] > valorMax) {
                valorMax = vetor[i];
            }
        }

        // Caso todos os elementos do vetor sejam iguais
        if (valorMax == valorMin) {return new ResultadoOrdenacao("Bucket Sort", iteracoes, trocas);}

        // Inicializar os baldes
        Node[] baldes = new Node[tamanho];
        for (int i = 0; i < tamanho; i++) {
            iteracoes++;
            baldes[i] = null; // Inicializar todas as cabecas da lista como null
        }

        for (int i = 0; i < tamanho; i++) {
            iteracoes++;
            int valor = vetor[i];

            int indiceBalde = (int) ((double)(valor - valorMin) * (tamanho - 1) / (valorMax - valorMin));

            Node novoNo = new Node(valor);

            novoNo.proximo = baldes[indiceBalde];
            baldes[indiceBalde] = novoNo;
            trocas++;
        }

        // Ordenar cada balde
        for (int i = 0; i < tamanho; i++) {
            iteracoes++;

            ResultadoBucket resultado = inserirOrdenado(baldes[i]);
            baldes[i] = resultado.cabecaOrdenada;

            // Agregar todas as iteracoes e trocas
            iteracoes += resultado.iteracoes;
            trocas += resultado.trocas;
        }

        int indice = 0;
        for (int i = 0; i < tamanho; i++) {
            iteracoes++;
            Node noAtual = baldes[i];

            while (noAtual != null) {
                iteracoes++;

                vetor[indice] = noAtual.info;
                trocas++;
                
                indice++;
                noAtual = noAtual.proximo;
            }
        }

        return new ResultadoOrdenacao("Bucket Sort", iteracoes, trocas);
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

    static class ResultadoOrdenacao {
        String nome;
        int iteracoes;
        int trocas;

        public ResultadoOrdenacao(String nome, int iteracoes, int trocas) {
            this.nome = nome;
            this.iteracoes = iteracoes;
            this.trocas = trocas;
        }
    }

    static void imprimirTabela(String titulo, ResultadoOrdenacao[] resultados) {
        System.out.println("===============================================================");
        System.out.println("| Algoritmos de Ordenação: Análise de Desempenho - " + titulo);
        System.out.println("===============================================================");
        System.out.printf("| %-25s | %-12s | %-12s |\n", "Algoritmo", "Iterações", "Trocas");
        System.out.println("|---------------------------|--------------|--------------|");

        for (int i = 0; i < 6; i++) {
            ResultadoOrdenacao res = resultados[i];
            if (res != null) {
                System.out.printf("| %-25s | %-12d | %-12d |\n",
                res.nome, res.iteracoes, res.trocas);
            }
        }
        System.out.println("===============================================================");
    }

    public static void main(String[] args) {
        int tamanho = 20;
        int numAlgoritmos = 6;

        ResultadoOrdenacao[] resultadosVetor1 = new ResultadoOrdenacao[numAlgoritmos];
        ResultadoOrdenacao[] resultadosVetor2 = new ResultadoOrdenacao[numAlgoritmos];
        ResultadoOrdenacao[] resultadosVetor3 = new ResultadoOrdenacao[numAlgoritmos];
        

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

        // Vetor 1
        int i = 0;
        resultadosVetor1[i++] = bubbleSortMelhorado(tamanho, vetor1_1);
        resultadosVetor1[i++] = selectionSort(tamanho, vetor1_2);
        resultadosVetor1[i++] = cocktailSort(tamanho, vetor1_3);
        resultadosVetor1[i++] = combSort(tamanho, vetor1_4);
        resultadosVetor1[i++] = gnomeSort(tamanho, vetor1_5);
        resultadosVetor1[i++] = bucketSort(tamanho, vetor1_6);

        // Vetor 2
        i = 0;
        resultadosVetor2[i++] = bubbleSortMelhorado(tamanho, vetor2_1);
        resultadosVetor2[i++] = selectionSort(tamanho, vetor2_2);
        resultadosVetor2[i++] = cocktailSort(tamanho, vetor2_3);
        resultadosVetor2[i++] = combSort(tamanho, vetor2_4);
        resultadosVetor2[i++] = gnomeSort(tamanho, vetor2_5);
        resultadosVetor2[i++] = bucketSort(tamanho, vetor2_6);

        // Vetor 3
        i = 0;
        resultadosVetor3[i++] = bubbleSortMelhorado(tamanho, vetor3_1);
        resultadosVetor3[i++] = selectionSort(tamanho, vetor3_2);
        resultadosVetor3[i++] = cocktailSort(tamanho, vetor3_3);
        resultadosVetor3[i++] = combSort(tamanho, vetor3_4);
        resultadosVetor3[i++] = gnomeSort(tamanho, vetor3_5);
        resultadosVetor3[i++] = bucketSort(tamanho, vetor3_6);

        // Impressao dos resultados

        System.out.println("=== Vetor 1 ===");
        imprimirTabela("Vetor 1", resultadosVetor1);

        System.out.println("=== Vetor 2 ===");
        imprimirTabela("Vetor 2", resultadosVetor2);

        System.out.println("=== Vetor 3 ===");
        imprimirTabela("Vetor 3", resultadosVetor3);
    }
}
