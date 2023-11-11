package negocio;

public class Apartamento extends Imovel {
	private double precoCondominio;
	private boolean areaDeConvivencia;
	private int andar;
	private boolean pet;
	public Apartamento(String endereco, double tamanhoImovel, String descricao, double valorDoImovel,
			String dataPublicacao, String tipoDeVenda, double precoCondominio, boolean areaDeConvivencia, int andar,
			boolean pet) {
		super(endereco, tamanhoImovel, descricao, valorDoImovel, dataPublicacao, tipoDeVenda);
		this.precoCondominio = precoCondominio;
		this.areaDeConvivencia = areaDeConvivencia;
		this.andar = andar;
		this.pet = pet;
	}
	
	public double calcularValorTotalDoApartamento(double precoCondominio, double valorDoImovel) {
		return precoCondominio+getValorDoImovel();
	}
	
	
	public double getPrecoCondominio() {
		return precoCondominio;
	}
	public void setPrecoCondominio(double precoCondominio) {
		this.precoCondominio = precoCondominio;
	}
	public boolean isAreaDeConvivencia() {
		return areaDeConvivencia;
	}
	public void setAreaDeConvivencia(boolean areaDeConvivencia) {
		this.areaDeConvivencia = areaDeConvivencia;
	}
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public boolean isPet() {
		return pet;
	}
	public void setPet(boolean pet) {
		this.pet = pet;
	}
	
}
