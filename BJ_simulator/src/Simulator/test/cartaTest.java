package Simulator.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import Simulator.Carta;	

public class cartaTest {

	@Test
	public void testCarta()
	{
		Carta c1 = new Carta();		
		c1.setValor(5);		
		assertThat(c1.getValor(), is(5));
	}
}
