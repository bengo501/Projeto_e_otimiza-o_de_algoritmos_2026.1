//Classe que resolve o problema de distancia de edicao usando forca bruta sem programacao dinamica
//Estrategia bruta (nao otimizada): testa TODAS as combinacoes possiveis de operacoes (remocao, insercao, substituicao)
//Complexidade exponencial O(3^(m+n)) pois explora arvore completa de decisoes sem reutilizar calculos
//Vantagem: codigo simples, nao usa memoria extra (recursao apenas)
//Desvantagem: MUITO lento para strings grandes pois nao memoriza resultados intermediarios
//Util para entender o problema e testar casos pequenos, mas inviavel para dados reais
public class DistanciaEdicaoBruta {

    //contador de iteracoes da forca bruta
    private static long iteracoes;

    //calcula a distancia de edicao usando recursao pura sem programacao dinamica
    public static int distEdBruteForce(String A, String B) {
        iteracoes = 0; //zera contador de iteracoes
        return bruteForce(A, B, A.length(), B.length());
    }

    //recursao que testa as tres operacoes possiveis: remocao, insercao e substituicao
    private static int bruteForce(String A, String B, int i, int j) {
        iteracoes++; //conta uma chamada recursiva
        if (i == 0) return j; //so insercoes restam
        if (j == 0) return i; //so remocoes restam
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
            return bruteForce(A, B, i - 1, j - 1); //match sem custo
        }
        //testa as tres operacoes e escolhe a melhor
        int remocao = 1 + bruteForce(A, B, i - 1, j); //remove da string A
        int insercao = 1 + bruteForce(A, B, i, j - 1); //insere na string A
        int substituicao = 1 + bruteForce(A, B, i - 1, j - 1); //substitui caractere
        return Math.min(Math.min(remocao, insercao), substituicao);
    }

    //retorna o contador de iteracoes
    public static long getIteracoes() {
        return iteracoes;
    }

    //executa um caso de teste e imprime o resultado
    private static void runCase(String nome, String A, String B) {
        System.out.println(nome);
        System.out.println("String A=\"" + A + "\"");
        System.out.println("String B=\"" + B + "\"");
        int distancia = distEdBruteForce(A, B);
        System.out.println("Distancia de edicao = " + distancia);
        System.out.println("Iteracoes = " + getIteracoes());
        System.out.println();
    }

    //metodo principal que executa os casos de teste
    public static void main(String[] args) {
        System.out.println("--- Distancia de Edicao Forca Bruta ---\n");

        runCase("Caso 1", "casa", "caso");
        runCase("Caso 2", "gato", "rato");
        runCase("Caso 3", "bom", "boum");
        runCase("Caso 4", "algoritmo", "algotimo");
        runCase("Caso 5", "Casablanca", "Portentoso");
    }
}
