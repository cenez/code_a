package swing;

import javax.swing.JOptionPane;

public class FibonacciGordo implements IFibonacci{
	private int n;
	public FibonacciGordo(int n) {
		this.n= n;
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
