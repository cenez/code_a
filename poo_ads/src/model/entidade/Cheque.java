package model.entidade;

public class Cheque implements Pagamento {
	private String numero;
	private String agencia;
	private String conta;
	private String banco;
	private double value;
	private Pedido pedido;
	
	public Cheque() { }
	public Cheque(String numero, String agencia, String conta, String banco, double _valor, Pedido pedido) {
		this.numero = numero;
		this.agencia = agencia;
		this.conta = conta;
		this.banco = banco;
		this.pedido = pedido;
	}
	public double getValue()               { return this.value; }
	public void setValue(double valor)     { this.value = valor; }
	public Pedido getPedido()              { return this.pedido; }
	public void setPedido(Pedido pedido)   { this.pedido = pedido; }	
	public String getBanco()               { return banco; }
	public void setBanco(String banco)     { this.banco = banco; }
	public String getConta()               { return conta; }
	public void setConta(String conta)     { this.conta = conta; }
	public String getAgencia()             { return agencia; }
	public void setAgencia(String agencia) { this.agencia = agencia; }
	public String getNumero()              { return numero; }
	public void setNumero(String numero)   { this.numero = numero; }
}
