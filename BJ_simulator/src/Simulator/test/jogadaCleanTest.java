package Simulator.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

import Simulator.Carta;
import Simulator.Jogada;	
import Simulator.JogadaClean;	

public class jogadaCleanTest {

	@Test
	public void testRetornaCarta()
	{
		int carta;
		JogadaClean j;
		
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			carta = j.retornaCarta(0, false);
			Assert.assertTrue(carta >= 2 && carta <=11);

			j = new JogadaClean(false);	
			carta = j.retornaCarta(20, false);
			Assert.assertTrue(carta >= 1 && carta <=10);
		}		
	}
	
	@Test
	public void testPegaCarta()
	{
		int soma;
		JogadaClean j;
		
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			soma = j.pegaCarta(0);
			Assert.assertTrue(soma >= 2 && soma <=11);
			
			j = new JogadaClean(false);	
			soma = j.pegaCarta(11);
			Assert.assertTrue(soma >= 12 && soma <=21);
		}
	}
	
	@Test
	public void testContaA()
	{
		int soma;
		JogadaClean j;
		
		j = new JogadaClean(false);	
		soma = j.contaA(11, 11);
		assertThat(soma, is(2));

		soma = j.contaA(10, 11);
		assertThat(soma, is(1));
		
		soma = j.contaA(9, 8);
		assertThat(soma, is(0));
	}

	@Test
	public void testDobrar()
	{
		int soma;
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			soma = j.dobrar(0);
			assertThat(j.aposta, is(4));
			Assert.assertTrue(soma >= 2 && soma <=11);

			j = new JogadaClean(false);	
			soma = j.dobrar(20);
			assertThat(j.aposta, is(4));
			Assert.assertTrue(soma >= 21 && soma <=30);
		}
	}

	@Test
	public void test22()
	{
		JogadaClean j;
		for(int i = 0; i < 1000; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(2, 2, 2, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 4 && j.somaJogadorDividiu == 0);	
			
			j = new JogadaClean(false);	
			j.iniciaJogada(2, 2, 3, 0); //SP
			Assert.assertTrue(j.saldoJogador <= 8 && j.saldoJogador >= -8); 
			Assert.assertTrue(j.somaJogador > 0 && j.somaJogadorDividiu > 0);	
			
			j = new JogadaClean(false);	
			j.iniciaJogada(2, 2, 7, 0); //SP
			Assert.assertTrue(j.saldoJogador <= 8 && j.saldoJogador >= -8); 
			Assert.assertTrue(j.somaJogador > 0 && j.somaJogadorDividiu > 0);		
			
			j = new JogadaClean(false);	
			j.iniciaJogada(2, 2, 8, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 4 && j.somaJogadorDividiu == 0);				
		}
	}

	@Test
	public void test33()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(3, 3, 3, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 6 && j.somaJogadorDividiu == 0);	
			
			j = new JogadaClean(false);	
			j.iniciaJogada(3, 3, 4, 0); //SP
			Assert.assertTrue(j.saldoJogador <= 4 && j.saldoJogador >= -4); 
			Assert.assertTrue(j.somaJogador > 0 && j.somaJogadorDividiu > 0);	
			
			j = new JogadaClean(false);	
			j.iniciaJogada(3, 3, 7, 0); //SP
			Assert.assertTrue(j.saldoJogador <= 4 && j.saldoJogador >= -4); 
			Assert.assertTrue(j.somaJogador > 0 && j.somaJogadorDividiu > 0);		
			
			j = new JogadaClean(false);	
			j.iniciaJogada(3, 3, 8, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 6 && j.somaJogadorDividiu == 0);				
		}
	}
	
	@Test
	public void test8()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(4, 4, 0, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 8 && j.somaJogadorDividiu == 0);
			
			j = new JogadaClean(false);	
			j.iniciaJogada(5, 3, 0, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 8 && j.somaJogadorDividiu == 0);
		}
	}

	@Test
	public void test9()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(5, 4, 2, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 9 && j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(5, 4, 7, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 9 && j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(5, 4, 3, 0);
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador > 9 && j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(5, 4, 6, 0);
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador > 9 && j.somaJogadorDividiu == 0);
			
		}
	}
	
	@Test
	public void test10()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(5, 5, 9, 0);
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador > 10 && j.somaJogadorDividiu == 0);
			
			j = new JogadaClean(false);	
			j.iniciaJogada(6, 4, 2, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador > 10 && j.somaJogadorDividiu == 0);
			
			j = new JogadaClean(false);	
			j.iniciaJogada(3, 7, 10, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 10 && j.somaJogadorDividiu == 0);
		}
	}

	@Test
	public void test11()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(5, 6, 10, 0);
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador > 11 && j.somaJogadorDividiu == 0);
			
			j = new JogadaClean(false);	
			j.iniciaJogada(7, 4, 11, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 11 && j.somaJogadorDividiu == 0);			
		}
	}

	@Test
	public void test12()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(8, 4, 3, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 12 && j.somaJogadorDividiu == 0);
			
			j = new JogadaClean(false);	
			j.iniciaJogada(2, 10, 4, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 12 && j.somaJogadorDividiu == 0);	
			
			j = new JogadaClean(false);	
			j.iniciaJogada(2, 10, 6, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 12 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(8, 4, 7, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 12 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(6, 6, 6, 0);
			Assert.assertTrue(j.saldoJogador <= 4 && j.saldoJogador >= -4);
			Assert.assertTrue(j.somaJogador > 0 && j.somaJogadorDividiu > 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(6, 6, 7, 0);
			Assert.assertTrue(j.saldoJogador <= 4 && j.saldoJogador >= -4);
			Assert.assertTrue(j.somaJogador > 12 && j.somaJogadorDividiu == 0);	
		}
	}

	@Test
	public void test13()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(10, 3, 6, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 13 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(6, 7, 7, 0);
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 13 && j.somaJogadorDividiu == 0);			
		}
	}

	@Test
	public void test14()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(10, 4, 6, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 14 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(6, 8, 7, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 14 && j.somaJogadorDividiu == 0);		

			j = new JogadaClean(false);	
			j.iniciaJogada(7, 7, 7, 0); //SP
			Assert.assertTrue(j.saldoJogador <= 4 && j.saldoJogador >= -4); 
			Assert.assertTrue(j.somaJogador > 0 && j.somaJogadorDividiu > 0);			

			j = new JogadaClean(false);	
			j.iniciaJogada(7, 7, 8, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 14 && j.somaJogadorDividiu == 0);			
		}
	}

	@Test
	public void test15()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(10, 5, 6, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 15 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(6, 9, 7, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 15 && j.somaJogadorDividiu == 0);				
		}
	}

	@Test
	public void test16()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(10, 6, 6, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 16 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(7, 9, 7, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 16 && j.somaJogadorDividiu == 0);		

			j = new JogadaClean(false);	
			j.iniciaJogada(8, 8, 0, 0); //SP
			Assert.assertTrue(j.saldoJogador <= 4 && j.saldoJogador >= -4); 
			Assert.assertTrue(j.somaJogador > 0 && j.somaJogadorDividiu > 0);			
		
		}
	}

	@Test
	public void test17()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(10, 7, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 17 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(8, 9, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 17 && j.somaJogadorDividiu == 0);			
		}
	}

	@Test
	public void test18()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(10, 8, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 18 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(9, 9, 7, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 18 && j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(9, 9, 10, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 18 && j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(9, 9, 9, 0); //SP
			Assert.assertTrue(j.saldoJogador <= 4 && j.saldoJogador >= -4); 
			Assert.assertTrue(j.somaJogador > 0 && j.somaJogadorDividiu > 0);				
		}
	}

	@Test
	public void test19_21()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(10, 9, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 19 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(10, 10, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 20 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(10, 11, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 3 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 21 && j.somaJogadorDividiu == 0);			

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 10, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 3 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 21 && j.somaJogadorDividiu == 0);			
		}
	}

	@Test
	public void testAA()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(11, 11, 0, 0);//SP
			Assert.assertTrue(j.saldoJogador <= 4 && j.saldoJogador >= -4); 
			Assert.assertTrue(j.somaJogador > 0 && j.somaJogadorDividiu > 0);					
		}
	}

	@Test
	public void testA2()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(11, 2, 5, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 2, 6, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 2, 4, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 2, 7, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 12 && j.somaJogadorDividiu == 0);	
			
		}
	}

	@Test
	public void testA3()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(11, 3, 5, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 3, 6, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 3, 4, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 3, 7, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 12 && j.somaJogadorDividiu == 0);	
			
		}
	}

	@Test
	public void testA4()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(11, 4, 4, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 4, 6, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 4, 3, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 4, 7, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 12 && j.somaJogadorDividiu == 0);	
			
		}
	}

	@Test
	public void testA5()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(11, 5, 4, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 5, 6, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 5, 3, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 5, 7, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 12 && j.somaJogadorDividiu == 0);	
			
		}
	}

	@Test
	public void testA6()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(11, 6, 3, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 6, 6, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 6, 2, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 6, 7, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 12 && j.somaJogadorDividiu == 0);	
			
		}
	}
	
	@Test
	public void testA7()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(11, 7, 3, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 7, 6, 0); //D
			Assert.assertTrue(j.saldoJogador == 4 || j.saldoJogador == 0 || j.saldoJogador == -4);
			Assert.assertTrue(j.somaJogador >= 12 && j.somaJogador <= 21);
			Assert.assertTrue(j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 7, 2, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 18 && j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 7, 7, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 18 && j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 7, 8, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 18 && j.somaJogadorDividiu == 0);

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 7, 9, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 12 && j.somaJogadorDividiu == 0);	

			j = new JogadaClean(false);	
			j.iniciaJogada(11, 7, 11, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador > 12 && j.somaJogadorDividiu == 0);	
			
		}
	}

	@Test
	public void testA8()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(11, 8, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 19 && j.somaJogadorDividiu == 0);
			
		}
	}
	
	@Test
	public void testA9()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(9, 11, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 20 && j.somaJogadorDividiu == 0);
			
		}
	}

	@Test
	public void testA10()
	{
		JogadaClean j;
		for(int i = 0; i < 100; i++)
		{
			j = new JogadaClean(false);	
			j.iniciaJogada(10, 11, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 3 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 21 && j.somaJogadorDividiu == 0);
			
			j = new JogadaClean(false);	
			j.iniciaJogada(11, 10, 0, 0); //S
			Assert.assertTrue(j.saldoJogador == 3 || j.saldoJogador == -2);
			Assert.assertTrue(j.somaJogador == 21 && j.somaJogadorDividiu == 0);
			
		}
	}
	
}
