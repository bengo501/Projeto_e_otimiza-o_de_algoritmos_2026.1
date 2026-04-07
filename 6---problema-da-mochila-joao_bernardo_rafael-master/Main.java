public class Main {

    //funcao que imprime um separador visivel entre secoes
    private static void printSeparador(String titulo) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(titulo);
        System.out.println("=".repeat(60) + "\n");
    }

    //executa o exercicio 1 e 2: fibonacci recursivo, iterativo e memoizado
    private static void executarFibonacci() {
        printSeparador("EXERCICIO 1 E 2: FIBONACCI");
        Fibonacci.main(new String[]{});
    }

    //executa o exercicio 3: mochila usando forca bruta
    private static void executarMochilaBruta() {
        printSeparador("EXERCICIO 3: MOCHILA FORCA BRUTA");
        Mochila.main(new String[]{});
    }

    //executa os exercicios 4 e 5: mochila com programacao dinamica e comparacao
    private static void executarMochilaPD() {
        printSeparador("EXERCICIO 4 E 5: MOCHILA PROGRAMACAO DINAMICA");
        MochilaPD.main(new String[]{});
    }

    //executa o exercicio 6: distancia de edicao usando forca bruta
    private static void executarDistanciaEdicaoBruta() {
        printSeparador("EXERCICIO 6: DISTANCIA DE EDICAO FORCA BRUTA");
        DistanciaEdicaoBruta.main(new String[]{});
    }

    //executa os exercicios 7 e 8: distancia de edicao com programacao dinamica e comparacao
    private static void executarDistanciaEdicaoDP() {
        printSeparador("EXERCICIO 7 E 8: DISTANCIA DE EDICAO PROGRAMACAO DINAMICA");
        DistanciaEdicao.main(new String[]{});
    }

    //metodo principal que coordena a execucao de todos os exercicios
    public static void main(String[] args) {
        System.out.println("\n" + "#".repeat(60));
        System.out.println("# TRABALHO DE ALGORITMOS: ANALISE E COMPARACAO");
        System.out.println("# Programacao Dinamica vs Forca Bruta");
        System.out.println("#".repeat(60));

        executarFibonacci();
        executarMochilaBruta();
        executarMochilaPD();
        executarDistanciaEdicaoBruta();
        executarDistanciaEdicaoDP();

        System.out.println("\n" + "#".repeat(60));
        System.out.println("# FIM DE TODAS AS EXECUCOES");
        System.out.println("#".repeat(60) + "\n");
    }
}
