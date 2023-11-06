package classes;

public class Usuario extends Conta {
	private int qtdFavoritos;
	private Imovel[] listaDeFavoritos = new Imovel[20];

	public Usuario(String nomeUsuario, String numeroCelular, String email, String senha) {
		super(nomeUsuario, numeroCelular, email, senha);
		qtdFavoritos = 0;
	}
	
	public boolean favoritar(Imovel i) {
		if(qtdFavoritos < 20) {
			listaDeFavoritos[qtdFavoritos] = i;
			qtdFavoritos++;
			return true;
		} else {
			return false;
		}
	}
	
	public Imovel[] getFavoritos() {
		return this.listaDeFavoritos;
	}
	
	
	
}
