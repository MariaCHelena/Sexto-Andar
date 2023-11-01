package dados;
import classes.Usuario;
import classes.Proprietario;
import classes.Imovel;
import classes.Apartamento;
import classes.Casa;
import java.util.Random;
public class Gerador_de_dados {
	public static Proprietario gerarProprietarioAleatorio() {
        Random random = new Random();
        String[] nomes = {"João", "Maria", "José", "Ana", "Pedro", "Mariana"};
        String nomeUsuario = nomes[random.nextInt(nomes.length)];
        String numeroCelular = "9" + (10000000 + random.nextInt(90000000));
        String email = nomeUsuario.toLowerCase() + "aleatorio.com";
        Imovel[] imoveisCadastrados = gerarImoveisAleatorios(random.nextInt(5) + 1); // Gera de 1 a 5 imóveis
        return new Proprietario(nomeUsuario, numeroCelular, email, imoveisCadastrados);
    }
	public static Usuario gerarUsuarioAleatorio() {
        Random random = new Random();
        String[] nomes = {"Fulano", "Ciclano", "Beltrano", "José", "Maria", "Ana"};
        String nomeUsuario = nomes[random.nextInt(nomes.length)];
        String numeroCelular = "9" + (10000000 + random.nextInt(90000000));
        String email = nomeUsuario.toLowerCase() + "@example.com";
        Imovel[] listaDeFavoritos = gerarImoveisAleatorios(random.nextInt(5) + 1); // Gera de 1 a 5 imóveis
        return new Usuario(nomeUsuario, numeroCelular, email, listaDeFavoritos);
    }
	
	public static Imovel[] gerarImoveisAleatorios(int quantidade) {
	    Imovel[] imoveis = new Imovel[quantidade];
	    Random random = new Random();
	    for (int i = 0; i < quantidade; i++) {
	        String endereco = "Endereço " + (i + 1);
	        double tamanhoImovel = 100 + random.nextInt(400);
	        String descricao = "Descrição do imóvel " + (i + 1);
	        double valorDoImovel = 100000 + random.nextInt(400000);
	        String dataPublicacao = "01-01-2023"; // Insira a data desejada
	        String tipoDeVenda = "Venda";
	        if (random.nextBoolean()) {
	            double precoTerreno = 50000 + random.nextInt(200000);
	            boolean casaUnicaNoTerreno = random.nextBoolean();
	            imoveis[i] = new Casa(endereco, tamanhoImovel, descricao, valorDoImovel, dataPublicacao, tipoDeVenda, precoTerreno, casaUnicaNoTerreno);
	        } else {
	            double precoCondominio = 500 + random.nextInt(2000);
	            boolean areaDeConvivencia = random.nextBoolean();
	            int andar = random.nextInt(20) + 1;
	            boolean pet = random.nextBoolean();
	            imoveis[i] = new Apartamento(endereco, tamanhoImovel, descricao, valorDoImovel, dataPublicacao, tipoDeVenda, precoCondominio, areaDeConvivencia, andar, pet);
	        }
	    }
	    return imoveis;
	}


}
