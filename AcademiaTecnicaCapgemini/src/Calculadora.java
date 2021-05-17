import static org.junit.Assert.*;

import java.util.Scanner;
import org.junit.Test;
/**
 * po
 * @author lindemberg
 * implementação da classe parte1 com modificações 
 */
public class Calculadora {

	/**
	 * controlador da quantidade de vezes que o anúncio foi compartilhado
	 */
	static int nivelDeCompartilhamento = 0;
	
	/**
	 * (JVM) método que executa o código da calculadora 
	 * Ao executar o código  na IDE, será mostrado o nome do sistema, bem como uma pequena introdução de como deve ser utiizado
	 * @param args 
	 */
	public static void main (String [] args) {
		System.out.println("<A informe um numero maio ou igual a 0(zero) e inteiro(sem casas decimais), qualquer dado diferente encerra a calculadora>");
		System.out.println("\t\t\t<Calculadora de alcance de anuncio>");
		Scanner in = new Scanner(System.in);
		
		while(true) {	
			try {
				
				System.out.print("\nInforme o valor a ser investido: R$");
				int investimento = in.nextInt();
				if (investimento >=0 && investimento<= Integer.MAX_VALUE) {
					System.out.print("A projeção estimada é de " + calculaProjecao(investimento)+"\n");
					nivelDeCompartilhamento=0;
				}else {
					throw new Exception();
				}
				
			} catch (Exception e) {
				System.out.println("\nDado informado invalido!\nCalculadora finalizada.");
				break;
			}
		}
	}
	
	/**
	 * calcula a quantidade de visualizações que o anúncio pode ter de acordo com o valor investido
	 * @param investimento  a ser pago pela divulgação dos aúnicos 
	 * @return a quantidade máxima de visualizações 
	 * @throws Exception 
	 */
	public static int calculaProjecao(int investimento ) {
		int visualizacaoTotal=0;
		int controle = investimento;
		
		do {
			int qtdVisualizacao = calculaVisualizacao(controle);
			int qtdClicks = calculaClick(qtdVisualizacao); 
			controle = qtdCompartilhamentos(qtdClicks);
			visualizacaoTotal+=qtdVisualizacao;
		}while (controle!=0 && nivelDeCompartilhamento<5);
		
		return visualizacaoTotal;
	}
	
	/**
	 * Calcula a quantidade de visualizações
	 * onde a primeira divulagação tem o alcance de 30 visuaizações e as demais de 40 visualizações 
	 * @param controle da quantidade de compartilhamento
	 * @return a quantidade visualizações parciais que pode ser alcançada 
	 */
	public static int calculaVisualizacao(int controle) {
		if (nivelDeCompartilhamento==0) {
			return controle * 30;
		}else {
			return controle * 40;
		}
	}
	
	/**
	 * calcula a quantidade de pessoa que ciclaram no anúncio 
	 * @param visualização dos anuncios (quantidade) 
	 * @return a quantidade de cliques no anúncio
	 */
	public static int calculaClick( int visualização) {
		return (int) (visualização * 0.12);
		
	}
	
	/**
	 * quantidade de compartilhamento feito por quem clicou no anuncio 
	 * @param click quantidade de pessoas que clicaram no anúncio 
	 * @return quantidade compartilhamentos 
	 */
	public static int qtdCompartilhamentos(int click) {
		nivelDeCompartilhamento++;
		return (int) (click * 0.15);
	}

	//---------------------------------------------------------- Auxiliares para a classe anuncio-------------------------------------------------------
	
	/**
	 * Como o método calculaProjecao é Static não pode ser instaciado, logo este método é um submétodo de calculaProjecao
	 * @param investimento a ser pago pelos anuncios 
	 * @return a quantidade visualização
	 */
	public int calculaProjecaoAnuncio(int investimento) {
		return calculaProjecao(investimento);
	}
	
	/**
	 * por calculaClick ser static não pode ser instanciado, logo este método é um submétodo de calculaClick
	 * @param visualização da quantidade vezes que o anuncio foi visto
	 * @return
	 */
	public int calculaClickAnuncio(int visualização) {
		return calculaClick(visualização);
	}
	
	/**
	 * por qtdCompartilhamentos ser static não pode ser instanciado, logo este método é um submétodo de qtdCompartilhamentos
	 * @param click com a quantidade de vezes que o anuncio foi clicado
	 * @return a quantidade de compartilhamento
	 */
	public int qtdCompartilhamentosAnuncio(int click) {
		return qtdCompartilhamentos(click);
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Testes os métodos da classe calculadora
	/**
	 * Testa a projecao de visualizações de acordo com o valor investido, valores negativos neste método seria executado pois o tratamento 
	 * dos numeros negativos foi denegado a um outro método
	 * 
	 */
	@Test
	public void calculaProjecaoTest() {
		
		nivelDeCompartilhamento=0;
		assertEquals(30,calculaProjecao(1));
	
		nivelDeCompartilhamento=0;
		assertEquals(100,calculaProjecao(2));	

		nivelDeCompartilhamento=0;
		assertEquals(270,calculaProjecao(5));

		nivelDeCompartilhamento=0;
		assertEquals(740,calculaProjecao(10));

		nivelDeCompartilhamento=0;
		assertEquals(73340,calculaProjecao(850));

		nivelDeCompartilhamento=0;
		assertEquals(2280,calculaProjecao(28));

		nivelDeCompartilhamento=0;
		assertEquals(8450,calculaProjecao(99));

		nivelDeCompartilhamento=0;
		assertEquals(86280,calculaProjecao(1000));
		
		nivelDeCompartilhamento=0;
		assertEquals(1728160,calculaProjecao(20000));
		
	}

	/**
	 * a taxa de cliques por visualização corrensponde a 12% do total de visualizações  (representado em inteiro) 
	 * o teste utiliza a quantidade de visualização, e analiza os 12% correspondente 
	 * 
	 * numeros negativos são tratados em outro método
	 */
	@Test
	public void calculaClickTest() {
		
		assertEquals(12, calculaClick(100));
		assertEquals(24, calculaClick(200));
		assertEquals(6, calculaClick(50));
		assertEquals(120, calculaClick(1000));
		assertEquals((int)(8521*0.12), calculaClick(8521));
		
		
	}
	/**
	 * a quantidade de vezes que o anuncio é compartilhado apos n cliques, corresponde a 15% do total de cliques (representado em inteiro) 
	 */
	@Test
	public void qtdCompartilhamentosTest() {
		
		assertEquals(15, qtdCompartilhamentos(100));
		assertEquals(150, qtdCompartilhamentos(1000));
		assertEquals(1434, qtdCompartilhamentos(9563));
		assertEquals(1500, qtdCompartilhamentos(10000));
		assertEquals(50, qtdCompartilhamentos(335));
		assertEquals(10, qtdCompartilhamentos(67));
		assertEquals((int)(15748*0.15), qtdCompartilhamentos(15748));
		
	}
	/*
	 * verifica a proporção da visualização, seguindo a regra a cada R$ 1.00 investido, corresponde a 30 visualizações
	 * em caso de compartilhamento o alcance é de 40 visualizações
	 * 
	 * não testa em caso de mais de 4 compartilhamento, uma vez que o controle é des resposabilidade de outra classe, bem como não se importa com compartilhamentos subsequentes
	 * 
	 */
	@Test
	public void calculaVisualizacaoTest() {
		nivelDeCompartilhamento=0;
		assertEquals(3000,calculaVisualizacao(100));
		
		nivelDeCompartilhamento=0;
		assertEquals(1500,calculaVisualizacao(50));
		
		nivelDeCompartilhamento=1;
		assertEquals(4000,calculaVisualizacao(100));
		
		nivelDeCompartilhamento=2;
		assertEquals( 6000,calculaVisualizacao(150));
		nivelDeCompartilhamento=3;
		assertEquals(3400,calculaVisualizacao(85));
		nivelDeCompartilhamento=4;
		assertEquals(2000,calculaVisualizacao(50));
		
				
	}
}
