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
		
	@Test
	public void test22()
	{
		Jogada j;
		for(int i = 0; i < 100; i++)
		{
			j = new Jogada(false);	
			j.iniciaJogada2(2, 2, 2, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.soma1 > 4 && j.soma2 == 0);	
			
			j = new Jogada(false);	
			Assert.assertTrue(j.saldoJogador == 0); 
			j.iniciaJogada2(2, 2, 3, 0); //SP
			Assert.assertTrue(j.saldoJogador <= 4 && j.saldoJogador >= -4); 
			Assert.assertTrue(j.soma1 > 0 && j.soma2 > 0);	
			
			j = new Jogada(false);	
			j.iniciaJogada2(2, 2, 7, 0); //SP
			Assert.assertTrue(j.saldoJogador <= 4 && j.saldoJogador >= -4); 
			Assert.assertTrue(j.soma1 > 0 && j.soma2 > 0);		
			
			j = new Jogada(false);	
			j.iniciaJogada2(2, 2, 8, 0); //H
			Assert.assertTrue(j.saldoJogador == 2 || j.saldoJogador == 0 || j.saldoJogador == -2);
			Assert.assertTrue(j.soma1 > 4 && j.soma2 == 0);				
		}
	}

	
	
	
}
