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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getValorProposta() {
		return valorProposta;
	}
	public void setValorProposta(double valorProposta) {
		this.valorProposta = valorProposta;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	
}
