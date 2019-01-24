package Simulator;

import java.util.Random;


public class Baralho {
	
	int qtdTotal;
	Carta [] baralho;
	
	public Baralho()
	{
		this.qtdTotal = 416;
		baralho = new Carta[qtdTotal];
	}
	
	public static void main(String[] args) {
//		Baralho b1 = new Baralho();		
//		b1.iniciaBaralho();
//		b1.exibeBaralho();
//		System.out.println(b1.retiraCarta());
//		b1.exibeBaralho();
	}
	public void geraEmbaralhado()
	{
		int i;
		int carta;
//		int carta = new Random().nextInt(baralho.length);
		int [] controle = new int[qtdTotal];
		Baralho b1 = new Baralho();		
		b1.iniciaBaralho();
		
		for(i = 0; i < qtdTotal; i++)
		{
			controle[i] = 0;
		}
		
		i = 0;
		while(i < qtdTotal)
		{
			
		}
		
		
	}
	
	public void iniciaBaralho() {		
		int [] faces = {1,2,3,4,5,6,7,8,9,10,10,10,10};
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
//			face = new Random().nextInt(faces.length);
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
	
	public void exibeBaralho()
	{
		int i = 0;
		while(i < qtdTotal)
		{
			System.out.println(i + " - " + baralho[i].getValor());
			i++;
		}
	}	
	
	public int retiraCarta(int carta)
	{
//		int carta = new Random().nextInt(baralho.length);
		int cartaRetorno = baralho[carta].getValor();
		qtdTotal--;
		for(int i = carta; i < qtdTotal; i++)
		{
			baralho[i].setValor(baralho[i+1].getValor());
		}
//		System.out.println(carta);
		return cartaRetorno;
	}
}





