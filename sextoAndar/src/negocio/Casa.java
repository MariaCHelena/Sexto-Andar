package negocio;

public class Casa extends Imovel {
	private double valorAluguel;
	private double precoTerreno;
	private boolean casaUnicaNoTerreno;

	public Casa(String endereco, double tamanhoImovel, String descricao, double valorDoImovel, String dataPublicacao,
			TipoDeVenda tipoDeVenda, Proprietario p, TipoDeImovel tipoDeImovel, double precoTerreno,
			boolean casaUnicaNoTerreno) {
		super(endereco, tamanhoImovel, descricao, valorDoImovel, dataPublicacao, tipoDeVenda, p, tipoDeImovel);
		this.precoTerreno = precoTerreno;
		this.casaUnicaNoTerreno = casaUnicaNoTerreno;
	}

	public Casa(String endereco, double tamanhoImovel, String descricao, double valorDoImovel, double valorAlguel,
			String dataPublicacao, TipoDeVenda tipoDeVenda, Proprietario p, TipoDeImovel tipoDeImovel,
			double precoTerreno, boolean casaUnicaNoTerreno) {
		super(endereco, tamanhoImovel, descricao, valorDoImovel, dataPublicacao, tipoDeVenda, p, tipoDeImovel);
		this.valorAluguel = valorAlguel;
		this.precoTerreno = precoTerreno;
		this.casaUnicaNoTerreno = casaUnicaNoTerreno;
	}

	public String toString() {
		return "\nTipo de Imóvel selecionado: Casa\n" + "Endereço: " + getEndereco() + "\n" + "Tamanho do Imóvel: "
				+ getTamanhoImovel() + "\n" + "Descrição: " + getDescricao() + "\n" + "Valor do Imóvel: "
				+ getValorDoImovel() + "\n" + "Data de publicação: " + getDataPublicacao() + "\n" + "Tipo de Venda: "
				+ (getTipoDeVenda().toString() == "ALUGUEL" ? "Aluguel" : "Venda") + "\n" + "Preço do Terreno: "
				+ getPrecoTerreno() + "\n" + "Casa única no terreno: " + (isCasaUnicaNoTerreno() ? "Sim" : "Não") + "\n"
				+ "Proprietario: " + p.getNomeUsuario() + " (" + p.getEmail() + ")\n";
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
	public double getValorAlguel() {
		return valorAluguel;
	}
	public void setValorAlguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

}
