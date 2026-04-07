//Classe que resolve o problema da mochila usando forca bruta sem programacao dinamica
//Estrategia bruta (nao otimizada): testa TODAS as combinacoes possiveis de inclusao/exclusao de itens
//Complexidade exponencial O(2^N) pois cada item tem 2 opcoes (incluir ou nao incluir)
//Usa bitmask para representar quais itens estao selecionados na melhor solucao
//Vantagem: codigo direto, encontra solucao exata testando todas as opcoes
//Desvantagem: MUITO lento para muitos itens pois explora todas as 2^N combinacoes possiveis
//Util para problemas pequenos, inviavel quando N eh grande (mais de 20-30 itens)
public class Mochila {

    //classe para guardar peso e valor de cada item
    public static class Item {
        public final int peso;
        public final int valor;

        public Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    //contador de iteracoes do algoritmo de forca bruta
    private static long iteracoes;
    //melhor valor encontrado
    private static int bestValue;
    //mask dos itens escolhidos na melhor solucao
    private static int bestMask;

    //resolve a mochila testando todas as combinacoes possiveis
    public static int backPackBruta(int N, int C, Item[] itens) {
        iteracoes = 0; //zera contador de iteracoes
        bestValue = 0; //zera melhor valor
        bestMask = 0; //zera melhor selecao
        bruteForce(1, N, C, itens, 0, 0, 0); //comeca no item 1
        return bestValue; //retorna melhor valor encontrado
    }

    //recursao que testa incluir ou nao cada item
    private static void bruteForce(int i, int N, int capacidade, Item[] itens, int valorAtual, int pesoAtual, int mask) {
        iteracoes++; //conta uma combinacao avaliada
        if (i > N) {
            if (valorAtual > bestValue) {
                bestValue = valorAtual; //atualiza melhor valor
                bestMask = mask; //salva selecao correta
            }
            return;
        }

        //caso nao inclua o item i
        bruteForce(i + 1, N, capacidade, itens, valorAtual, pesoAtual, mask);

        //caso inclua o item i, se couber na mochila
        if (pesoAtual + itens[i].peso <= capacidade) {
            bruteForce(i + 1, N, capacidade, itens,
                    valorAtual + itens[i].valor,
                    pesoAtual + itens[i].peso,
                    mask | (1 << (i - 1)));
        }
    }

    //retorna os indices dos itens selecionados na melhor solucao
    public static int[] getSelectedItems(int N) {
        int[] selected = new int[N];
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if ((bestMask & (1 << (i - 1))) != 0) {
                selected[count++] = i;
            }
        }
        int[] result = new int[count];
        System.arraycopy(selected, 0, result, 0, count);
        return result;
    }

    //retorna o contador de iteracoes
    public static long getIteracoes() {
        return iteracoes;
    }

    //executa um caso de teste e imprime o resultado
    private static void runCase(String nome, int[] pesos, int[] valores, int capacidade) {
        Item[] itens = new Item[pesos.length + 1];
        itens[0] = new Item(0, 0); //indice 0 nao usado
        for (int i = 0; i < pesos.length; i++) {
            itens[i + 1] = new Item(pesos[i], valores[i]);
        }

        int N = pesos.length;
        int valorMaximo = backPackBruta(N, capacidade, itens);
        int[] selecionados = getSelectedItems(N);

        System.out.println(nome);
        System.out.println("Capacidade = " + capacidade);
        System.out.println("Valor maximo = " + valorMaximo);
        System.out.print("Itens selecionados = ");
        for (int i = 0; i < selecionados.length; i++) {
            System.out.print(selecionados[i]);
            if (i < selecionados.length - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.println("Iteracoes = " + getIteracoes());
        System.out.println();
    }

    //metodo principal que executa os casos de teste
    public static void main(String[] args) {
        System.out.println("--- Mochila Forca Bruta ---\n");

        runCase("Caso 1",
                new int[]{23, 31, 29, 44, 53, 38, 63, 85, 89, 82},
                new int[]{92, 57, 49, 68, 60, 43, 67, 84, 87, 72},
                165);

        runCase("Caso 2",
                new int[]{56, 59, 80, 64, 75, 17},
                new int[]{50, 50, 64, 46, 50, 5},
                190);
    }
}
