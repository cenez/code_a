package teste;

public class MainApp {
	public static void main(String[] args) {
		Endereco end = new Endereco("Rua 10", 25, "Apto 5", "Fortaleza","CE");
		Aluno joao = new Aluno("Joao da Silva",123456, end);
		
		end.setCidade("Guaramiranga");
		AlunoPos ap = new AlunoPos("Joao da Silva",123456, end);
		
		System.out.println(ap.getNome());
	}
}
