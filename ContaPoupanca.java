public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numeroDaConta, int agencia, Cliente cliente) {
        super(numeroDaConta, agencia, cliente);
    }

    public void rendimentos(){
        this.saldo = this.saldo * 0.05;
    }
    
}
