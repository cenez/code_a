package aula_banco;

public class Data {
	String dia;
	String mes;
	String ano;
	
	public String getDia() {
		return dia;
	}
	public String getMes() {
		return mes;
	}
	public String getAno() {
		return ano;
	}
	public void setData(String dia, String mes, String ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
    public Data getClone () {
		try {
			return (Data)this.clone();
		}
		catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
