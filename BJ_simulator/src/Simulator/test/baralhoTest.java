package Simulator.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

import Simulator.Baralho;

public class baralhoTest {
	@Test
	public void testIniciaBaralho() {
		Baralho b1 = new Baralho();
		b1.iniciaBaralhoOrdenado();
		assertThat(b1.exibeBaralho(), is(1));
	}
	
	@Test
	public void testRetiraCarta() {
		Baralho b1 = new Baralho();
		b1.iniciaBaralhoOrdenado();
		assertThat(b1.retiraCarta(415), is(10));
	}

	@Test
	public void testEmbaralhado() {
		Baralho b1 = new Baralho();
		b1.geraEmbaralhado();
		assertThat(b1.exibeBaralho(), is(1));
	}

	@Test
	public void testContaCarta() {
		Baralho b1 = new Baralho();
		b1.iniciaBaralhoOrdenado();
		assertThat(b1.contaCarta(1), is(32));
		assertThat(b1.contaCarta(10), is(128));		
	}

	@Test
	public void testContaEmbaralhado() {
		Baralho b1 = new Baralho();
		b1.geraEmbaralhado();
		assertThat(b1.contaCarta(1), is(32));
		assertThat(b1.contaCarta(10), is(128));		
	}

	@Test
	public void testDistribuiCarta() {
		Baralho b1 = new Baralho();
		b1.geraEmbaralhado();
		int carta = b1.distribuiCarta();
		Assert.assertTrue(carta > 0 && carta < 14); 
	}

	@Test
	public void testDistribuiCarta2() {
		Baralho b1 = new Baralho();
		b1.geraEmbaralhado();
		
		for(int i = 0; i < 416; i++)
		{
			b1.distribuiCarta();
		}
		int carta = b1.distribuiCarta();
		Assert.assertTrue(carta == 0); 
	}
	
}
