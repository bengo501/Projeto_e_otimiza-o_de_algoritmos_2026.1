package br.pucrs.alav;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class RecursionTests {
	private Recursion rec;
	
	@BeforeAll
	public void setUp() {
		rec = new Recursion();
	}
	
	@Test
	public void testMultNat1() {
		assertEquals(24, rec.multNat(6, 4), "6 * 4 == 24");
	}
	
	@Test
	public void testMultNat2() {
		assertEquals(24, rec.multNat(4, 6), "4 * 6 == 24");
	}
	
	@Test
	public void testMultNat3() {
		assertEquals(05, rec.multNat(1, 5), "1 * 5 == 5");
	}
	
	@Test
	public void testMultNat4() {
		assertEquals(25, rec.multNat(5, 5), "5 * 5 == 25");
	}
	
	@Test
	public void testMultNat5() {
		assertEquals(0, rec.multNat(0, 5), "0 * 5 == 0");
	}
	
	@Test
	public void testMultNat6() {
		assertEquals(0, rec.multNat(5, 0), "0 * 5 == 0");
	}

	@Test
	public void testSomaIncr1() {
		assertEquals(6, rec.somaIncr(4, 2), "4 + 2 == 6");
	}
	
	@Test
	public void testSomaIncr2() {
		assertEquals(6, rec.somaIncr(2, 4), "2 + 4 == 6");
	}

	@Test
	public void testSomaIncr3() {
		assertEquals(8, rec.somaIncr(4, 4), "4 + 4 == 8");
	}

	@Test
	public void testSomaIncrAlt1() {
		assertEquals(6, rec.somaIncrAlt(4, 2), "4 + 2 == 6");
	}
	
	@Test
	public void testSomaIncrAlt2() {
		assertEquals(6, rec.somaIncrAlt(2, 4), "2 + 4 == 6");
	}

	@Test
	public void testSomaIncrAlt3() {
		assertEquals(8, rec.somaIncrAlt(4, 4), "4 + 4 == 8");
	}

	@Test
	public void testSomaSerie1() {
		assertEquals(1.0, rec.somaSerie(1), 0.00001, " para n = 1");
	}
	
	@Test
	public void testSomaSerie2() {
		assertEquals(1.5, rec.somaSerie(2), 0.00001, " para n = 2");
	}

	@Test
	public void testSomaSerie3() {
		assertEquals(1.833333, rec.somaSerie(3), 0.00001, " para n = 3");
	}
	
	@Test
	public void testSomaSerie4() {
		assertEquals(2.083333, rec.somaSerie(4), 0.00001, " para n = 4");
	}
	
	@Test
	public void testSomaSerie5() {
		assertEquals(2.283333, rec.somaSerie(5), 0.00001, " para n = 5");
	}

	@Test
	public void testreverseStr1() {
		assertEquals("asaC", rec.reverseStr("Casa"));
	}
	
	@Test
	public void testreverseStr2() {
		assertEquals("ocin�grO", rec.reverseStr("Org�nico"));
	}
	
	@Test
	public void testreverseStr3() {
		assertEquals("olelaraP", rec.reverseStr("Paralelo"));
	}	
	
	@Test
	public void testreverseStr4() {
		assertEquals("ararA", rec.reverseStr("Arara"));
	}	
	
	@Test
	public void testreverseStr5() {
		assertEquals("a", rec.reverseStr("a"));
	}	
	
	@Test
	public void testreverseStr6() {
		assertEquals("", rec.reverseStr(""));
	}	
	
	@Test
	public void testFFunction1() {
		assertEquals(1, rec.fFunction(1));
	}	
	
	@Test
	public void testFFunction2() {
		assertEquals(2, rec.fFunction(2));
	}
	
	@Test
	public void testFFunction3() {
		assertEquals(7, rec.fFunction(3));
	}	
	
	@Test
	public void testFFunction4() {
		assertEquals(20, rec.fFunction(4));
	}	
	
	@Test
	public void testFFunction5() {
		assertEquals(61, rec.fFunction(5));
	}	
	
	@Test
	public void testAckermarn1() {
		assertEquals(1, rec.ackerman(0, 0));
	}	

	@Test
	public void testAckermarn2() {
		assertEquals(2, rec.ackerman(0, 1));
	}	

	@Test
	public void testAckermarn3() {
		assertEquals(2, rec.ackerman(1, 0));
	}	

	@Test
	public void testAckermarn4() {
		assertEquals(3, rec.ackerman(0, 2));
	}	

	@Test
	public void testAckermarn5() {
		assertEquals(3, rec.ackerman(2, 0));
	}
	
	@Test
	public void testAckermarn6() {
		assertEquals(3, rec.ackerman(1, 1));
	}	

	@Test
	public void testAckermarn7() {
		assertEquals(4, rec.ackerman(1, 2));
	}	

	@Test
	public void testAckermarn8() {
		assertEquals(5, rec.ackerman(1, 3));
	}	
	
	@Test
	public void testAckermarn9() {
		assertEquals(5, rec.ackerman(2, 1));
	}	
	
	@Test
	public void testAckermarn10() {
		assertEquals(13, rec.ackerman(3, 1));
	}	
	
	@Test
	public void testAckermarn11() {
		assertEquals(29, rec.ackerman(3, 2));
	}	
	
	@Test
	public void testAckermarn12() {
		assertEquals(9, rec.ackerman(2, 3));
	} 	
	
	@Test
	public void testVetSlice1() {
		int [] vetRes = {3, 4, 5};
		int [] vet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(vetRes, rec.vetSlice(vet, 2, 5));
	}
	
	@Test
	public void testVetSlice2() {
		int [] vetRes = {7};
		int [] vet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(vetRes, rec.vetSlice(vet, 6, 7));
	}
	
	@Test
	public void testVetSlice3() {
		int [] vetRes = {};
		int [] vet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(vetRes, rec.vetSlice(vet, 6, 6));
	}
	
	@Test
	public void testSomaVet1() {
		int [] vet = {1,2,3,4,5,6,7,8,9,10};
		assertEquals(55, rec.somaVet1(vet));
	}

	@Test
	public void testSomaVet2() {
		int [] vet = new int[10];

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
		assertEquals(100, rec.somaVet1(vet));
	}
}
