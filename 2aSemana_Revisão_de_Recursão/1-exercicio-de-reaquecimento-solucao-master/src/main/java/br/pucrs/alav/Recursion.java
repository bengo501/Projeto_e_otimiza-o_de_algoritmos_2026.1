package br.pucrs.alav;

public class Recursion {
	
	public static void main(String[] args) {
		Recursion rec = new Recursion();
		
		System.out.println("6 * 4 = " + rec.multNat(6, 4));

		System.out.println("6 + 4 = " + rec.somaIncr(6, 4));
		System.out.println("6 + 4 = " + rec.somaIncrAlt(6, 4));
		System.out.println("6 + 4 = " + rec.somaIncrAlt2(6, 4));
		
		for (int i = 1; i <=5; i++)
			System.out.println("n = " + i + "   serie = " + rec.somaSerie(i));

		System.out.println("\nCasa -> " + rec.reverseStr("Casa"));
		System.out.println("Org�nico -> " + rec.reverseStr("Org�nico"));
		System.out.println("Paralelo -> " + rec.reverseStr("Paralelo"));
		System.out.println(" -> " + rec.reverseStr(""));
		System.out.println("Arara -> " + rec.reverseStr("Arara"));

		System.out.println("");
		for (int i = 1; i <=5; i++)
			System.out.println("n = " + i + "   fFunction = " + rec.fFunction(i));

		System.out.println("");
		System.out.println("m = 0, n = 0   --> " + rec.ackerman(0, 0));
		System.out.println("m = 0, n = 1   --> " + rec.ackerman(0, 1));
		System.out.println("m = 1, n = 0   --> " + rec.ackerman(1, 0));
		System.out.println("m = 0, n = 2   --> " + rec.ackerman(0, 2));
		System.out.println("m = 2, n = 0   --> " + rec.ackerman(2, 0));
		System.out.println("m = 1, n = 1   --> " + rec.ackerman(1, 1));
		System.out.println("m = 1, n = 2   --> " + rec.ackerman(1, 2));
		System.out.println("m = 1, n = 3   --> " + rec.ackerman(1, 3));
		System.out.println("m = 2, n = 1   --> " + rec.ackerman(2, 1));
		System.out.println("m = 3, n = 1   --> " + rec.ackerman(3, 1));
		System.out.println("m = 3, n = 2   --> " + rec.ackerman(3, 2));
		System.out.println("m = 2, n = 3   --> " + rec.ackerman(2, 3));
		System.out.println("m = 4, n = 1   --> " + rec.ackerman(4, 1));
		System.out.println("m = 4, n = 2   --> " + rec.ackerman(4, 2));

		int [] vet = {1,2,3,4,5,6,7,8,9,10};
		System.out.println("\nSoma de {1,2,3,4,5,6,7,8,9,10} = " + rec.somaVet1(vet));
		vet[0] = 10;
		vet[1] = 10;
		vet[2] = 10;
		vet[3] = 10;
		vet[4] = 10;
		vet[5] = 10;
		vet[6] = 10;
		vet[7] = 10;
		vet[8] = 10;
		vet[9] = 10;
		System.out.println("Soma de {10, 10, 10, 10, 10, 10, 10, 10, 10, 10} = " + rec.somaVet1(vet));
		
		vet[0] = 2;
		vet[1] = 2;
		vet[2] = 2;
		vet[3] = 2;
		vet[4] = 2;
		vet[5] = 2;
		vet[6] = 2;
		vet[7] = 2;
		vet[8] = 2;
		vet[9] = 2;
		System.out.println("\nProduto de {2, 2, 2, 2, 2, 2, 2, 2, 2, 2} = " + rec.multVet1(vet));
		System.out.println("Produto de {2, 2, 2, 2, 2, 2, 2, 2, 2, 2} = " + rec.multVet2(vet));
	}

	public long multNat(long vezes, long nro) {
		if (vezes < 0)
			throw new IllegalArgumentException("N�mero negativo");
		else if (vezes == 0)
			return 0;
		else if (vezes == 1)
			return nro;
		else 
			return multNat(vezes - 1, nro) + nro;
	}

	public long somaIncr(long n1, long n2) {
		if ((n1 < 0) || (n2 < 0))
			throw new IllegalArgumentException();
		else if ((n1 ==0) && (n2 == 0))
			return(0);
		else if (n1 == 0)
			return(somaIncr(n1, n2 - 1) + 1);
		else if (n2 == 0)
			return(somaIncr(n1 - 1, n2) + 1);
		else 
			return(somaIncr(n1 - 1, n2 - 1) + 1 + 1);
	}

	public long somaIncrAlt(long n1, long n2) {
		if ((n1 < 0) || (n2 < 0))
			throw new IllegalArgumentException();
		else if ((n1 ==0) && (n2 == 0))
			return(0);
		else if (n1 == 0)
			return(somaIncr(n1, n2 - 1) + 1);
		else if (n2 == 0)
			return(somaIncr(n1 - 1, n2) + 1);
		else 
			return(somaIncr(n1, n2 - 1) + 1);
	}
	
	public long somaIncrAlt2(long n1, long n2) {
		if ((n1 < 0) || (n2 < 0))
			throw new IllegalArgumentException();
		else if (n1 > 0)
			return(somaIncrAlt2(n1 - 1, n2) + 1);
		else if (n2 > 0)
			return(somaIncrAlt2(n1, n2 - 1) + 1);
		else 
			return(0);
	}

	public double somaSerie(long n) {
		if (n < 0)
			throw new IllegalArgumentException();
		else if (n ==1)
			return(1);
		else 
			return(somaSerie(n-1) + 1/((double)n));
	}

	public String reverseStr(String str) {
		StringBuilder res = new StringBuilder(str.length());

		for(int i = str.length()-1; i >= 0; i--)
			res.append(str.charAt(i));

		return res.toString();
	}

	public long fFunction(long n) {
		if (n < 0)
			throw new IllegalArgumentException("Nro negativo.");
		else if ((n == 1) || (n == 2))
			return n;
		else 
			return 2*fFunction(n-1)+3*fFunction(n-2);
	}

	public long ackerman(long m, long n) {
		if (m == 0)
			return n + 1;
		else if ((m != 0) && (n == 0))
			return ackerman(m-1, 1);
		else /**if ((m != 0) && (n != 0))  **/
			return ackerman(m-1, ackerman(m, n-1));
	}

	public int [] vetSlice(int[] vet, int ini, int fim) {
		int [] res = new int[fim - ini];
		
		System.arraycopy(vet, ini, res, 0, fim - ini);
		
		return res;
	}
	
	public long somaVet1(int[] vet) {
		return somaVet1(vet, 0);
	}

	private long somaVet1(int [] vet, int pos) {
		if ((pos < 0) || (pos >= vet.length) || (vet == null))
			throw new IllegalArgumentException("Nro negativo!");
		else if (vet.length == 0)
			return 0;
		else if (pos == vet.length - 1)
			return vet[pos];
		else return vet[pos] + somaVet1(vet, pos + 1);
	}

	public long somaVet2(int[] vet) {
		if (vet.length == 0)
			return 0;
		else 
			return vet[0] + somaVet2(vetSlice(vet, 1, vet.length));
	}
	
	public long multVet1(int[] vet) {
		return multVet1(vet, 0);
	}

	private long multVet1(int [] vet, int pos) {
		if ((pos < 0) || (pos >= vet.length) || (vet == null))
			throw new IllegalArgumentException("Nro negativo!");
		else if (vet.length == 0)
			return 0;
		else if (pos == vet.length - 1)
			return vet[pos];
		else return vet[pos] * multVet1(vet, pos + 1);
	}

	public long multVet2(int[] vet) {
		if (vet.length == 0)
			return 0;
		else if (vet.length == 1)
			return vet[0];
		else 
			return vet[0] * multVet2(vetSlice(vet, 1, vet.length));
	}
}

