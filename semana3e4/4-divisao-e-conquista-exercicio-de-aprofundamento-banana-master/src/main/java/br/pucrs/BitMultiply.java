package br.pucrs;

// multiplicação de nmros representados como strings binárias
//usa divisão e conquista aplicada aos dígitos binários
public class BitMultiply {
    //armazena o nro de iterações realizadas
    private static long iterationCount;
    //multiplica duas strings binárias (sequências de 0 e 1)
    //retorna o resultado como long
    public static long multiply(String X, String Y) {
        //reseta o contador antes de iniciar
        iterationCount = 0;
        int n = Math.max(X.length(), Y.length()); //encontra o comprimento max entre as duas strings

        X = String.format("%" + n + "s", X).replace(' ', '0');  //add zeros à esquerda em X para igualar comprimentos

        Y = String.format("%" + n + "s", Y).replace(' ', '0'); //add zeros à esquerda em Y para igualar comprimentos

        return multiplyHelper(X, Y, n);  //inicia a multiplicação recursiva
    }
    //implementação recursiva da multiplicação usando divisão e conquista
    // X e Y são strings binárias com n dígitos cada
    private static long multiplyHelper(String X, String Y, int n) {
        iterationCount++;        //incrementa contador para cada chamada recursiva
        //caso base: quando há apenas 1 dígito binário
        if (n == 1) {
            //converte o caractere '0' ou '1' em inteiro e multiplica
            return (X.charAt(0) - '0') * (Y.charAt(0) - '0');
        } else {
            int m = (n + 1) / 2;      //calcula m = ceil(n/2) para dividir as strings em duas partes

            String a = X.substring(0, n - m);      //extrai a parte alta de X (primeiros n-m caracteres)

            String b = X.substring(n - m);    //extrai a parte baixa de X (últimos m caracteres)

            String c = Y.substring(0, n - m);//extrai a parte alta de Y

            String d = Y.substring(n - m);//extrai a parte baixa de Y

            long e = multiplyHelper(a, c, m);//recursivamente multiplica as partes altas: a*c

            long f = multiplyHelper(b, d, m);    //recursivamente multiplica as partes baixas: b*d

            long g = multiplyHelper(b, c, m);        //recursivamente multiplica: b*c

            long h = multiplyHelper(a, d, m);    //recursivamente multiplica: a*d

            long pow2m = 1L << (2 * m); //calcula 2^(2m) para deslocar os produtos
            long powM_gh = (1L << m) * (g + h); //calcula 2^m * (g + h)
            return pow2m * e + powM_gh + f; //retorna a combinação: 2^(2m)*e + 2^m*(g+h) + f
        }
    }
    public static long getIterationCount() {//retorna o total de iterações da ultima execução
        return iterationCount;
    }
}