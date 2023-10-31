package classes;

public class Usuario extends Conta {
	private Imovel[] listaDeFavoritos;

	public Usuario(String nomeUsuario, String numeroCelular, String email, Imovel[] listaDeFavoritos) {
		super(nomeUsuario, numeroCelular, email);
		this.listaDeFavoritos = listaDeFavoritos;
	}
	
}
