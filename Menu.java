import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;

	public Menu(String title, List<String> options) {
		this.title = "Menu";
		this.options = options;
	}

	public void MenuIniciar() throws Exception{
		// this.title = title;
		// this.options = options;
		Banco banco = new Banco();
		ArrayList<Cliente> clientes = new ArrayList<>();
		int op = -1;
		while (op != 0) {
			Scanner scan = new Scanner(System.in);
			System.out.println(
					"[1]-Cadastrar Cliente\n[2]-Cadastrar Conta Corrente\n[3]-Conta Poupança\n[4]-Mostrar Contas Cadastradas\n[5]-Sacar\n[6]-Depositar\n[7]-Transferir\n[8]-Extrato");
			op = scan.nextInt();
			switch (op) {
				case 1:// cadastrar cliente

					Scanner clienteScan = new Scanner(System.in);
					System.out.println("Nome: ");
					String nome = clienteScan.nextLine();
					System.out.println("Sexo: ");
					String sexo = clienteScan.nextLine();
					System.out.println("CPF: ");
					int cpf = clienteScan.nextInt();
					
					Cliente cliente = new Cliente(nome, cpf, sexo);
					boolean cad = false;
					for (Cliente c : clientes){
						if(c.getCpf() == cpf){
							cad = true;
						}
					}
					if(cad){
						System.out.println("Um cliente com mesmo CPF já existe");
					}else{
						clientes.add(cliente);
						System.out.println("Cliente cadastrado com sucesso");
					}
					
					break;

				case 2:// cadastrar conta corrente
					Conta conta;
					Scanner contaScan = new Scanner(System.in);
					System.out.println("Numero da conta: ");
					int numeroConta = contaScan.nextInt();
					System.out.println("Agencia: ");
					int agencia = contaScan.nextInt();
					System.out.println("Digite o cpf do cliente escolhido");
					int clienteEscolhido = contaScan.nextInt();
					Cliente clienteDoBanco = banco.getCliente(clientes, clienteEscolhido);

					if (clienteDoBanco != null) {
						conta = new ContaCorrente(numeroConta, agencia, clienteDoBanco);
						if(banco.CadastrarConta(conta)){
							System.out.println("Conta cadastrada com sucesso");
						}else{
							System.out.println("Numero de conta já existente, tente novamente com um número diferente");
						}
					} else {
						System.out.println("Cliente não encontrado, verifique se digitou o cpf corretamente");
					}
					break;
				case 3:// cadastrar conta poupança
					Conta contaPoupanca;
					Scanner contaPScan = new Scanner(System.in);
					System.out.println("Numero da conta: ");
					int numeroContaP = contaPScan.nextInt();
					System.out.println("Agencia: ");
					int agenciaP = contaPScan.nextInt();

					System.out.println("Digite o cpf do cliente escolhido");
					int clientePEscolhido = contaPScan.nextInt();
					Cliente clientePDoBanco = banco.getCliente(clientes, clientePEscolhido);

					if (clientePDoBanco != null) {
						contaPoupanca = new ContaPoupanca(numeroContaP, agenciaP, clientePDoBanco);
						if(banco.CadastrarConta(contaPoupanca)){
							System.out.println("Conta cadastrada com sucesso");
						}else{
							System.out.println("Numero de conta já existente, tente novamente com um número diferente");
						}
					} else {
						System.out.println("Cliente não encontrado, verifique se digitou o cpf corretamente");
					}
					break;
				case 4:// mostrar todas as contas
					banco.mostrarContas();
					break;
				
				case 5://Sacar
					Scanner contaScan5 = new Scanner(System.in);
					System.out.println("Numero da conta: ");
					int numeroConta5 = contaScan5.nextInt();
					System.out.println("Agencia: ");
					int agencia5 = contaScan5.nextInt();
					Conta contaSaque = banco.getConta(numeroConta5,agencia5);
					if (contaSaque != null){
						System.out.println("Conta identificada com sucesso\nDigite o valor a ser sacado:");
						double saqueValor = contaScan5.nextDouble();
						contaSaque.sacar(saqueValor);
					}else{
						System.out.println("Conta não encontrada");
					}
					break;

				case 6://Deposito
					Scanner contaScan6 = new Scanner(System.in);
					System.out.println("Numero da conta: ");
					int numeroConta6 = contaScan6.nextInt();
					System.out.println("Agencia: ");
					int agencia6 = contaScan6.nextInt();
					Conta contaDeposito = banco.getConta(numeroConta6,agencia6);
					if (contaDeposito != null){
						System.out.println("Conta identificada com sucesso\nDigite o valor a ser depositado:");
						double depositoValor = contaScan6.nextDouble();
						contaDeposito.deposito(depositoValor);
					}else{
						System.out.println("Conta não encontrada");
					}
					break;

				case 7://Extrato
					Scanner contaScan7 = new Scanner(System.in);
					System.out.println("Numero da conta origem: ");
					int numeroConta7 = contaScan7.nextInt();
					System.out.println("Agencia da conta origem: ");
					int agencia7 = contaScan7.nextInt();
					Conta contaOrigem = banco.getConta(numeroConta7,agencia7);
					if (contaOrigem != null){
						System.out.println("Conta identificada com sucesso\nDigite o valor a ser trasnferido:");
						double transferenciaValor = contaScan7.nextDouble();
						System.out.println("Numero da conta destino: ");
						numeroConta7 = contaScan7.nextInt();
						System.out.println("Agencia da conta destino: ");
						agencia7 = contaScan7.nextInt();
						Conta contaDestino = banco.getConta(numeroConta7,agencia7);
						if (contaDestino != null){System.out.println("Conta não encontrada");break;}
						contaOrigem.transferencia(transferenciaValor,contaDestino);
					}else{
						System.out.println("Conta não encontrada");
					}
					break;

				case 8://Extrato
					Scanner contaScan8 = new Scanner(System.in);
					System.out.println("Numero da conta: ");
					int numeroConta8 = contaScan8.nextInt();
					System.out.println("Agencia: ");
					int agencia8 = contaScan8.nextInt();
					Conta contaExtrato = banco.getConta(numeroConta8,agencia8);
					if (contaExtrato != null){
						System.out.println("Conta identificada com sucesso\nGerando Extrato...");
						System.out.println(contaExtrato.getExtrato());
					}else{
						System.out.println("Conta não encontrada");
					}
					break;

			}

		}

	}

	// public int getSelection() {
	// int op = 0;
	// while (op!=0){

	// }
	// return op;
}
