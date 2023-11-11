package negocio;

public class Proprietario extends Conta{
	private Imovel[] imoveisCadastrados;

	public Proprietario(String nomeUsuario, String numeroCelular, String email, Imovel[] imoveisCadastrados) {
		super(nomeUsuario, numeroCelular, email);
		this.imoveisCadastrados = imoveisCadastrados;
	}
	
	public int qtdImoveisCadastrados() {
		return imoveisCadastrados.length;
	}
	
}