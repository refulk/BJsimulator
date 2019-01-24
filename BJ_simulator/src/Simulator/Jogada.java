package Simulator;

public class Jogada {
		
	Baralho b = new Baralho();
	Carta j1 = new Carta();
	Carta j2 = new Carta();
	Carta m1 = new Carta();
	Carta m2 = new Carta();
	
	public static void main(String[] args) {		
		Jogada j = new Jogada();		
		j.iniciaJogada();
		System.out.println("j1 = " + j.j1.getValor());
		System.out.println("j2 = " + j.j2.getValor());
		System.out.println("m1 = " + j.m1.getValor());
		System.out.println("m2 = " + j.m2.getValor());		
	}
	
	public Jogada()
	{
		b.geraEmbaralhado();
	}

	public void iniciaJogada()
	{
		if(b.qtdTotal < 100)
		{
			b.geraEmbaralhado();			
		}
		m1.setValor(b.distribuiCarta());
		j1.setValor(b.distribuiCarta());
		j2.setValor(b.distribuiCarta());
		m2.setValor(b.distribuiCarta());
	}
}
