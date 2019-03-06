package aula_banco;

public class Conta {
	int nroConta;
	double saldo;
	Data dataAbertura;
	Correntista[] correntistas;

	Conta() {
	}

	Conta(double saldo) {
		this.saldo = saldo;
	}

	void depositar(double valor) {
		if (valor > 0)
			saldo += valor;
	}

	boolean sacar(double valor) {
		if (saldo >= valor) {
			saldo = saldo - valor;
			return true;
		}
		System.out.println("Valor de saque maior que valor de saldo!!!");
		return false;
	}

	double getSaldo() {
		return saldo;
	}

	boolean transferir(double valor, Conta favorecido) {
		if (this.sacar(valor)) {
			favorecido.depositar(valor);
			return true;
		}
		return false;
	}
}
