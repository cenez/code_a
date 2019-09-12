package teste;

public class Endereco {
	private String rua, complemento, cidade, uf;
	private int nro;
	public Endereco(String rua, int nro, String complemento, String cidade, String uf) {
		this.rua = rua; 
		this.nro = nro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.uf = uf;
	}
	public String getRua() { return rua; }
	public int getNro() { return nro; }
	public String getComplemento() { return complemento; }
	public String getCidade() { return cidade; }
	public String getUf() { return uf; }
	public void setRua(String rua) { this.rua = rua; }
	public void setNro(int nro) { this.nro = nro; }
	public void setComplemento(String complemento) { this.complemento = complemento; }
	public void setCidade(String cidade) { this.cidade = cidade; }
	public void setUf(String uf) { this.uf = uf; }
}
