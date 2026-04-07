package br.pucrs;

// divisão e conquista para encontrar o maior valor em um array
// divide o array recursivamente e compara os máximos das metades
public class MaxVal2 {
    private long iterationCount;    // armazena o número de iterações realizadas
    // encontra o maior valor recursivamente usando divisão e conquista
    // init: índice inicial, end: índice final (inclusivo)
    // complexidade: O(n) - visita cada elemento uma vez, ~2n-1 chamadas
    private long maxVal2(long[] A, int init, int end) {
        iterationCount++;   //incrementa contador para cada chamada recursiva
        if (end - init <= 1) {// caso base: quando há apenas 1 ou 2 elementos
            return Math.max(A[init], A[end]);//retorna o maior entre os dois elementos
        } else {
            int m = (init + end) / 2;      //encontra o meio do array para fazer a divisão
            long v1 = maxVal2(A, init, m);//recursivamente encontra o máximo da primeira metade
            long v2 = maxVal2(A, m + 1, end);//recursivamente encontra o máximo da segunda metade
            return Math.max(v1, v2);    //retorna o maior entre os dois máximos
        }
    }
    // metodo inicial que reseta o contador e inicia a busca recursiva
    // n =  tamanho do array
    public long findMax(long[] A, int n) {
        iterationCount = 0;        //reseta o contador antes de iniciar
        if (n == 0) {        //valida se o array não está vazio
            throw new IllegalArgumentException("Array vazio");
        }
        return maxVal2(A, 0, n - 1);//inicia a busca com índices do primeiro e último elemento
    }
    public long getIterationCount() {//retorna o total de iterações da última execução
        return iterationCount;
    }
}