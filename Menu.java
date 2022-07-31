import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;
import javax.swing.SwingWorker;

public class Menu {
	private String title;
	private List<String> options;

	public Menu(String title, List<String> options) {
		this.title = "Menu";
		this.options = options;
	}

	public void MenuIniciar() {
		// this.title = title;
		// this.options = options;
		Banco banco = new Banco();
		ArrayList<Cliente> clientes = new ArrayList<>();
		int op = -1;
		while (op != 0) {
			Scanner scan = new Scanner(System.in);
			op = scan.nextInt();
			System.out.println(
					"[1]-Cadastrar Cliente/n[2]-Cadastrar Conta Corrente/n[3]-Conta Poupança/n[4]-Mostrar Contas Cadastradas");
			switch (op) {
				case 1:// cadastrar cliente

					Scanner clienteScan = new Scanner(System.in);
					var nome = clienteScan.nextLine();
					var cpf = clienteScan.nextInt();
					var sexo = clienteScan.nextLine();
					Cliente cliente = new Cliente(nome, cpf, sexo);
					clientes.add(cliente);

					break;

				case 2:// cadastrar conta corrente
					Conta conta;
					Scanner contaScan = new Scanner(System.in);
					var numeroConta = contaScan.nextInt();
					var agencia = contaScan.nextInt();
					int i = 1;
					for (Cliente clienteEscolhido : clientes) {
						System.out.println(i + "-" + clienteEscolhido.getNome() + "cpf: " + clienteEscolhido.getCpf());
					}

					System.out.println("Digite o cpf do cliente escolhido");
					var clienteEscolhido = contaScan.nextInt();
					var clienteDoBanco = banco.getCliente(clientes, clienteEscolhido);

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
					Conta contaPoupança;
					Scanner contaPScan = new Scanner(System.in);
					var numeroContaP = contaPScan.nextInt();
					var agenciaP = contaPScan.nextInt();
					int numCliente = 1;
					for (Cliente clientePEscolhido : clientes) {
						System.out.println(
								numCliente + "-" + clientePEscolhido.getNome() + "cpf: " + clientePEscolhido.getCpf());
					}

					System.out.println("Digite o cpf do cliente escolhido");
					var clientePEscolhido = contaPScan.nextInt();
					var clientePDoBanco = banco.getCliente(clientes, clientePEscolhido);

					if (clientePDoBanco != null) {
						conta = new ContaCorrente(numeroContaP, agenciaP, clientePDoBanco);
						System.out.println("Conta cadastrada com sucesso");
						banco.CadastrarConta(conta);
					} else {
						System.out.println("Cliente não encontrado, verifique se digitou o cpf corretamente");
					}
					break;
				case 4:// mostrar todas as contas
					banco.mostrarContas();
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
