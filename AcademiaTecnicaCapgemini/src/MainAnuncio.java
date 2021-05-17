import java.text.ParseException;
import java.util.Scanner;

/**
 * 
 * @author lindemberg
 *
 */
public class MainAnuncio {
	public static void main (String [] args ) {
		Scanner in = new Scanner(System.in);
		controleAnuncio anuncio = new controleAnuncio();
		
		System.out.println("\t\tSistema de cadastro de Anúncios\n");
		while(true) {
			System.out.print("\n(C)adastrar Anúcio: \n"
								+"(I)nvestimento: \n"
								+"(V)isualizações: \n"
								+"(CL)iques: \n"
								+"(CO)mpartilhamentos: \n"
								+"(F)iltro: \n"
								+"(S)air:\n"							
								+"\nOpção >>");
			String opcao = in.next();
			in.nextLine();
			opcoes(anuncio,in,opcao);
		}
	}
	/**
	 * menu de opções 
	 * @param anuncio lista de anuncios 
	 * @param in atributo Scanner 
	 * @param op opção do menu
	 */
	public static void opcoes(controleAnuncio anuncio,Scanner in, String op) {
		switch (op.toUpperCase()) {
			case "C":				
				System.out.println(cadastro(anuncio,in));
				break;
			case "I":
				System.out.println(listaInvestimentos(anuncio));
				break;
			case "V":				
				System.out.println(listaVisualizacao(anuncio));
				break;
			case "CL":
				System.out.println(listaCliques(anuncio));
				break;
			case "CO":				
				System.out.println(listaCompartilhamentos(anuncio));
				break;
			case "F":
				System.out.println(filtra(anuncio,in));
				break;
			case "S":
				System.out.println(">>Finalizado<<");
				System.exit(0);
			default:
				System.out.println("Opção Invalida, tente novamente\n");
				}
	}
		/**
		 * cadastro de anuncio no sistema 
		 * @param anuncio lista de anuncio
		 * @param in atributo Scanner 
		 * @return a confirmação da inclusão
		 */
	public static String cadastro(controleAnuncio anuncio, Scanner  in ) {
			System.out.print("\nNome do Anuncio: ");
			String nomeAnuncio = in.nextLine();
			System.out.print("Nome do Cliente: ");
			String cliente = in.nextLine();
			System.out.println("OBS: a Data ser preenchida da seguinte forma >dd/mm/aaaa");
			System.out.print("Data de início: ");
			String inicio = in.nextLine();
			System.out.print("Data de término: ");
			String fim = in.nextLine();
			System.out.print("Valor investido (em inteiro): ");
			int investimento = in.nextInt();
			Anuncio dados = new  Anuncio(nomeAnuncio, cliente, inicio, fim, investimento);
			return anuncio.cadastraString(dados);		
	}
	/**
	 * lista com dados de investimentos dos anuncios 
	 * @param anuncio lista de anúncio
	 * @return representação textual dos investimentos 
	 */
	public static String listaInvestimentos(controleAnuncio anuncio) {
		return anuncio.totalInvestido();
	}
	/**
	 * lista com dados de visualizações dos anuncios 
	 * @param anuncio lista de anúncio
	 * @return representação textual das visualizaçẽos 
	 */
	public static String listaVisualizacao(controleAnuncio anuncio) {
		return anuncio.qtdMaximaDeVisualizacoes();
	}
	/**
	 * lista com dados de cliques dos anuncios 
	 * @param anuncio lista de anúncio
	 * @return representação textual dos cliques  
	 */
	public static String listaCliques(controleAnuncio anuncio) {
		return anuncio.qtdMaximaDeCliques();
	}
	/**
	 * lista com dados de compartilhamento dos anuncios 
	 * @param anuncio lista de anúncio
	 * @return representação textual dos compartilhamentos  
	 */
	public static String listaCompartilhamentos(controleAnuncio anuncio) {
		return anuncio.qtdMaximaDeCompartilhamentos();
	}
	/**
	 * filtro de pesquisa 
	 * @param anuncio lista de anúncios
	 * @param in stributo scanner 
	 * @return representação textual do anuncio 
	 */
	public static String filtra(controleAnuncio anuncio, Scanner in) {
		String filtro= "";
		System.out.print("(N)ome ou (D)ata: >>");
		String op = in.nextLine();
		if(op.toUpperCase().equals("N")) {
			System.out.println("Informe o nome: ");
			String nome = in.nextLine();
			
			return anuncio.relatorioPorNome(nome);
		}else if (op.toUpperCase().equals("D")) {
			System.out.println("FORMATO DA DATA >> dd/mm/aaaa <<");
			System.out.println("Informe data de Início: ");
			String inicio = in.nextLine();
			System.out.println("Informe data de Término: ");
			String fim = in.nextLine();
			 return anuncio.relatorioPorPeriodoDeTempo(inicio, fim);
		}
		return "Não encontrado";
	}
	
}
