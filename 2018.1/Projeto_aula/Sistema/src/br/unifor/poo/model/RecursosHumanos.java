package br.unifor.poo.model;

import br.unifor.poo.model.servicos.IRHManager;

public class RecursosHumanos extends Departamento implements IRHManager{

	public RecursosHumanos() {}
	public RecursosHumanos(Long id, String nome) { super(id,nome); }
	
	@Override
	public boolean R() { return false; }
	@Override
	public boolean W() { return false; }
	@Override
	public boolean X() { return false; }

}
