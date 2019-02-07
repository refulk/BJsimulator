package Simulator;

import java.util.Scanner;
import java.util.Random;

public class ControladorJogo {
	
	double porcWin, porcSaldo;
	double porcWinMed, porcSaldoMed;
	int saldoBruto, saldoBrutoTot;

	public static void main(String[] args) {
		
		ControladorJogo cont = new ControladorJogo();

//		cont.JogarMediaEspec(1, 10000000, 9, 5, 0);

		// cont.JogarEspec(10, 0, 0, 2, true);

		// cont.jogarTodasCartasM(1, 10000000, 2);

		cont.Jogar(10000000, 0, 0, 0, 0, true);
		
	}
	
	public ControladorJogo()
	{
		zerarVariaveis();
	}

	public void zerarVariaveis()
	{
		porcWin = 0;
		porcSaldo = 0;
		porcWinMed = 0;
		porcSaldoMed = 0;
		saldoBruto = 0;
		saldoBrutoTot = 0;
	}
	
		
	public void jogarTodasCartasM(int qtdMed, int qtdJogadas, int somaLimite)
	{
		System.out.println(somaLimite);	
		for(int i = 0; i <= 11; i++)
		{
			if(i == 1)
				i = 2;
//			System.out.printf("("+i+")");
			JogarMediaEspec(qtdMed, qtdJogadas, somaLimite, i, 0);	
		}	
		System.out.println("");	
	}
	
	public void JogarMediaEspec(int qtdMed, int qtdJogadas, int somaLimite, int m1, int m2)
	{
		zerarVariaveis();
		for(int i = 0; i < qtdMed; i++)
		{
			JogarEspec(qtdJogadas,m1,m2, somaLimite, false);
//			System.out.println(" saldoP = " + saldoBruto);
		}
		System.out.printf(saldoBruto + ", ");
	}
	
	public void JogarEspec(int qtdJogadas, int m1, int m2, int somaLimite, boolean exibir)
	{
		JogadaClean j = new JogadaClean(false);
		int carta1 = somaLimite, carta2 = somaLimite, soma = carta1 + carta2;
		int limite = somaLimite - 1;
		
		if(limite > 12)
			limite = 12;
		
		for(int i = 0; i < qtdJogadas; i++)
		{
// 			carta2 = 12;
// 			while(carta2 > 11)
// 			{
// //				carta1 = retornarMenorQue(limite);
// 				carta1 = 11;
// 				carta2 = somaLimite - carta1;
// 				soma = carta1 + carta2;
// 			}
			if(exibir)
			{			
				System.out.println("carta1 = " + carta1);
				System.out.println("carta2 = " + carta2);	
				System.out.println("soma = " + soma);	
			}
			else
			{
				j.iniciaJogada(carta1,carta2,m1,m2);
//				j.iniciaJogada(0,0,0,0);
			}
		}
		saldoBruto += j.saldoJogador;

	}

	public int retornarMenorQue(int valor)
	{
		int retorno = 0;
		if(valor > 2)
		{
			while(retorno <= 1)
			{
				retorno = new Random().nextInt(valor);
			}			
		}		
		return retorno;
	}


	public void Jogar(int qtdJogadas, int j1, int j2, int m1, int m2, boolean exibe)
	{
		JogadaClean j = new JogadaClean(false);
		
		for(int i = 0; i < qtdJogadas; i++)
		{
			j.iniciaJogada(j1,j2,m1,m2);
		}
		saldoBruto += j.saldoJogador;
		saldoBrutoTot += j.apostaTotal;

		porcWin = (j.qtdWin*100)/Double.valueOf(j.qtdWin+j.qtdLoss+j.qtdEmpate);
		porcSaldo = (j.saldoJogador*100)/Double.valueOf(j.apostaTotal);

		if(exibe)
		{
			System.out.println("\nQtdJogadas = " + qtdJogadas);
			System.out.println("Saldo = " + j.saldoJogador);
			System.out.println("qtdWin = " + j.qtdWin);
			System.out.println("qtdLoss = " + j.qtdLoss);
			System.out.println("Empate = " + j.qtdEmpate);
			System.out.println("apostaTotal = " + j.apostaTotal);
		}

		if(exibe)
		{
			System.out.printf("\nporcWin = " + "%.3f", porcWin);
			System.out.printf("\nporcSaldo = " + "%.3f", porcSaldo);
			System.out.println("");
		}

		
	}

	/*
	public void JogarMedia(int qtdMed, int qtdJogadas, int j1, int j2, int m1, int m2)
	{
		zerarVariaveis();
		for(int i = 0; i < qtdMed; i++)
		{
			Jogar(qtdJogadas,j1,j2,m1,m2);
		}
		System.out.println("saldoBruto = " + saldoBruto);
	}
	
	public void JogarManual(int j1, int j2, int m1, int m2)
	{
		JogadaClean j = new JogadaClean(true);
//		Scanner Input = new Scanner (System.in);		
		Scanner reader = new Scanner(System.in);
		int  entrada = 1;
		
		while(entrada == 1)
		{
			j.iniciaJogada(j1,j2,m1,m2);
			entrada = reader.nextInt();
		}
	}
	
	public void JogarQtd(int qtd)
	{
		JogadaClean j = new JogadaClean(true);
		
		for(int i = 0; i < qtd; i++)
		{
			j.iniciaJogada(0,0,0,0);
		}
	}
	
	*/
	
	
	  /*
	   //BACKUP
	   
	   	
	public void gravarArquivo()
	{
		FileWriter arq = null;
		try {
			arq = new FileWriter("Arquivo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter gravarArq = new PrintWriter(arq);
		
		for (int i=1; i<=100; i++) {
		    gravarArq.printf("%d%n", i);
		  }
		
		try {
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	   
	   
	   import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Scanner;
	 
	public class Exemplo {
	 
	  public static void main(String[] args) throws IOException {
	    Scanner ler = new Scanner(System.in);
	    int i, n;
	 
	    System.out.printf("Informe o numero para a tabuada:\n");
	    n = ler.nextInt();
	 
	    FileWriter arq = new FileWriter("d:\\tabuada.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	 
	    gravarArq.printf("+--Resultado--+%n");
	    for (i=1; i<=10; i++) {
	      gravarArq.printf("| %2d X %d = %2d |%n", i, n, (i*n));
	    }
	    gravarArq.printf("+-------------+%n");
	 
	    arq.close();
	 
	    System.out.printf("\nTabuada do %d foi gravada com sucesso em \"d:\\tabuada.txt\".\n", n);
	  }
	 
	}

	 */
	
}
