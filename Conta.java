public class Conta {
    
    protected int numeroDaConta;
    protected int agencia;
    protected double saldo;
    protected Cliente cliente;

    public Conta(int numeroDaConta, int agencia, Cliente cliente) {
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.saldo = 0;
        this.cliente = cliente;
    }
    
}
