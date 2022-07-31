import java.util.ArrayList;

public class Banco {
    // public ArrayList<Cliente> clientes = new ArrayList();
    public ArrayList<Conta> contas = new ArrayList();
    public String nomeBanco = "banco";

    // public void CadastrarCliente(Cliente cliente) {
    // clientes.add(cliente);
    // }

    public void CadastrarConta(Conta conta) {
        contas.add(conta);
    }

    public Cliente getCliente(ArrayList<Cliente> clientes, int cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf)
                return cliente;
        }
        return null;
    }

    public void mostrarContas() {
        for (Conta conta : contas) {
            System.out.println(conta.mostrarCliente() + "- " + conta.getSaldo() + "/n");
        }
    }

}