package dados;

import negocio.*;
import java.util.Random;

public class Gerador_de_dados {
	Random random = new Random();
	private String[] nomes = { "Ana Maria", "João Pedro", "Paulo Jose", "Louro Jose", "Maria Clara" };
	private String[] emails = { "azulmarinho@yahoo.com", "verdefloresta@gmail.com", "brancoceu@hotmail.com" };
	private String[] numeros = { "(61)9 91238-2741", "(61)9 98213-1234", "(61)9 93127-2124" };
	private String senha_geral = "123";
	private String[] endereco = { "Avenida Esbertalina Barbosa Damiani, Lote 14", "Travessa da CDL, Lote 23",
			"Rua Arlindo Nogueira, Lote 62", "Avenida Afonso Pena, lote 5", "Rua Serra de Bragança, lote 54" };
	private String[] descricao = { "Casa aconchegante com 3 quartos e jardim espaçoso.",
			"Apartamento moderno com vista para a cidade.", "Chalé encantador nas montanhas, perfeito para relaxar.",
			"Sobrado espaçoso com piscina e área de lazer.",
			"Loft urbano com design contemporâneo e localização central." };
	private String[] datas = { "15/03/2017", "22/08/2018", "07/01/2019", "14/06/2021", "03/11/2023" };
	private String[] tipodeVenda = { "Aluguel", "Venda" };

	public Usuario geradorDeUsuario() {
		Usuario user = new Usuario(nomes[random.nextInt(4)], numeros[random.nextInt(2)], emails[random.nextInt(2)],
				senha_geral);
		return user;
	}

	public Proprietario geradorDeProprietario() {
		Proprietario user = new Proprietario(nomes[random.nextInt(4)], numeros[random.nextInt(2)],
				emails[random.nextInt(2)], senha_geral);
		return user;
	}

	public Casa geradorDeCasa() {
		Casa casa = new Casa(endereco[random.nextInt(4)], random.nextDouble(132.00) + 32, descricao[random.nextInt(4)],
				random.nextDouble(2000000.00) + 541200.00, datas[random.nextInt(4)], tipodeVenda[random.nextInt(1)],
				random.nextDouble(500000.00) + 500000.00, random.nextBoolean());
		return casa;
	}
	public Apartamento geradorDeApartamento() {
		Apartamento apt = new Apartamento(endereco[random.nextInt(4)], random.nextDouble(132.00) + 32, descricao[random.nextInt(4)],
				random.nextDouble(2000000.00) + 541200.00, datas[random.nextInt(4)], tipodeVenda[random.nextInt(1)],
				random.nextDouble(400),random.nextBoolean(),random.nextInt(8),random.nextBoolean());
		return apt;
	}
}
