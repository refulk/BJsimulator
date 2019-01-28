
package Simulator;

public class Jogada {
		
	//mesa pega ate 17
	//empatou, ngm ganha, ngm perde. As apostas sao devolvidas
	
	Baralho b = new Baralho();
	Carta j1 = new Carta();
	Carta j2 = new Carta();
	Carta m1 = new Carta();
	Carta m2 = new Carta();
	int qtdA;
	int soma;
	int soma1;
	int soma2;
	int dobrou;
	int dobrou1;
	int dobrou2;
	int saldoJogador;
	int blackjack;
	int blackjack1;
	int blackjack2;
	static int qtdJogadas;
	
	final int apostar = 2;
	
	public static void main(String[] args) {	
		
		int qtdJ = 10000000;
		Jogada j;		
		
		j = new Jogada();
		j.setQtdJogadas(qtdJ);		
		for(int i = 0; i < qtdJogadas; i++)
		{
			j.iniciaJogada();
//			j.iniciaJogada2(2,2,0,0);
		}
		System.out.println(j.getQtdJogadas());
		System.out.println(j.getSaldoJogador());
		
		
		j = new Jogada();		
		j.setQtdJogadas(qtdJ);		
		for(int i = 0; i < qtdJogadas; i++)
		{
			j.iniciaJogada();
//			j.iniciaJogada2(2,2,0,0);
		}
		System.out.println("\n"+j.getQtdJogadas());
		System.out.println(j.getSaldoJogador());
		
//		j.iniciaJogadaTeste(9,9,7,5);
	}
	
	public Jogada()
	{
		b.geraEmbaralhado();
		qtdA = 0;
		soma = 0;
		soma1 = 0;
		soma2 = 0;
		dobrou = 0;
		saldoJogador = 0;
		blackjack = 0;
		blackjack1 = 0;
		blackjack2 = 0;
		dobrou1 = 0;
		dobrou2 = 0;
	}

	public void setQtdJogadas(int qtdJ)
	{
		qtdJogadas = qtdJ;
	}

	public int getQtdJogadas()
	{
		return qtdJogadas;
	}
	
	public int getSaldoJogador()
	{
		return saldoJogador;
	}

	public void iniciaJogada()
	{
		int saldoJogo;
		qtdA = 0;
		soma = 0;
		soma1 = 0;
		soma2 = 0;
		dobrou = 0;
		blackjack = 0;
		blackjack1 = 0;
		blackjack2 = 0;
		dobrou1 = 0;
		dobrou2 = 0;
		
		if(b.qtdTotal < 100)
		{
			b.geraEmbaralhado();			
		}

		m1.setValor(b.distribuiCarta()); //carta visivel
		j1.setValor(b.distribuiCarta());
		m2.setValor(b.distribuiCarta()); //carta escondida
		j2.setValor(b.distribuiCarta());

		//System.out.println("/////////////////////////////");
		//System.out.println("NOVO JOGO\nJOGADOR:");
//		System.out.println(j1.getValor() + " + " + j2.getValor() + " = " + (j1.getValor() + j2.getValor()));
		//System.out.println(j1.getValor() + " - " + j2.getValor());

		
		realizaJogada();
		saldoJogo = mesaJoga();
		saldoJogador += saldoJogo;
		
//		if(saldoJogo > 0)
//			System.out.println("\nGanhou: " + saldoJogo);
//		else if(saldoJogo < 0)
//			System.out.println("\nPerdeu: " + saldoJogo);
//		else
//			System.out.println("\nEmpatou: " + saldoJogo);
//		System.out.println("Saldo Jogador = " + saldoJogador + "\n");
		
	}

	public void iniciaJogada2(int jj1, int jj2, int mm1, int mm2)
	{
		int saldoJogo;
		qtdA = 0;
		soma = 0;
		soma1 = 0;
		soma2 = 0;
		dobrou = 0;
		blackjack = 0;
		blackjack1 = 0;
		blackjack2 = 0;
		dobrou1 = 0;
		dobrou2 = 0;
		
		if(b.qtdTotal < 100)
		{
			b.geraEmbaralhado();			
		}

		if(jj1 == 0)
		{
			j1.setValor(b.distribuiCarta());			
		}
		else
		{
//			b.buscaRetiraCarta(jj1);
			j1.setValor(jj1);
		}
		if(jj2 == 0)
		{
			j2.setValor(b.distribuiCarta());			
		}
		else
		{
//			b.buscaRetiraCarta(jj2);
			j2.setValor(jj2);
		}
		
		if(mm1 == 0)
		{
			m1.setValor(b.distribuiCarta());			
		}
		else
		{
//			b.buscaRetiraCarta(mm1);
			m1.setValor(mm1);
		}
		if(mm2 == 0)
		{
			m2.setValor(b.distribuiCarta());			
		}
		else
		{
//			b.buscaRetiraCarta(mm2);
			m2.setValor(mm2);
		}
				
		realizaJogada();
		saldoJogo = mesaJoga();
		saldoJogador += saldoJogo;	
	}
	
	public int mesaJoga()
	{
		//System.out.println("\nMESA:");
		
		int somaMesa, qtdAmesa, aposta;
		aposta = 0;
		qtdAmesa = 0;
		if(m1.getValor() == 11)
			qtdAmesa++;
		if(m2.getValor() == 11)
			qtdAmesa++;	
		somaMesa = m1.getValor() + m2.getValor();
		if(somaMesa > 21 && qtdAmesa > 0)
		{
			somaMesa -= 10;
			qtdAmesa--;
		}
		
//		System.out.println(m1.getValor() + " + " + m2.getValor() + " = " + somaMesa);
		//System.out.println(m1.getValor() + " - " + m2.getValor());
		
		int novaCarta;
		
		while(somaMesa < 17)
		{
			novaCarta = b.distribuiCarta();
			if(novaCarta == 11)
				qtdAmesa++;
			somaMesa = somaMesa + novaCarta;
			if(somaMesa > 21 && qtdAmesa > 0)
			{
				somaMesa -= 10;
				qtdAmesa--;
			}
			//System.out.println("(" + novaCarta + ") = " + somaMesa);
//			System.out.println("Soma = " + somaMesa);
		}
		
		//System.out.println("\nJ="+soma1+" M="+somaMesa);
		
		if(dobrou1 > 0 || dobrou2 > 0)
		{
			dobrou = dobrou1;
		}
		if(soma1 < 21)
		{
			if(somaMesa > 21)
			{
				aposta += (apostar + dobrou);
//				System.out.println("1");
			}
			else
			{
				if(somaMesa > soma1)
				{
					aposta -= (apostar + dobrou); //perdeu
//					System.out.println("2");
				}
				else if(somaMesa < soma1)
				{
					aposta += (apostar + dobrou);
//					System.out.println("3");
				}
				else
				{
					aposta += 0; //empate!
//					System.out.println("4");
				}					
			}
						
		}
		else if(soma1 == 21)
		{
			if(blackjack1 == 1)
			{
				//blackjack
				//System.out.println("BlackJack1");
				aposta += (2 + dobrou);
				aposta += (1); //ganha 50% a mais
//				System.out.println("5");
			}
			else
			{
				if(soma1 != somaMesa)
					aposta += (apostar + dobrou);
				else
					aposta += 0;
//				System.out.println("6");
			}			
		}
		else
		{
			aposta -= (apostar + dobrou); //perdeu
//			System.out.println("7");
		}
		
//		System.out.println("SaldoParcial: " + aposta);
		//Se dividir
		if(soma2 > 0)
		{
			if(dobrou2 > 0 || dobrou1 > 0)
			{
				dobrou = dobrou2;
			}
			//System.out.println("J="+soma2+" M="+somaMesa);
			if(soma2 < 21)
			{
				if(somaMesa > 21)
				{
					aposta += (apostar + dobrou);
//					System.out.println("8");
				}
				else
				{
					if(somaMesa > soma2)
					{
						aposta -= (apostar + dobrou); //perdeu
//						System.out.println("9");
					}
					else if(somaMesa < soma2)
					{
						aposta += (apostar + dobrou);
//						System.out.println("10");
					}
					else
					{
						aposta += 0; //empate!
//						System.out.println("11");
					}					
				}
							
			}
			else if(soma2 == 21)
			{
				if(blackjack2 == 1)
				{
					//blackjack
					//System.out.println("BlackJack2");
					aposta += (2 + dobrou);
					aposta += 1;
//					System.out.println("12");
				}
				else
				{
					if(soma2 != somaMesa)
						aposta += (apostar + dobrou);
					else
						aposta += 0;					
//					System.out.println("13");
				}			
			}
			else
			{
				aposta -= (apostar + dobrou); //perdeu
//				System.out.println("14");
			}
		}
		//System.out.println("Saldo da Jogada: " + saldoJogador);
		return aposta;
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
			(lj1 == 11)//Par de Ás
			|| ((lj1 == 2) && (lm1 >= 3 && lm1 <= 7)) //2, mesa 2 a 7, #divida.
			|| ((lj1 == 3) && (lm1 >= 4 && lm1 <= 7)) //3, mesa 2 a 7, #divida.
			/*|| ((lj1 == 4) && (lm1 >=4 && lm1 <=6))*/ //4, 7 ou 8, mesa de 4 a 6, #divida.
			|| ((lj1 == 6) && (lm1 >=2 && lm1 <=6)) //6, mesa de 2 a 6, #divida.
			|| ((lj1 == 7) && (lm1 >=2 && lm1 <=7)) //7, mesa de 4 a 7, #divida.
			|| (lj1 == 8) //8
			|| ((lj1 == 9) && ((lm1 >=2 && lm1 <=6) || (lm1 ==8 || lm1 ==9) )) //9, mesa de 2 a 6, #divida.			
			) //final do IF
			{
				//Dividir
				//System.out.println("Dividiu1:");
				if(j1.getValor() == 11)
					qtdA=1;
				else
					qtdA = 0;
				soma1 = jogadaDividir(lj1);
				blackjack1 = blackjack;
				dobrou1 = dobrou;
				dobrou = 0;

				//System.out.println("Dividiu2:");
				if(j1.getValor() == 11)
					qtdA=1;
				else
					qtdA = 0;
				soma2 = jogadaDividir(lj2);
				blackjack2 = blackjack;
				dobrou2 = dobrou;
				dobrou = 0;
			}
			else
			{
				if(lj1 == 9 || lj1 == 10)
				{
					soma1 = lj1 + lj1;
				}
				else
				{
					if(j1.getValor() == 11)
						qtdA++;
					if(j2.getValor() == 11)
						qtdA++;	
					soma1 = jogadaSoma();
				}
			}
		}
		else //não tem par
		{
			if(j1.getValor() == 11)
				qtdA++;
			if(j2.getValor() == 11)
				qtdA++;	
			if(qtdA > 0) //recebeu As
			{
//				System.out.println("tem As");
				soma1 = jogadaAs();
				blackjack1 = blackjack;
			}
			else
			{
				soma1 = jogadaSoma();
			}
		}
		
	}
	
	
	private int jogadaDividir(int carta)
	{
		int somaTemp;
		//quando o jogador dividir
		j2.setValor(b.distribuiCarta());
		//System.out.println("(" + j2.getValor() + ") = " + (j1.getValor() + j2.getValor()));
		if(j2.getValor() == 11)
			qtdA++;
		if(j1.getValor() == 11 || j2.getValor() == 11)
		{
			somaTemp = jogadaAs();
		}
		else
		{
			somaTemp = jogadaSoma();
		}
		return somaTemp;
	}
	
	
	private int pegaCarta()
	{
		int novaCarta, somaP;
		novaCarta = b.distribuiCarta();
		if(novaCarta == 11)
			qtdA++;
		somaP = soma + novaCarta;
		if(somaP > 21 && qtdA > 0)
		{
			somaP -= 10;
			qtdA--;
		}
		//System.out.println("(" + novaCarta + ") = " + somaP);
//		System.out.println("Soma = " + somaP);
		return somaP;
	}
	
	private int jogadaSoma() //SemPar
	{
		int lj2;
		
		if(j1.getValor() == 11)
			lj2 = j2.getValor();
		else
			lj2 = j1.getValor();
		
		int lm1;
		soma = j1.getValor() + j2.getValor();
		lm1 = m1.getValor();
		
		if(soma <= 8)
		{
			//peça
			soma = pegaCarta();
		}
		else if(soma == 9)
		{
			if(lm1 >= 3 && lm1 <=6)
			{
				//dobre
				//System.out.println("Dobrou!");
				dobrou = apostar;
				soma = pegaCarta();	
				return soma;
			}
			else
			{
				//peça
				soma = pegaCarta();		
			}
		}
		else if(soma == 10)
		{
			if(lm1 >= 2 && lm1 <=9)
			{
				//dobre
				//System.out.println("Dobrou!");
				dobrou = apostar;
				soma = pegaCarta();	
				return soma;
			}
			else
			{
				//peça
				soma = pegaCarta();		
			}
		}
		else if(soma == 11)
		{
			if(lm1 != 11)
			{
				//dobre
				//System.out.println("Dobrou!");
				dobrou = apostar;
				soma = pegaCarta();	
				return soma;
			}
			else
			{
				//peça
				soma = pegaCarta();		
			}
		}
		else if(soma == 12)
		{
			if(lm1 >= 4 && lm1 <=6)
			{
				return soma;
			}
			else
			{
				//peça
				soma = pegaCarta();		
			}	
		}
		else if(soma >= 13 && soma <= 16)
		{
			if(qtdA > 0)
			{
				if(
					((lj2 == 2 || lj2 == 3) && (lm1 == 5 || lm1 == 6))
					|| ((lj2 == 4 || lj2 == 5) && (lm1 >= 4 && lm1 <= 6))  
					)
				{
					//dobre
					//System.out.println("Dobrou!");
					dobrou = apostar;
					soma = pegaCarta();	
					return soma;
				}
				else
				{
					//peça
					soma = pegaCarta();						
				}
			}
			else
			{
				if(lm1 >= 2 && lm1 <=6)
				{
					return soma;
				}
				else
				{
					//peça
					soma = pegaCarta();		
				}	
			}
		}
		else 
		{
			if(soma == 17 && qtdA > 0)
			{
				//peça
				soma = pegaCarta();	
			}
			else
			{
				return soma;				
			}
		}
		if(soma < 17)
			return jogadaSoma2();
		else
			return soma;
	}

	private int jogadaSoma2() //SemPar
	{
		int lm1;
//		soma = j1.getValor() + j2.getValor(); //verificar se esta correto!
		lm1 = m1.getValor();

		int lj2;
		
		if(j1.getValor() == 11)
			lj2 = j2.getValor();
		else
			lj2 = j1.getValor();
		
		while(soma < 17)
		{
			if(soma <= 8)
			{
				//peça
				soma = pegaCarta();
			}
			else if(soma == 9)
			{
				//peça
				soma = pegaCarta();		
			}
			else if(soma == 10)
			{
				//peça
				soma = pegaCarta();		
			}
			else if(soma == 11)
			{
				//peça
				soma = pegaCarta();	
			}
			else if(soma == 12)
			{
				if(lm1 >= 4 && lm1 <=6)
				{
					return soma;
				}
				else
				{
					//peça
					soma = pegaCarta();		
				}	
			}
			else if(soma >= 13 && soma <= 16)
			{
				if(qtdA > 0)
				{
					//peça
					soma = pegaCarta();	
				}
				else
				{
					if(lm1 >= 2 && lm1 <=6)
					{
						return soma;
					}
					else
					{
						//peça
						soma = pegaCarta();		
					}	
				}
			}
			else 
			{
				if(soma == 17 && qtdA > 0)
				{
					//peça
					soma = pegaCarta();	
				}
				else
				{
					return soma;				
				}
			}
		}	
		return soma; //confirmar
	}
	
	private int jogadaAs() //tem 1 As
	{
		int lj2;
		int lm1 = m1.getValor();
		if(j1.getValor() == 11)
			lj2 = j2.getValor();
		else
			lj2 = j1.getValor();

		soma = j1.getValor() + j2.getValor();
		
		if(
		((lj2 == 2 || lj2 == 3) && (lm1 == 5 || lm1 == 6)) //Ás/2 ou Ás/3, mesa 5 ou 6, #dobre.
		|| ((lj2 == 4 || lj2 == 5) && (lm1 >= 4 && lm1 <= 6))  //Ás/4 ou Ás/5, mesa de 4 a 6, #dobre.
		|| ((lj2 == 6 || lj2 == 7) && (lm1 >= 3 && lm1 <= 6)) //Ás/6 ou Ás/7, mesa 3 a 6, #dobre.
		)
		{
			
			 //Codigo original			  
			//dobre
			//System.out.println("Dobrou!");
			dobrou = apostar;
			soma = pegaCarta();	
			return soma;
			  			
			/*
			//VER SE COMPENSA (imagino que nao)
			if(lj2 == 2 || lj2 == 3) //if(lj2 == 4 || lj2 == 5) 
			{
				soma = pegaCarta();	
				return jogadaSoma();
			}
			else
			{
				//dobre
				//System.out.println("Dobrou!");
				dobrou = apostar;
				soma = pegaCarta();	
				return soma;
			}
			*/
			
		}
		else
		{
			if(
			/*((lj2 == 6) && (lm1 == 7))
			||*/ ((lj2 == 7) && (lm1 == 2 || lm1 == 7 || lm1 == 8))
			|| (lj2 == 8 || lj2 == 9)
			)
			{
				return soma;
			}
			else if(lj2 == 10) //BlackJack
			{
				blackjack = 1;
//				System.out.println("BJ-linha481");
				return soma;
			}
			else
			{
				//peça
//				System.out.println("PONTO!");
				return jogadaSoma();
			}
		}
	}
		

	//metodos utilizados para realizar testes
	public int iniciaJogadaTeste(int jj1, int jj2, int mm1, int mm2)
	{

		int saldoJogo;
		qtdA = 0;
		soma = 0;
		soma1 = 0;
		soma2 = 0;
		dobrou = 0;
		blackjack = 0;
		blackjack1 = 0;
		blackjack2 = 0;
		
		if(b.qtdTotal < 100)
		{
			b.geraEmbaralhado();			
		}

		m1.setValor(mm1); //carta visivel
		j1.setValor(jj1);
		m2.setValor(mm2); //carta escondida
		j2.setValor(jj2);

		//System.out.println("/////////////////////////////");
		//System.out.println("NOVO JOGO\nJOGADOR:");
//		System.out.println(j1.getValor() + " + " + j2.getValor() + " = " + (j1.getValor() + j2.getValor()));
		//System.out.println(j1.getValor() + " - " + j2.getValor());
		realizaJogada();
		saldoJogo = mesaJoga();
		saldoJogador += saldoJogo;
		
//		if(saldoJogo > 0)
//			System.out.println("\nGanhou: " + saldoJogo);
//		else if(saldoJogo < 0)
//			System.out.println("\nPerdeu: " + saldoJogo);
//		else
//			System.out.println("\nEmpatou: " + saldoJogo);
//		System.out.println("Saldo Jogador = " + saldoJogador + "\n");
		return soma1;		
	}
	
	public int getSoma1()
	{
		return soma1;
	}
	
	public int getSoma2()
	{
		return soma2;
	}
}




/*
//BACKUP VERSAO EXIBE TODAS JOGADAS

package Simulator;

public class Jogada {
		
	//mesa pega ate 17
	//empatou, ngm ganha, ngm perde. As apostas sao devolvidas
	
	Baralho b = new Baralho();
	Carta j1 = new Carta();
	Carta j2 = new Carta();
	Carta m1 = new Carta();
	Carta m2 = new Carta();
	int qtdA;
	int soma;
	int soma1;
	int soma2;
	int dobrou;
	int dobrou1;
	int dobrou2;
	int saldoJogador;
	int blackjack;
	int blackjack1;
	int blackjack2;
	
	final int apostar = 2;
	
	public static void main(String[] args) {		
		Jogada j = new Jogada();
		
		for(int i = 0; i < 10; i++)
			j.iniciaJogada2(5,3,0,0);
//		j.iniciaJogadaTeste(9,9,7,5);
	}
	
	public Jogada()
	{
		b.geraEmbaralhado();
		qtdA = 0;
		soma = 0;
		soma1 = 0;
		soma2 = 0;
		dobrou = 0;
		saldoJogador = 0;
		blackjack = 0;
		blackjack1 = 0;
		blackjack2 = 0;
		dobrou1 = 0;
		dobrou2 = 0;
	}

	public void iniciaJogada()
	{
		int saldoJogo;
		qtdA = 0;
		soma = 0;
		soma1 = 0;
		soma2 = 0;
		dobrou = 0;
		blackjack = 0;
		blackjack1 = 0;
		blackjack2 = 0;
		dobrou1 = 0;
		dobrou2 = 0;
		
		if(b.qtdTotal < 100)
		{
			b.geraEmbaralhado();			
		}

		m1.setValor(b.distribuiCarta()); //carta visivel
		j1.setValor(b.distribuiCarta());
		m2.setValor(b.distribuiCarta()); //carta escondida
		j2.setValor(b.distribuiCarta());

		System.out.println("/////////////////////////////");
		System.out.println("NOVO JOGO\nJOGADOR:");
//		System.out.println(j1.getValor() + " + " + j2.getValor() + " = " + (j1.getValor() + j2.getValor()));
		System.out.println(j1.getValor() + " - " + j2.getValor());

		
		realizaJogada();
		saldoJogo = mesaJoga();
		saldoJogador += saldoJogo;
		
		if(saldoJogo > 0)
			System.out.println("\nGanhou: " + saldoJogo);
		else if(saldoJogo < 0)
			System.out.println("\nPerdeu: " + saldoJogo);
		else
			System.out.println("\nEmpatou: " + saldoJogo);
		System.out.println("Saldo Jogador = " + saldoJogador + "\n");
		
	}
	
	public void iniciaJogada2(int jj1, int jj2, int mm1, int mm2)
	{
		int saldoJogo;
		qtdA = 0;
		soma = 0;
		soma1 = 0;
		soma2 = 0;
		dobrou = 0;
		blackjack = 0;
		blackjack1 = 0;
		blackjack2 = 0;
		dobrou1 = 0;
		dobrou2 = 0;
		
		if(b.qtdTotal < 100)
		{
			b.geraEmbaralhado();			
		}

		if(jj1 == 0)
		{
			j1.setValor(b.distribuiCarta());			
		}
		else
		{
			b.buscaRetiraCarta(jj1);
			j1.setValor(jj1);
		}
		if(jj2 == 0)
		{
			j2.setValor(b.distribuiCarta());			
		}
		else
		{
			b.buscaRetiraCarta(jj2);
			j2.setValor(jj2);
		}
		
		if(mm1 == 0)
		{
			m1.setValor(b.distribuiCarta());			
		}
		else
		{
			b.buscaRetiraCarta(mm1);
			m1.setValor(mm1);
		}
		if(mm2 == 0)
		{
			m2.setValor(b.distribuiCarta());			
		}
		else
		{
			b.buscaRetiraCarta(mm2);
			m2.setValor(mm2);
		}
				
		System.out.println("/////////////////////////////");
		System.out.println("NOVO JOGO\nJOGADOR:");
//		System.out.println(j1.getValor() + " + " + j2.getValor() + " = " + (j1.getValor() + j2.getValor()));
		System.out.println(j1.getValor() + " - " + j2.getValor());

		realizaJogada();
		saldoJogo = mesaJoga();
		saldoJogador += saldoJogo;	
		
		
		if(saldoJogo > 0)
			System.out.println("\nGanhou: " + saldoJogo);
		else if(saldoJogo < 0)
			System.out.println("\nPerdeu: " + saldoJogo);
		else
			System.out.println("\nEmpatou: " + saldoJogo);
		System.out.println("Saldo Jogador = " + saldoJogador + "\n");
		
		
	}
		
	public int mesaJoga()
	{
		System.out.println("\nMESA:");
		
		int somaMesa, qtdAmesa, aposta;
		aposta = 0;
		qtdAmesa = 0;
		if(m1.getValor() == 11)
			qtdAmesa++;
		if(m2.getValor() == 11)
			qtdAmesa++;	
		somaMesa = m1.getValor() + m2.getValor();
		if(somaMesa > 21 && qtdAmesa > 0)
		{
			somaMesa -= 10;
			qtdAmesa--;
		}
		
//		System.out.println(m1.getValor() + " + " + m2.getValor() + " = " + somaMesa);
		System.out.println(m1.getValor() + " - " + m2.getValor());
		
		int novaCarta;
		
		while(somaMesa < 17)
		{
			novaCarta = b.distribuiCarta();
			if(novaCarta == 11)
				qtdAmesa++;
			somaMesa = somaMesa + novaCarta;
			if(somaMesa > 21 && qtdAmesa > 0)
			{
				somaMesa -= 10;
				qtdAmesa--;
			}
			System.out.println("(" + novaCarta + ") = " + somaMesa);
//			System.out.println("Soma = " + somaMesa);
		}
		
		System.out.println("\nJ="+soma1+" M="+somaMesa);
		
		if(dobrou1 > 0 || dobrou2 > 0)
		{
			dobrou = dobrou1;
		}
		if(soma1 < 21)
		{
			if(somaMesa > 21)
			{
				aposta += (apostar + dobrou);
//				System.out.println("1");
			}
			else
			{
				if(somaMesa > soma1)
				{
					aposta -= (apostar + dobrou); //perdeu
//					System.out.println("2");
				}
				else if(somaMesa < soma1)
				{
					aposta += (apostar + dobrou);
//					System.out.println("3");
				}
				else
				{
					aposta += 0; //empate!
//					System.out.println("4");
				}					
			}
						
		}
		else if(soma1 == 21)
		{
			if(blackjack1 == 1)
			{
				//blackjack
				System.out.println("BlackJack1");
				aposta += (2 + dobrou);
				aposta += (1); //ganha 50% a mais
//				System.out.println("5");
			}
			else
			{
				if(soma1 != somaMesa)
					aposta += (apostar + dobrou);
				else
					aposta += 0;
//				System.out.println("6");
			}			
		}
		else
		{
			aposta -= (apostar + dobrou); //perdeu
//			System.out.println("7");
		}
		
//		System.out.println("SaldoParcial: " + aposta);
		//Se dividir
		if(soma2 > 0)
		{
			if(dobrou2 > 0 || dobrou1 > 0)
			{
				dobrou = dobrou2;
			}
			System.out.println("J="+soma2+" M="+somaMesa);
			if(soma2 < 21)
			{
				if(somaMesa > 21)
				{
					aposta += (apostar + dobrou);
//					System.out.println("8");
				}
				else
				{
					if(somaMesa > soma2)
					{
						aposta -= (apostar + dobrou); //perdeu
//						System.out.println("9");
					}
					else if(somaMesa < soma2)
					{
						aposta += (apostar + dobrou);
//						System.out.println("10");
					}
					else
					{
						aposta += 0; //empate!
//						System.out.println("11");
					}					
				}
							
			}
			else if(soma2 == 21)
			{
				if(blackjack2 == 1)
				{
					//blackjack
					System.out.println("BlackJack2");
					aposta += (2 + dobrou);
					aposta += 1;
//					System.out.println("12");
				}
				else
				{
					if(soma2 != somaMesa)
						aposta += (apostar + dobrou);
					else
						aposta += 0;					
//					System.out.println("13");
				}			
			}
			else
			{
				aposta -= (apostar + dobrou); //perdeu
//				System.out.println("14");
			}
		}
//		System.out.println("Saldo da Jogada: " + saldoJogador);
		return aposta;
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
			(lj1 == 11)//Par de Ás
			|| ((lj1 == 2 || lj1 == 3) && (lm1 >= 2 && lm1 <= 7)) //2 ou 3, mesa 2 a 7, #divida.
			|| ((lj1 == 4) && (lm1 >=4 && lm1 <=6)) //4, 7 ou 8, mesa de 4 a 6, #divida.
			|| ((lj1 == 7 || lj1 == 8) && (lm1 >=4 && lm1 <=7)) //7 ou 8, mesa de 4 a 7, #divida.
			|| ((lj1 == 9) && (lm1 >=2 && lm1 <=6)) //9, mesa de 2 a 6, #divida.			
			) //final do IF
			{
				//Dividir
				System.out.println("Dividiu1:");
				if(j1.getValor() == 11)
					qtdA=1;
				else
					qtdA = 0;
				soma1 = jogadaDividir(lj1);
				blackjack1 = blackjack;
				dobrou1 = dobrou;
				dobrou = 0;

				System.out.println("Dividiu2:");
				if(j1.getValor() == 11)
					qtdA=1;
				else
					qtdA = 0;
				soma2 = jogadaDividir(lj2);
				blackjack2 = blackjack;
				dobrou2 = dobrou;
				dobrou = 0;
			}
			else
			{
				if(lj1 == 9 || lj1 == 10)
				{
					soma1 = lj1 + lj1;
				}
				else
				{
					if(j1.getValor() == 11)
						qtdA++;
					if(j2.getValor() == 11)
						qtdA++;	
					soma1 = jogadaSoma();
				}
			}
		}
		else //não tem par
		{
			if(j1.getValor() == 11)
				qtdA++;
			if(j2.getValor() == 11)
				qtdA++;	
			if(qtdA > 0) //recebeu As
			{
//				System.out.println("tem As");
				soma1 = jogadaAs();
				blackjack1 = blackjack;
			}
			else
			{
				soma1 = jogadaSoma();
			}
		}
		
	}
	
	
	private int jogadaDividir(int carta)
	{
		int somaTemp;
		//quando o jogador dividir
		j2.setValor(b.distribuiCarta());
		System.out.println("(" + j2.getValor() + ") = " + (j1.getValor() + j2.getValor()));
		if(j2.getValor() == 11)
			qtdA++;
		if(j1.getValor() == 11 || j2.getValor() == 11)
		{
			somaTemp = jogadaAs();
		}
		else
		{
			somaTemp = jogadaSoma();
		}
		return somaTemp;
	}
	
	
	private int pegaCarta()
	{
		int novaCarta, somaP;
		novaCarta = b.distribuiCarta();
		if(novaCarta == 11)
			qtdA++;
		somaP = soma + novaCarta;
		if(somaP > 21 && qtdA > 0)
		{
			somaP -= 10;
			qtdA--;
		}
		System.out.println("(" + novaCarta + ") = " + somaP);
//		System.out.println("Soma = " + somaP);
		return somaP;
	}
	
	private int jogadaSoma() //SemPar
	{
		int lm1;
		soma = j1.getValor() + j2.getValor();
		lm1 = m1.getValor();
		
		if(soma <= 8)
		{
			//peça
			soma = pegaCarta();
		}
		else if(soma == 9)
		{
			if(lm1 >= 3 && lm1 <=6)
			{
				//dobre
				System.out.println("Dobrou!");
				dobrou = apostar;
				soma = pegaCarta();	
				return soma;
			}
			else
			{
				//peça
				soma = pegaCarta();		
			}
		}
		else if(soma == 10)
		{
			if(lm1 >= 2 && lm1 <=9)
			{
				//dobre
				System.out.println("Dobrou!");
				dobrou = apostar;
				soma = pegaCarta();	
				return soma;
			}
			else
			{
				//peça
				soma = pegaCarta();		
			}
		}
		else if(soma == 11)
		{
			if(lm1 != 11)
			{
				//dobre
				System.out.println("Dobrou!");
				dobrou = apostar;
				soma = pegaCarta();	
				return soma;
			}
			else
			{
				//peça
				soma = pegaCarta();		
			}
		}
		else if(soma >= 12 && soma <= 16)
		{
			if(lm1 >= 4 && lm1 <=6)
			{
				return soma;
			}
			else
			{
				//peça
				soma = pegaCarta();		
			}	
		}
		else 
		{
			if(soma == 17 && qtdA > 0)
			{
				//peça
				soma = pegaCarta();	
			}
			else
			{
				return soma;				
			}
		}
		if(soma < 17)
			return jogadaSoma2();
		else
			return soma;
	}

	private int jogadaSoma2() //SemPar
	{
		int lm1;
//		soma = j1.getValor() + j2.getValor(); //verificar se esta correto!
		lm1 = m1.getValor();
		
		while(soma < 17)
		{
			if(soma <= 8)
			{
				//peça
				soma = pegaCarta();
			}
			else if(soma == 9)
			{
				//peça
				soma = pegaCarta();		
			}
			else if(soma == 10)
			{
				//peça
				soma = pegaCarta();		
			}
			else if(soma == 11)
			{
				//peça
				soma = pegaCarta();		
			}
			else if(soma >= 12 && soma <= 16)
			{
				if(lm1 >= 4 && lm1 <=6)
				{
					return soma;
				}
				else
				{
					//peça
					soma = pegaCarta();		
				}	
			}
			else 
			{
				return soma;
			}
		}	
		return soma; //confirmar
	}
	
	private int jogadaAs() //tem 1 As
	{
		int lj2;
		int lm1 = m1.getValor();
		if(j1.getValor() == 11)
			lj2 = j2.getValor();
		else
			lj2 = j1.getValor();

		soma = j1.getValor() + j2.getValor();
		
		if(
		((lj2 == 2 || lj2 == 3) && (lm1 == 5 || lm1 == 6)) //Ás/2 ou Ás/3, mesa 5 ou 6, #dobre.
		|| ((lj2 == 4 || lj2 == 5) && (lm1 >= 4 && lm1 <= 6))  //Ás/4 ou Ás/5, mesa de 4 a 6, #dobre.
		|| ((lj2 == 6 || lj2 == 7) && (lm1 >= 3 && lm1 <= 6)) //Ás/6 ou Ás/7, mesa 3 a 6, #dobre.
		)
		{
			//dobre
			System.out.println("Dobrou!");
			dobrou = apostar;
			soma = pegaCarta();	
			return soma;
		}
		else
		{
			if(
			(lj2 == 7) && (lm1 == 2 || lm1 == 7 || lm1 == 8)
			|| (lj2 == 8 || lj2 == 9)
			)
			{
				return soma;
			}
			else if(lj2 == 10) //BlackJack
			{
				blackjack = 1;
//				System.out.println("BJ-linha481");
				return soma;
			}
			else
			{
				//peça
//				System.out.println("PONTO!");
				return jogadaSoma();
			}
		}
	}
		

	//metodos utilizados para realizar testes
	public int iniciaJogadaTeste(int jj1, int jj2, int mm1, int mm2)
	{

		int saldoJogo;
		qtdA = 0;
		soma = 0;
		soma1 = 0;
		soma2 = 0;
		dobrou = 0;
		blackjack = 0;
		blackjack1 = 0;
		blackjack2 = 0;
		
		if(b.qtdTotal < 100)
		{
			b.geraEmbaralhado();			
		}

		m1.setValor(mm1); //carta visivel
		j1.setValor(jj1);
		m2.setValor(mm2); //carta escondida
		j2.setValor(jj2);

		System.out.println("/////////////////////////////");
		System.out.println("NOVO JOGO\nJOGADOR:");
//		System.out.println(j1.getValor() + " + " + j2.getValor() + " = " + (j1.getValor() + j2.getValor()));
		System.out.println(j1.getValor() + " - " + j2.getValor());
		realizaJogada();
		saldoJogo = mesaJoga();
		saldoJogador += saldoJogo;
		
		if(saldoJogo > 0)
			System.out.println("\nGanhou: " + saldoJogo);
		else if(saldoJogo < 0)
			System.out.println("\nPerdeu: " + saldoJogo);
		else
			System.out.println("\nEmpatou: " + saldoJogo);
		System.out.println("Saldo Jogador = " + saldoJogador + "\n");
		return soma1;		
	}
	
	public int getSoma1()
	{
		return soma1;
	}
	
	public int getSoma2()
	{
		return soma2;
	}
}
*/
