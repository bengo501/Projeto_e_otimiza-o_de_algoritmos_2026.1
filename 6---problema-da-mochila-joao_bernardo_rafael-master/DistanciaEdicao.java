//Classe que resolve o problema de distancia de edicao usando programacao dinamica
//Programacao dinamica (otimizada): monta uma tabela armazenando resultados intermediarios para reutilizar
//Complexidade polinomial O(m*n) onde m e n sao os tamanhos das strings (muito mais rapido que bruta)
//Tabela[i][j] guarda a distancia minima entre os primeiros i caracteres de A e j caracteres de B
//Vantagem: execucao rapida mesmo para strings grandes, reutiliza calculos ja feitos
//Desvantagem: precisa de memoria extra para armazenar a tabela, codigo um pouco mais complexo
//Pratico e eficiente para problemas reais
public class DistanciaEdicao {
    //contador de iteracoes DP
    private static long iteracoesDP;
    //contador de iteracoes da forca bruta
    private static long iteracoesBruta;

    //calcula a distancia de edicao usando programacao dinamica
    public static int distEdProgDina(String A, String B) {
        int m = A.length(); //tamanho de A
        int n = B.length(); //tamanho de B
        int[][] matriz = new int[m + 1][n + 1]; //tabela de custos
        iteracoesDP = 0; //zera contador DP
        matriz[0][0] = 0; //custo vazio para vazio
        //inicializa primeira coluna: remover caracteres de A
        for (int i = 1; i <= m; i++) {
            matriz[i][0] = matriz[i - 1][0] + 1;
            iteracoesDP++;
        }
        //inicializa primeira linha: inserir caracteres em A
        for (int j = 1; j <= n; j++) {
            matriz[0][j] = matriz[0][j - 1] + 1;
            iteracoesDP++;
        }
        //preenche a tabela principal comparando pares de caracteres
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int custoExtra = (A.charAt(i - 1) == B.charAt(j - 1)) ? 0 : 1; //match ou substituicao
                matriz[i][j] = Math.min(
                        Math.min(matriz[i - 1][j] + 1, matriz[i][j - 1] + 1),
                        matriz[i - 1][j - 1] + custoExtra);
                iteracoesDP++; //conta iteracao da tabela
            }
        }
        return matriz[m][n]; //retorna custo minimo de edicao
    }

    //calcula a distancia de edicao usando recursao pura (forca bruta)
    public static int distEdBruteForce(String A, String B) {
        iteracoesBruta = 0; //zera contador da forca bruta
        return bruteForce(A, B, A.length(), B.length());
    }

    //recursao que testa as tres operacoes possiveis
    private static int bruteForce(String A, String B, int i, int j) {
        iteracoesBruta++;
        if (i == 0) return j; //so insercoes restam
        if (j == 0) return i; //so remocoes restam
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
            return bruteForce(A, B, i - 1, j - 1); //match sem custo
        }
        int remove = 1 + bruteForce(A, B, i - 1, j); //remocao
        int insert = 1 + bruteForce(A, B, i, j - 1); //insercao
        int substitute = 1 + bruteForce(A, B, i - 1, j - 1); //substituicao
        return Math.min(Math.min(remove, insert), substitute);
    }

    public static long getIteracoesDP() {
        return iteracoesDP;
    }

    public static long getIteracoesBruta() {
        return iteracoesBruta;
    }

    //executa um caso de teste e imprime os valores
    private static void runCase(String nome, String A, String B, boolean executaBruta) {
        System.out.println(nome);
        System.out.println("A=\"" + A + "\" B=\"" + B + "\"");

        int distanciaDP = distEdProgDina(A, B);
        long iterDP = getIteracoesDP();
        System.out.println("DP: distancia=" + distanciaDP + " iteracoes=" + iterDP);

        if (executaBruta) {
            int distanciaBr = distEdBruteForce(A, B);
            long iterBr = getIteracoesBruta();
            System.out.println("Bruto: distancia=" + distanciaBr + " iteracoes=" + iterBr);
        } else {
            System.out.println("Bruto: nao executado para caso grande");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Distancia de Edicao: DP x Forca Bruta ---\n");

        runCase("Caso 1", "casa", "caso", true);
        runCase("Caso 2", "gato", "rato", true);
        runCase("Caso 3", "bom", "boum", true);
        runCase("Caso 4", "algoritmo", "algotimo", true);
        runCase("Caso 5", "Casablanca", "Portentoso", true);
    }
}
