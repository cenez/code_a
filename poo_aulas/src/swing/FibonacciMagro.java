package swing;

import javax.swing.JOptionPane;

public class FibonacciMagro implements IFibonacci, Runnable{
	private int n;
	public FibonacciMagro(int n) {
		this.n= n;
	}
	@Override
	public void run(){
		fibonacci();
	}
	@Override
	public void fibonacci() {
		int f = fibonacci(n);
		JOptionPane.showMessageDialog(null, "Fibonacci de "+n+": "+f);
	}
	private int fibonacci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fibonacci(n-1)+fibonacci(n-2);	
	}
}
