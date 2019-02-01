package Simulator;

import java.util.Random;
import java.util.Scanner;

public class Baralho {
	
	int qtdTotal;
	Carta [] baralho;
	
	public static void main(String[] args) {
		Baralho b = new Baralho();

		b.iniciaBaralhoOrdenado();
		b.geraEmbaralhadoTemp();			
		b.exibeBaralhoFixo();
	}
	
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
		b2.exibeBaralhoFixo();
//		b2.exibeBaralho();
	}
	*/
	
	public void geraEmbaralhadoTemp()
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
	
	public void geraEmbaralhado()
	{
//		qtdTotal = 416;
//		iniciaBaralhoOrdenado();
//		geraBaralhoFixo();
		
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
		
//		int i = new Random().nextInt(qtdTotal);
//		int cartaRetorno = baralho[i].getValor();
//		return cartaRetorno;
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
	
	
	
	///////////////////////////////////////////////////

	
	public void geraBaralhoFixo()
	{
//		Scanner reader = new Scanner(System.in);
//		int  entrada = 0;
//		
//		for(int i = 0; i < 416; i++)
//		{
//			entrada = reader.nextInt();
//			baralho[i].setValor(entrada);	
//		}

		baralho[0].setValor(10);
		baralho[1].setValor(2);
		baralho[2].setValor(3);
		baralho[3].setValor(2);
		baralho[4].setValor(2);
		baralho[5].setValor(10);
		baralho[6].setValor(7);
		baralho[7].setValor(4);
		baralho[8].setValor(10);
		baralho[9].setValor(4);
		baralho[10].setValor(9);
		baralho[11].setValor(2);
		baralho[12].setValor(10);
		baralho[13].setValor(6);
		baralho[14].setValor(7);
		baralho[15].setValor(5);
		baralho[16].setValor(3);
		baralho[17].setValor(10);
		baralho[18].setValor(7);
		baralho[19].setValor(4);
		baralho[20].setValor(10);
		baralho[21].setValor(11);
		baralho[22].setValor(5);
		baralho[23].setValor(10);
		baralho[24].setValor(10);
		baralho[25].setValor(6);
		baralho[26].setValor(11);
		baralho[27].setValor(2);
		baralho[28].setValor(7);
		baralho[29].setValor(10);
		baralho[30].setValor(9);
		baralho[31].setValor(10);
		baralho[32].setValor(10);
		baralho[33].setValor(2);
		baralho[34].setValor(10);
		baralho[35].setValor(3);
		baralho[36].setValor(10);
		baralho[37].setValor(5);
		baralho[38].setValor(7);
		baralho[39].setValor(5);
		baralho[40].setValor(3);
		baralho[41].setValor(10);
		baralho[42].setValor(2);
		baralho[43].setValor(2);
		baralho[44].setValor(2);
		baralho[45].setValor(6);
		baralho[46].setValor(3);
		baralho[47].setValor(5);
		baralho[48].setValor(10);
		baralho[49].setValor(5);
		baralho[50].setValor(10);
		baralho[51].setValor(5);
		baralho[52].setValor(10);
		baralho[53].setValor(6);
		baralho[54].setValor(9);
		baralho[55].setValor(5);
		baralho[56].setValor(7);
		baralho[57].setValor(11);
		baralho[58].setValor(6);
		baralho[59].setValor(8);
		baralho[60].setValor(11);
		baralho[61].setValor(2);
		baralho[62].setValor(6);
		baralho[63].setValor(7);
		baralho[64].setValor(11);
		baralho[65].setValor(3);
		baralho[66].setValor(10);
		baralho[67].setValor(10);
		baralho[68].setValor(5);
		baralho[69].setValor(11);
		baralho[70].setValor(5);
		baralho[71].setValor(3);
		baralho[72].setValor(11);
		baralho[73].setValor(3);
		baralho[74].setValor(6);
		baralho[75].setValor(10);
		baralho[76].setValor(5);
		baralho[77].setValor(9);
		baralho[78].setValor(4);
		baralho[79].setValor(10);
		baralho[80].setValor(11);
		baralho[81].setValor(3);
		baralho[82].setValor(2);
		baralho[83].setValor(2);
		baralho[84].setValor(8);
		baralho[85].setValor(7);
		baralho[86].setValor(10);
		baralho[87].setValor(4);
		baralho[88].setValor(3);
		baralho[89].setValor(10);
		baralho[90].setValor(9);
		baralho[91].setValor(8);
		baralho[92].setValor(8);
		baralho[93].setValor(9);
		baralho[94].setValor(10);
		baralho[95].setValor(9);
		baralho[96].setValor(10);
		baralho[97].setValor(4);
		baralho[98].setValor(11);
		baralho[99].setValor(8);
		baralho[100].setValor(6);
		baralho[101].setValor(7);
		baralho[102].setValor(9);
		baralho[103].setValor(7);
		baralho[104].setValor(3);
		baralho[105].setValor(4);
		baralho[106].setValor(7);
		baralho[107].setValor(9);
		baralho[108].setValor(11);
		baralho[109].setValor(8);
		baralho[110].setValor(10);
		baralho[111].setValor(8);
		baralho[112].setValor(9);
		baralho[113].setValor(6);
		baralho[114].setValor(6);
		baralho[115].setValor(2);
		baralho[116].setValor(10);
		baralho[117].setValor(10);
		baralho[118].setValor(10);
		baralho[119].setValor(6);
		baralho[120].setValor(11);
		baralho[121].setValor(3);
		baralho[122].setValor(6);
		baralho[123].setValor(10);
		baralho[124].setValor(10);
		baralho[125].setValor(10);
		baralho[126].setValor(4);
		baralho[127].setValor(8);
		baralho[128].setValor(10);
		baralho[129].setValor(10);
		baralho[130].setValor(5);
		baralho[131].setValor(10);
		baralho[132].setValor(10);
		baralho[133].setValor(8);
		baralho[134].setValor(10);
		baralho[135].setValor(10);
		baralho[136].setValor(8);
		baralho[137].setValor(4);
		baralho[138].setValor(2);
		baralho[139].setValor(8);
		baralho[140].setValor(10);
		baralho[141].setValor(5);
		baralho[142].setValor(11);
		baralho[143].setValor(10);
		baralho[144].setValor(6);
		baralho[145].setValor(3);
		baralho[146].setValor(10);
		baralho[147].setValor(4);
		baralho[148].setValor(5);
		baralho[149].setValor(11);
		baralho[150].setValor(10);
		baralho[151].setValor(7);
		baralho[152].setValor(10);
		baralho[153].setValor(6);
		baralho[154].setValor(4);
		baralho[155].setValor(10);
		baralho[156].setValor(10);
		baralho[157].setValor(7);
		baralho[158].setValor(10);
		baralho[159].setValor(8);
		baralho[160].setValor(10);
		baralho[161].setValor(11);
		baralho[162].setValor(6);
		baralho[163].setValor(10);
		baralho[164].setValor(10);
		baralho[165].setValor(9);
		baralho[166].setValor(2);
		baralho[167].setValor(10);
		baralho[168].setValor(10);
		baralho[169].setValor(9);
		baralho[170].setValor(8);
		baralho[171].setValor(3);
		baralho[172].setValor(7);
		baralho[173].setValor(4);
		baralho[174].setValor(2);
		baralho[175].setValor(9);
		baralho[176].setValor(8);
		baralho[177].setValor(8);
		baralho[178].setValor(5);
		baralho[179].setValor(4);
		baralho[180].setValor(10);
		baralho[181].setValor(5);
		baralho[182].setValor(9);
		baralho[183].setValor(7);
		baralho[184].setValor(9);
		baralho[185].setValor(4);
		baralho[186].setValor(5);
		baralho[187].setValor(3);
		baralho[188].setValor(11);
		baralho[189].setValor(10);
		baralho[190].setValor(3);
		baralho[191].setValor(5);
		baralho[192].setValor(7);
		baralho[193].setValor(6);
		baralho[194].setValor(6);
		baralho[195].setValor(9);
		baralho[196].setValor(11);
		baralho[197].setValor(8);
		baralho[198].setValor(11);
		baralho[199].setValor(10);
		baralho[200].setValor(10);
		baralho[201].setValor(4);
		baralho[202].setValor(10);
		baralho[203].setValor(3);
		baralho[204].setValor(11);
		baralho[205].setValor(10);
		baralho[206].setValor(2);
		baralho[207].setValor(2);
		baralho[208].setValor(10);
		baralho[209].setValor(5);
		baralho[210].setValor(10);
		baralho[211].setValor(6);
		baralho[212].setValor(10);
		baralho[213].setValor(10);
		baralho[214].setValor(10);
		baralho[215].setValor(4);
		baralho[216].setValor(3);
		baralho[217].setValor(10);
		baralho[218].setValor(10);
		baralho[219].setValor(5);
		baralho[220].setValor(6);
		baralho[221].setValor(10);
		baralho[222].setValor(10);
		baralho[223].setValor(10);
		baralho[224].setValor(10);
		baralho[225].setValor(8);
		baralho[226].setValor(10);
		baralho[227].setValor(6);
		baralho[228].setValor(10);
		baralho[229].setValor(6);
		baralho[230].setValor(10);
		baralho[231].setValor(4);
		baralho[232].setValor(10);
		baralho[233].setValor(9);
		baralho[234].setValor(10);
		baralho[235].setValor(2);
		baralho[236].setValor(10);
		baralho[237].setValor(3);
		baralho[238].setValor(10);
		baralho[239].setValor(7);
		baralho[240].setValor(11);
		baralho[241].setValor(7);
		baralho[242].setValor(10);
		baralho[243].setValor(11);
		baralho[244].setValor(4);
		baralho[245].setValor(10);
		baralho[246].setValor(9);
		baralho[247].setValor(10);
		baralho[248].setValor(6);
		baralho[249].setValor(6);
		baralho[250].setValor(5);
		baralho[251].setValor(10);
		baralho[252].setValor(9);
		baralho[253].setValor(10);
		baralho[254].setValor(4);
		baralho[255].setValor(10);
		baralho[256].setValor(10);
		baralho[257].setValor(4);
		baralho[258].setValor(8);
		baralho[259].setValor(3);
		baralho[260].setValor(10);
		baralho[261].setValor(6);
		baralho[262].setValor(10);
		baralho[263].setValor(4);
		baralho[264].setValor(8);
		baralho[265].setValor(4);
		baralho[266].setValor(8);
		baralho[267].setValor(8);
		baralho[268].setValor(10);
		baralho[269].setValor(10);
		baralho[270].setValor(4);
		baralho[271].setValor(4);
		baralho[272].setValor(2);
		baralho[273].setValor(2);
		baralho[274].setValor(9);
		baralho[275].setValor(7);
		baralho[276].setValor(5);
		baralho[277].setValor(11);
		baralho[278].setValor(8);
		baralho[279].setValor(10);
		baralho[280].setValor(3);
		baralho[281].setValor(10);
		baralho[282].setValor(10);
		baralho[283].setValor(9);
		baralho[284].setValor(2);
		baralho[285].setValor(4);
		baralho[286].setValor(8);
		baralho[287].setValor(10);
		baralho[288].setValor(7);
		baralho[289].setValor(10);
		baralho[290].setValor(10);
		baralho[291].setValor(9);
		baralho[292].setValor(10);
		baralho[293].setValor(7);
		baralho[294].setValor(10);
		baralho[295].setValor(7);
		baralho[296].setValor(11);
		baralho[297].setValor(6);
		baralho[298].setValor(11);
		baralho[299].setValor(7);
		baralho[300].setValor(6);
		baralho[301].setValor(11);
		baralho[302].setValor(3);
		baralho[303].setValor(10);
		baralho[304].setValor(8);
		baralho[305].setValor(3);
		baralho[306].setValor(7);
		baralho[307].setValor(6);
		baralho[308].setValor(3);
		baralho[309].setValor(6);
		baralho[310].setValor(10);
		baralho[311].setValor(10);
		baralho[312].setValor(9);
		baralho[313].setValor(3);
		baralho[314].setValor(4);
		baralho[315].setValor(10);
		baralho[316].setValor(10);
		baralho[317].setValor(11);
		baralho[318].setValor(7);
		baralho[319].setValor(5);
		baralho[320].setValor(10);
		baralho[321].setValor(10);
		baralho[322].setValor(9);
		baralho[323].setValor(6);
		baralho[324].setValor(10);
		baralho[325].setValor(10);
		baralho[326].setValor(10);
		baralho[327].setValor(7);
		baralho[328].setValor(8);
		baralho[329].setValor(5);
		baralho[330].setValor(10);
		baralho[331].setValor(2);
		baralho[332].setValor(10);
		baralho[333].setValor(11);
		baralho[334].setValor(4);
		baralho[335].setValor(10);
		baralho[336].setValor(10);
		baralho[337].setValor(5);
		baralho[338].setValor(8);
		baralho[339].setValor(10);
		baralho[340].setValor(5);
		baralho[341].setValor(10);
		baralho[342].setValor(10);
		baralho[343].setValor(8);
		baralho[344].setValor(7);
		baralho[345].setValor(11);
		baralho[346].setValor(4);
		baralho[347].setValor(10);
		baralho[348].setValor(5);
		baralho[349].setValor(10);
		baralho[350].setValor(9);
		baralho[351].setValor(4);
		baralho[352].setValor(11);
		baralho[353].setValor(2);
		baralho[354].setValor(8);
		baralho[355].setValor(2);
		baralho[356].setValor(10);
		baralho[357].setValor(2);
		baralho[358].setValor(2);
		baralho[359].setValor(2);
		baralho[360].setValor(10);
		baralho[361].setValor(3);
		baralho[362].setValor(11);
		baralho[363].setValor(10);
		baralho[364].setValor(6);
		baralho[365].setValor(6);
		baralho[366].setValor(8);
		baralho[367].setValor(7);
		baralho[368].setValor(10);
		baralho[369].setValor(11);
		baralho[370].setValor(3);
		baralho[371].setValor(8);
		baralho[372].setValor(3);
		baralho[373].setValor(7);
		baralho[374].setValor(9);
		baralho[375].setValor(5);
		baralho[376].setValor(2);
		baralho[377].setValor(10);
		baralho[378].setValor(10);
		baralho[379].setValor(5);
		baralho[380].setValor(2);
		baralho[381].setValor(10);
		baralho[382].setValor(10);
		baralho[383].setValor(7);
		baralho[384].setValor(7);
		baralho[385].setValor(11);
		baralho[386].setValor(6);
		baralho[387].setValor(10);
		baralho[388].setValor(10);
		baralho[389].setValor(10);
		baralho[390].setValor(2);
		baralho[391].setValor(9);
		baralho[392].setValor(3);
		baralho[393].setValor(2);
		baralho[394].setValor(4);
		baralho[395].setValor(7);
		baralho[396].setValor(10);
		baralho[397].setValor(11);
		baralho[398].setValor(4);
		baralho[399].setValor(3);
		baralho[400].setValor(9);
		baralho[401].setValor(3);
		baralho[402].setValor(3);
		baralho[403].setValor(5);
		baralho[404].setValor(10);
		baralho[405].setValor(8);
		baralho[406].setValor(10);
		baralho[407].setValor(10);
		baralho[408].setValor(9);
		baralho[409].setValor(8);
		baralho[410].setValor(9);
		baralho[411].setValor(4);
		baralho[412].setValor(5);
		baralho[413].setValor(5);
		baralho[414].setValor(9);
		baralho[415].setValor(9);


	}
	
	public int exibeBaralhoFixo()
	{
		int i = 0;
		while(i < qtdTotal)
		{
			System.out.println("baralho["+i+"].setValor("+baralho[i].getValor()+");");
			i++;
		}
		return 1;
	}	
	
	
}





