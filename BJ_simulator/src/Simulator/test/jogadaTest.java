package Simulator.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

import Simulator.Carta;
import Simulator.Jogada;
import Simulator.JogadaClean;	

public class jogadaTest {

	@Test
	public void testPare()
	{
		int valor;
		Jogada j = new Jogada(false);	
		valor = j.iniciaJogadaTeste(10, 2, 5, 9);
		assertThat(valor, is(12));
		
		j = new Jogada(false);
		valor = j.iniciaJogadaTeste(10, 6, 5, 9);
		assertThat(valor, is(16));
		
		j = new Jogada(false);
		valor = j.iniciaJogadaTeste(10, 7, 5, 9);
		assertThat(valor, is(17));
		
		j = new Jogada(false);
		valor = j.iniciaJogadaTeste(11, 7, 2, 9);
		assertThat(valor, is(18));
		
		j = new Jogada(false);
		valor = j.iniciaJogadaTeste(8, 11, 2, 9);
		assertThat(valor, is(19));
		
		j = new Jogada(false);
		valor = j.iniciaJogadaTeste(10, 11, 2, 9);
		assertThat(valor, is(21));
		
		j = new Jogada(false);
		valor = j.iniciaJogadaTeste(9, 9, 7, 9);
		assertThat(valor, is(18));
		
		j = new Jogada(false);
		valor = j.iniciaJogadaTeste(10, 10, 5, 9);
		assertThat(j.getSoma1(), is(20));
		Assert.assertTrue(j.getSoma2() == 0);
	}
	
	@Test
	public void testDividir()
	{
		Jogada j = new Jogada(false);	
		j.iniciaJogadaTeste(11, 11, 5, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() > 0);

		j = new Jogada(false);	
		j.iniciaJogadaTeste(2, 2, 2, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() == 0);

		j = new Jogada(false);	
		j.iniciaJogadaTeste(2, 2, 8, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() == 0); //naoDivide
		
		j = new Jogada(false);	
		j.iniciaJogadaTeste(4, 4, 6, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() == 0);

		j = new Jogada(false);	
		j.iniciaJogadaTeste(4, 4, 2, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() == 0); //naoDivide

		j = new Jogada(false);	
		j.iniciaJogadaTeste(5, 5, 5, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() == 0); //naoDivide

		j = new Jogada(false);	
		j.iniciaJogadaTeste(6, 6, 5, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() > 0); 
		
		j = new Jogada(false);	
		j.iniciaJogadaTeste(7, 7, 4, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() > 0); 

		j = new Jogada(false);	
		j.iniciaJogadaTeste(7, 7, 8, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() == 0); //naoDivide
		
		j = new Jogada(false);	
		j.iniciaJogadaTeste(8, 8, 4, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() > 0); 

		j = new Jogada(false);	
		j.iniciaJogadaTeste(8, 8, 8, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() > 0); //
		
		j = new Jogada(false);	
		j.iniciaJogadaTeste(9, 9, 4, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() > 0); 

		j = new Jogada(false);	
		j.iniciaJogadaTeste(9, 9, 8, 9);
		Assert.assertTrue(j.getSoma1() > 0);
		Assert.assertTrue(j.getSoma2() > 0); //naoDivide		
	}
		

	public void sp(int saldo, int soma, int somaDiv, int limSoma)
	{
		Assert.assertTrue(saldo <= 8 && saldo >= -8); 
		Assert.assertTrue(soma > limSoma && somaDiv > limSoma);	
	}	
	
	public void h(int saldo, int soma, int somaDiv, int limSoma)
	{
		Assert.assertTrue(saldo == 2 || saldo == 0 || saldo == -2);
		Assert.assertTrue(soma > limSoma && somaDiv == 0);		
	}
	
	public void d(int saldo, int soma, int somaDiv, int limSoma)
	{
		Assert.assertTrue(saldo == 4 || saldo == 0 || saldo == -4 || saldo == -2);
		Assert.assertTrue(soma > limSoma && soma <= 21);
		Assert.assertTrue(somaDiv == 0);
	}

	public void s(int saldo, int soma, int somaDiv, int limSoma)
	{
		Assert.assertTrue(saldo == 2 || saldo == 0 || saldo == -2);
		Assert.assertTrue(soma == limSoma && somaDiv == 0);	
	}

	public void bj(int saldo, int soma, int somaDiv, int limSoma)
	{
		Assert.assertTrue(saldo == 3 || saldo == -2);
		Assert.assertTrue(soma == limSoma && somaDiv == 0);	
	}
	
	
	@Test
	public void test22()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(2, 2, 2, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

			j = new Jogada(false);	
			Assert.assertTrue(j.saldoJogador == 0); 
			j.iniciaJogada2(2, 2, 3, 0); //SP
			sp(j.saldoJogador, j.soma1, j.soma2, 10);

			j = new Jogada(false);	
			j.iniciaJogada2(2, 2, 7, 0); //SP
			sp(j.saldoJogador, j.soma1, j.soma2, 11);		
			
			j = new Jogada(false);	
			j.iniciaJogada2(2, 2, 8, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);					
		}
	}


	@Test
	public void test33()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(3, 3, 3, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);	
			
			j = new Jogada(false);	
			j.iniciaJogada2(3, 3, 4, 0); //SP
			sp(j.saldoJogador, j.soma1, j.soma2, 10);		
			
			j = new Jogada(false);	
			j.iniciaJogada2(3, 3, 7, 0); //SP
			sp(j.saldoJogador, j.soma1, j.soma2, 11);		
			
			j = new Jogada(false);	
			j.iniciaJogada2(3, 3, 8, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);				
		}
	}
	
	@Test
	public void test8()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(4, 4, 0, 0);
			h(j.saldoJogador, j.soma1, j.soma2, 11);	
			
			j = new Jogada(false);	
			j.iniciaJogada2(5, 3, 0, 0);
			h(j.saldoJogador, j.soma1, j.soma2, 11);	
		}
	}
	
	@Test
	public void test9()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(2, 7, 3, 0);
			d(j.saldoJogador, j.soma1, j.soma2, 10);	

			j = new Jogada(false);	
			j.iniciaJogada2(5, 4, 6, 0);
			d(j.saldoJogador, j.soma1, j.soma2, 10);	

			j = new Jogada(false);	
			j.iniciaJogada2(5, 4, 7, 0);
			h(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(5, 4, 2, 0);
			h(j.saldoJogador, j.soma1, j.soma2, 11);	
			
		}
	}
		
	@Test
	public void test10()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(5, 5, 9, 0);
			d(j.saldoJogador, j.soma1, j.soma2, 11);	
			
			j = new Jogada(false);	
			j.iniciaJogada2(6, 4, 2, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(3, 7, 10, 0);
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

		}
	}
	
	@Test
	public void test11()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(5, 6, 10, 0);
			d(j.saldoJogador, j.soma1, j.soma2, 10);	

			
			j = new Jogada(false);	
			j.iniciaJogada2(7, 4, 11, 0);	
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

		}
	}
	
	@Test
	public void test12()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(8, 4, 3, 0);
			h(j.saldoJogador, j.soma1, j.soma2, 12);
			
			j = new Jogada(false);	
			j.iniciaJogada2(2, 10, 4, 0);
			s(j.saldoJogador, j.soma1, j.soma2, 12);	
			
			j = new Jogada(false);	
			j.iniciaJogada2(2, 10, 6, 0);
			s(j.saldoJogador, j.soma1, j.soma2, 12);		

			j = new Jogada(false);	
			j.iniciaJogada2(8, 4, 7, 0);
			h(j.saldoJogador, j.soma1, j.soma2, 12);

			j = new Jogada(false);	
			j.iniciaJogada2(6, 6, 6, 0);
			sp(j.saldoJogador, j.soma1, j.soma2, 10);

			j = new Jogada(false);	
			j.iniciaJogada2(6, 6, 7, 0);
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

		}
	}
	
	@Test
	public void test13()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(10, 3, 6, 0);
			s(j.saldoJogador, j.soma1, j.soma2, 13);	

			j = new Jogada(false);	
			j.iniciaJogada2(6, 7, 7, 0);
			h(j.saldoJogador, j.soma1, j.soma2, 11);			
		
		}
	}
	
	@Test
	public void test14()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(10, 4, 6, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 14);	

			j = new Jogada(false);	
			j.iniciaJogada2(6, 8, 7, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

			j = new Jogada(false);	
			j.iniciaJogada2(7, 7, 7, 0); //SP
			sp(j.saldoJogador, j.soma1, j.soma2, 10);

			j = new Jogada(false);	
			j.iniciaJogada2(7, 7, 8, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			
		
		}
	}
	
	@Test
	public void test15()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(10, 5, 6, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 15);	

			j = new Jogada(false);	
			j.iniciaJogada2(6, 9, 7, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 15);			
			
		}
	}
	
	@Test
	public void test16()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(10, 6, 6, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 16);	

			j = new Jogada(false);	
			j.iniciaJogada2(7, 9, 7, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

			j = new Jogada(false);	
			j.iniciaJogada2(8, 8, 0, 0); //SP
			sp(j.saldoJogador, j.soma1, j.soma2, 11);

		}
	}
	
	@Test
	public void test17()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(10, 7, 0, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 17);	

			j = new Jogada(false);	
			j.iniciaJogada2(8, 9, 0, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 17);	
			
		}
	}
	
	@Test
	public void test18()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(10, 8, 0, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 18);	

			j = new Jogada(false);	
			j.iniciaJogada2(9, 9, 7, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 18);	

			j = new Jogada(false);	
			j.iniciaJogada2(9, 9, 10, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 18);	

			j = new Jogada(false);	
			j.iniciaJogada2(9, 9, 9, 0); //SP
			sp(j.saldoJogador, j.soma1, j.soma2, 11);
			
		}
	}
	
	@Test
	public void test19_21()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(10, 9, 0, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 19);	

			j = new Jogada(false);	
			j.iniciaJogada2(10, 10, 0, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 20);	

			j = new Jogada(false);	
			j.iniciaJogada2(10, 11, 0, 0); //BJ
			bj(j.saldoJogador, j.soma1, j.soma2, 21);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 10, 0, 0); //BJ	
			bj(j.saldoJogador, j.soma1, j.soma2, 21);	
			
		}
	}
	
	@Test
	public void testAA()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(11, 11, 0, 0);//SP
			sp(j.saldoJogador, j.soma1, j.soma2, 11);
				
		}
	}
	
	@Test
	public void testA2()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(11, 2, 5, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	


			j = new Jogada(false);	
			j.iniciaJogada2(11, 2, 6, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	


			j = new Jogada(false);	
			j.iniciaJogada2(11, 2, 4, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			


			j = new Jogada(false);	
			j.iniciaJogada2(11, 2, 7, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

			
		}
	}
	
	@Test
	public void testA3()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(11, 3, 5, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 3, 6, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 3, 4, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

			j = new Jogada(false);	
			j.iniciaJogada2(11, 3, 7, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

		}
	}
	
	@Test
	public void testA4()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(11, 4, 4, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 4, 6, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 4, 3, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

			j = new Jogada(false);	
			j.iniciaJogada2(11, 4, 7, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

		}
	}
	
	@Test
	public void testA5()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(11, 5, 4, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 5, 6, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 5, 3, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

			j = new Jogada(false);	
			j.iniciaJogada2(11, 5, 7, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

		}
	}
	
	@Test
	public void testA6()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(11, 6, 3, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 6, 6, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 6, 2, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

			j = new Jogada(false);	
			j.iniciaJogada2(11, 6, 7, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

		}
	}
	
	@Test
	public void testA7()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(11, 7, 3, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 7, 6, 0); //D
			d(j.saldoJogador, j.soma1, j.soma2, 11);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 7, 2, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 18);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 7, 7, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 18);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 7, 8, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 18);	

			j = new Jogada(false);	
			j.iniciaJogada2(11, 7, 9, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

			j = new Jogada(false);	
			j.iniciaJogada2(11, 7, 11, 0); //H
			h(j.saldoJogador, j.soma1, j.soma2, 11);			

		}
	}
	
	@Test
	public void testA8()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(11, 8, 0, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 19);	
			
		}
	}
	
	@Test
	public void testA9()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(9, 11, 0, 0); //S
			s(j.saldoJogador, j.soma1, j.soma2, 20);	

		}
	}

	@Test
	public void testA10()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(10, 11, 0, 0); //BJ
			bj(j.saldoJogador, j.soma1, j.soma2, 21);	
			
			j = new Jogada(false);	
			j.iniciaJogada2(11, 10, 0, 0); //BJ
			bj(j.saldoJogador, j.soma1, j.soma2, 21);	
			
		}
	}
	
	
}
