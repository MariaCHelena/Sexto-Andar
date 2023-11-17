package main;
import java.time.LocalDate;
import java.util.Scanner;

import dados.Gerador_de_dados;
import negocio.Apartamento;
import negocio.ArrayListPersonalizado;
import negocio.Casa;
import negocio.Conta;
import negocio.Proprietario;
import negocio.TipoConta;
import negocio.TipoDeVenda;
import negocio.Usuario;

public class Main {
	public static ArrayListPersonalizado<Proprietario> listaDeProprietario = new ArrayListPersonalizado<>();
	public static ArrayListPersonalizado<Usuario> listaDeUsuario = new ArrayListPersonalizado<>();
	public static Usuario contaUsuario, keep, sc;
	public static Proprietario contaProprietario;
	public static void main(String[] args) {
		for (int i = 0; i <10 ; i++) {
			listaDeProprietario.add(Gerador_de_dados.geradorDeProprietario()); //gerando contas de proprietarios e imoveis
		} 
		// System.out.print(listaDeProprietario);
		// Criando conta para facilitar os testes
		Usuario conta = new Usuario("Maria", "celular", "maria@gmail.com", "123");
		Proprietario prop = new Proprietario("Victor","931293912", "victor@gmail.com", "123");
		listaDeUsuario.add(conta);
		listaDeProprietario.add(prop);
		
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
				System.out.println("");
			} else {
				keep = exibirMenuAutenticacao(keep, sc);
				System.out.println("");
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
						}	
					}
					if(contaUsuario == null) {
						System.out.println("Não há uma conta cadastrada com este email no sistema.");
					}
				} else {
					System.out.println("Não há contas de usuário cadastradas no sistema. Por favor, efetue um cadastro.");
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
						}
					}
					if(contaProprietario == null) {
						System.out.println("Não há uma conta cadastrada com este email no sistema.");
					}
				} else {
					System.out.println("Não há contas de proprietário cadastradas no sistema. Por favor, efetue o cadastro.");
				}
			}
			break;
		case 2:
			System.out.print("Selecione o tipo de conta que deseja cadastrar: \n" + "1. Usuario\n" + "2. Proprietario\n"
					+ "3. Retornar\n");
			int selecaoCadastro = sc.nextInt();
			TipoConta contaSelecionada = null;
			if (selecaoCadastro == 1) {
				contaSelecionada = TipoConta.USUARIO;
				cadastrarConta(sc, contaSelecionada);
				System.out.print("Você foi cadastrado com sucesso. \nVolte ao menu inicial para realizar seu login.\n"
						+ "1. Voltar ao menu inicial\n" + "2. Encerrar\n");
				selecaoCadastro = sc.nextInt();
				if (selecaoCadastro == 2) {
					keep = false;
				}
			} else if (selecaoCadastro == 2) {
				contaSelecionada = TipoConta.PROPRIETARIO;
				cadastrarConta(sc, contaSelecionada);
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
			System.out.println("Opção inválida. Pressione qualquer tecla para continuar.\n");
			String abc = sc.nextLine();
			if(abc != null) {
				sc.nextLine(); //limpando o scanner
				break;
			}
		}
		return keep;
	}

	public static boolean exibirMenuLogadoUsuario(Usuario u, boolean keep, Scanner sc) {
		System.out.println("Logado como usuario: " + u.getNomeUsuario());
		System.out.print("Selecione a Opção desejada:\n" 
				+ "1 - Visualizar dados da Conta.\n" 
				+ "2 - Deslogar.\n"
				+ "3 - Sair do sistema\n");
		int selecaoConta = sc.nextInt();
		switch (selecaoConta) {
		case 1:
			System.out.println("");
			System.out.println(u);
			System.out.print("Deseja editar seus dados? (s/n): ");
			sc.nextLine(); // limpando o scanner
			String selecaoResposta = sc.nextLine();
			if(selecaoResposta.toLowerCase().charAt(0) == 's') {
				System.out.print("Digite seu nome:\n");
				String nome = sc.nextLine();
				System.out.print("Digite seu numero de celular:\n");
				String celular = sc.nextLine();
				System.out.print("Digite seu email:\n");
				String email = sc.nextLine();
				System.out.print("Escolha uma nova senha para sua conta:\n");
				String senha = sc.nextLine();
				u.setNomeUsuario(nome);
				u.setNumeroCelular(celular);
				u.setEmail(email);
				u.setSenha(senha);
				System.out.println("Dados alterados com sucesso.");
				break;
			} else {
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
				+ "2 - Cadastrar Imovel.\n"
				+ "3 - Visualizar Imoveis\n"
				+ "4 - Deslogar\n"
				+ "5 - Sair do sistema\n");
		int selecaoConta = sc.nextInt();
		switch (selecaoConta) {
		case 1:
			System.out.println("");
			System.out.println(c);
			System.out.print("Deseja editar seus dados? (s/n): ");
			sc.nextLine(); // limpando o scanner
			String selecaoResposta = sc.nextLine();
			if(selecaoResposta.toLowerCase().charAt(0) == 's') {
				System.out.print("Digite seu nome:\n");
				String nome = sc.nextLine();
				System.out.print("Digite seu numero de celular:\n");
				String celular = sc.nextLine();
				System.out.print("Digite seu email:\n");
				String email = sc.nextLine();
				System.out.print("Escolha uma nova senha para sua conta:\n");
				String senha = sc.nextLine();
				c.setNomeUsuario(nome);
				c.setNumeroCelular(celular);
				c.setEmail(email);
				c.setSenha(senha);
				System.out.println("Dados alterados com sucesso.");
				break;
			} else {
				break;
			}
		case 2:
			System.out.print("Selecione o tipo de imovel que você deseja cadastrar;\n"
					+ "1 - Casa\n"
					+ "2 - Apartamento\n");
			int tipo = sc.nextInt();
			sc.nextLine(); //limpando o scanner
			switch(tipo) {
			case 1:
				System.out.print("Digite o endereço no qual se localiza a casa:\n");
		        String endereco = sc.nextLine();
		        System.out.print("Digite o tamanho do seu imovel em metros quadrados:\n");
		        double tamanhoimovel = sc.nextDouble();
		        sc.nextLine(); // Limpa o buffer do scanner
		        System.out.print("Descreva em poucas palavras uma breve descrição do imovel:\n");
		        String descricao = sc.nextLine();
		        System.out.print("Digite o valor do imovel em reais:\n");
		        double valorimovel = sc.nextDouble();
		        sc.nextLine(); // Limpa o buffer do scanner
		        LocalDate datanostring = LocalDate.now(); 
		        String data = datanostring.toString();
		        System.out.print("Qual o tipo de venda do seu imovel:\n"
		                + "1 - Aluguel\n"
		                + "2 - Venda\n");
		        int opcao = sc.nextInt();
		        sc.nextLine(); //limpando buffer
		        TipoDeVenda tipoDeVenda = null;
		        switch(opcao) {
		            case 1: tipoDeVenda = TipoDeVenda.ALUGUEL; break;
		            case 2: tipoDeVenda = TipoDeVenda.VENDA; break;
		            default:
		                System.out.println("Opção inválida, pressione qualquer tecla para continuar.\n");
		                String anychar = sc.nextLine(); // Limpa o buffer do scanner
		                if (anychar != null ) break;
		        }
		        if (opcao != 1 && opcao != 2) break; //encerrando processo por erro do usuario
				System.out.print("Digite o preço do terreno em que o Imovel se localiza:\n");
				double precoTerreno = sc.nextDouble();
				sc.nextLine(); // Limpa o buffer do scanner
				System.out.print("É a única casa no terreno:\n"
						+ "1 - Sim\n"
						+ "2 - Não\n");
				boolean casaUnicaTerreno = true;
				int opcao1 = sc.nextInt();
				sc.nextLine(); // limpando buffer
				switch(opcao1) {
					case 1: casaUnicaTerreno = true; break;
					case 2: casaUnicaTerreno = false; break;
					default:
						System.out.println("Opção inválida, pressione qualquer tecla para continuar.\n");
						String h = sc.nextLine();
						if(h != null) {
							sc.nextLine(); //limpando o scanner
							break;
						}
				}
				if (opcao1 != 1 && opcao1 != 2) break; //encerrando processo por erro do usuario
				Casa casa = new Casa(endereco,tamanhoimovel,descricao,valorimovel,data,
						tipoDeVenda,precoTerreno,casaUnicaTerreno);
				contaProprietario.cadastrarImovel(casa);
				System.out.print("Seu imovel foi cadastrado com sucesso.\n");
				System.out.println("Aperte qualquer tecla para continuar\n");
				String g = sc.nextLine();
				if(g != null) {
					sc.nextLine(); //limpando o scanner
					break;
				}
				break;
			case 2:
				System.out.print("Digite o endereço no qual se localiza o apartamento:\n");
		        String endereco1 = sc.nextLine();
		        System.out.print("Digite o tamanho do seu imovel em metros quadrados:\n");
		        double tamanhoimovel1 = sc.nextDouble();
		        sc.nextLine(); // Limpa o buffer do scanner
		        System.out.print("Descreva em poucas palavras uma breve descrição do imovel:\n");
		        String descricao1 = sc.nextLine();
		        System.out.print("Digite o valor do imovel em reais:\n");
		        double valorimovel1 = sc.nextDouble();
		        sc.nextLine(); // Limpa o buffer do scanner
		        LocalDate datanostring1 = LocalDate.now(); 
		        String data1 = datanostring1.toString();
		        System.out.print("O condominio possui area de convivencia:\n"
		                + "1 - Sim\n"
		                + "2 - Não\n");
		        int opcao2 = sc.nextInt();
		        sc.nextLine(); // limpando scanner
		        boolean areaconvivencia = (opcao2 == 1? true : false);
		        switch(opcao2) {
		            case 1: areaconvivencia = true; break;
		            case 2: areaconvivencia = false; break;
		            default:
		                System.out.println("Opção inválida, pressione qualquer tecla para continuar.\n");
		                sc.nextLine(); // Limpa o buffer do scanner
		                break;
		        }
		        if (opcao2 != 1 && opcao2 != 2) break; //encerrando processo por erro do usuario
		        System.out.println("Selecione o tipo de venda: " + "\n1 - Aluguel\n2 - Venda");
		        int opcao6 = sc.nextInt();
		        sc.nextLine(); //limpando buffer
		        TipoDeVenda tipoDeVendaApartamento = null;
		        switch(opcao6) {
		            case 1: tipoDeVendaApartamento = TipoDeVenda.ALUGUEL; break;
		            case 2: tipoDeVendaApartamento = TipoDeVenda.VENDA; break;
		            default:
		                System.out.println("Opção inválida, pressione qualquer tecla para continuar.\n");
		                sc.nextLine(); // Limpa o buffer do scanner
		                break;
		        }
		        if (opcao6 != 1 && opcao6 != 2) break; //encerrando processo por erro do usuario
				System.out.print("Digite o preço do terreno em que o Imovel se localiza:\n");
				double precoCondominio = sc.nextDouble();
				sc.nextLine(); // Limpa o buffer do scanner
				System.out.print("É permitido animais:\n"
						+ "1 - Sim\n"
						+ "2 - Não\n");
				int opcao9 = sc.nextInt();
				boolean pet = (opcao9 == 1 ? true : false);
				switch(opcao9) {
					case 1: pet = true; break;
					case 2: pet = false; break;
					default:
						System.out.println("Opção inválida, pressione qualquer tecla para continuar.\n");
						String h = sc.nextLine();
						if(h != null) {
							sc.nextLine(); //limpando o scanner
							break;
						}
				}
				if (opcao9 != 1 && opcao9 != 2) break; //encerrando processo por erro do usuario
				System.out.print("Digite em qual andar se localiza o apartamento:\n");
				int andar = sc.nextInt(); 
				Apartamento aptm = new Apartamento(endereco1,tamanhoimovel1,descricao1,valorimovel1,data1,
						tipoDeVendaApartamento,precoCondominio,areaconvivencia,andar,pet);
				contaProprietario.cadastrarImovel(aptm);
				System.out.print("Seu imovel foi cadastrado com sucesso.\n");
				System.out.println("Aperte qualquer tecla para continuar\n");
				String j = sc.nextLine();
				if(j != null) {
					sc.nextLine(); //limpando o scanner
					break;
				}
				break;
			default:
				System.out.println("Opção inválida, pressione qualquer tecla para continuar.\n");
				String ab = sc.nextLine();
				if(ab != null) {
					sc.nextLine(); //limpando o scanner
					break;
				}
			}
			break;
		case 3:
			System.out.print(contaProprietario.getImoveisCadastrados());
			System.out.println("Pressione qualuqer tecla para retornar\n");
			String z = sc.nextLine();
			if(z != null) {
				sc.nextLine(); //limpando o scanner
				break;
			}
			break;
		case 4:
			contaProprietario = null;
			break;
		case 5:
			keep = false;
			break;
		default:
			System.out.println("Opção inválida, pressione qualquer tecla para continuar.\n");
			String ab = sc.nextLine();
			if(ab != null) {
				sc.nextLine(); //limpando o scanner
				break;
			}
		}
		return keep;
	}

	public static void cadastrarConta(Scanner sc, TipoConta contaSelecionada) {
		sc.nextLine();
		System.out.print("Digite seu nome:\n");
		String nome = sc.nextLine();
		System.out.print("Digite seu numero de celular:\n");
		String celular = sc.nextLine();
		System.out.print("Digite seu email:\n");
		String email = sc.nextLine();
		System.out.print("Escolha uma senha para sua conta:\n");
		String senha = sc.nextLine();
		switch(contaSelecionada) {
			case USUARIO:
				Usuario contaUsuario = new Usuario(nome, celular, email, senha);
				listaDeUsuario.add(contaUsuario);
				break;
			case PROPRIETARIO:
				Proprietario contaProprietario = new Proprietario(nome, celular, email, senha);
				listaDeProprietario.add(contaProprietario);
				break;
		}
		return;
	}

}
