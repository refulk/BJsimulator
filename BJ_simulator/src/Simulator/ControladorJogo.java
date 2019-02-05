package Simulator;

import java.util.Scanner;
import java.util.Random;

public class ControladorJogo {
	
	double porcWin, porcSaldo;
	double porcWinMed, porcSaldoMed;
	int saldoBruto, saldoBrutoTot;

	public static void main(String[] args) {
		
		ControladorJogo cont = new ControladorJogo();
		
		cont.JogarMediaEspec(10);

//		cont.JogarMedia(10, 2000000, 0, 0, 0, 0);
//		cont.Jogar(1000000, 0, 0, 0, 0);
//		cont.JogarManual(11, 11, 0, 0);
//		cont.JogarQtd(300);
	}

	public ControladorJogo()
	{
		porcWin = 0;
		porcSaldo = 0;
		porcWinMed = 0;
		porcSaldoMed = 0;
		saldoBruto = 0;
		saldoBrutoTot = 0;
	}

	public void JogarMediaEspec(int qtdMed)
	{
		for(int k = 0; k <= 0; k++) //alterar aqui para executar mais numeros
		{			
			System.out.println("\n"+k);

			for(int i = 0; i < qtdMed; i++)
			{
				JogarEspec(k);
				porcWinMed+=porcWin;
				porcSaldoMed+=porcSaldo;
			}

			porcWinMed = porcWinMed/qtdMed;
			porcSaldoMed = porcSaldoMed/qtdMed;
			System.out.printf("porcWinMed = " + "%.3f", porcWinMed);
			System.out.printf("\nporcSaldoMed = " + "%.3f", porcSaldoMed);
			System.out.println("");
			System.out.printf("porcBruto = " + "%.3f", ((saldoBruto / Double.valueOf(saldoBrutoTot))*100));
			System.out.println("\nSaldoBruto Final (volume) = "+saldoBruto);

		}
	}

	public void JogarEspec(int m1)
	{
		int carta1 = 1, carta2 = 1, soma = 22;
		int limite = 8;
		int somaLimite = 9;
		
		//somaLimite++;

		
		//while(soma != somaLimite)
		//{
			//while(carta1 <= 1)
			//{
				carta1 = retornarMenorQue(limite);
			//}
			//while(carta2 <= 1)
			//{
				carta2 = 9 - carta1;
			//}
			soma = carta1 + carta2;
		//}
		if(1 == 0)
		{			
			System.out.println("carta1 = " + carta1);
			System.out.println("carta2 = " + carta2);	
			System.out.println("soma = " + soma);	
		}

		Jogar(2000000, carta1, carta2, m1, 0);
//		Jogar(2000000, 0, 0, 0, 0);
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

	public void JogarMedia(int qtdMed, int qtdJogadas, int j1, int j2, int m1, int m2)
	{
		for(int i = 0; i < qtdMed; i++)
		{
			Jogar(qtdJogadas,j1,j2,m1,m2);
			porcWinMed+=porcWin;
			porcSaldoMed+=porcSaldo;
		}
		porcWinMed = porcWinMed/qtdMed;
		porcSaldoMed = porcSaldoMed/qtdMed;
		System.out.printf("\nporcWinMed = " + "%.3f", porcWinMed);
		System.out.printf("\nporcSaldoMed = " + "%.3f", porcSaldoMed);
		System.out.println("");
	}

	public void Jogar(int qtdJogadas, int j1, int j2, int m1, int m2)
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

		if(1 == 0)
		{
			System.out.println("\nQtdJogadas = " + qtdJogadas);
			System.out.println("Saldo = " + j.saldoJogador);
			System.out.println("qtdWin = " + j.qtdWin);
			System.out.println("qtdLoss = " + j.qtdLoss);
			System.out.println("Empate = " + j.qtdEmpate);
			System.out.println("apostaTotal = " + j.apostaTotal);
		}

		if(1 == 0)
		{
			System.out.printf("\nporcWin = " + "%.3f", porcWin);
			System.out.printf("\nporcSaldo = " + "%.3f", porcSaldo);
			System.out.println("");
		}
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
