package br.pucrs;

// multiplicação de inteiros de n-bits usando divisão e conquista
//divide os números em duas partes e resolve submultiplicações recursivas
public class Multiply {
    private long iterationCount;    //armazena o número de iterações realizadas


    public Multiply() {    //construtor que inicializa o contador
        this.iterationCount = 0;
    }

    //multiplica dois números x e y de n bits usando divisão e conquista
    //complexidade: O(n^2) onde n é o número de bits
    public long multiply(long x, long y, int n) {
        iterationCount++;        //incrementa contador para cada chamada recursiva
        if (n == 1) {        //caso base: quando há apenas 1 bit, multiplicação é trivial
            return x * y;
        } else {
            int m = (n + 1) / 2;            //calcula m = ceil(n/2) para dividir o número em duas partes
            long powM = 1L << m;            //calcula 2^m como potência de 2 usando shift bits
            long a = x / powM;            //extrai a parte alta de x (dígitos mais significativos)
            long b = x % powM;            //extrai a parte baixa de x (dígitos menos significativos)
            long c = y / powM;            //extrai a parte baixa de y
            long d = y % powM;            //extrai a parte baixa de y
            long e = multiply(a, c, m);            //recursivamente multiplica as partes altas: a*c
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);            //recursivamente multiplica: b*c
            long h = multiply(a, d, m);            //recursivamente multiplica: a*d
            long pow2m = 1L << (2 * m);            //calcula 2^(2m) para deslocar os produtos corretamente
            long powM_gh = (1L << m) * (g + h);            //calcula 2^m * (g + h)
            return pow2m * e + powM_gh + f;            //combina os resultados: 2^(2m)*e + 2^m*(g+h) + f
        }
    }

    public long getIterationCount() {//retorna o total de iterações da última execução
        return iterationCount;
    }

    public void resetIterationCount() {//reseta o contador para zero (útil para múltiplas execuções)
        iterationCount = 0;
    }
}