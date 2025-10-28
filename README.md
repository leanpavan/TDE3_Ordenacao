# Análise de Desempenho de Algoritmos de Ordenação
TDE3 da disciplina Resolução de Problemas Estruturados em Computação, com o objetivo de comparar o desempenho dos algoritmos de ordenação (Bubble Sort Melhorado, Selection Sort, Cocktail Sort, Comb Sort, Gnome Sort e Bucket Sort) em três cenários distintos (Vetor Misto, Vetor Pré-Ordenado e Vetor Invertido), utilizando as métricas de Iterações (Comparações) e Trocas (Movimentações).

## Resultados Detalhados da Comparação

Os testes foram realizados em um vetor de tamanho N=20. O arquivo README.md foi feito com apoio de IA, enquanto os algoritmos de ordenação foram feitos manualmente com os documentos disponibilizados pelo professor Andrey Cabral Meira.

### Cenário 1: Vetor 1 (Quase Desordenado)

Este vetor representa o caso médio, com elementos em ordem aleatória.

| Algoritmo | Iterações (Comparações) | Trocas (Movimentações) | Observações de Desempenho |
| :--- | :---: | :---: | :--- |
| **Bucket Sort** | **127** | **44** | Esperado ser o mais rápido (O(N)). |
| Comb Sort | 140 | 22 | Demonstra performance superior aos algoritmos O(N²). |
| Cocktail Sort | 154 | 78 | Bom desempenho, mas mais lento que Comb Sort. |
| Gnome Sort | 174 | 78 | Comparações e trocas moderadas. |
| Bubble Sort Melhorado | 190 | 78 | Similar ao Cocktail neste caso. |
| Selection Sort | 190 | 18 | **Maior** nº de iterações, mas **menor** nº de trocas entre os O(N²). |

---

### Cenário 2: Vetor 2 (Pré-Ordenado - Melhor Caso)

Este vetor está quase totalmente ordenado, testando otimizações de parada rápida.

| Algoritmo | Iterações (Comparações) | Trocas (Movimentações) | Observações de Desempenho |
| :--- | :---: | :---: | :--- |
| **Bubble Sort Melhorado** | **190** | **0** | **MELHOR**: Parada imediata, eficiência O(N). |
| Cocktail Sort | 19 | 0 | Excelente desempenho, pois para rapidamente. |
| Bucket Sort | 127 | 44 | Eficiência O(N), com custo de distribuição/coleta. |
| Gnome Sort | 19 | 0 | Desempenho O(N) devido à natureza dos dados. |
| Comb Sort | 121 | 0 | Mantém o desempenho próximo ao melhor caso. |
| Selection Sort | 190 | 0 | **PIOR em Iterações**: Sempre faz O(N²) comparações. |

---

### Cenário 3: Vetor 3 (Invertido - Pior Caso)

Este vetor está em ordem decrescente, o pior cenário para muitos algoritmos baseados em adjacência.

| Algoritmo | Iterações (Comparações) | Trocas (Movimentações) | Observações de Desempenho |
| :--- | :---: | :---: | :--- |
| **Bucket Sort** | **151** | **50** | **MELHOR**: O(N) constante, não afetado pela ordem. |
| Comb Sort | 140 | 16 | **MELHOR O(N²)**: Usa intervalos maiores para reduzir trocas. |
| Selection Sort | 190 | 10 | Alto nº de iterações, mas o **menor** nº de trocas totais ($N-1$). |
| Gnome Sort | 380 | 190 | Alto custo de movimento (trocas). |
| Cocktail Sort | 190 | 190 | Alto nº de iterações e trocas (quase $O(N^2)$). |
| Bubble Sort Melhorado | 190 | 190 | **PIOR**: Máximo de iterações e trocas (O(N²)). |
