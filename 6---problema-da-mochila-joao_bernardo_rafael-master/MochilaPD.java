//Classe que resolve o problema da mochila usando programacao dinamica
//Programacao dinamica (otimizada): monta uma tabela armazenando melhores solucoes para subproblemas
//Complexidade polinomial O(N*C) onde N eh numero de itens e C eh capacidade da mochila (muito mais rapido)
//Tabela[i][j] guarda o valor maximo obtido considerando os primeiros i itens com capacidade j
//Vantagem: execucao rapida mesmo para muitos itens, resolve problemas de tamanho realista
//Desvantagem: precisa de memoria extra para armazenar a tabela O(N*C), nao rastreia itens automaticamente
//Pratico e eficiente para problemas reais com muitos itens
public class MochilaPD {
    //classe para guardar peso e valor de cada item
    public static class Item {
        public final int peso;
        public final int valor;

        public Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }
    //contadores para medir iteracoes e instrucoes
    private static long iteracoesPD;
    private static long instrPD;
    private static long iteracoesBruta;
    private static long instrBruta;
    //metodo que resolve a mochila usando programacao dinamica
    public static int backPackPD(int N, int C, Item[] itens) {
        int[][] maxTab = new int[N + 1][C + 1]; //tabela DP
        iteracoesPD = 0; //zera contador de iteracoes
        instrPD = 0; //zera contador de instrucoes
        //inicializa linha 0 com zeros
        for (int j = 0; j <= C; j++) {
            maxTab[0][j] = 0;
            iteracoesPD++;
            instrPD += 2; //atribuicao e incremento de indice
        }
        //inicializa coluna 0 com zeros
        for (int i = 1; i <= N; i++) {
            maxTab[i][0] = 0;
            iteracoesPD++;
            instrPD += 2;
        }
        //preenche a tabela DP usando a recursao de subproblemas
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                iteracoesPD++; //conte cada celula calculada como iteracao
                instrPD += 1; //compara peso do item com capacidade
                if (itens[i].peso <= j) {
                    //item cabe na mochila atual
                    maxTab[i][j] = Math.max(
                            maxTab[i - 1][j],
                            itens[i].valor + maxTab[i - 1][j - itens[i].peso]);
                    instrPD += 5; //maximo e soma de valor
                } else {
                    //item nao cabe, copia valor do item anterior
                    maxTab[i][j] = maxTab[i - 1][j];
                    instrPD += 1;
                }
            }
        }

        return maxTab[N][C]; //valor maximo para N itens e capacidade C
    }
    //metodo que resolve a mochila por forca bruta recursiva
    public static int backPackBruteForce(int N, int C, Item[] itens) {
        iteracoesBruta = 0; //zera contador de iteracoes brutas
        instrBruta = 0; //zera contador de instrucoes brutas
        return bruteForce(1, C, N, itens); //comeca no item 1
    }
    //recursao que testa incluir ou nao cada item
    private static int bruteForce(int i, int capacidade, int N, Item[] itens) {
        iteracoesBruta++;
        instrBruta += 1; //conta a chamada recursiva
        if (i > N) {
            instrBruta += 1; //fim da lista de itens
            return 0; //nenhum item restante
        }
        if (itens[i].peso > capacidade) {
            instrBruta += 2; //comparacao e retorno
            return bruteForce(i + 1, capacidade, N, itens); //pula item que nao cabe
        }
        instrBruta += 2; //prepara as duas opcoes
        int semItem = bruteForce(i + 1, capacidade, N, itens); //nao pega item
        int comItem = itens[i].valor + bruteForce(i + 1, capacidade - itens[i].peso, N, itens); //pega item
        instrBruta += 2; //calcula maximo entre as opcoes
        return Math.max(semItem, comItem);
    }
    //getters para os contadores de DP
    public static long getIteracoesPD() {
        return iteracoesPD;
    }

    public static long getInstrPD() {
        return instrPD;
    }
    //getters para os contadores de forca bruta
    public static long getIteracoesBruta() {
        return iteracoesBruta;
    }

    public static long getInstrBruta() {
        return instrBruta;
    }
    //executa um caso de teste e imprime os valores calculados
    private static void runCase(String nome, int[] pesos, int[] valores, int capacidade) {
        Item[] itens = new Item[pesos.length + 1];
        itens[0] = new Item(0, 0); //indice 0 nao usado
        for (int i = 0; i < pesos.length; i++) {
            itens[i + 1] = new Item(pesos[i], valores[i]);
        }

        int N = pesos.length;
        int valorPD = backPackPD(N, capacidade, itens); //calcula com DP
        long iterPD = getIteracoesPD();
        long instrPD = getInstrPD();

        int valorBr = backPackBruteForce(N, capacidade, itens); //calcula com forca bruta
        long iterBr = getIteracoesBruta();
        long instrBr = getInstrBruta();

        System.out.println(nome);
        System.out.println("Capacidade = " + capacidade);
        System.out.println("Valor maximo DP      = " + valorPD + " | iteracoes = " + iterPD + " | instrucoes approximadas = " + instrPD);
        System.out.println("Valor maximo Bruto   = " + valorBr + " | iteracoes = " + iterBr + " | instrucoes approximadas = " + instrBr);
        System.out.println();
    }

    //metodo principal que roda os dois casos do Moodle
    public static void main(String[] args) {
        System.out.println("--- Comparacao Mochila DP x Forca Bruta ---\n");

        runCase("Caso 1", new int[]{23, 31, 29, 44, 53, 38, 63, 85, 89, 82},
                new int[]{92, 57, 49, 68, 60, 43, 67, 84, 87, 72}, 165);

        runCase("Caso 2", new int[]{56, 59, 80, 64, 75, 17},
                new int[]{50, 50, 64, 46, 50, 5}, 190);
    }
}
