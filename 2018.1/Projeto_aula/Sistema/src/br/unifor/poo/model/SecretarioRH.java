package br.unifor.poo.model;

import br.unifor.poo.model.servicos.IRHManager;

public class SecretarioRH extends Funcionario implements IRHManager{

	public SecretarioRH() {}
	public SecretarioRH(Long id, String nome, String atribuicao) { super(id,nome, atribuicao); }
	
	@Override
	public boolean R() { return false; }
	@Override
	public boolean W() { return false; }
	@Override
	public boolean X() { return false; }

}
