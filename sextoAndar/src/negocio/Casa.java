package negocio;

public class Casa extends Imovel {
	private double precoTerreno;
	private boolean casaUnicaNoTerreno;
	public Casa(String endereco, double tamanhoImovel, String descricao, double valorDoImovel, String dataPublicacao,
			TipoDeVenda tipoDeVenda, double precoTerreno, boolean casaUnicaNoTerreno) {
		super(endereco, tamanhoImovel, descricao, valorDoImovel, dataPublicacao, tipoDeVenda);
		this.precoTerreno = precoTerreno;
		this.casaUnicaNoTerreno = casaUnicaNoTerreno;
	}
	public String toString() {
		return "Tipo de Imóvel selecionado: Casa\n" +
			"Endereço: " + getEndereco() + "\n" +
			"Tamanho do Imóvel: " + getTamanhoImovel() + "\n" +
			"Descrição: " + getDescricao() + "\n" +
			"Valor do Imóvel: " + getValorDoImovel() + "\n" +
			"Data de publicação: " + getDataPublicacao() + "\n" +
			"Tipo de Venda: " + (getTipoDeVenda().toString() == "ALUGUEL" ? "Aluguel" : "Venda")+ "\n" +
			"Preço do Terreno: " + getPrecoTerreno() + "\n" +
			"Casa única no terreno: " + (isCasaUnicaNoTerreno() ? "Sim" : "Não")+"\n";
	}
	
	
	public double getPrecoTerreno() {
		return precoTerreno;
	}
	public boolean isCasaUnicaNoTerreno() {
		return casaUnicaNoTerreno;
	}
	public void setPrecoTerreno(double precoTerreno) {
		this.precoTerreno = precoTerreno;
	}
	public void setCasaUnicaNoTerreno(boolean casaUnicaNoTerreno) {
		this.casaUnicaNoTerreno = casaUnicaNoTerreno;
	}
	
}
