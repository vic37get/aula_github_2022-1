public class Conta {

    protected int numeroDaConta;
    protected int agencia;
    protected double saldo;
    protected Cliente cliente;
    protected String extrato;

    public Conta(int numeroDaConta, int agencia, Cliente cliente) {
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.saldo = 0;
        this.cliente = cliente;
        this.extrato = "";
    }

    public String getExtrato() {
        return this.extrato + "\nSaldo atual: R$ " + this.getSaldo();
    }

    public int getNumeroDaConta() {
        return this.numeroDaConta;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposito(double valor) {
        this.saldo += valor;
        this.extrato += "Deposito no valor de R$ " + valor + " Saldo atual: R$ " + this.saldo + "\n";
    }

    public void sacar(double valor) throws Exception {
        if (this.saldo < valor) {
            throw new Exception("Saldo insuficente para realizar operação");
        } else {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso");
            this.extrato += "Saque no valor de R$ " + valor + " Saldo restante: R$ " + this.saldo + "\n";
        }
    }

    public void transferencia(double valor, Conta destino) throws Exception {
        if (saldo - valor < 0)
            throw new Exception("Saldo insuficente para realizar operação");
        else {
            saldo -= valor;
            destino.deposito(valor);
            this.extrato += "Tranferência Enviada no valor de R$ " + valor + ",para " + destino.getAgencia()
                    + " Saldo restante: R$ " + this.saldo + "\n";
        }

    }

    public String mostrarCliente() {
        return cliente.getNome();
    }
}
