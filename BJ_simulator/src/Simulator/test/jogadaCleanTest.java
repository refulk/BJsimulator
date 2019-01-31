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
			j = new JogadaClean();	
			carta = j.retornaCarta(0);
			Assert.assertTrue(carta >= 2 && carta <=11);

			j = new JogadaClean();	
			carta = j.retornaCarta(20);
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
			j = new JogadaClean();	
			soma = j.pegaCarta(0);
			Assert.assertTrue(soma >= 2 && soma <=11);
			
			j = new JogadaClean();	
			soma = j.pegaCarta(11);
			Assert.assertTrue(soma >= 12 && soma <=21);
		}
	}
	
	@Test
	public void testContaA()
	{
		int soma;
		JogadaClean j;
		
		j = new JogadaClean();	
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
			j = new JogadaClean();	
			soma = j.dobrar(0);
			assertThat(j.aposta, is(4));
			Assert.assertTrue(soma >= 2 && soma <=11);

			j = new JogadaClean();	
			soma = j.dobrar(20);
			assertThat(j.aposta, is(4));
			Assert.assertTrue(soma >= 21 && soma <=30);
		}
	}
	
	
	
	
	
	
}
