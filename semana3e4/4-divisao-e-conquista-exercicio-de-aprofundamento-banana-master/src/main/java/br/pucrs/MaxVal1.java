package br.pucrs;

// busca linear para encontrar o maior valor em um array
//n usa divisão e conquista, percorre sequencialmente o array
public class MaxVal1 {
    //armazena o nmro de iterações realizadas
    private long iterationCount;
    //busca pelo maior val percorrendo o array sequencialmente
    //complexidade: O(n) - percorre todos os elementos uma vez
    public long maxVal1(long[] A, int n) {
        iterationCount = 0;

        if (n == 0) {        // valida se o array n está vazio
            throw new IllegalArgumentException("Array vazio");
        }

        long max = A[0]; // inicializa o max com o primeiro elemento
        iterationCount++;//incrementa contador de operações

        for (int i = 1; i < n; i++) {//loop que percorre todo o array procurando o maior valor
            iterationCount++;//conta cada iteração do loop principal

            if (A[i] > max) { //se encontra um val maior, atualiza o max
                max = A[i];
                iterationCount++;   //incrementa contador (count) extra para a atribuição
            }
        }
        return max;
    }

    public long getIterationCount() {//retorna o total de iterações da última execução
        return iterationCount;
    }
}