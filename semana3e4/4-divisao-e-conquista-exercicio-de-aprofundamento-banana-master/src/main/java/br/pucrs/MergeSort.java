package br.pucrs;
//algoritmo Merge Sort usando divisão e conquista
// conta o nmro de iterações (chamadas recursivas) durante a execução
public class MergeSort {
    private long iterationCount;    // var para armazenar a contagem total de iterações
    //inicia o Merge Sort pelo método recursivo
    //retorna o número total de iterações executadas
    public long mergeSort(long[] arr, int n) {
        iterationCount = 0;
        if (n > 1) {
            mergeSortRecursive(arr, 0, n - 1);
        }
        return iterationCount;
    }
    //implementação recursiva: divide o array e ordena recursivamente
    // left e right definem os índices do subarray atual
    private void mergeSortRecursive(long[] arr, int left, int right) {
        iterationCount++;//incrementa contador para cada chamada recursiva do algoritmo

        if (left >= right) {        // caso base: quando há apenas um elemento, o array está ordenado
            return;
        }
        int mid = (left + right) / 2;        // encontra o ponto do meio para dividir o array em duas metades
        mergeSortRecursive(arr, left, mid);        //ordena recursivamente a primeira metade (esquerda)
        mergeSortRecursive(arr, mid + 1, right);//ordena recursivamente a segunda metade (direita)
        merge(arr, left, mid, right);//mescla as duas metades ordenadas

    }
    // mescla dois subarrays ordenados em um único array ordenado
    // left a mid: primeira metade, mid+1 a right: segunda metade
    private void merge(long[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;        //calcula o tamanho do subarray da esquerda
        int n2 = right - mid;//calcula o tamanho do subarray da direita
        long[] leftArr = new long[n1];    // cria array temporário para a metade esquerda
        long[] rightArr = new long[n2];    // cria array temporário para a metade direita

        for (int i = 0; i < n1; i++) {   //copia os elementos para o array temporário esquerdo
            iterationCount++;
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {// Copia os elementos para o array temporário direito
            iterationCount++;
            rightArr[j] = arr[mid + 1 + j];
        }
        //inicializa os índices para o processo de mesclagem
        int i = 0;  // indice para leftArr
        int j = 0;    //indice para rightArr
        int k = left;//indice para o array original
        
        while (i < n1 && j < n2) {//compara elementos dos dois arrays e coloca o menor no array original
            iterationCount++;
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) {//copia os elementos restantes do array esquerdo (se houver)
            iterationCount++;
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {     //copia os elementos restantes do array direito (se houver)
            iterationCount++;
            arr[k++] = rightArr[j++];
        }
    }
    public long getIterationCount() {//retorna o número total de iterações da última execução do algoritmo
        return iterationCount;
    }
}
