package negocio;

public class Casa extends Imovel {
	private double precoTerreno;
	private boolean casaUnicaNoTerreno;
	public Casa(String endereco, double tamanhoImovel, String descricao, double valorDoImovel, String dataPublicacao,
			String tipoDeVenda, double precoTerreno, boolean casaUnicaNoTerreno) {
		super(endereco, tamanhoImovel, descricao, valorDoImovel, dataPublicacao, tipoDeVenda);
		this.precoTerreno = precoTerreno;
		this.casaUnicaNoTerreno = casaUnicaNoTerreno;
	}
	
}
