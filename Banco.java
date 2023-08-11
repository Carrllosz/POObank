import java.util.ArrayList;
import java.util.List;

class ContaBancaria {
    private int numeroConta;
    private String titular;
    private double saldo;

    public ContaBancaria(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}

class AgenciaBancaria {
    private int numeroAgencia;
    private List<ContaBancaria> contas;

    public AgenciaBancaria(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public ContaBancaria buscarConta(int numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        AgenciaBancaria agencia = new AgenciaBancaria(1);

        ContaBancaria conta1 = new ContaBancaria(123, "João");
        ContaBancaria conta2 = new ContaBancaria(456, "Maria");

        agencia.adicionarConta(conta1);
        agencia.adicionarConta(conta2);

        conta1.depositar(1000);
        conta2.depositar(500);

        System.out.println("Saldo da conta de João: " + conta1.getSaldo());
        System.out.println("Saldo da conta de Maria: " + conta2.getSaldo());

        if (conta1.sacar(500)) {
            System.out.println("Saque de 500 realizado com sucesso na conta de João");
        } else {
            System.out.println("Não foi possível realizar o saque na conta de João");
        }

        ContaBancaria contaEncontrada = agencia.buscarConta(456);
        if (contaEncontrada != null) {
            System.out.println("Saldo da conta de Maria encontrada: " + contaEncontrada.getSaldo());
        } else {
            System.out.println("Conta de Maria não encontrada na agência");
        }
    }
}
