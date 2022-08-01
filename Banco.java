import java.util.ArrayList;
import java.util.Random;

public class Banco {
    // public ArrayList<Cliente> clientes = new ArrayList();
    public ArrayList<Conta> contas = new ArrayList();
    public String nomeBanco = "banco";

    // public void CadastrarCliente(Cliente cliente) {
    // clientes.add(cliente);
    // }

    public boolean CadastrarConta(Conta conta) {
        for (Conta c : contas){
            if(c.getNumeroDaConta() == conta.getNumeroDaConta()){
                return false;
            }
        }
        contas.add(conta);
        return true;
    }

    public Cliente getCliente(ArrayList<Cliente> clientes, int cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf)
                return cliente;
        }
        return null;
    }

    public Conta getConta(int numeroConta, int agencia){
        for (Conta conta: contas){
            if (conta.getNumeroDaConta() == numeroConta && conta.getAgencia() == agencia){
                return conta;
            }
        }
        return null;
    }

    public void mostrarContas() {
        for (Conta conta : contas) {
            System.out.println("Cliente: "+conta.mostrarCliente() + " - Saldo: " + conta.getSaldo() + "\n");
        }
    }

}