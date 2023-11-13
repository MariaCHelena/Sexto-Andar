package main;

import java.util.Scanner;
import negocio.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Proprietario> listaDeProprietario = new ArrayList<>();
		ArrayList<Usuario> listaDeUsuario = new ArrayList<>();
		Proprietario user1 = null; // caso o usuario logado seja proprietario
		Usuario user2 = null; // caso o usuario logado seja um usuario comum
		Scanner inteiro = new Scanner(System.in);
		Scanner texto = new Scanner(System.in);
		while (true) { // esse while é encerrado nos breaks
			System.out.print("Seja bem vindo ao Sexto Andar. Selecione a opção desejada:\n " 
					+ "1. Realizar Login\n"
					+ "2. Realizar Cadastro\n" 
					+ "3. Encerrar\n");
			int opcao1 = inteiro.nextInt();
			if (opcao1 == 1) {
				System.out.print("Selecione o tipo da sua conta:\n" 
						+ "1. Conta Usuario\n" 
						+ "2. Conta Proprietario\n");
				int opcao3 = inteiro.nextInt();
				if (opcao3 == 1) { //PROGRAMAR AS OPÇÕES DE USUARIO NESSE ESCOPO
					System.out.print("Digite o email cadastrado:\n");
					String email = texto.nextLine();
					for (int i = 0; i < listaDeUsuario.size(); i++) {
						Usuario p = listaDeUsuario.get(i);
						if (p.getEmail().equals(email)) {
							System.out.print("Digite a senha da sua conta:\n");
							String senha = texto.nextLine();
							if (p.getSenha().equals(senha)) {
								user2 = p;
							} else
								System.out.print("A senha está incorreta. Reinicie o processo.\n");
						} else
							System.out.print("Esse email não está cadastrado, por favor realize o cadastro.\n");
					}
				} else if (opcao3 == 2) { //PROGRAMAR AS OPÇÕES DE PROPRIETARIOS NESSE ESCOPO
					System.out.print("Digite o email cadastrado:\n");
					String email = texto.nextLine();
					for (int i = 0; i < listaDeProprietario.size(); i++) {
						Proprietario p = listaDeProprietario.get(i);
						if (p.getEmail().equals(email)) {
							System.out.print("Digite a senha da sua conta:\n");
							String senha = texto.nextLine();
							if (p.getSenha().equals(senha)) {
								user1 = p;
							} else
								System.out.print("A senha está incorreta. Reinicie o processo.\n");
						} else
							System.out.print("Esse email não está cadastrado, por favor realize o cadastro.\n");
					}
				}

			} else if (opcao1 == 2) {
				System.out.print("Selecione o tipo de conta que deseja cadastrar: \n" 
						+ "1. Usuario\n"
						+ "2. Proprietario\n" 
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
					Usuario conta = new Usuario(nome, celular, email, senha);
					listaDeUsuario.add(conta);
					System.out.print("Você foi cadastrado com sucesso:\n" 
							+ "1. Voltar ao menu inicial\n" 
							+ "2. Encerrar\n");
					int opcao3 = inteiro.nextInt();
					if (opcao3 == 1) {
						continue;
					} // volta para o menu inicial
					else
						break; // encerra o programa
				} else if (opcao2 == 2) {
					System.out.print("Digite seu nome:\n");
					String nome = texto.nextLine();
					System.out.print("Digite seu numero de celular:\n");
					String celular = texto.nextLine();
					System.out.print("Digite seu email:\n");
					String email = texto.nextLine();
					System.out.print("Escolha uma senha para sua conta:\n");
					String senha = texto.nextLine();
					Proprietario conta = new Proprietario(nome, celular, email, senha);
					listaDeProprietario.add(conta);
					System.out.print("Você foi cadastrado com sucesso:\n" 
							+ "1. Voltar ao menu inicial\n" 
							+ "2. Encerrar\n");
					int opcao3 = inteiro.nextInt();
					if (opcao3 == 1) {
						continue;
					} // volta para o menu inicial
					else
						break; // encerra o programa
				}
			} else if (opcao1 == 3) { // encerrar o processo
				break;
			}
		}
		texto.close();
		inteiro.close();
		System.exit(0);

	}

}
