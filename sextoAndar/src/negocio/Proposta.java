package negocio;

public class Proposta {
	private String data;
	private double valorProposta;
	private Usuario usuario;
	private Imovel imovel;
	public Proposta(String data, double valorProposta, Usuario usuario, Imovel imovel) {
		super();
		this.data = data;
		this.valorProposta = valorProposta;
		this.usuario = usuario;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	
}
