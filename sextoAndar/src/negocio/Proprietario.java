package negocio;
import java.util.ArrayList;
import java.util.List;
public class Proprietario extends Conta{
	private List<Imovel> imoveisCadastrados = new ArrayList<>();
	
	public Proprietario(String nomeUsuario, String numeroCelular, String email, String senha) {
		super(nomeUsuario, numeroCelular, email, senha);
	}


	public boolean cadastrarImovel(Imovel i) {
		imoveisCadastrados.add(i);
		return true;
	}

	public String exibirImoveisCadastrados() {
		String mensagem = "";
		for (Imovel i : imoveisCadastrados) {
			mensagem += i;
		}
		return mensagem;
	}

	public String toString() {
		return "Conta de Proprietário" + "------------------------\n" + "Nome do usuário cadastrado: " + this.nomeUsuario + 
				"\nNúmero do celular cadastrado: " + this.numeroCelular +
				"\nEmail da conta: " + this.email + 
				"\nQuantidade de imóveis cadastrados na conta: " + imoveisCadastrados.size();
	}

}
