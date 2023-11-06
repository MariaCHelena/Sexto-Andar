package classes;

public class Proprietario extends Conta{
	private int qtdImoveis;
	private Imovel[] imoveisCadastrados = new Imovel[3];

	public Proprietario(String nomeUsuario, String numeroCelular, String email, String senha) {
		super(nomeUsuario, numeroCelular, email, senha);
		this.qtdImoveis = 0;
	}
	
	public int getQtdImovies() {
		return this.qtdImoveis;
	}
	
	public boolean cadastrarImovel(Imovel i) {
		if(qtdImoveis < 3) {
			imoveisCadastrados[qtdImoveis] = i;
			qtdImoveis++;
			return true;
		} else {
			return false;
		}
	}
	
}
