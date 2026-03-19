package recursao;

import java.util.Random;
import java.util.ArrayList;
import br.pucrs.util.ExecTimer;

public class ExerRec {
	private long contIter = 0;

	public void resetCont(){
		contIter = 0;
	}
	public void incrCont(){
		contIter++;
	}
	public void incrCont(long i){
		contIter += i;
	}

	public long getContIter() {
		return contIter;
	}

	public  ArrayList<Long> geraArray(int nro){
		ArrayList<Long> res = new ArrayList<Long>();
		long novoNum;
		Random rnd = new Random(System.currentTimeMillis());

		for (int i = 0; i < nro; i++) {
			novoNum = rnd.nextInt(98)+1;
			res.add(novoNum);
		}

		return res;
	}

	public String geraPalindrome(int tam){
		StringBuilder str = new StringBuilder(tam);

		for (int i = 0; i < tam; i++)
			str.append('a');

		return str.toString();
	}

	public long fatorialIter(long n){
		long fat = 1;

		for (long i = n; i > 1; i--)
			fat = fat * i;

		return fat;
	}

	public long fatorial(long n) {
		long res = 0;

		if (n < 0)
			throw new IllegalArgumentException();
		else if ((n == 1) || (n == 0)) {
			incrCont();
			res = 1;
		}
		else {
			incrCont();
			res = n * fatorial(n-1);
		}

		return res;
	}

	public long somatorio(long n) {
		long res = 0;

		if (n == 0) {
			incrCont();
			res = 0;
		}
		else if (n> 0) {
			incrCont();
			res = n + somatorio(n-1);
		}
		else {
			incrCont();
			res = n + somatorio(n+1);
		}

		return res;
	}

	public long somatorio(long k, long j) {
		long res = 0;

		if (k == j) {
			incrCont();
			res = k;
		}
		else {
			incrCont();
			if (k < j)
				res = k + somatorio(k+1, j);
			else if (k > j)
				res = somatorio(j, k);
		}

		return res;
	}

	public long somatorioV2(long k, long j) {
		long res = 0;
		long ini, fim;

		if (k == j) {
			incrCont();
			res = k;
		}
		else {
			incrCont();
			if (k > j){
				ini = j;
				fim = k;
			}
			else { 
				ini = k;
				fim = j;
			}
			res = k + somatorio(k+1, j);
		}

		return res;
	}

	private void arrayListCopy(ArrayList<Long> src, int posSrc, ArrayList<Long> dest, int posDest, int length) {

		for (int  i = posSrc, j = posDest; i <= length; i++, j++ ){
			incrCont();
			dest.add(j, src.get(i));
		}
		return;
	}

	public long somaArray(ArrayList<Long> ar) {
		long res = 0;

		if (ar == null){
			incrCont();
			throw new IllegalArgumentException();
		}
		else if (ar.size() == 0){
			incrCont();
			res = 0;
		}
		else {
			incrCont();
			ArrayList<Long> nAr = new ArrayList<Long>(ar.size()-1);
			this.arrayListCopy(ar, 1, nAr, 0, ar.size()-1 );
			res = ar.get(0) + somaArray(nAr);
		}

		return res;
	}

	public long somaArray2(ArrayList<Long> ar) {
		return somaArray2Aux((ArrayList<Long>) ar.clone());
	}

	private long somaArray2Aux(ArrayList<Long> ar) {
		long res = 0;

		if ((ar == null) || (ar.size() == 0)){
			incrCont();
			throw new IllegalArgumentException();
		}
		else if (ar.size() == 1){
			incrCont();
			res = ar.get(0);
		}
		else {
			incrCont();
			incrCont(ar.size()-1);
			res = ar.remove(0) + somaArray2Aux(ar);
		}

		return res;
	}

	public long somaArrayPos(ArrayList<Long> ar) {
		return somaArrayPos(ar, 0);
	}

	private long somaArrayPos(ArrayList<Long> ar, int pos) {
		long res = 0;

		if ((ar == null) || (ar.size() == 0))
			throw new IllegalArgumentException();
		else if (pos >= ar.size()) {
			incrCont();
			res = 0;
		}
		else {
			res = ar.get(pos) + somaArrayPos(ar, pos+1);
			incrCont();
		}

		return res;
	}

	private long fibonacci(long n) {
		long res;

		if (n > 0)
			if ((n ==1) || (n == 2)) {
				incrCont();
				res = 1;
			}
			else {
				incrCont();
				res = fibonacci(n-1) + fibonacci(n-2);
			}
		else
			throw new IllegalArgumentException();

		return res;
	}

	public long findBiggest_v1(ArrayList<Long> ar) {
		return findBiggestAux_v1((ArrayList<Long>)ar.clone());
	}

	private long findBiggestAux_v1(ArrayList<Long> ar) {
		long res;
		long prim;
		long maior;

		if ((ar == null) ||
				(ar.size() == 0))
			throw new IllegalArgumentException();
		else if (ar.size() == 1)
			res = ar.get(0);
		else {
			prim = ar.remove(0);
			maior = findBiggestAux_v1(ar);
			if (prim > maior)
				res = prim;
			else
				res = maior;
		}

		return res;
	}


	public long findBiggest_v2(ArrayList<Long> ar) {
		return findBiggest_v2((ArrayList<Long>)ar, 0);
	}

	private long findBiggest_v2(ArrayList<Long> ar, int ini) {
		long res;
		long prim;
		long maior;

		if ((ar == null) ||
				((ar.size() - ini )== 0))
			throw new IllegalArgumentException();
		else if ((ar.size() - ini) == 1)
			res = ar.get(ini);
		else {
			prim = ar.get(ini);
			maior = findBiggest_v2(ar, ini + 1);
			if (prim > maior)
				res = prim;
			else
				res = maior;
		}

		return res;
	}


	// Sï¿½ converte pra binï¿½rio, mudar ao vivo pra base qualquer...
	// Proposto pelo Joï¿½o Batista

	public String convBase2( int n ) {
		String res;

		if (n < 0)
			throw new IllegalArgumentException();
		else if (n == 0) 
			res = "0";
		else if (n == 1) 
			res = "1";
		else 
			res = convBase2( n / 2 ) +  n % 2;

		return res;
	}

	// Demonstra o fluxo de execuï¿½ï¿½o
	// Proposto pelo Agustini
	public  void floresVaso(int numFlores) {
		if (numFlores > 0) {
			System.out.println("Tenho " + numFlores +
					" no vaso - vou tirar uma");
			floresVaso(numFlores - 1);
		} else {
			System.out.println("O vaso estï¿½ vazio!");
		}
		System.out.println("Voltei (aqui quando ainda tinha " + numFlores + " flores no vaso)");
	}

	public boolean isPal_v1(String s) {
		boolean res;

		if (s == null)
			throw new IllegalArgumentException();
		else if ((s.length() == 0) || (s.length() == 1))
			res = true;
		else if (s.charAt(0) != s.charAt(s.length()-1))
			res = false;
		else
			res = isPal_v1(s.substring(1, s.length()-1));

		return res;
	}

	public boolean isPal_v2(String s) {
		return isPal_v2(s, 0, s.length()-1);
	}

	private boolean isPal_v2(String s, int ini, int fim) {
		boolean res;

		if (s == null)
			throw new IllegalArgumentException();
		else if ((ini == fim) || (ini > fim))
			res = true;
		else if (s.charAt(ini) != s.charAt(fim))
			res = false;
		else
			res = isPal_v2(s, ini+1, fim-1);

		return res;
	}

	private boolean prefix(String str, String match){
		boolean res = true;

		if (str == null || match == null)
			throw new IllegalArgumentException();

		if (str.length() < match.length())
			res = false;
		else if (match.length() ==0)
			res = true;
		else if (str.length() ==0)
			res = false;
		else if (str.charAt(0) == match.charAt(0))
			res = prefix(str.substring(1), match.substring(1));
		else
			res = false;

		return res;
	}

	public boolean findString(String str, String match) {
		boolean res = true;

		if (str == null || match == null)
			throw new IllegalArgumentException();

		if (str.length() < match.length())
			res = false;
		else if (match.length() == 0)
			res = true;
		else if (str.length() == 0)
			res = false;
		else if (str.charAt(0) != match.charAt(0))
			res = findString(str.substring(1), match);
		else {
			if (prefix(str, match) == true)
				res = true;
			else
				res = findString(str.substring(1), match);
		}
		return res;
	}

	public static void main(String [] argc) {
		ExerRec ex = new ExerRec();
		ArrayList<Long> arr = new ArrayList<Long>();

		for (long i = 1; i <= 10; i++) 
			arr.add(i);

		System.out.println("\n\n ******Fatorial:");

		ex.resetCont();
		System.out.println("\nFatorial de 1 iter: " + ex.fatorial(1));
		System.out.println("Fatorial de 1: " + ex.fatorial(1));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("\nFatorial de 4 iter: " + ex.fatorialIter(4));
		System.out.println("Fatorial de 4: " + ex.fatorial(4));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("\nFatorial de 8 iter: " + ex.fatorialIter(8));
		System.out.println("Fatorial de 8: " + ex.fatorial(8));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("\nFatorial de 16 iter: " + ex.fatorialIter(16));
		System.out.println("Fatorial de 16: " + ex.fatorial(16));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("\nFatorial de 17 iter: " + ex.fatorialIter(17));
		System.out.println("Fatorial de 17: " + ex.fatorial(17));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("\nFatorial de 18 iter: " + ex.fatorialIter(18));
		System.out.println("Fatorial de 18: " + ex.fatorial(18));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("\nFatorial de 19 iter: " + ex.fatorialIter(19));
		System.out.println("Fatorial de 19: " + ex.fatorial(19));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		ExecTimer tf = new ExecTimer();

		tf.start();
		System.out.println("\nFatorial de 20 iter: " + ex.fatorialIter(20));
		tf.finish();
		System.out.println("Tempo: " + tf.getTime());
		tf.start();
		System.out.println("Fatorial de 20: " + ex.fatorial(20));
		tf.finish();
		System.out.println("Tempo: " + tf.getTime());
		System.out.println("Nro de iteracoes: " + ex.getContIter());


		ex.resetCont();
		System.out.println("\nFatorial de 21 iter: " + ex.fatorialIter(21));
		System.out.println("Fatorial de 21: " + ex.fatorial(21));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("\nFatorial de 100 iter: " + ex.fatorialIter(100));
		System.out.println("Fatorial de 100: " + ex.fatorial(100));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("\nFatorial de 1000 iter: " + ex.fatorialIter(1000));
		System.out.println("Fatorial de 1000: " + ex.fatorial(1000));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		System.out.println("Fatorial de 10000????" );
		try {
			ex.resetCont();
			System.out.println("Fatorial de 10000 iter: " + ex.fatorialIter(10000));
			System.out.println("Fatorial de 10000: " + ex.fatorial(10000));
			System.out.println("Nro de iteracoes: " + ex.getContIter());

			System.out.println("Fatorial de 10000000 iter: " + ex.fatorialIter(10000000));
			System.out.println("Fatorial de 10000000????" );
			ex.resetCont();
			System.out.println("Fatorial de 10000000: " + ex.fatorial(10000000));
			System.out.println("Nro de iteracoes: " + ex.getContIter());
		}
		catch (StackOverflowError exec) {
			System.out.println("Fatorial falhou: Estourou a pilha!");
			System.out.println(exec.getMessage());
		}


		System.out.println("\n\n ******Somatorio:");

		ex.resetCont();
		System.out.println("Somatorio a partir de 1: " + ex.somatorio(1));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Somatorio a partir de 4: " + ex.somatorio(4));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Somatorio a partir de 8: " + ex.somatorio(8));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Somatorio a partir de 16: " + ex.somatorio(16));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Somatorio a partir de -16: " + ex.somatorio(-16));
		System.out.println("Nro de iteracoes: " + ex.getContIter());


		ex.resetCont();
		System.out.println("Somatorio a partir de 100: " + ex.somatorio(100));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Somatorio a partir de 1000: " + ex.somatorio(1000));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		try {
			System.out.println("Somatorio de 10000????");
			ex.resetCont();
			System.out.println("Somatorio a partir de 10000: " + ex.somatorio(10000));
			System.out.println("Nro de iteracoes: " + ex.getContIter());

			System.out.println("Somatorio de 1000000????");
			ex.resetCont();
			System.out.println("Somatorio a partir de 1000000: " + ex.somatorio(1000000));
			System.out.println("Nro de iteracoes: " + ex.getContIter());
		}
		catch (StackOverflowError exec) {
			System.out.println("Somatório falhou: Estourou a pilha!");
			System.out.println(exec.getMessage());
		}

		System.out.println("\n\n ******Somatorio de k a j:");

		ex.resetCont();
		System.out.println("Somatorio V1 de 1 a 10: " + ex.somatorio(1, 10));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Somatorio V2 de 1 a 10: " + ex.somatorioV2(1, 10));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Somatorio V1 de 4 a 32: " + ex.somatorio(4, 32));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Somatorio V2 de 4 a 32: " + ex.somatorioV2(4, 32));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Somatorio V1 de 8 a 64: " + ex.somatorio(8, 64));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Somatorio V2 de 8 a 64: " + ex.somatorioV2(8, 64));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Somatorio V1 de 16 a 256: " + ex.somatorio(16, 256));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Somatorio V2 de 16 a 256: " + ex.somatorioV2(16, 256));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Somatorio V1 de 100 a 1000: " + ex.somatorio(100, 1000));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Somatorio V2 de 100 a 1000: " + ex.somatorioV2(100, 1000));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		try {
			ex.resetCont();
			System.out.println("Somatorio de 1000 a 10000: " + ex.somatorio(1000, 10000));
			System.out.println("Nro de iteracoes: " + ex.getContIter());
			ex.resetCont();
			System.out.println("Somatorio V2 de 1000 a 10000: " + ex.somatorioV2(1000, 10000));
			System.out.println("Nro de iteracoes: " + ex.getContIter());
		}
		catch(StackOverflowError exec) {
			System.out.println("Somatório ou V2 falhou: Estourou a pilha!");
			System.out.println(exec.getMessage());
		}

		System.out.println("\n\n ******Soma o ArrayList (v1 - posiï¿½ï¿½o, v2 - remove elem, e v3 - copia array):");		
		System.out.println("Soma ArrayList (v1) com 10 elementos - 1 a 10: " + ex.somaArrayPos(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Soma ArrayList (v2) com 10 elementos - 1 a 10: " + ex.somaArray2(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Soma ArrayList (v3) com 10 elementos - 1 a 10: " + ex.somaArray(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		arr = ex.geraArray(4);
		ex.resetCont();
		System.out.println("Soma ArrayList (v1) com 4 elementos: " + ex.somaArrayPos(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Soma ArrayList (v2) com 4 elementos: " + ex.somaArray2(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Soma ArrayList (v3) com 4 elementos: " + ex.somaArray(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		arr = ex.geraArray(8);
		ex.resetCont();
		System.out.println("Soma ArrayList (v1) com 8 elementos: " + ex.somaArrayPos(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Soma ArrayList (v2) com 8 elementos: " + ex.somaArray2(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Soma ArrayList (v3) com 8 elementos: " + ex.somaArray(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		arr = ex.geraArray(16);
		ex.resetCont();
		System.out.println("Soma ArrayList (v1) com 16 elementos: " + ex.somaArrayPos(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Soma ArrayList (v2) com 16 elementos: " + ex.somaArray2(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Soma ArrayList (v3) com 16 elementos: " + ex.somaArray(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());


		arr = ex.geraArray(100);
		ex.resetCont();
		System.out.println("Soma ArrayList (v1) com 100 elementos: " + ex.somaArrayPos(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Soma ArrayList (v2) com 100 elementos: " + ex.somaArray2(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		ex.resetCont();
		System.out.println("Soma ArrayList (v3) com 100 elementos: " + ex.somaArray(arr));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ExecTimer t1 = new ExecTimer();
		try {
			arr = ex.geraArray(100000);
			ex.resetCont();

			t1.start();

			System.out.println("\n\nSoma ArrayList (v1) com 100000 elementos: " + ex.somaArrayPos(arr));
			t1.finish();

			System.out.println("Nro de iteracoes: " + ex.getContIter());
			System.out.println("Tempo em segundos: " + t1.getTime());

			ex.resetCont();
			t1.start();

			System.out.println("\n\nSoma ArrayList (v2) com 100000 elementos: " + ex.somaArray2(arr));
			t1.finish();

			System.out.println("Nro de iteracoes: " + ex.getContIter());
			System.out.println("Tempo em segundos: " + t1.getTime());

			ex.resetCont();
			t1.start();

			System.out.println("\n\nSoma ArrayList (v3) com 100000 elementos: " + ex.somaArray(arr));
			t1.finish();

			System.out.println("Nro de iteracoes: " + ex.getContIter());
			System.out.println("Tempo em segundos: " + t1.getTime());

			System.out.println("Soma ArrayList com 1000000 elementos????");
		}
		catch(StackOverflowError exec) {
			System.out.println("SomaArrayList V3 falhou: Estourou a pilha!");
			System.out.println(exec.getMessage());
		}

		System.out.println("\n\n ******Fibonacci:");

		ex.resetCont();
		System.out.println("Fibonacci na posicao 4: " + ex.fibonacci(4));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Fibonacci na posicao 8: " + ex.fibonacci(8));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Fibonacci na posicao 16: " + ex.fibonacci(16));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		ex.resetCont();
		System.out.println("Fibonacci na posicao 32: " + ex.fibonacci(32));
		System.out.println("Nro de iteracoes: " + ex.getContIter());

		System.out.println("Fibonacci na posicao 64? \n");	
//		ex.resetCont();
//		System.out.println("Fibonacci na posicao 64: " + ex.fibonacci(64));
//		System.out.println("Nro de iteracoes: " + ex.getContIter());

		System.out.println("\n\n ******Acha o maior - v1 e v2:");
		arr = ex.geraArray(4);
		ex.resetCont();
		System.out.println("O Maior (4 elementos - v1) de " + arr.toString() + " ï¿½ " +  ex.findBiggest_v1(arr) );
		ex.resetCont();
		System.out.println("O Maior (4 elementos - v2) de " + arr.toString() + " ï¿½ " +  ex.findBiggest_v2(arr) );
		arr = ex.geraArray(8);
		ex.resetCont();
		System.out.println("O Maior (8 elementos - v1) de " + arr.toString() + " ï¿½ " +  ex.findBiggest_v1(arr) );
		ex.resetCont();
		System.out.println("O Maior (8 elementos - v2) de " + arr.toString() + " ï¿½ " +  ex.findBiggest_v2(arr) );
		arr = ex.geraArray(32);
		ex.resetCont();
		System.out.println("O Maior (32 elementos - v1) de " + arr.toString() + " ï¿½ " +  ex.findBiggest_v1(arr) );
		ex.resetCont();
		System.out.println("O Maior (32 elementos - v2) de " + arr.toString() + " ï¿½ " +  ex.findBiggest_v2(arr) );
		arr = ex.geraArray(128);

		ex.resetCont();
		t1.start();

		System.out.println("\n\nO Maior (128 elementos - v1) de " + arr.toString() + " ï¿½ " +  ex.findBiggest_v1(arr) );
		t1.finish();
		System.out.println("Tempo em segundos: " + t1.getTime());

		ex.resetCont();
		t1.start();

		System.out.println("O Maior (128 elementos - v2) de " + arr.toString() + " ï¿½ " +  ex.findBiggest_v2(arr) );
		t1.finish();
		System.out.println("Tempo em segundos: " + t1.getTime());


		System.out.println("\n\n ******Palindrome - v1 e v2:");
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'a'? " +  ex.isPal_v1("a") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'a'? " +  ex.isPal_v2("a") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome ''? " +  ex.isPal_v1("") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome ''? " +  ex.isPal_v2("") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'casa'? " +  ex.isPal_v1("casa") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'casa'? " +  ex.isPal_v2("casa") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'arara'? " +  ex.isPal_v1("arara") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'arara'? " +  ex.isPal_v2("arara") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'cassac'? " +  ex.isPal_v1("cassac") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'cassac'? " +  ex.isPal_v2("cassac") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'mesam'? " +  ex.isPal_v1("mesam") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'mesam'? " +  ex.isPal_v2("mesam") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'ss'? " +  ex.isPal_v1("ss") );
		ex.resetCont();
		System.out.println("ï¿½ palindrome 'ss'? " +  ex.isPal_v2("ss") );

		String str = ex.geraPalindrome(10000);
		ex.resetCont();
		ExecTimer t2 = new ExecTimer();
		try {
		t2.start();
		System.out.println("ï¿½ palindrome str com 10000? " +  ex.isPal_v1(str) );
		t2.finish();
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		System.out.println("Tempo em segundos: " + t2.getTime());

		t2.start();
		System.out.println("\nï¿½ palindrome str com 10000? " +  ex.isPal_v2(str) );
		t2.finish();
		System.out.println("Nro de iteracoes: " + ex.getContIter());
		System.out.println("Tempo em segundos: " + t2.getTime());
		}
		catch(StackOverflowError exec) {
			System.out.println("Is Pal V2 falhou: Estourou a pilha!");
			System.out.println(exec.getMessage());
		}

		System.out.println("\n\n ******Converte para Base 2:");
		ex.resetCont();
		System.out.println("Convertendo 0 -> " +  ex.convBase2( 0 ) );
		ex.resetCont();
		System.out.println("Convertendo 1 -> " +  ex.convBase2( 1 ) );
		ex.resetCont();
		System.out.println("Convertendo 2 -> " +  ex.convBase2( 2 ) );
		ex.resetCont();
		System.out.println("Convertendo 3 -> " +  ex.convBase2( 3 ) );
		ex.resetCont();
		System.out.println("Convertendo 4 -> " +  ex.convBase2( 4 ) );
		ex.resetCont();
		System.out.println("Convertendo 15 -> " +  ex.convBase2( 15 ) );
		ex.resetCont();
		System.out.println("Convertendo 16 -> " +  ex.convBase2( 16 ) );
		ex.resetCont();
		System.out.println("Convertendo 143 -> " +  ex.convBase2( 143 ) );

		System.out.println("\n\n ******Flores no vaso:");
		System.out.println("Vaso com 10 Flores:");
		ex.floresVaso(10);

		System.out.println("\n\n ******Find String:");
		ex.resetCont();
		try {
		System.out.println("findString(null, null): " +  ex.findString(null, null) );
		}
		catch(IllegalArgumentException exec) {
			System.out.println("findString falhou: null e null!");
			System.out.println(exec.getMessage());
		}
		
		try {
		ex.resetCont();
		System.out.println("findString(\"casamento\", null): " +  ex.findString("casamento", null) );
		}
		catch (IllegalArgumentException exec) {
			System.out.println("findString falhou: String null!");
			System.out.println(exec.getMessage());
		}
		ex.resetCont();
		System.out.println("findString(\"casamento\", \"same\"): " +  ex.findString("casamento", "same") );
		ex.resetCont();
		System.out.println("findString(\"casamento\", \"sae\"): " +  ex.findString("casamento", "sae") );
		ex.resetCont();
		System.out.println("findString(\"casamento\", \"casamento\"): " +  ex.findString("casamento", "casamento") );
		ex.resetCont();
		System.out.println("findString(\"samento\", \"casamento\"): " +  ex.findString("samento", "casamento") );

	}

}
