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

    public void transferencia(double valor, Conta destino) throws Exception {
        if (saldo - valor < 0)
            throw new Exception("Saldo insuficente para realizar operação");
        else {
            saldo = -valor;
            destino.deposito(valor);
        }

    }

    public String mostrarCliente() {
        return cliente.getNome();
    }
}
