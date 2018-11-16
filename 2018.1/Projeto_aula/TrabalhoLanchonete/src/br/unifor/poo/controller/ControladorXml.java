package br.unifor.poo.controller;

import java.util.ArrayList;
import java.util.List;

import br.unifor.poo.model.Bebida;
import br.unifor.poo.model.dao.XMLDao;
import br.unifor.poo.util.FileUtil;

public class ControladorXml {
	private XMLDao<Bebida> xmlDaoBebida = new XMLDao<Bebida>();
	
	private static List<Bebida> bebidas;
	
	private String pathBebida = "bebidas.xml";
	
	public ControladorXml(){
		if(!FileUtil.existsFile(pathBebida)) {
			bebidas = new ArrayList<Bebida>();
			this.salvaBebida();
		}
		bebidas = ((List<Bebida>) xmlDaoBebida.fromXMLFile(pathBebida));
	}
	public List<Bebida> getBebidas() {
		return bebidas;
	}
	public void salvaBebida() {
		xmlDaoBebida.toXMLFile(ControladorXml.bebidas, pathBebida);
	}
}
