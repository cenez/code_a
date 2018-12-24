package tests;

import geometrics.Point;

public class NO extends Point {
	public String chave = null;
	public NO(double x, double y) {
		super(x, y);
	}
	public NO(String key, double x, double y) {
		super(x,y);
		this.chave = key;
	}
}
