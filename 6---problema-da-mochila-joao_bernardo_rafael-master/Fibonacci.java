import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci {
    //contadores para recursao de fibonacci
    private static long recIteracoes;
    private static long recInstrucoes;
    //contadores para fibonacci iterativo
    private static long iterIteracoes;
    private static long iterInstrucoes;
    //contadores para fibonacci memoizado
    private static long memoIteracoes;
    private static long memoInstrucoes;
    //calculo de fibonacci usando recursao simples
    public static BigInteger fiboRec(int n) {
        recIteracoes++;
        recInstrucoes += 1; // compara n <= 1
        if (n <= 1) return BigInteger.valueOf(n); //caso base
        recInstrucoes += 2; // chamada recursiva e soma
        return fiboRec(n - 1).add(fiboRec(n - 2)); //recursao para n-1 e n-2
    }
    //calculo de fibonacci usando iteracao e vetor de resultados
    public static BigInteger fiboIterativo(int n) {
        iterIteracoes = 0;
        iterInstrucoes = 0;
        iterIteracoes++;
        iterInstrucoes += 1; // verifica n <= 1
        if (n <= 1) return BigInteger.valueOf(n); //casos base 0 e 1

        BigInteger[] f = new BigInteger[n + 1]; //vetor para armazenar valores
        iterInstrucoes += 2; // aloca vetor e define inicializacoes
        f[0] = BigInteger.ZERO;
        f[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            iterIteracoes++;
            iterInstrucoes += 3; // operacoes do loop e soma
            f[i] = f[i - 1].add(f[i - 2]); //soma dos dois anteriores
        }
        iterInstrucoes += 1; // ultima verificacao de loop
        return f[n]; //retorna fibo de n
    }
    //calculo de fibonacci com memoizacao para evitar recalculos
    public static BigInteger memoizedFibo(int n) {
        memoIteracoes = 0;
        memoInstrucoes = 0;
        BigInteger[] f = new BigInteger[n + 1]; //vetor de memoizacao
        memoInstrucoes += 1; // alocacao do vetor
        Arrays.fill(f, BigInteger.valueOf(-1)); //marca valores desconhecidos
        memoIteracoes += n + 1; // inicializacao do vetor
        memoInstrucoes += n + 1; // atribuicoes do fill
        return lookupFibo(f, n);
    }
    //funcao auxiliar que retorna fibo(n) usando memoizacao
    private static BigInteger lookupFibo(BigInteger[] f, int n) {
        memoIteracoes++;
        memoInstrucoes += 1; // compara valor memoizado
        if (f[n].compareTo(BigInteger.ZERO) >= 0) return f[n]; //valor ja calculado
        memoInstrucoes += 1; // compara n <= 1
        if (n <= 1) {
            f[n] = BigInteger.valueOf(n); //caso base
            memoInstrucoes += 1; // atribuicao
        } else {
            memoInstrucoes += 2; // prepara chamadas recursivas
            f[n] = lookupFibo(f, n - 1).add(lookupFibo(f, n - 2)); //recursao com guardado
            memoInstrucoes += 1; // atribuicao do resultado
        }
        return f[n]; //retorna valor calculado ou recuperado
    }
    //retorna contadores recursivos
    public static long getRecIteracoes() {
        return recIteracoes;
    }

    public static long getRecInstrucoes() {
        return recInstrucoes;
    }
    //retorna contadores iterativos
    public static long getIterIteracoes() {
        return iterIteracoes;
    }

    public static long getIterInstrucoes() {
        return iterInstrucoes;
    }
    //retorna contadores memoizados
    public static long getMemoIteracoes() {
        return memoIteracoes;
    }

    public static long getMemoInstrucoes() {
        return memoInstrucoes;
    }
    //metodo principal que executa os testes de fibonacci e imprime o resumo
    public static void main(String[] args) {
        int[] testes = {4, 8, 16, 32}; //casos pequenos
        int[] testesGrandes = {128, 1000, 10000}; //casos grandes

        System.out.println("--- Fibonacci Comparativo ---");
        //testes da recursao simples nos casos pequenos
        System.out.println("\nFIBO-REC");
        for (int n : testes) {
            recIteracoes = 0;
            recInstrucoes = 0;
            BigInteger resultado = fiboRec(n);
            System.out.println("n=" + n + " resultado=" + resultado + " iteracoes=" + getRecIteracoes() + " instrucoes=" + getRecInstrucoes());
        }
        //testes do metodo iterativo nos casos pequenos e grandes
        System.out.println("\nFIBO ITERATIVO");
        for (int n : testes) {
            BigInteger resultado = fiboIterativo(n);
            System.out.println("n=" + n + " resultado=" + resultado + " iteracoes=" + getIterIteracoes() + " instrucoes=" + getIterInstrucoes());
        }
        for (int n : testesGrandes) {
            BigInteger resultado = fiboIterativo(n);
            System.out.println("n=" + n + " resultado=(" + resultado.toString().substring(0, 20) + "...) iteracoes=" + getIterIteracoes() + " instrucoes=" + getIterInstrucoes());
        }
        //testes do metodo memoizado nos casos pequenos e grandes
        System.out.println("\nMEMOIZED-FIBO");
        for (int n : testes) {
            BigInteger resultado = memoizedFibo(n);
            System.out.println("n=" + n + " resultado=" + resultado + " iteracoes=" + getMemoIteracoes() + " instrucoes=" + getMemoInstrucoes());
        }
        for (int n : testesGrandes) {
            BigInteger resultado = memoizedFibo(n);
            System.out.println("n=" + n + " resultado=(" + resultado.toString().substring(0, 20) + "...) iteracoes=" + getMemoIteracoes() + " instrucoes=" + getMemoInstrucoes());
        }
    }
}
