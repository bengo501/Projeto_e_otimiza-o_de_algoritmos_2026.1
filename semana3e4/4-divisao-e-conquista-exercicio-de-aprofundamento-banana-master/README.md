# Enunciado para exercício preparatório sobre Divisão e Conquista

1. Vamos começar com um algorítmo já estudado e conhecido (em AEDI). O Merge Sort é um algorítmo de ordenação baseado nos seguintes passos:

    * recursivamente ordene a metade esquerda do vetor
    * recursivamente ordene a metade direita do vetor
    * mescle (faça o merge) das duas metades para ter o vetor ordenado. 
    
    Assim:
    
    * implemente o algortimo abaixo;
    * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048 e 1.048.576. Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;  
    
   ```java
   MERGE-SORT(L: List with n elements) : Ordered list with n elements
       IF (list L has one element)
           RETURN L.
       Divide the list into two halves A and B.
       A ← MERGE-SORT(A).
       B ← MERGE-SORT(B).
       L ← MERGE(A, B).
       RETURN L. 
   ```
   
2. O algoritmo a seguir (que não utiliza divisão-e-conquista) encontra o maior valor em um vetor.

    Assim, novamente:
   
    * implemente o algortimo abaixo;
    * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048 e 1.048.576. Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;
    
   ```java
   long maxVal1(long A[], int n) {  
       long max = A[0];
       for (int i = 1; i < n; i++) {  
           if( A[i] > max ) 
              max = A[i];
       }
       return max;
   }
   ```
    
3. O algoritmo a seguir (que utiliza divisão-e-conquista) encontra o maior valor em um vetor.

    Assim, novamente:
   
    * implemente o algortimo abaixo;
    * teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048 e 1.048.576. Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;
    
   ```java
   long maxVal2(long A[], int init, int end) {  
       if (end - init <= 1)
           return max(A[init], A[end]);  
       else {
             int m = (init + end)/2;
             long v1 = maxVal2(A,init,m);   
             long v2 = maxVal2(A,m+1,end);  
             return max(v1,v2);
            }
   }
   ```
    
4. A Multiplicação Inteira de n-bits recebe dois números inteiros x e y de n-bits e retorna o resutado de x * y.
  
   Assim, novamente:
  
     * implemente o algortimo abaixo;
     * teste-o para os 3 casos de valores inteiros: com 4 bits, com 16 bits e com 64 bits. Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto.

  O algoritmo está dado abaixo:
  
  ```java
  MULTIPLY(x, y, n) 
     IF (n = 1)
        RETURN x * y.
     ELSE
        m ← ⎡ n / 2 ⎤.
        a ← ⎣ x / 2^m ⎦; b ← x mod 2^m.
        c ← ⎣ y / 2^m ⎦; d ← y mod 2^m.
        e ← MULTIPLY(a, c, m).
        f ← MULTIPLY(b, d, m).
        g ← MULTIPLY(b, c, m).
        h ← MULTIPLY(a, d, m).
        RETURN 2^(2m)*e + 2^m*(g + h) + f.
  ```

  Ajuste a assinatura da sua implementação para receber tipo inteiros long (em java).
      
5. Monte uma tabela com os resultados das execuções acima. As linhas da tabela são os algoritmos implementados, as colunas o tamanho dos vetores usados para testar e contabilizar.
