package Simulator;

public class Jogada {
		
	public static void main(String[] args) {
		
		Baralho b = new Baralho();
		Carta j1 = new Carta();
		Carta j2 = new Carta();
		Carta m1 = new Carta();
		Carta m2 = new Carta();
		
		
		b.iniciaBaralhoOrdenado();
		System.out.println("Ordenado: ");
		System.out.println("	1 = " + b.contaCarta(1));
		System.out.println("	5 = " + b.contaCarta(5));
		System.out.println("	10 = " + b.contaCarta(10));

		b.geraEmbaralhado();
		System.out.println("\nEmbaralhado: ");
		System.out.println("	1 = " + b.contaCarta(1));
		System.out.println("	5 = " + b.contaCarta(5));
		System.out.println("	10 = " + b.contaCarta(10));
		
		System.out.println(b.distribuiCarta());

//		j1.setValor(b.retiraCarta(cartaAtual, cartaAtual));
		
		
		
	}

}
