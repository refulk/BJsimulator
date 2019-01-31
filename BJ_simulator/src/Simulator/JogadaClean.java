// package Simulator;

public class JogadaClean {	
	
	Baralho b = new Baralho();
	Carta j1 = new Carta();
	Carta j2 = new Carta();
	Carta m1 = new Carta();
	Carta m2 = new Carta();
	public int saldoJogador;
	int qtdA;
	public int somaJogador;
	public int aposta;
	int blackjack;
	int qtdADividiu;
	public int somaJogadorDividiu;
	int apostaDividiu;
	int blackjackDividiu;
	public int qtdWin;
	public int qtdLoss;
	
	boolean exibir;

	public JogadaClean()
	{
		exibir = true;
		inicia();
	}
	
	public JogadaClean(boolean e)
	{
		exibir = e;
		inicia();
	}
	
	private void inicia()
	{
		b.geraEmbaralhado();
		saldoJogador = 0;
		qtdWin = 0;
		qtdLoss = 0;
		zerarVariaveis();		
	}
	
	private void zerarVariaveis()
	{
		qtdA = 0;
		somaJogador = 0;
		aposta = 2;
		blackjack = 0;
		qtdADividiu = 0;
		somaJogadorDividiu = 0;
		apostaDividiu = 2;
		blackjackDividiu = 0;
	}
	
	public void iniciaJogada(int jj1, int jj2, int mm1, int mm2)
	{
		if(exibir)
			System.out.println("\nNOVO JOGO");
		zerarVariaveis();
		if(b.qtdTotal < 100) //Se tiver menos de 100 cartas, embaralha novamente
		{
			b.geraEmbaralhado();			
		}

		if(jj1 == 0)
		{
			j1.setValor(b.distribuiCarta());
		}
		else
		{
			j1.setValor(jj1);
		}
		if(jj2 == 0)
		{
			j2.setValor(b.distribuiCarta());			
		}
		else
		{
			j2.setValor(jj2);
		}
		
		if(mm1 == 0)
		{
			m1.setValor(b.distribuiCarta());			
		}
		else
		{
			m1.setValor(mm1);
		}
		if(mm2 == 0)
		{
			m2.setValor(b.distribuiCarta());			
		}
		else
		{
			m2.setValor(mm2);
		}

		if(exibir)
			System.out.println("Jogador: " + j1.getValor() + " " + j2.getValor());
		
		realizaJogada();
		mesajoga();
	}
	
	//Ok
	private void realizaJogada()
	{
		int lj1, lj2;
		lj1 = j1.getValor();
		lj2 = j2.getValor();
				
		if(lj1 == lj2)
		{
			jogadaPar();
		}
		else
		{
			qtdA = contaA(lj1, lj2);
			somaJogador = jogada1();
		}
		if(exibir)
		{
			System.out.println("somaJogador = " + somaJogador);
			System.out.println("somaJogadorDividiu = " + somaJogadorDividiu);
		}
	}
	
	//Ok
	public int contaA(int c1, int c2)
	{
		int cont = 0;
		if(c1 == 11)
			cont++;
		if(c2 == 11)
			cont++;
		return cont;
	}
	
	//Ok
	public int pegaCarta(int soma)
	{
		int novaCarta, somaP;
		novaCarta = retornaCarta(soma, false);
		if(novaCarta == 11)
			qtdA++;
		somaP = soma + novaCarta;
		if(somaP > 21 && qtdA > 0)
		{
			somaP -= 10;
			qtdA--;
		}			
		if(exibir)
			System.out.println("("+novaCarta+") = "+somaP);	
		return somaP;
	}
	
	//Ok
	public int retornaCarta(int soma, boolean ex)
	{
		int novaCarta, somaP;
		novaCarta = b.distribuiCarta();
		somaP = soma + novaCarta;
		if(novaCarta == 11)
		{
			if(somaP > 21)
			{
				novaCarta = 1;
				somaP -= 10;
			}
			else
			{
				qtdA++;
			}
		}
		if(ex)
			System.out.println("("+novaCarta+") = "+somaP);
		return novaCarta;		
	}
	
	//Ok
	public int dobrar(int soma)
	{
		aposta = aposta * 2;
		if(exibir)
			System.out.println("AP = " + aposta);
		return pegaCarta(soma);
	}
	
	//Feito
	private void jogadaPar()
	{
		int lj1, lm1;
		lj1 = j1.getValor();
		lm1 = m1.getValor();
//		somaJogador = lj1 + lj1;
		
		switch(lj1)
		{
			case 2:			
				if(lm1>=3 && lm1<=7)
				{
					jogadaDividir();
				}
				else
				{
					somaJogador = jogada1();
				}
				break;
			case 3:				
				if(lm1>=4 && lm1<=7)
				{
					jogadaDividir();
				}
				else
				{
					somaJogador = jogada1();
				}		
				break;
			case 4:	
				somaJogador = jogada1();	
				break;
			case 5:			
				somaJogador = jogada1();				
				break;
			case 6:				
				if(lm1>=2 && lm1<=6)
				{
					jogadaDividir();
				}
				else
				{
					somaJogador = jogada1();
				}				
				break;
			case 7:				
				if(lm1>=2 && lm1<=7)
				{
					jogadaDividir();
				}
				else
				{
					somaJogador = jogada1();
				}				
				break;
			case 8:			
				jogadaDividir();	//verificar se compensa dividir em todas	
				break;
			case 9:					
				if((lm1>=2 && lm1<=6) || (lm1>=8 && lm1<=9))
				{
					jogadaDividir();
				}
				else
				{
					somaJogador = jogada1();
				}	
				break;
			case 10:
				somaJogador = lj1 + lj1;
				break;
			case 11:	
				jogadaDividir();			
				break;
		}
	}
	
	//Feito
	private void jogadaDividir()  //verificar se esta correto!
	{
		int lj1, lj2;
		lj1 = j1.getValor();
		
		if(exibir)
			System.out.println("Dividiu1");
		
		lj2 = retornaCarta(lj1, exibir); //pega segunda carta dividiu		
		j2.setValor(lj2); //atualiza valor da segunda carta dividiu
		qtdA = contaA(lj1, lj2);
		somaJogadorDividiu = jogada1();
		
		qtdADividiu = qtdA;
		apostaDividiu = aposta;
		blackjackDividiu = blackjack;
		qtdA = 0;
		aposta = 2;
		blackjack = 0;

		if(exibir)
			System.out.println("Dividiu2");
		
		lj2 = retornaCarta(lj1, exibir); //pega segunda carta
		j2.setValor(lj2); //atualiza valor da segunda carta
		qtdA = contaA(lj1, lj2);
		somaJogador = jogada1();
	}
	
	//Feito
	private int jogada1()
	{
		int soma;
		if(qtdA > 0)
		{
			soma = jogadaAs();
		}
		else
		{
			soma = jogadaComum1();
		}		
		return soma;
	}

	//Feito
	private int jogadaAs()
	{
		int soma;
		int lj1, lj2, lm1;
		int carta;
		lj1 = j1.getValor();
		lj2 = j2.getValor();
		lm1 = m1.getValor();
		soma = lj1 + lj2;
		
		if(lj1 == 11)
			carta = lj2;
		else
			carta = lj1;
		
		switch(carta)
		{
			case 1:
				soma = jogadaComum(soma);
				break;
			case 2:		
				if(lm1 >= 5 && lm1 <= 6)
				{
					soma = dobrar(soma);
				}
				else
				{
					soma = jogadaComum(soma);
				}
				break;
			case 3:		
				if(lm1 >= 5 && lm1 <= 6)
				{
					soma = dobrar(soma);
				}
				else
				{
					soma = jogadaComum(soma);
				}				
				break;
			case 4:		
				if(lm1 >= 4 && lm1 <= 6)
				{
					soma = dobrar(soma);
				}
				else
				{
					soma = jogadaComum(soma);
				}				
				break;
			case 5:		
				if(lm1 >= 4 && lm1 <= 6)
				{
					soma = dobrar(soma);
				}
				else
				{
					soma = jogadaComum(soma);
				}				
				break;
			case 6:		
				if(lm1 >= 3 && lm1 <= 6)
				{
					soma = dobrar(soma);
				}
				else
				{
					soma = jogadaComum(soma);
				}				
				break;
			case 7:	
				if(lm1 >= 3 && lm1 <= 6)
				{
					soma = dobrar(soma);
				}
				else if(lm1 != 2 || lm1 != 7 || lm1 != 8)
				{
					soma = jogadaComum(soma);
				}
				break;
			case 8:	
				//nothing
				break;
			case 9:			
				//nothing		
				break;
			case 10:
				//blackJack
				blackjack = 1;
				break;
		}
		
		return soma;
	}
	
	//Feito
	private int jogadaComum1()
	{
		int soma;
		int lj1, lj2, lm1;
		lj1 = j1.getValor();
		lj2 = j2.getValor();
		lm1 = m1.getValor();
		soma = lj1 + lj2;

		if(soma <= 8)
		{
			soma = jogadaComum(soma);
		}
		else if(soma <= 9)
		{
			if(lm1 >= 3 && lm1 <= 6)
			{
				soma = dobrar(soma);
			}
			else
			{
				soma = jogadaComum(soma);
			}
		}
		else if(soma <= 10)
		{
			if(lm1 >= 2 && lm1 <= 9)
			{
				soma = dobrar(soma);
			}
			else
			{
				soma = jogadaComum(soma);
			}
		}
		else if(soma <= 11)
		{
			if(lm1 >= 2 && lm1 <= 10)
			{
				soma = dobrar(soma);
			}
			else
			{
				soma = jogadaComum(soma);
			}
		}
		else if(soma <= 12)
		{
			if(lm1 >= 4 && lm1 <= 6)
			{
				//stop
			}
			else
			{
				soma = jogadaComum(soma);
			}
		}
		else if(soma <= 16)
		{
			if(lm1 >= 2 && lm1 <= 6)
			{
				//stop
			}
			else
			{
				soma = jogadaComum(soma);
			}
		}
		else 
		{
			//stop
		}
		
		return soma;
	}
	
	//Feito
	private int jogadaComum(int somaP)
	{
		int soma;
		int lm1;
		int stop = 0;
		lm1 = m1.getValor();
		soma = somaP;

		while(stop == 0)
		{
			if(soma <= 11)
			{
				soma = pegaCarta(soma);
			}
			else if(soma <= 12)
			{
				if(qtdA > 0)
				{
					soma = pegaCarta(soma);
				}
				else if(lm1 >= 4 && lm1 <= 6)
				{
					//stop
					stop = 1;
				}
				else
				{
					soma = pegaCarta(soma);
				}
			}
			else if(soma <= 16)
			{
				if(qtdA > 0)
				{
					//tem As
					soma = pegaCarta(soma);					
				}
				else
				{
					if(lm1 >= 2 && lm1 <= 6)
					{
						//stop
						stop = 1;
					}
					else
					{
						soma = pegaCarta(soma);
					}
				}
			}
			else 
			{
				if(qtdA > 0)
				{
					//tem As
					if(
					(soma > 18) ||
					(soma == 18 && (lm1 == 2 || lm1 == 7 || lm1 == 8))
					)
					{
						//stop
						stop = 1;							
					}
					else
					{
						//17 ou 18 com mesa diferente de 2 7 8
						soma = pegaCarta(soma);							
					}				
				}
				else
				{		
					//stop
					stop = 1;			
				}
			}
		}
		
		return soma;
	}

	private void mesajoga()
	{
		int somaMesa, qtdAmesa, mesaBlackJack;
		qtdAmesa = 0;
		mesaBlackJack = 0;
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
		
		if(somaMesa == 21) //MesaBlackJack
		{
			mesaBlackJack = 1;
		}
		
		int novaCarta;
		
		if(exibir)
			System.out.println("Mesa: " + m1.getValor() + " " + m2.getValor()+" = " + somaMesa);
		
		while(somaMesa < 17)
		{
			novaCarta = b.distribuiCarta();
			if(novaCarta == 11)
				qtdAmesa++;
			somaMesa = somaMesa + novaCarta;
			if(somaMesa > 21 && qtdAmesa > 0)
			{
				novaCarta = 1;
				somaMesa -= 10;
				qtdAmesa--;
			}
			if(exibir)
				System.out.println("(" + novaCarta + ") = " + somaMesa);		
			
		}
		
		verificaVencedor(somaMesa, mesaBlackJack, somaJogador, blackjack, aposta);
		
		if(somaJogadorDividiu > 0)
		{
			verificaVencedor(somaMesa, mesaBlackJack, somaJogadorDividiu, blackjackDividiu, apostaDividiu);			
		}
		
		if(exibir)
		{
			System.out.println("J = "+somaJogador);
			System.out.println("Aposta = " + aposta);
			if(somaJogadorDividiu > 0)
			{
				System.out.println("Jdiv = "+somaJogadorDividiu);
				System.out.println("apostaDividiu = " + apostaDividiu);
			}
			System.out.println("M = "+somaMesa);
			System.out.println("SALDO = " + saldoJogador);
		}
		
	}
	
	private void verificaVencedor(int msomaMesa, int mblackjack, int jsomaJogador, int jblackjack, int japosta)
	{
		if(jsomaJogador <= 21) 
		{
			if(mblackjack == 1) // locovisck Se mesa e jogador tem BJ ?
			{
				//Perdeu
				saldoJogador -= japosta;
				qtdLoss++;
			}
			else if(jblackjack == 1)
			{
				//BlackJack
				saldoJogador += japosta + (japosta/2);
				qtdWin++;
			}
			else if(msomaMesa > 21)
			{
				//Mesa estourou
				//Ganhou
				saldoJogador += japosta;
				qtdWin++;
			}
			else if(jsomaJogador > msomaMesa)
			{
				//Ganhou
				saldoJogador += japosta;	
				qtdWin++;			
			}
			else if(jsomaJogador < msomaMesa)
			{
				//Perdeu
				saldoJogador -= japosta;
				qtdLoss++;
			}
			//else empate!				
		}
		else
		{
			//Jogador estourou
			//Perdeu
			saldoJogador -= japosta;
			qtdLoss++;
		}
	}
}
