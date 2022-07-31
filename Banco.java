import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes = new ArrayList();

    public void CadastrarCliente(Cliente cliente){
        clientes.add(cliente);
    }
}