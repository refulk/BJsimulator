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

		m1.setValor(b.distribuiCarta()); //carta visivel
		j1.setValor(b.distribuiCarta());
		m2.setValor(b.distribuiCarta()); //carta escondida
		j2.setValor(b.distribuiCarta());
		
		realizaJogada();
		
	}
	
	private void realizaJogada()
	{
		int lj1, lj2, lm1;
		lj1 = j1.getValor();
		lj2 = j2.getValor();
		lm1 = m1.getValor();
		
		if(lj1 == lj2)//tem par
		{
			if(
			(lj1 == 1)//Par de Ás
			|| ((lj1 == 2 || lj1 == 3) && (lm1 >= 2 && lm1 <= 7)) //2 ou 3, mesa 2 a 7, #divida.
			|| ((lj1 == 4 || lj1 == 7 || lj1 == 8) && (lm1 >=4 && lm1 <=6)) //4, 7 ou 8, mesa de 4 a 6, #divida.
			|| ((lj1 == 9) && (lm1 >=2 && lm1 <=6)) //9, mesa de 2 a 6, #divida.			
			) //final do IF
			{
				//Dividir
				//jogadaDividir(lj1);
				//jogadaDividir(lj2);
			}
			else
			{
				
			}
		}
		else //não tem par
		{
			
		}
		
	}
	
	private void jogadaDividir(int carta)
	{
		//quando o jogador dividir
		j2.setValor(b.distribuiCarta());
		if(j1.getValor() == 1 || j2.getValor() == 1)
		{
			jogadaAs();
		}
		else
		{
			jogadaSoma();
		}
	}
	
	private void jogadaSoma() //SemPar
	{
		
	}
	
	private void jogadaAs() //tem 1 As
	{
		int lj2 = j2.getValor();
		
		if()
	}
	
}