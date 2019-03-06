package aula_banco;

public class MainTestRegistroDeContas { 
	public static void main(String[] args) { 
		Conta contaJoao = new Conta(); 
		contaJoao.depositar(50); 
		
		Conta contaMaria = new Conta(); 
		contaMaria.depositar(50); 
		
		Data data = new Data(); 
		data.setData("10", "02", "2019"); 
		
		Correntista joao = new Correntista(); 
		joao.setCpf("123.456.789-01"); 
		joao.setNome("Joao da Silva Sauro"); 
		
		Correntista maria = new Correntista(); 
		maria.setCpf("321.654.987-10"); 
		maria.setNome("Maria da Silva Sauro"); 
		
		contaJoao.sacar(100); 
		contaJoao.transferir(20, contaMaria); 
		
		System.out.println(contaJoao.getSaldo()); 
		System.out.println(contaMaria.getSaldo()); 
	}
}
