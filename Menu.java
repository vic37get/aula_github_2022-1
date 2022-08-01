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
					"[1]-Cadastrar Cliente/n[2]-Cadastrar Conta Corrente/n[3]-Conta Poupança/n[4]-Mostrar Contas Cadastradas/n[5]-Sacar");
			op = scan.nextInt();
			switch (op) {
				case 1:// cadastrar cliente

					Scanner clienteScan = new Scanner(System.in);
					String nome = clienteScan.nextLine();
					int cpf = clienteScan.nextInt();
					String sexo = clienteScan.nextLine();
					Cliente cliente = new Cliente(nome, cpf, sexo);
					clientes.add(cliente);

					break;

				case 2:// cadastrar conta corrente
					Conta conta;
					Scanner contaScan = new Scanner(System.in);
					int numeroConta = contaScan.nextInt();
					int agencia = contaScan.nextInt();
					int i = 1;
					for (Cliente clienteEscolhido : clientes) {
						System.out.println(i + "-" + clienteEscolhido.getNome() + "cpf: " + clienteEscolhido.getCpf());
					}

					System.out.println("Digite o cpf do cliente escolhido");
					int clienteEscolhido = contaScan.nextInt();
					Cliente clienteDoBanco = banco.getCliente(clientes, clienteEscolhido);

					if (clienteDoBanco != null) {
						conta = new ContaCorrente(numeroConta, agencia, clienteDoBanco);
						System.out.println("Conta cadastrada com sucesso");
						banco.CadastrarConta(conta);
					} else {
						System.out.println("Cliente não encontrado, verifique se digitou o cpf corretamente");
					}

					// clientes.contains();
					// Cliente cliente = new Cliente(nome,cpf,sexo);
					// clientes.add(cliente);
					break;
				case 3:// cadastrar conta poupança
					Conta contaPoupanca;
					Scanner contaPScan = new Scanner(System.in);
					int numeroContaP = contaPScan.nextInt();
					int agenciaP = contaPScan.nextInt();
					int numCliente = 1;
					for (Cliente clientePEscolhido : clientes) {
						System.out.println(
								numCliente + "-" + clientePEscolhido.getNome() + "cpf: " + clientePEscolhido.getCpf());
					}

					System.out.println("Digite o cpf do cliente escolhido");
					int clientePEscolhido = contaPScan.nextInt();
					Cliente clientePDoBanco = banco.getCliente(clientes, clientePEscolhido);

					if (clientePDoBanco != null) {
						contaPoupanca = new ContaPoupanca(numeroContaP, agenciaP, clientePDoBanco);
						System.out.println("Conta cadastrada com sucesso");
						banco.CadastrarConta(contaPoupanca);
					} else {
						System.out.println("Cliente não encontrado, verifique se digitou o cpf corretamente");
					}
					break;
				case 4:// mostrar todas as contas
					banco.mostrarContas();
					break;
				
				case 5://Sacar
					Scanner contaScan5 = new Scanner(System.in);
					int numeroConta5 = contaScan5.nextInt();
					int agencia5 = contaScan5.nextInt();
					Conta contaSaque = banco.getConta(numeroConta5,agencia5);
					if (contaSaque != null){
						System.out.println("Conta identificada com sucesso/nDigite o valor a ser sacado:/n");
						double saqueValor = contaScan5.nextDouble();
						contaSaque.sacar(saqueValor);
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
