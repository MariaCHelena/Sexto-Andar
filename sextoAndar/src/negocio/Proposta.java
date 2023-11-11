package negocio;

public class Proposta {
	private String data;
	private double valorProposta;
	private String autor;
	private Imovel imovel;
	public Proposta(String data, double valorProposta, String autor, Imovel imovel) {
		super();
		this.data = data;
		this.valorProposta = valorProposta;
		this.autor = autor;
		this.imovel = imovel;
	}
	
	
}
