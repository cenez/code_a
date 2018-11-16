package br.unifor.poo.util;

import java.util.ArrayDeque;
import java.util.Queue;

public class Logger extends Thread {
	private static Queue<String> LOG = new ArrayDeque<String>();
	public static boolean ativo = true;
	@Override
	public void run() {
		while(ativo) {
			String msn;
			synchronized (LOG) {
				msn = LOG.poll();
			}
			if(msn!=null)
				System.out.println(msn);
		}
	}
	static {
		System.out.println("*********************************************** Log Ativado **************************************");
	}
	public static void add(String msn) {
		synchronized (LOG) {
			LOG.add(msn);
		}		
	}
	public static void imprime() {
		synchronized (LOG) {
			for (String msn : LOG)
				System.out.println(msn);
		}
	}
	public static int size() { 
		int tam = 0;
		synchronized (LOG) {
			tam = LOG.size();
		}
		return tam;
	}
	public static void finaliza() {
		while(size()>0) {}
		ativo = false;
		System.out.println("*********************************************** Log Desativado ***********************************");
	}
}
