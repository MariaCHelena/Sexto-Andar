package classes;

public abstract class Imovel {
	protected String endereco;
	protected double tamanhoImovel;
	protected String descricao;
	protected double valorDoImovel;
	protected String dataPublicacao;
	protected String tipoDeVenda;
	public Imovel(String endereco, double tamanhoImovel, String descricao,
			double valorDoImovel, String dataPublicacao, String tipoDeVenda) {
		this.endereco = endereco;
		this.tamanhoImovel = tamanhoImovel;
		this.descricao = descricao;
		this.valorDoImovel = valorDoImovel;
		this.dataPublicacao = dataPublicacao;
		this.tipoDeVenda = tipoDeVenda;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getTamanhoImovel() {
		return tamanhoImovel;
	}
	public void setTamanhoImovel(double tamanhoImovel) {
		this.tamanhoImovel = tamanhoImovel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorDoImovel() {
		return valorDoImovel;
	}
	public void setValorDoImovel(double valorDoImovel) {
		this.valorDoImovel = valorDoImovel;
	}
	public String getTipoDeVenda() {
		return tipoDeVenda;
	}
	public void setTipoDeVenda(String tipoDeVenda) {
		this.tipoDeVenda = tipoDeVenda;
	}
	
	
}
