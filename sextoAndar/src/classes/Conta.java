package classes;

public abstract class Conta {
	protected String nomeUsuario;
	protected String numeroCelular;
	protected String email;
	public Conta(String nomeUsuario, String numeroCelular, String email) {
		this.nomeUsuario = nomeUsuario;
		this.numeroCelular = numeroCelular;
		this.email = email;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
