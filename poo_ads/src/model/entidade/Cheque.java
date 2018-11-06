package model.entidade;

public class Cheque extends Pagamento {
	private String numero;
	private String agencia;
	private String conta;
	private String banco;
	
	public Cheque() { super(0); }
	public Cheque(double _valor) { super(_valor); }	
	public Cheque(String numero, String agencia, String conta, String banco, double _valor) {
		super(_valor);
		this.numero = numero;
		this.agencia = agencia;
		this.conta = conta;
		this.banco = banco;
	}
	public String getBanco()               { return banco; }
	public void setBanco(String banco)     { this.banco = banco; }
	public String getConta()               { return conta; }
	public void setConta(String conta)     { this.conta = conta; }
	public String getAgencia()             { return agencia; }
	public void setAgencia(String agencia) { this.agencia = agencia; }
	public String getNumero()              { return numero; }
	public void setNumero(String numero)   { this.numero = numero; }
}
