package main;

import java.util.ArrayList;
import java.util.Scanner;
import negocio.Proprietario;
import negocio.Usuario;
import dados.Gerador_de_dados;

public class Main {
	public static ArrayList<Proprietario> listaDeProprietario = new ArrayList<>();
	public static ArrayList<Usuario> listaDeUsuario = new ArrayList<>();
	public static Usuario contaUsuario, keep, sc;
	public static Proprietario contaProprietario;

	public static void main(String[] args) {

		// Criando conta para facilitar os testes
		Usuario conta = new Usuario("Maria", "celular", "maria@gmail.com", "123");
		listaDeUsuario.add(conta);

		boolean keep = true;
		Scanner sc = new Scanner(System.in);
		do {
			if (contaUsuario != null || contaProprietario != null) {
				if (contaUsuario != null) {
					keep = exibirMenuLogadoUsuario(contaUsuario, keep, sc);
				}else if (contaProprietario != null) {
					keep = exibirMenuLogadoProprietario(contaProprietario, keep, sc);
				}
				//keep = (contaUsuario != null) ? exibirMenuLogadoUsuario(contaUsuario, keep, sc)
				//		: exibirMenuLogadoProprietario(contaProprietario, keep, sc);
				clearScreen();
			} else {
				keep = exibirMenuAutenticacao(keep, sc);
				clearScreen();
			}
		} while (keep);

		sc.close();
		System.out.println("Muito obrigado por usar o nosso programa!");
		System.out.println("Esse processo foi encerrado");
	}

	public static boolean exibirMenuAutenticacao(boolean keep, Scanner sc) {
		int selecaoMenu = 0;
		System.out.print("Seja bem vindo ao Sexto Andar. Selecione a opção desejada:\n" + "1. Realizar Login\n"
				+ "2. Realizar Cadastro\n" + "3. Encerrar\n");
		selecaoMenu = sc.nextInt();
		switch (selecaoMenu) {
		case 1:
			System.out.print("Selecione o tipo da sua conta:\n" + "1. Conta Usuario\n" + "2. Conta Proprietario\n");
			int selecaoLogin = sc.nextInt();

			if (selecaoLogin == 1) { // PROGRAMAR AS OPÇÕES DE USUARIO NESSE ESCOPO
				if (listaDeUsuario.size() != 0) { // Checagem provisória, verifica se existem usuários cadastrados antes
													// de fazer o login. Poderá ser removida quando os dados da
													// aplicação forem adicionados automaticamente;
					System.out.print("Digite o email cadastrado:\n");
					sc.nextLine();
					String email = sc.nextLine();
					for (Usuario p : listaDeUsuario) {
						if (p.getEmail().equals(email)) {
							System.out.print("Digite a senha da sua conta:\n");
							String senha = sc.nextLine();
							if (p.getSenha().equals(senha)) {
								contaUsuario = p;
								System.out.println("Autenticado como: " + contaUsuario.getNomeUsuario());
							} else
								System.out.print("A senha está incorreta. Reinicie o processo.\n");
						} else
							System.out.print("Esse email não está cadastrado, por favor realize o cadastro.\n");
					}
				} else {
					System.out.println("Não há usuários cadastrados no sistema!");
				}

			} else if (selecaoLogin == 2) { // PROGRAMAR AS OPÇÕES DE PROPRIETARIOS NESSE ESCOPO
				if (listaDeProprietario.size() != 0) {
					sc.nextLine();
					System.out.print("Digite o email cadastrado:\n");
					String email = sc.nextLine();
					for (int i = 0; i < listaDeProprietario.size(); i++) {
						Proprietario p = listaDeProprietario.get(i);
						if (p.getEmail().equals(email)) {
							System.out.print("Digite a senha da sua conta:\n");
							String senha = sc.nextLine();
							if (p.getSenha().equals(senha)) {
								contaProprietario = p;
								System.out.println("Autenticado como: " + contaProprietario.getNomeUsuario());
							} else
								System.out.print("A senha está incorreta. Reinicie o processo.\n");
						} else
							System.out.print("Esse email não está cadastrado, por favor realize o cadastro.\n");
					}
				} else {
					System.out.println("Não há contas de proprietários cadastradas no sistema!");
				}
			}
			break;
		case 2:
			System.out.print("Selecione o tipo de conta que deseja cadastrar: \n" + "1. Usuario\n" + "2. Proprietario\n"
					+ "3. Retornar\n");
			int selecaoCadastro = sc.nextInt();
			if (selecaoCadastro == 1) {
				sc.nextLine();
				System.out.print("Digite seu nome:\n");
				String nome = sc.nextLine();
				System.out.print("Digite seu numero de celular:\n");
				String celular = sc.nextLine();
				System.out.print("Digite seu email:\n");
				String email = sc.nextLine();
				System.out.print("Escolha uma senha para sua conta:\n");
				String senha = sc.nextLine();
				Usuario conta = new Usuario(nome, celular, email, senha);
				listaDeUsuario.add(conta);
				System.out.print("Você foi cadastrado com sucesso. \nVolte ao menu inicial para realizar seu login.\n"
						+ "1. Voltar ao menu inicial\n" + "2. Encerrar\n");
				selecaoCadastro = sc.nextInt();
				if (selecaoCadastro == 1) {
					keep = true;
				} // volta para o menu inicial
				else {
					keep = false;
				}
			} else if (selecaoCadastro == 2) {
				sc.nextLine();
				System.out.print("Digite seu nome:\n");
				String nome = sc.nextLine();
				System.out.print("Digite seu numero de celular:\n");
				String celular = sc.nextLine();
				System.out.print("Digite seu email:\n");
				String email = sc.nextLine();
				System.out.print("Escolha uma senha para sua conta:\n");
				String senha = sc.nextLine();
				Proprietario conta = new Proprietario(nome, celular, email, senha);
				listaDeProprietario.add(conta);
				System.out.print("Você foi cadastrado com sucesso. \nVolte ao menu inicial para realizar seu login.\n"
						+ "1. Voltar ao menu inicial\n" + "2. Encerrar\n");
				selecaoCadastro = sc.nextInt();
				if (selecaoCadastro == 2) {
					keep = false;
				} // Keep recebe false, retornando à função main e encerrando o programa
			}
			break;
		case 3:
			keep = false;
			break;
		default:
			System.out.println("Opção inválida. Tente novamente.\n");
			break;
		}
		return keep;
	}

	public static boolean exibirMenuLogadoUsuario(Usuario c, boolean keep, Scanner sc) {
		System.out.println("Logado como usuario: " + c.getNomeUsuario());
		System.out.print("Selecione a Opção desejada:\n" + "1 - Visualizar dados da Conta.\n" + "2 - Deslogar.\n"
				+ "3 - Sair do sistema\n");
		int selecaoConta = sc.nextInt();
		switch (selecaoConta) {
		case 1:
			clearScreen();
			System.out.println(c);
			System.out.print("Aperte qualquer botão para voltar\n");
			String a = sc.nextLine();
			if(a != null) {
				sc.nextLine(); //limpando o scanner
				break;
			}
		case 2:
			contaUsuario = null;
			break;
		case 3:
			keep = false;
			break;
		default:
			System.out.println("Opção inválida, tente novamente.\n");
			break;
		}
		return keep;
	}

	public static boolean exibirMenuLogadoProprietario(Proprietario c, boolean keep, Scanner sc) {
		System.out.println("Logado como usuario: " + c.getNomeUsuario());
		System.out.print("Selecione a Opção desejada:\n" 
				+ "1 - Visualizar dados da Conta.\n" 
				+ "2 - Deslogar.\n"
				+ "3 - Cadastrar Imovel\n"
				+ "4 - Sair do sistema\n");
		int selecaoConta = sc.nextInt();
		switch (selecaoConta) {
		case 1:
			clearScreen();
			System.out.println(c);
			System.out.print("Aperte qualquer botão para voltar\n");
			String a = sc.nextLine();
			if(a != null) {
				sc.nextLine(); //limpando o scanner
				break;
			}
		case 2:
			contaProprietario = null;
			break;
		case 3:
			
			break;
		case 4:
			keep = false;
			break;
		default:
			System.out.println("Opção inválida, tente novamente.\n");
			break;
		}
		return keep;
	}

	public static void clearScreen() {
		System.out.println("\n");
	}

}
