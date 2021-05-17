import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 * 
 * @author lindemberg Rodrigues 
 *
 */
public class controleAnuncio {
	/**
	 * Arraylist com a lista de anuncios 
	 */
	ArrayList<Anuncio> listaDeAnuncio = new ArrayList<>();
	
	/**
	 * realiza o cadasto dos anuncios
	 * @param nomeAnuncio, nome do anuncio
	 * @param cliente, nome do cliente 
	 * @param DataInicio, data de inicio de divulgação do anunci o
	 * @param dataFim, data do fim da divulgação do anuncio
	 * @param investimento, o valor a ser investido  
	 * @return a confirmação ou falha do cadastro
	 */
	public String  cadastraString(Anuncio dadosAnuncio) {
		Anuncio anuncio = dadosAnuncio;
		listaDeAnuncio.add(anuncio);
		return "Anúncio cadastrado";
	}
	
	/**
	 * quantidade maxima que o anuncio irá ter 
	 * @return a quatidade de vezes que o anúncio foi visto 
	 */
	public String qtdMaximaDeVisualizacoes() {
		String visualizacao = "<ANUNCIO - CLIENTE - QTD MAXIMA DE VISUALIZAÇÃO>\n";
		
		for (int i=0; i < listaDeAnuncio.size(); i++) {
			visualizacao+= listaDeAnuncio.get(i).getNomeAnuncio()+ " - " +listaDeAnuncio.get(i).getNomeCliente() + " - "+ listaDeAnuncio.get(i).qtdTotalDeVisualizacoes()+"\n";
		}
		return visualizacao;
	}
	
	/**
	 * quantidade de vezes qeu o anúncio foi clicado 
	 * @return a quantidade de vezes que foi clicado 
	 */
	public String qtdMaximaDeCliques() {
		String cliques = "<ANUNCIO - CLIENTE - QTD MAXIMA DE CLIQUES>\n";
		
		for (int i=0; i < listaDeAnuncio.size(); i++) {
			cliques+= listaDeAnuncio.get(i).getNomeAnuncio()+ " - " +listaDeAnuncio.get(i).getNomeCliente() + " - "+ listaDeAnuncio.get(i).qtdTotalCliques()+"\n";
		}
		return cliques;
	}
	
	/**
	 * a quantidade máxima de compartilhamentos que o anúncio pode ter
	 * @return a quantidade de compartilhamentos 
	 */
	public String qtdMaximaDeCompartilhamentos() {
		String compartilhar = "<ANUNCIO - CLIENTE - QTD MAXIMA DE COMPARTILHAMENTOS>\n";
		
		for (int i=0; i < listaDeAnuncio.size(); i++) {
			compartilhar+= listaDeAnuncio.get(i).getNomeAnuncio()+ " - " +listaDeAnuncio.get(i).getNomeCliente() + " - "+ listaDeAnuncio.get(i).qtdTotalCompartilhamento()+"\n";
		}
		return compartilhar;
	}
	
	/**
	 * quantidade investida no anuncio
	 * @return o valor total do investimento
	 */
	public String  totalInvestido () {
		String investido = "<ANUNCIO - CLIENTE - TOTAL INVESTIDO>\n";
		
		for (int i=0; i < listaDeAnuncio.size(); i++) {
			investido+= listaDeAnuncio.get(i).getNomeAnuncio()+ " - " +listaDeAnuncio.get(i).getNomeCliente() + " - "+ listaDeAnuncio.get(i).getValorInvestido()+"\n";
		}
		return investido;
	}

	/**
	 * relatório com os dados do anuncio filtrado pelo nome do anuncio
	 * @param nome do anuncio a ser exibido 
	 * @return os dados do anúncio
	 */
	public String relatorioPorNome(String nome) {
		String relatorio ="";
		
		for (int i =0 ; i< listaDeAnuncio.size(); i++) {
			if (listaDeAnuncio.get(i).getNomeCliente().equals(nome)) {
				relatorio += listaDeAnuncio.get(i).toString()+"\n";		
			}
		}
		
		return relatorio;
	}
	
	/**
	 * relatório com os dados do anuncio filtrado pelo período de tempo  do anuncio
	 * @param nome do anuncio a ser exibido 
	 * @return os dados do anúncio
	 */
	public String relatorioPorPeriodoDeTempo(String inicio, String fim) {
		String relatorio ="";
		
		for (int i =0 ; i< listaDeAnuncio.size(); i++) {
			if (listaDeAnuncio.get(i).getDatainicio().equals(inicio) && listaDeAnuncio.get(i).getDataFim().equals(fim)) {
				relatorio += listaDeAnuncio.get(i).toString()+"\n";		
			}
		}
		
		return relatorio;
	}

	
	
	
}
