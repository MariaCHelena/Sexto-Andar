package negocio;

public abstract class Imovel {
	protected String endereco;
	protected double tamanhoImovel;
	protected String descricao;
	protected double valorDoImovel;
	protected String dataPublicacao;
	protected TipoDeVenda tipoDeVenda;
	protected Proprietario p;
	private ArrayListPersonalizado<Proposta> propostasRegistradas = new ArrayListPersonalizado<>();
	private ArrayListPersonalizado<Visita> visitasAgendades = new ArrayListPersonalizado<>();
	public Imovel(String endereco, double tamanhoImovel, String descricao,
			double valorDoImovel, String dataPublicacao, TipoDeVenda tipoDeVenda, Proprietario p) {
		this.endereco = endereco;
		this.tamanhoImovel = tamanhoImovel;
		this.descricao = descricao;
		this.valorDoImovel = valorDoImovel;
		this.dataPublicacao = dataPublicacao;
		this.tipoDeVenda = tipoDeVenda; // true para aluguel e false para venda
		this.p = p;
	}
	public void setTipoDeVenda(TipoDeVenda tipoDeVenda) {
		this.tipoDeVenda = tipoDeVenda;
	}
	public String getEndereco() {
		return endereco;
	}
	public TipoDeVenda getTipoDeVenda() {
		return tipoDeVenda;
	}
	public double getTamanhoImovel() {
		return tamanhoImovel;
	}
	public String getDescricao() {
		return descricao;
	}
	public double getValorDoImovel() {
		return valorDoImovel;
	}
	public String getDataPublicacao() {
		return dataPublicacao;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setTamanhoImovel(double tamanhoImovel) {
		this.tamanhoImovel = tamanhoImovel;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setValorDoImovel(double valorDoImovel) {
		this.valorDoImovel = valorDoImovel;
	}
	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	
	
}
