package main;
import java.util.Scanner;
import negocio.*;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		ArrayList<Proprietario> listaDeProprietario = new ArrayList<>();
		ArrayList<Usuario> listaDeUsuario = new ArrayList<>();
		
		Scanner inteiro = new Scanner(System.in);
		Scanner texto = new Scanner(System.in);
		while (true) {
		System.out.print("Seja bem vindo ao Sexto Andar. Selecione a opção desejada:\n "
				+ "1. Realizar Login\n"
				+ "2. Realizar Cadastro\n"
				+ "3. Encerrar\n");
		int opcao1 = inteiro.nextInt();
		if(opcao1 == 1) {
			System.out.print("Digite seu email:\n");
			
		} else if(opcao1 == 2) {
			System.out.print("Selecione o tipo de conta que deseja cadastrar: \n"
					+ "1. Proprietario\n"
					+ "2. Usuario\n"
					+ "3. Encerrar\n");
			int opcao2 = inteiro.nextInt();
			if (opcao2 == 1) {
				System.out.print("Digite seu nome:\n");
				String nome = texto.nextLine();
				System.out.print("Digite seu numero de celular:\n");
				String celular = texto.nextLine();
				System.out.print("Digite seu email:\n");
				String email = texto.nextLine();
				System.out.print("Escolha uma senha para sua conta:\n");
				String senha = texto.nextLine();
				Proprietario conta = new Proprietario(nome,celular,email,senha);
				listaDeProprietario.add(conta);
				System.out.print("Você foi cadastrado com sucesso:\n"
						+ "1. Voltar ao menu inicial\n"
						+ "2. Encerrar\n");
				int opcao3 = inteiro.nextInt();
				if (opcao3 == 1) {continue;}
				else break;
				}
		}else if (opcao1 == 3) { //encerrar o processo
			break;
		}
		}
		texto.close();
		inteiro.close();
		System.exit(0);
	
	}
		
}
