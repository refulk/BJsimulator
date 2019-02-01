// package Simulator;

import java.util.Random;

public class Baralho {
	
	int qtdTotal;
	Carta [] baralho;
	
	public Baralho()
	{
		this.qtdTotal = 416;
//		this.qtdTotal = 52;
		baralho = new Carta[qtdTotal];
	}
	
	/*
	public static void main(String[] args) {
		Baralho b2 = new Baralho();		
		b2.geraEmbaralhado();
//		b2.exibeBaralho();
	}
	*/
	
	public void geraEmbaralhado()
	{
		int i;
		int carta;
		Baralho b1 = new Baralho();		
		b1.iniciaBaralhoOrdenado();
		qtdTotal = 416;
		
		i = 0;
		while(i < qtdTotal)
		{
			carta = b1.retiraCarta(new Random().nextInt(b1.qtdTotal));			
			baralho[i] = new Carta();
			baralho[i].setValor(carta);
			i++;
		}		
	}
	
	public void iniciaBaralhoOrdenado() {		
		int [] faces = {11,2,3,4,5,6,7,8,9,10,10,10,10};
		int tamBaralho = faces.length;
		int qtdCarta = qtdTotal / faces.length;
		int [] qtd = new int[tamBaralho];
		int face;
		int i = 0;		
		
		for(i = 0; i < tamBaralho; i++)
		{
			qtd[i] = qtdCarta;
		}
		i = 0;
		
		while(i< qtdTotal)
		{
			face = i % 13;			
			if(qtd[face] > 0)
			{
				baralho[i] = new Carta();
				baralho[i].setValor(faces[face]);
				i++;
				qtd[face]--;
			}
		}
	}
	
	public int exibeBaralho()
	{
		int i = 0;
		while(i < qtdTotal)
		{
			System.out.println(i + " - " + baralho[i].getValor());
			i++;
		}
		return 1;
	}	
	
	public int retiraCarta(int carta)
	{
		int cartaRetorno = baralho[carta].getValor();
		qtdTotal--;
		for(int i = carta; i < qtdTotal; i++)
		{
			baralho[i].setValor(baralho[i+1].getValor());
		}
		return cartaRetorno;
	}
	
	public int contaCarta(int carta)
	{
		int cont = 0;
		for(int i = 0; i < qtdTotal; i++)
		{
			if(baralho[i].getValor() == carta)
			{
				cont++;
			}
		}
		return cont;
	}
	
	public int distribuiCarta()
	{
		if(this.qtdTotal > 0)
		{
			this.qtdTotal--;
			return baralho[this.qtdTotal].getValor();			
		}
		else
		{
			return 0;
		}
	}
	
	public int buscaRetiraCarta(int valorCarta)
	{
		int carta = qtdTotal - 1;
		while(carta >= 0 && valorCarta != baralho[carta].getValor())
		{
			carta--;
		}
		if(carta >= 0)
		{			
			return retiraCarta(carta);
		}
		else
		{
			return -1;			
		}
	}
	
}





