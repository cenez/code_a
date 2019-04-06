package associacao;

public class Main {
	public static void main(String[] args) {
		Departamento computacao = new Departamento(1, "Computacao");
		Departamento fisica = new Departamento(2, "Fisica");

		Funcionario joao = new Funcionario(1, "Joao", "Professor");
		Funcionario maria = new Funcionario(2, "Maria", "Pesquisadora");

		joao.setDepartamento(computacao);
		maria.setDepartamento(computacao);
		
		System.out.println("Imprimindo funcionario: ");
		System.out.println(joao);
		System.out.println(maria);
		
		System.out.println("\n"+maria.getNome() + 
				" foi alocada no departamento de "+fisica.getNome());
		maria.setDepartamento(fisica);
		
		System.out.println("\nImprimindo funcionario: ");
		System.out.println(joao);
		System.out.println(maria);
		
		System.out.println("\nImprimindo funcionarios dos departamentos: ");
		computacao.imprimeFuncionarios();
		System.out.println();
		fisica.imprimeFuncionarios();
	}
}