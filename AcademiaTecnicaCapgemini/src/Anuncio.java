import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author lindemberg
 *
 */
public class Anuncio {
	/**
	 * noem do anúncio
	 */
	private String nomeAnuncio;
	/**
	 * nome do cliente que solicitou o anúncio
	 */
	private String nomeCliente;
	/**
	 * data de inicio de divulgação
	 */
	private String datainicio;

	/**
	 * data do fim da divulgação
	 */
	private String dataFim;
	/**
	 * valor investido no anúncio
	 */
	private int valorInvestido;
	/**
	 * Quantidade de dias que será anunciados
	 */
	private int diasAnunciados;
	/**
	 * quantidade de visualizações 
	 */
	private int totalDeVisualizacoes;
	/**
	 * quantidade de cliques
	 */
	private int totalDeCliques;
	
	
	
	/**
	 * construtor do anúncio 
	 * @param anuncio, nome do anuncio
	 * @param nomeCliente, nome do cliente 
	 * @param dataInicio, data de inicio 
	 * @param dataFim, data de término
	 * @param valorInvestido, valor investido no anuncio
	 * @throws ParseException possivel erro na inserção da data 
	 */
	public Anuncio(String anuncio, String nomeCliente, String dataInicio, String dataFim, int valorInvestido)  {
		this.nomeAnuncio = anuncio;
		this.nomeCliente = nomeCliente;
		this.datainicio = dataInicio;
		this.dataFim = dataFim;
		this.valorInvestido = valorInvestido;
		
		SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		Date inicio = formate.parse(dataInicio);
		Date fim = formate.parse(dataFim);
		long tempoEmMilisegundos = fim.getTime() - inicio.getTime();
		long dias = TimeUnit.DAYS.convert(tempoEmMilisegundos, TimeUnit.MILLISECONDS);
		this.diasAnunciados =  (int)dias+1;
		}catch (Exception e) {
			System.out.println("data incorreta");
		}	 
		totalDeCliques = 0;
		totalDeVisualizacoes = 0;
		
		
	}	
	/**
	 * retorna o valor total investido
	 * @return  valor total investido
	 */
	public int getValorInvestido() {
		return valorInvestido * diasAnunciados;
	}
	
	/**
	 * retorna a quantidade máxima de visualizações 
	 * @return ao total de visualizações 
	 */
	public int qtdTotalDeVisualizacoes() {
		Calculadora calc = new Calculadora();
		totalDeVisualizacoes = calc.calculaProjecaoAnuncio(valorInvestido) * diasAnunciados;
		
		return totalDeVisualizacoes;
	}
	
	/**
	 * retorna a quantidade máxima de cliques 
	 * @return quantidade de cliques 
	 */
	public int qtdTotalCliques() {
		if (totalDeVisualizacoes == 0) {
			qtdTotalDeVisualizacoes();
		}
		Calculadora calc = new Calculadora();
		totalDeCliques = calc.calculaClickAnuncio(totalDeVisualizacoes/diasAnunciados) * diasAnunciados;
		
		return totalDeVisualizacoes;
	}
	
	/**
	 * retorna a quantidade máxima de compartilhamentos 
	 * @return quantidade de compartilhamentos 
	 */
	public int qtdTotalCompartilhamento() {
		if (totalDeCliques == 0) {
			qtdTotalCliques();
		}
		Calculadora calc = new Calculadora();
		
		return calc.qtdCompartilhamentosAnuncio(totalDeCliques/diasAnunciados) * diasAnunciados;
	}
	
	/**
	 * retorna o nome do anúncio
	 * @return nome do anuncio
	 */
	public String getNomeAnuncio() {
		return nomeAnuncio;
	}

	/**
	 * retorna o nome do cliente 
	 * @return nome do cliente 
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}
	/**
	 * retorna a data de inicio do anúncio
	 * @return a data do início
	 */
	public String getDatainicio() {
		return datainicio;
	}
	
	/**
	 * retorna a data de término do anúncio
	 * @return a data do término
	 */
	public String getDataFim() {
		return dataFim;
	}
	
	/**
	 * representação textual do anúncio
	 */
	public String toString() {
		return "Anúncio: " + nomeAnuncio + " - Cliente: " +nomeCliente + "Perído de tempo: "+ datainicio + " até " + dataFim + " - Valor total Investido: "+ valorInvestido + " - Quant. máxima de visualizações: " + 
	totalDeVisualizacoes + " - TQuant. máxima de Cliques: " + totalDeCliques + " - Quant. máxima de compartilhamento: " +  qtdTotalCompartilhamento();
	}
	
}
