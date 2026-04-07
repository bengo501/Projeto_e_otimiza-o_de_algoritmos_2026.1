package br.pucrs;
import java.util.Random;
import java.math.BigInteger;
//classe principal para executar testes de todos os algoritmos de divisão e conquista
//testa Merge Sort, MaxVal1, MaxVal2, Multiplicação e Multiplicação com Strings
public class App 
{
    public static void main(String[] args) { //método principal que executa todos os testes
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MERGE SORT - DIVISÃO E CONQUISTA");
        System.out.println("=".repeat(80));
        System.out.println();
        
        int[] sizes = {32, 2048, 1_048_576}; //define tamanhos dos vetores para os testes

        for (int size : sizes) {//executa testes de Merge Sort para cada tamanho

            testarMergeSort(size);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MAXVAL1 - BUSCA LINEAR (SEM DIVISÃO E CONQUISTA)");
        System.out.println("=".repeat(80));
        System.out.println();
        
        for (int size : sizes) {  //executa testes de MaxVal1 para cada tamanho
            testarMaxVal1(size);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MAXVAL2 - DIVISAO E CONQUISTA");
        System.out.println("=".repeat(80));
        System.out.println();
        
        for (int size : sizes) { //executa testes de MaxVal2 para cada tamanho
            testarMaxVal2(size);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MULTIPLICACAO INTEIRA - DIVISAO E CONQUISTA");
        System.out.println("=".repeat(80));
        System.out.println();
        
        int[] bitSizes = {4, 16, 64};//define tamanhos em bits para teste de multiplicação
        //executa testes de multiplicação para cada tamanho de bits
        for (int bits : bitSizes) {
            testarMultiply(bits);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO ALGORITMO MULTIPLICACAO INTEIRA (STRINGS) - DIVISAO E CONQUISTA");
        System.out.println("=".repeat(80));
        System.out.println();
        
        for (int bits : bitSizes) {//ecuta testes de multiplicação com strings para cada tamanho de bits
            testarBitMultiply(bits);
            System.out.println();
        }
        System.out.println("=".repeat(80));
        System.out.println("FIM DOS TESTES");
        System.out.println("=".repeat(80));
    }
    //executa testes do Merge Sort com um tamanho específico
    //cria um array aleatório, ordena e valida o resultado
    private static void testarMergeSort(int size) {
        System.out.println("TESTE COM VETOR DE TAMANHO: " + size);
        System.out.println("-".repeat(80));
        
        long[] arr = gerarVetorAleatorio(size);        //gera 1 array com valores aleatórios
        long[] arrCopy = arr.clone();  //cria 1aa cópia para possível validação posterior
        MergeSort sorter = new MergeSort(); //cria 1a instância do Merge Sort
        long startTime = System.nanoTime();    //registra o tempo de início em nanosegundos
        long iterations = sorter.mergeSort(arr, size);   //exec o algoritmo e obtém o número de iterações
        long endTime = System.nanoTime();     // Registra o tempo de fim
        double timeMs = (endTime - startTime) / 1_000_000.0; //calcula o tempo decorrido convertendo para ms
        boolean isOrdenado = validarOrdenacao(arr);//valida se o array foi ordenado corretamente

        System.out.printf("Número de iterações: %,d%n", iterations); //exibe o número de iterações executadas
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);         //mostra o tempo gasto em ms
        System.out.printf("Status de ordenação: %s%n", isOrdenado ? "CORRETO" : "ERRADO");//mostra o status de validação da ordenação
        System.out.print("Primeiros 10 elementos: ");//Mostra os primeiros 10 elementos ordenados como amostra

        for (int i = 0; i < Math.min(10, size); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //executa testes do MaxVal1 (busca linear) com um tamanho específico
    //percorre sequencialmente o array para encontrar o max
    private static void testarMaxVal1(int size) {
        System.out.println("TESTE COM VETOR DE TAMANHO: " + size);
        System.out.println("-".repeat(80));
        
        long[] arr = gerarVetorAleatorio(size);// gera um array com valores random
        MaxVal1 finder = new MaxVal1();//cria uma instância do MaxVal1
        long startTime = System.nanoTime();//registra o tempo de início
        long maxValue = finder.maxVal1(arr, size);//exec o algoritmo de busca linear
        long iterations = finder.getIterationCount();//obtém o número de iterações realizadas
        long endTime = System.nanoTime(); //registra o tempo de fim
        double timeMs = (endTime - startTime) / 1_000_000.0; //calcula o tempo decorrido em ms
        boolean isCorrect = validarMaximo(arr, maxValue);     //valida se o valor encontrado é realmente o  valor max

        System.out.printf("Maior valor encontrado: %,d%n", maxValue);        //exibe o valor max encontrado
        System.out.printf("Número de iterações: %,d%n", iterations);        //exibe o nro de iterações
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);        // exibe o tempo gasto
        System.out.printf("Status da busca: %s%n", isCorrect ? "CORRETO" : "ERRADO");        // exibe o status de validação
 
        System.out.print("Primeiros 10 elementos: ");  // Mostra alguns elementos como amostra
        for (int i = 0; i < Math.min(10, size); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //executa testes do MaxVal2 (divisão e conquista) com um tamanho específico
    //divide recursivamente o array para encontrar o max
    private static void testarMaxVal2(int size) {
        System.out.println("TESTE COM VETOR DE TAMANHO: " + size);
        System.out.println("-".repeat(80));
        
        long[] arr = gerarVetorAleatorio(size);//gera um array com vals rands
        MaxVal2 finder = new MaxVal2(); //cria uma instancia do MaxVal2
        long startTime = System.nanoTime();   // Registra o tempo de início
        long maxValue = finder.findMax(arr, size); // Executa o algoritmo de divisao e conquista
        long iterations = finder.getIterationCount();  //obtém o nro de iterações realizadas
        long endTime = System.nanoTime();     // registra o tempo de fim
        double timeMs = (endTime - startTime) / 1_000_000.0;    // Calcula o tempo decorrido em ms
        boolean isCorrect = validarMaximo(arr, maxValue);  // Valida se o val encontrado é realmente o max

        System.out.printf("Maior valor encontrado: %,d%n", maxValue); // exibe o val max encontrado
        System.out.printf("Número de iterações: %,d%n", iterations);// Exibe o nro de iterações
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);// exibe o tempo gasto
        System.out.printf("Status da busca: %s%n", isCorrect ? "CORRETO" : "ERRADO");// Exibe o status de validação

        System.out.print("Primeiros 10 elementos: "); //mostra alguns elementos como amostra
        for (int i = 0; i < Math.min(10, size); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //gera um vetor com valores inteiros aleatórios
    //usa Random com seed do tempo atual para variedade
    private static long[] gerarVetorAleatorio(int size) {
        long[] arr = new long[size];   // cria um array do tamanho especificado

        Random random = new Random(System.currentTimeMillis());  //cria gerador de nros rand com seed diferente cada execução

    
        for (int i = 0; i < size; i++) {   // preenche o array com valores rand
            arr[i] = random.nextLong() % 1_000_000;     // Gera nros rand entre -1.000.000 e 1.000.000
        }
        return arr;
    }
    //valida se um array está ordenado em ordem crescente
    //percorre verificando se cada elemento ≤ ao próximo
    private static boolean validarOrdenacao(long[] arr) {
        //compara cada elemento com o próximo
        for (int i = 0; i < arr.length - 1; i++) {
            //se encontrar um elemento fora de ordem
            //  retorna falso
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        //se passar por todos
        //  está ordenado
        //retorna true
        return true;
    }
    //valida se um valor é realmente o máximo do array
    //percorre todo o array procurando valor maior
    private static boolean validarMaximo(long[] arr, long maxValue) {
        // Verifica cada elemento do array
        for (long value : arr) {
            // Se encontrar um valor maior
            // o máximo está errado
            if (value > maxValue) {
                return false;
            }
        }
        // Se nenhum valor for maior
        // está correto
        return true;
    }
    // gera uma string binária aleatória com n bits (0s e 1s)
    // util para testes de multiplicação com strings
    private static String gerarStringBinaria(int bits, Random random) {
        // Cria um StringBuilder para construir a string
        StringBuilder sb = new StringBuilder();
        //gera cada bit aleatoriamente
        for (int i = 0; i < bits; i++) {
            // nextInt(2) retorna 0 ou 1 aleatoriamente
            sb.append(random.nextInt(2));
        }
        return sb.toString();
    }
    
    // Executa testes da multiplicação com dois números long de n bits
    // Verifica se o resultado está correto
    private static void testarMultiply(int bits) {
        System.out.println("TESTE COM NUMEROS DE " + bits + " BITS");
        System.out.println("-".repeat(80));
        
        //cria gerador de números aleatórios
        Random random = new Random(System.currentTimeMillis());
        //cria uma máscara para limitar os bits (ex: 15 para 4 bits = 0xF)
        long mask = (bits == 64) ? -1L : ((1L << bits) - 1);
        // Gera dois números aleatórios com no máximo n bits
        long x = random.nextLong() & mask;
        long y = random.nextLong() & mask;
        
        Multiply multiplier = new Multiply();//cria uma instância do algoritmo de multiplicação

        long startTime = System.nanoTime();// registra tempo de início
        long result = multiplier.multiply(x, y, bits);// Executa a multiplicação
        long endTime = System.nanoTime();// Registra tempo de fim
        long iterations = multiplier.getIterationCount();// Obtem o nro de iterações
        double timeMs = (endTime - startTime) / 1_000_000.0;        // calcula o tempo em ms
        long expected = x * y;// Calcula o resultado esperado (multiplicação nativa Java)

        System.out.printf("x: %,d (%d bits)%n", x, bits);    //exibe o primeiro operando
        System.out.printf("y: %,d (%d bits)%n", y, bits);  // exibe o segundo operando
        System.out.printf("Resultado: %,d%n", result);//exibe o resultado obtido
        System.out.printf("Esperado: %,d%n", expected);//exibe o resultado esperado
        System.out.printf("Correto: %s%n", result == expected ? "SIM" : "NAO");    // valida se os resultados coincidem
        System.out.printf("Número de iterações: %,d%n", iterations);        // exibe nro de iterações
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);        // exibe tempo gasto
    }
    
    //executa testes de multiplicação usando strings binárias
    //compara resultado com cálculo usando BigInteger
    private static void testarBitMultiply(int bits) {
        System.out.println("TESTE COM STRINGS DE " + bits + " BITS");
        System.out.println("-".repeat(80));
        
        Random random = new Random(System.currentTimeMillis());//cria gerador de números aleatórios
        String X = gerarStringBinaria(bits, random); //gera primeira string binária aleatória
        String Y = gerarStringBinaria(bits, random);    // gera segunda string binária aleatória
        long startTime = System.nanoTime();   // Registra tempo de início
        long result = BitMultiply.multiply(X, Y);     // executa a multiplicação com strings
        long endTime = System.nanoTime();    // registra tempo de fim
        long iterations = BitMultiply.getIterationCount();// obtem o nmro de iterações
        double timeMs = (endTime - startTime) / 1_000_000.0;        //calcula o tempo em ms
        BigInteger xVal = new BigInteger(X, 2);       //converte X binária para BigInteger para calcular resultado esperado
        BigInteger yVal = new BigInteger(Y, 2);     //converte Y binária para BigInteger
        BigInteger expectedBig = xVal.multiply(yVal);     // calcula o produto verdadeiro com BigInteger

        System.out.printf("X: %s (%d bits)%n", X, bits);  // exibe a primeira string binária
        System.out.printf("Y: %s (%d bits)%n", Y, bits);// exibe a segunda string binária
        System.out.printf("Resultado: %,d%n", result);//exibe o resultado obtido
        System.out.printf("Esperado: %s%n", expectedBig.toString());// exibe o resultado esperado
        //valida se o resultado está em range e é correto
        System.out.printf("Correto: %s%n", expectedBig.bitLength() <= 64 && expectedBig.longValue() == result ? "SIM" : "NAO");
        System.out.printf("Número de iterações: %,d%n", iterations);        // exibe nro de iterações
        System.out.printf("Tempo gasto: %.2f ms%n", timeMs);//exibe tempo gasto

    }
}
