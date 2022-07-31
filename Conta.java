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

    public double getSaldo() {
        return saldo;
    }

    public void deposito(double valor) {
        saldo += valor;
    }

    
}
