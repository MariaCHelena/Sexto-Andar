package classes;

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
	
}
