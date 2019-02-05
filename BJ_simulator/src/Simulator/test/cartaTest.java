package Simulator.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import Simulator.Carta;	

public class cartaTest {

	@BeforeClass
	public static void BeforeClass()
	{
		System.out.println("@BeforeClass");
	}
	
	@AfterClass
	public static void AfterClass()
	{
		System.out.println("@AfterClass");
	}
	
	@Before
	public void before()
	{
		System.out.println("@Before");
	}
	
	@After
	public void after()
	{
		System.out.println("@After");
	}
	
	@Test
	public void testCarta1()
	{
		Carta c1 = new Carta();		
		c1.setValor(5);		
		assertThat(c1.getValor(), is(5));
		System.out.println("TestCarta1");
	}
	
	@Test
	public void testCarta2()
	{
		Carta c1 = new Carta();		
		c1.setValor(5);		
		assertThat(c1.getValor(), is(5));
		System.out.println("TestCarta2");
	}
}
