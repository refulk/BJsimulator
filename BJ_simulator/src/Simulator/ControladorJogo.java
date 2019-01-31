// package Simulator;

import java.util.Scanner;

public class ControladorJogo {
	
	public static void main(String[] args) {
		
		ControladorJogo cont = new ControladorJogo();
		
		cont.Jogar(1000000, 0, 0, 0, 0);
		// cont.JogarManual(11, 11, 5, 0);
	}

	public void Jogar(int qtdJogadas, int j1, int j2, int m1, int m2)
	{
		JogadaClean j = new JogadaClean(false);
		for(int i = 0; i < qtdJogadas; i++)
		{
			j.iniciaJogada(j1,j2,m1,m2);
		}
		System.out.println("\nSaldo = " + j.saldoJogador);
		System.out.println("qtdWin = " + j.qtdWin);
		System.out.println("qtdLoss = " + j.qtdLoss);
		System.out.println("Empate = " + (qtdJogadas - (j.qtdLoss+j.qtdWin)));
	}
	
	public void JogarManual(int j1, int j2, int m1, int m2)
	{
		JogadaClean j = new JogadaClean(true);
		Scanner Input = new Scanner (System.in);		
		Scanner reader = new Scanner(System.in);
		int  entrada = 1;
		
		while(entrada == 1)
		{
			j.iniciaJogada(j1,j2,m1,m2);
			entrada = reader.nextInt();
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
