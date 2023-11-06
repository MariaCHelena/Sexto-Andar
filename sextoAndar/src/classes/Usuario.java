package classes;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Conta {
	private List<Imovel> imoveisFavoritos = new ArrayList<>();

	public Usuario(String nomeUsuario, String numeroCelular, String email, String senha) {
		super(nomeUsuario, numeroCelular, email, senha);
	}
	
	public boolean favoritar(Imovel i) {
		imoveisFavoritos.add(i);
		return true;
	}
	
	public List<Imovel> getFavoritos() {
		return this.imoveisFavoritos;
	}
	
	
}
